package toDoApp;

public class TaskCLI {
	
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
			System.out.println("Usage: TaskCLI <command> [arguments]");
			return;
		}
		
		String command = args[0];
		switch(command) {
			case "add":{
				if(args.length < 2) {
					System.out.println("Usage: TaskCLI add <description>");
					return;
				}
				taskManager.add(args[1]);
				break;
			}
			case "update":{
				if(args.length < 3) {
					System.out.println("Usage: TaskCLI update ID <description>");
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
					System.out.println("Usage: TaskCLI delete ID");
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
					System.out.println("Usage: TaskCLI mark-in-progress ID");
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
					System.out.println("Usage: TaskCLI mark-done ID");
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
				}
				break;
			}
			default:{
				System.out.println("Usage: TaskCLI <command> [arguments]");
				break;
			}
		}
		taskManager.saveTask();
	}

}
