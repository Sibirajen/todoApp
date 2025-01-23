package toDoApp;

import java.time.LocalDateTime;

public class Task {
	private static int UID = 99;
	
	private int id;
	private String description;
	private Status status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public Task(String description) {
		this.id = ++UID;
		this.description = description;
		this.status = Status.todo;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();	
	}
	
	private Task(int id, String description, Status status, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Task fromJSON() {
		
		return new Task("");
	}
	
	public String toJSON() {
	    return "{\"id\":\"" + id +
	            "\",\"description\":\"" + description +
	            "\",\"status\":\"" + status +
	            "\",\"createdAt\":\"" + createdAt +
	            "\",\"updatedAt\":\"" + updatedAt + "\"}";
	}
}