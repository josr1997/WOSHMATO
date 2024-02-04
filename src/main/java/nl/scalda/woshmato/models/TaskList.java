package nl.scalda.woshmato.models;

import java.util.ArrayList;

import nl.scalda.woshmato.datalayer.DAOTask;

public class TaskList {

	private ArrayList<Task> tasks = new ArrayList<>();
	private static TaskList instance;

	public TaskList(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

	public TaskList() {
	}

	public void createTask(Task t)
	{
		this.tasks.add(t);
		DAOTask.getInstance().createTask(t);
	}

	public void editTask(Task t){
		DAOTask.getInstance().editTask(t);
	}

	public void archiveTask(Task t){
		DAOTask.getInstance().archiveTask(t);
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

	public static TaskList getInstance() {
		if(instance == null) {
			instance = new TaskList();
		}
		return instance;
	}

}
