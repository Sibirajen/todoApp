package toDoApp;

public class TaskCLI {

	public static void main(String[] args) {
		TaskManager taskManager = new TaskManager();
		
		if(args.length < 1) {
			System.out.println("Usage: TaskCLI <command> [arguments]");
			return;
		}
		
		String command = args[0];
		switch(command) {
			case "add":
				if(args.length < 2) {
					System.out.println("Usage: TaskCLI add <description>");
					return;
				}
				taskManager.add(args[1]);
				break;
			case "update":
				if(args.length < 3) {
					System.out.println("Usage: TaskCLI update ID <description>");
					return;
				}
				try {
					int id = Integer.parseInt(args[1]);
					taskManager.update(id,args[2]);
				}
				catch(Exception e) {
					System.out.println("ID needs to be a number");
				}
				break;
			case "delete":
				if(args.length < 2) {
					System.out.println("Usage: TaskCLI delete ID");
					return;
				}
				try {
					int id = Integer.parseInt(args[1]);
					taskManager.delete(id);
				}
				catch(Exception e) {
					System.out.println("ID needs to be a number");
				}
				break;
			case "mark-in-progress":
				if(args.length < 2) {
					System.out.println("Usage: TaskCLI mark-in-progress ID");
					return;
				}
				try {
					int id = Integer.parseInt(args[1]);
					taskManager.markInProgress(id);
				}
				catch(Exception e) {
					System.out.println("ID needs to be a number");
				}
				break;
			case "mark-done":
				if(args.length < 2) {
					System.out.println("Usage: TaskCLI mark-done ID");
					return;
				}
				try {
					int id = Integer.parseInt(args[1]);
					taskManager.markDone(id);
				}
				catch(Exception e) {
					System.out.println("ID needs to be a number");
				}
				break;
			default:
				System.out.println("Usage: TaskCLI <command> [arguments]");
				break;
		}
		taskManager.saveTask();
	}

}
