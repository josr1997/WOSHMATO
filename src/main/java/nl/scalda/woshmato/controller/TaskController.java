package nl.scalda.woshmato.controller;

import static com.opensymphony.xwork2.Action.*;
import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.Action;
import org.apache.struts2.interceptor.ServletRequestAware;

import nl.scalda.woshmato.datalayer.DAOCategory;
import nl.scalda.woshmato.datalayer.DAOTask;
import nl.scalda.woshmato.models.Category;
import nl.scalda.woshmato.models.Task;
import nl.scalda.woshmato.models.TaskList;

public class TaskController extends Action implements ServletRequestAware {

    HttpServletRequest request;
    ArrayList<Task> tasks = new ArrayList<>();
    Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    Matcher m;
    String categoryName;
    ArrayList<Category> categoriesList = DAOCategory.getInstance().getCategories();

    public String loadTask() {
        int id = Integer.parseInt(request.getParameter("id"));
        DAOCategory.getInstance().loadAllCategorys();
        Task t = DAOTask.getInstance().findTaskById(id);
        request.setAttribute("taskId", t.getId());
        request.setAttribute("taskName", t.getName());
        request.setAttribute("taskDescription", t.getDescription());
        request.setAttribute("taskArchived", t.getArchived());
        request.setAttribute("taskCategory", t.getCategory().getName());
        request.setAttribute("taskCategory", t.getCategory());
        request.setAttribute("taskClockHour", (new DecimalFormat("##.#").format(t.getClockhour())));
        request.setAttribute("taskLessonHour", (new DecimalFormat("##.#").format(t.getLessonhour())));
        return SUCCESS;
    }

    public String addTask() throws Exception {
        Category c = null;
        if (request.getParameter("category").startsWith("undefined")) {
            return ERROR;
        }
        for (Category ca : categoriesList) {
            if (ca.toString().equals(request.getParameter("category"))) {
                c = ca;
            }
        }

        m = p.matcher(request.getParameter("taskName"));
        boolean b = m.find();
        String taskName;
        if (!b) {
            taskName = request.getParameter("taskName");
        } else {
            return ERROR;
        }
        m = p.matcher(request.getParameter("taskDescription"));
        boolean b2 = m.find();
        String taskDescription;
        if (!b) {
            taskDescription = request.getParameter("taskDescription");
        } else {
            return ERROR;
        }
        if ("".equals(request.getParameter("taskLessonHours"))) {
            double taskClockHours = Double.parseDouble(request.getParameter("taskClockHours"));
            Task t = new Task(taskName, taskDescription, 0, taskClockHours, 0, c);
            TaskList.getInstance().createTask(t);
        } else if ("".equals(request.getParameter("taskClockHours"))) {
            double taskLessonHours = Double.parseDouble(request.getParameter("taskLessonHours"));
            Task t = new Task(0, taskName, taskDescription, taskLessonHours, 0, c);
            TaskList.getInstance().createTask(t);
        } else {
            double taskClockHours = Double.parseDouble(request.getParameter("taskClockHours"));
            double taskLessonHours = Double.parseDouble(request.getParameter("taskLessonHours"));
            Task t = new Task(0, taskName, taskDescription, taskLessonHours, taskClockHours, 0, c);
            TaskList.getInstance().createTask(t);
        }
        return SUCCESS;
    }

    public String editTask() throws Exception {
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        m = p.matcher(request.getParameter("taskName"));
        boolean b = m.find();
        String taskName = null;
        if (request.getParameter("taskCategory").startsWith("undefined")) {
            return ERROR;
        }
        if (!b) {
            if ("".equals(request.getParameter("taskName"))) {
                for (Task ta : DAOTask.getInstance().getTasks()) {
                    if (ta.getId() == taskId) {
                        taskName = ta.getName();
                    }
                }
            } else {
                taskName = request.getParameter("taskName");
            }
        } else {
            return ERROR;
        }
        m = p.matcher(request.getParameter("taskDescription"));
        boolean b2 = m.find();
        String taskDescription = null;
        if (!b) {
            if ("".equals(request.getParameter("taskDescription"))) {
                for (Task ta : DAOTask.getInstance().getTasks()) {
                    if (ta.getId() == taskId) {
                        taskDescription = ta.getDescription();
                    }
                }
            } else {
                taskDescription = request.getParameter("taskDescription");
            }
        } else {
            return ERROR;
        }
        int taskArchived = 0;
        if ("".equals(request.getParameter("taskArchived"))) {
            for (Task ta : DAOTask.getInstance().getTasks()) {
                if (ta.getId() == taskId) {
                    taskArchived = ta.getArchived();
                }
            }
        } else {
            taskArchived = Integer.parseInt(request.getParameter("taskArchived"));
        }
        double lessonHours = 0;
        double clockHours = 0;

        CharSequence cs = ",";

        if (!request.getParameter("taskLessonHours").equals("")) {
            if (request.getParameter("taskLessonHours").contains(cs)) {
                String s = request.getParameter("taskLessonHours");
                s = s.replace(',', '.');
                lessonHours = Double.parseDouble(s);
            } else {
                lessonHours = Double.parseDouble(request.getParameter("taskLessonHours"));
            }

        }
        if (!request.getParameter("taskClockHours").equals("")) {
            if (request.getParameter("taskClockHours").contains(cs)) {
                String s = request.getParameter("taskClockHours");
                s = s.replace(',', '.');
                clockHours = Double.parseDouble(s);
            } else {
                clockHours = Double.parseDouble(request.getParameter("taskClockHours"));
            }
        }

        Category c = null;
        for (Category ca : categoriesList) {
            if (ca.toString().equals(request.getParameter("taskCategory"))) {
                c = ca;
            }
        }

        Task t = null;

        if (request.getParameter("taskLessonHours").equals("") && request.getParameter("taskClockHours").equals("")) {
            lessonHours = DAOTask.getInstance().findTaskById(taskId).getLessonhour();
            clockHours = DAOTask.getInstance().findTaskById(taskId).getClockhour();

            t = new Task(taskId, taskName, taskDescription, lessonHours, clockHours, taskArchived, c);
        } else {
            if (request.getParameter("taskLessonHours").equals("")) {
                t = new Task(taskName, taskDescription, taskArchived, clockHours, taskId, c);
            }
            if (!request.getParameter("taskLessonHours").equals("")) {
                t = new Task(taskId, taskName, taskDescription, lessonHours, taskArchived, c);
            }
        }
        DAOTask.getInstance().editTask(t);
        return SUCCESS;
    }

    public String archiveTask() throws Exception {
        int taskId = Integer.parseInt(request.getParameter("taskArchive"));
        Task t = new Task();
        t.setId(taskId);
        TaskList.getInstance().archiveTask(t);
        return SUCCESS;
    }

    public String loadAllTasks() {
        DAOTask.getInstance().loadAllTasks(true);
        tasks = DAOTask.getInstance().getTasks();

        DAOCategory.getInstance().loadAllCategorys();
        categoriesList = DAOCategory.getInstance().getCategories();

        return SUCCESS;
    }

    public String archiveTaskProcess() {
        int id = Integer.parseInt(request.getParameter("id"));
        Task t = new Task();
        t.setId(id);
        DAOTask.getInstance().archiveTask(t);
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    private HttpServletRequest getServletRequest() {
        return this.request;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Category> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(ArrayList<Category> categoriesList) {
        this.categoriesList = categoriesList;
    }
}
