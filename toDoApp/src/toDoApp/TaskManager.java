package toDoApp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class TaskManager {
	private final Path FILE_PATH = Path.of("tasks.json");
	private List<Task> storedTasks;
	
	public TaskManager() {
		this.storedTasks = loadTasks();
	}

	private List<Task> loadTasks() {
		List<Task> tasks = new ArrayList<>();
		if(Files.exists(FILE_PATH)) {
			try {
				String[] jsonArray = Files.readString(FILE_PATH)
						.replace("[","").replace("]","").split("},");
				if(jsonArray.length >= 0) {
					for(String json: jsonArray) {
						if(!json.isBlank()) {
							tasks.add(Task.fromJSON(json));
						}
					}
					return tasks;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return tasks;
	}
	
	public void add(String description) {
		Task newTask = new Task(description);
		storedTasks.add(newTask);
		System.out.println("Task added successfully (ID: " + newTask.getId() + ")");
	}
	
	public void update(int id,String description) {
		for(Task currTask: storedTasks) {
			if(currTask.getId() == id) {
				currTask.update(description);
				System.out.println("Task updated successfully");
				return;
			}
		}
		System.out.println("ID not found");
	}
	
	public void delete(int id) {
		for(int i=0;i<storedTasks.size();i++) {
			Task currTask = storedTasks.get(i);
			if(currTask.getId() == id) {
				storedTasks.remove(i);
				System.out.println("Task deleted successfully");
				return;
			}
		}
		System.out.println("ID not found");
	}
	
	public void markInProgress(int id) {
		for(Task currTask: storedTasks) {
			if(currTask.getId() == id) {
				currTask.markInProgress();
				System.out.println("Task marked for in-progress successfully");
				return;
			}
		}
		System.out.println("ID not found");
	}
	
	public void markDone(int id) {
		for(Task currTask: storedTasks) {
			if(currTask.getId() == id) {
				currTask.markDone();
				System.out.println("Task marked done successfully");
				return;
			}
		}
		System.out.println("ID not found");
	}
	
	public void list() {
		if(storedTasks.size() == 0) {
			System.out.println("No tasks is currently present");
			return;
		}
		System.out.printf("+------+------------------------------------------+--------------+--------------------------------+--------------------------------+\n" +
		        "| %-4s | %-40s | %-12s | %-30s | %-30s |\n" ,
		        "ID", "Description", "Status", "Created Time", "Updated Time");
		for(Task currTask: storedTasks) {
			System.out.print(currTask);
		}
		System.out.printf("+------+------------------------------------------+--------------+--------------------------------+--------------------------------+\n");
	}
	
	public void list(Status staus) {
		if(storedTasks.isEmpty()) {
			System.out.println("No tasks is currently present");
			return;
		}
		System.out.printf("+------+------------------------------------------+--------------+--------------------------------+--------------------------------+\n" +
	        "| %-4s | %-40s | %-12s | %-30s | %-30s |\n" ,
	        "ID", "Description", "Status", "Created Time", "Updated Time");
		for(Task currTask: storedTasks) {
			if(currTask.getStatus() == staus) {
				System.out.print(currTask);
			}
		}
		System.out.print("+------+------------------------------------------+--------------+--------------------------------+--------------------------------+\n");
	}
	
	public void saveTask() {
		try {
			StringBuilder jsonStr = new StringBuilder("[\n");
			for(int i=0;i<storedTasks.size();i++) {
				Task task = storedTasks.get(i);
				jsonStr.append(task.toJSON());
				if(i < storedTasks.size()-1) {
					jsonStr.append(",\n");
				}
			}
			jsonStr.append("\n]");
			Files.writeString(FILE_PATH, jsonStr);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
