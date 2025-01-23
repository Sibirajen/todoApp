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
				// add the task
				break;
		}
	}

}
