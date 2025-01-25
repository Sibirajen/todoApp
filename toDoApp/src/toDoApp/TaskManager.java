package toDoApp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
	private final Path FILE_PATH = Path.of("tasks.json");
	private List<Task> storedTasks = new ArrayList<>();
	
	public TaskManager() {
		this.storedTasks = loadTasks();
	}

	private List<Task> loadTasks() {
		if(Files.exists(FILE_PATH)) {
			try {
				String[] jsonArray = Files.readString(FILE_PATH)
						.replace("[","").replace("]","").split("},");
				for(String json: jsonArray) {
					storedTasks.add(Task.fromJSON(json));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<>();
	}
	
//	# Output: Task added successfully (ID: 1)
	public void add(String description) {
		Task newTask = new Task(description);
		storedTasks.add(newTask);
		System.out.println("Task added successfully (ID: " + newTask.getId() + ")");
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
