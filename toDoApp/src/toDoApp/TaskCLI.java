package toDoApp;

public class TaskCLI {
	
	public static void printHelp() {
	    System.out.println("TaskCLI Command-Line Usage:");
	    System.out.println();
	    System.out.println("General Usage:");
	    System.out.println("  toDoApp.TaskCLI <command> [arguments]");
	    System.out.println();
	    System.out.println("Commands:");
	    System.out.println("  add <description>              - Add a new task with the specified description.");
	    System.out.println("  update ID <description>        - Update an existing task with the specified ID and new description.");
	    System.out.println("  delete ID                      - Delete a task with the specified ID.");
	    System.out.println("  mark-in-progress ID            - Mark the task with the specified ID as in-progress.");
	    System.out.println("  mark-done ID                   - Mark the task with the specified ID as done.");
	    System.out.println("  list                           - List all tasks.");
	    System.out.println("  list todo                      - List tasks with 'To-Do' status.");
	    System.out.println("  list in-progress               - List tasks with 'In-Progress' status.");
	    System.out.println("  list done                      - List tasks with 'Done' status.");
	    System.out.println();
	    System.out.println("Examples:");
	    System.out.println("  toDoApp.TaskCLI add \"Complete project report\"");
	    System.out.println("  toDoApp.TaskCLI update 1 \"Update documentation\"");
	    System.out.println("  toDoApp.TaskCLI delete 2");
	    System.out.println("  toDoApp.TaskCLI mark-in-progress 3");
	    System.out.println("  toDoApp.TaskCLI mark-done 4");
	    System.out.println("  toDoApp.TaskCLI list");
	    System.out.println("  toDoApp.TaskCLI list todo");
	}
	
	public static int getNumber(String number) {
		try{
			return Integer.parseInt(number);
		}
		catch(Exception e) {
			System.out.println("Id needs to be a number");
			return -1;
		}
	}

	public static void main(String[] args) {
		TaskManager taskManager = new TaskManager();
		
		if(args.length < 1) {
			System.out.println("Usage:toDoApp.TaskCLI <command> [arguments]");
			System.out.println("Use \"toDoApp.TaskCLI help\" to learn more");
			return;
		}
		
		switch(args[0]) {
			case "add":{
				if(args.length < 2) {
					System.out.println("Usage: toDoApp.TaskCLI add <description>");
					System.out.println("Use \"toDoApp.TaskCLI help\" to learn more");
					return;
				}
				taskManager.add(args[1]);
				break;
			}
			case "update":{
				if(args.length < 3) {
					System.out.println("Usage: toDoApp.TaskCLI update ID <description>");
					System.out.println("Use \"toDoApp.TaskCLI help\" to learn more");
					return;
				}
				int id = getNumber(args[1]);
				if(id > -1) {
					taskManager.update(id,args[2]);
				}
				break;
			}
			case "delete":{
				if(args.length < 2) {
					System.out.println("Usage: toDoApp.TaskCLI delete ID");
					System.out.println("Use \"toDoApp.TaskCLI help\" to learn more");
					return;
				}
				int id = getNumber(args[1]);
				if(id > -1) {
					taskManager.delete(id);
				}
				break;
			}
			case "mark-in-progress":{
				if(args.length < 2) {
					System.out.println("Usage: toDoApp.TaskCLI mark-in-progress ID");
					System.out.println("Use \"toDoApp.TaskCLI help\" to learn more");
					return;
				}
				int id = getNumber(args[1]);
				if(id > -1) {
					taskManager.markInProgress(id);
				}
				break;
			}
			case "mark-done":{
				if(args.length < 2) {
					System.out.println("Usage: toDoApp.TaskCLI mark-done ID");
					System.out.println("Use \"toDoApp.TaskCLI help\" to learn more");
					return;
				}
				int id = getNumber(args[1]);
				if(id > -1) {
					taskManager.markDone(id);
				}
				break;
			}
			case "list":{
				if(args.length == 1) {
					taskManager.list();
					return;
				}
				switch(args[1]) {
					case "todo":
						taskManager.list(Status.todo);
						break;
					case "in-progress":
						taskManager.list(Status.inProgress);
						break;
					case "done":
						taskManager.list(Status.done);
						break;
					default:
						System.out.println("Usage: toDoApp.TaskCLI list <command>");
						System.out.println("Use \"toDoApp.TaskCLI help\" to learn more");
						break;
				}
				break;
			}
			case "help":{
				if(args.length == 1) {
					printHelp();
					return;
				}
				System.out.println("Usage: toDoApp.TaskCLI help");
				break;
			}
			default:{
				System.out.println("Usage: toDoApp.TaskCLI <command> [arguments]");
				System.out.println("Use \"toDoApp.TaskCLI help\" to learn more");
				break;
			}
		}
		taskManager.saveTask();
	}

}
