package toDoApp;

public class SimArgs {

	public static void main(String[] args) {
		String[][] cmd = {
				{"add", "study"},
				{"add", "sleep"},
				{"add", "work"}
			   };
		for (int i = 0; i < cmd.length; i++) {
			TaskCLI.main(cmd[i]);
		}
	}

}
