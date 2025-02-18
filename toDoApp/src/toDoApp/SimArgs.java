package toDoApp;

public class SimArgs {

	public static void main(String[] args) {
		String[][] cmd = {
//				empty argument
				{},
//				list command
				{"list"},
				{"list"},
				{"list","todo"},
				{"list","in-progress"},
				{"list","done"},
//				add command
				{"add"},
				{"add", "study"},
				{"add", "work"},
				{"add", "sleep"},
				{"add", "Me time"},
//				update command
				{"update"},
				{"update","101"},
				{"update","NA","hardwork"},
				{"update","111111","sleep"},
				{"update","100","improve"},
//				delete command
				{"delete"},
				{"delete","NA"},
				{"delete","103"},
//				mark-in-progress command
				{"mark-in-progress"},
				{"mark-in-progress","NA"},
				{"mark-in-progress","102"},
//				mark-done
				{"mark-done"},
				{"mark-done","NA"},
				{"mark-done","101"},
//				list all tasks command
				{"list"},
				{"list","todo"},
				{"list","in-progress"},
				{"list","done"},
				{"list","something"},
//				help command
				{"help"},
				{"help","something"}
			   };
        for (String[] strings : cmd) {
            TaskCLI.main(strings);
        }
	}

}
