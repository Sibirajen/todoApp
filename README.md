# TaskCLI - Command-Line Task Management Application

This project is a challenge from [task-tracker](https://roadmap.sh/projects/task-tracker)

## Overview

TaskCLI is a simple command-line application designed for managing tasks efficiently. It allows users to create, update, delete, and track tasks using an intuitive command-line interface.

## Features

- Add new tasks with a description.
- Update existing tasks by ID.
- Delete tasks by ID.
- Mark tasks as **In-Progress** or **Done**.
- List tasks based on their status:
  - All tasks
  - Tasks in **To-Do**
  - Tasks in **In-Progress**
  - Tasks marked as **Done**.

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Sibirajen/todoApp.git

2. **Compile the source code:**
    ```bash
   javac TaskCLI.java Task.java TaskManager.java Status.java
    
3. **Run the application:**
    ```bash
   java toDoApp.TaskCLIApp <command> [arguments]
   ```

## Usage

### General Syntax

```
TaskCLI <command> [arguments]
```

### Commands

| Command               | Description                                         | Example                                     |
| --------------------- | --------------------------------------------------- | ------------------------------------------- |
| `add <description>`   | Add a new task with the specified description.      | `TaskCLI add "Complete homework"`           |
| `update ID <desc>`    | Update the task with the specified ID.              | `TaskCLI update 1 "Update ``documentation"` |
| `delete ID`           | Delete the task with the specified ID.              | `TaskCLI delete 1`                          |
| `mark-in-progress ID` | Mark the task with the specified ID as In-Progress. | `TaskCLI mark-in-progress 2`                |
| `mark-done ID`        | Mark the task with the specified ID as Done.        | `TaskCLI mark-done 3`                       |
| `list`                | List all tasks.                                     | `TaskCLI list`                              |
| `list todo`           | List tasks with **To-Do** status.                   | `TaskCLI list todo`                         |
| `list in-progress`    | List tasks with **In-Progress** status.             | `TaskCLI list in-progress`                  |
| `list done`           | List tasks with **Done** status.                    | `TaskCLI list done`                         |

### Help Command

If you enter an invalid command or need assistance, TaskCLI will display a help message with all available commands.

## License

This project is open-source and free to use.

---

Developed by Sibirajen.

