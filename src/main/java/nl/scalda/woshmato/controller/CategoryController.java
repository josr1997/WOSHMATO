/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.woshmato.controller;

import static com.opensymphony.xwork2.Action.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import nl.scalda.woshmato.datalayer.DAOCategory;
import nl.scalda.woshmato.datalayer.DAOGroup;
import nl.scalda.woshmato.models.Category;
import nl.scalda.woshmato.models.CategoryList;
import nl.scalda.woshmato.models.Group;

import org.apache.struts.action.Action;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author kevin
 */
public class CategoryController extends Action implements ServletRequestAware {

    HttpServletRequest request;
    ArrayList<Category> categories = CategoryList.getInstance().getCategories();
    Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    Matcher m;

    public String loadCategory() {
        int id = Integer.parseInt(request.getParameter("id"));
        Category p = DAOCategory.getInstance().findCategoryById(id);
        request.setAttribute("categoryId", p.getId());
        request.setAttribute("categoryName", p.getName());

        return SUCCESS;
    }

    public String removeCategoryProcess() {
        int id = Integer.parseInt(request.getParameter("id"));
        Category d = null;
        for (Category c : DAOCategory.getInstance().getCategories()) {
            if (c.getId() == id) {
                d = c;
            }
        }

        CategoryList.getInstance().removeCategory(d);
        return SUCCESS;
    }

    public String addCategory() throws Exception {
 //       m = p.matcher(request.getParameter("categoryName"));
 //       boolean b = m.find();
        String categoryName;
        try {
            categoryName = request.getParameter("categoryName");
        } catch {
            categoryName = "onbekend";
        }
    	 
//        if (!b) {
//            categoryName = request.getParameter("categoryName");
//        } else {
//            return ERROR;
//        }

        Category c = new Category(0, categoryName);
        for (Category cat : categories) {
            int compare = c.compareTo(cat);
            if (compare == 0) {
                return ERROR;
            }
        }
        CategoryList.getInstance().createCategory(c);
        return SUCCESS;
    }

    public String editCategory() throws Exception {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
//        m = p.matcher(request.getParameter("categoryName"));
//        boolean b = m.find();
//        String name;
        String name = request.getParameter("categoryName");
//        if (!b) {
//            name = request.getParameter("categoryName");
//        } else {
//            return ERROR;
//        }
        Category c = new Category();
        if (name.isEmpty() == false) {
            c.setName(name);
        } else {
            ArrayList<Category> ca = DAOCategory.getInstance().getCategories();
            for (Category cate : ca) {
                if (cate.getId() == categoryId) {
                    c.setName(cate.getName());
                }
            }

        }
        c.setId(categoryId);
        for (Category cat : categories) {
            if (c.getId() != cat.getId()) {
                int compare = c.compareTo(cat);
                if (compare == 0) {
                    return ERROR;
                }
            }
        }
        CategoryList.getInstance().editCategory(c);
        return SUCCESS;
    }

    public String removeCategory() throws Exception {
        int id = Integer.parseInt(request.getParameter("categoryRemove"));
        Category d = null;
        for (Category c : DAOCategory.getInstance().getCategories()) {
            if (c.getId() == id) {
                d = c;
            }
        }

        CategoryList.getInstance().removeCategory(d);
        return SUCCESS;
    }

    public String loadAllCategories() {
        DAOCategory.getInstance().loadAllCategorys();
        categories = CategoryList.getInstance().getCategories();
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    private HttpServletRequest getServletRequest() {
        return this.request;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

}
