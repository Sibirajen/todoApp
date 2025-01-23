package toDoApp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
	private final Path FILE_PATH = Path.of("src/Files/tasks.json");
	List<Task> listTasks = new ArrayList<>();
	
	public TaskManager() {
		this.listTasks = loadTasks();
	}

	private List<Task> loadTasks() {
		if(Files.exists(FILE_PATH)) {
			try {
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<>();
	}
}
