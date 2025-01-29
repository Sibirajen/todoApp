package toDoApp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
	private static int Last_Used_Id = 99;
	
	private int id;
	private String description;
	private Status status;
	private String createdAt;
	private String updatedAt;
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss a");
	
	private Task() {}
		
	public Task(String description) {
		this.id = ++Last_Used_Id;
		this.description = description;
		this.status = Status.todo;
		this.createdAt = LocalDateTime.now().format(formatter);
		this.updatedAt = LocalDateTime.now().format(formatter);
	}
	
	public int getId() {
		return id;
	}

	public void update(String description) {
		this.description = description;
		this.updatedAt = LocalDateTime.now().format(formatter);
	}
	
	public void markInProgress() {
		this.status = Status.inProgress;
		this.updatedAt = LocalDateTime.now().format(formatter);
	}
	
	public void markDone() {
		this.status = Status.done;
		this.updatedAt = LocalDateTime.now().format(formatter);
	}

	public Status getStatus() {
		return status;
	}

	public static Task fromJSON(String json) {
		String[] jsonValues = json.replace("{", "").replace("}", "").replace("\"", "").split(",");
		Task newTask = new Task();
		newTask.id = Integer.parseInt(jsonValues[0].split(":")[1].trim());
		newTask.description = jsonValues[1].split(":")[1].trim();
		newTask.status = Status.valueOf(jsonValues[2].split(":")[1].trim());
		newTask.createdAt = jsonValues[3].split("[a-z]:")[1].trim();
		newTask.updatedAt = jsonValues[4].split("[a-z]:")[1].trim();
		if(newTask.id > Last_Used_Id) {
			Last_Used_Id = newTask.id;
		}
		return newTask;
	}
	
	public String toJSON() {
	    return "\t{\n\t\t\"id\":\"" + id +
	            "\",\n\t\t\"description\":\"" + description +
	            "\",\n\t\t\"status\":\"" + status +
	            "\",\n\t\t\"createdAt\":\"" + createdAt +
	            "\",\n\t\t\"updatedAt\":\"" + updatedAt + "\"\n\t}";
	}

	@Override
	public String toString() {
	    return String.format(
	        "+------+------------------------------------------+--------------+--------------------------------+--------------------------------+\n" +
	        "| %-4s | %-40s | %-12s | %-30s | %-30s |\n" ,
	        id, description, status, createdAt, updatedAt
	    );
	}



}