package toDoApp;

import java.time.LocalDateTime;

public class Task {
	private static int UID = 99;
	
	private int id;
	private String description;
	private Status status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	private Task() {}
		
	public Task(String description) {
		this.id = ++UID;
		this.description = description;
		this.status = Status.todo;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();	
	}
	
	public int getId() {
		return id;
	}

	public static Task fromJSON(String json) {
		String[] jsonValues = json.replace("{", "").replace("}", "").replace("\"", "").split(",");
		Task newTask = new Task();
		newTask.id = Integer.parseInt(jsonValues[0].split(":")[1].trim());
		newTask.description = jsonValues[1].split(":")[1].trim();
		newTask.status = Status.valueOf(jsonValues[2].split(":")[1].trim());
		newTask.createdAt = LocalDateTime.parse(jsonValues[3].split("[a-z]:")[1].trim());
		newTask.updatedAt = LocalDateTime.parse(jsonValues[4].split("[a-z]:")[1].trim());
		return newTask;
	}
	
	public String toJSON() {
	    return "\t{\n\t\t\"id\":\"" + id +
	            "\",\n\t\t\"description\":\"" + description +
	            "\",\n\t\t\"status\":\"" + status +
	            "\",\n\t\t\"createdAt\":\"" + createdAt +
	            "\",\n\t\t\"updatedAt\":\"" + updatedAt + "\"\n\t}";
	}
}