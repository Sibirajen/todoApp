# TaskCLI - Command-Line Task Management Application

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

## Examples

1. **Add a Task**:

   ```
   TaskCLI add "Complete project report"
   ```

2. **Update a Task**:

   ```
   TaskCLI update 1 "Review team feedback"
   ```

3. **Delete a Task**:

   ```
   TaskCLI delete 2
   ```

4. **Mark a Task as In-Progress**:

   ```
   TaskCLI mark-in-progress 3
   ```

5. **Mark a Task as Done**:

   ```
   TaskCLI mark-done 4
   ```

6. **List All Tasks**:

   ```
   TaskCLI list
   ```

7. **List Tasks by Status**:

   - To-Do:
     ```
     TaskCLI list todo
     ```
   - In-Progress:
     ```
     TaskCLI list in-progress
     ```
   - Done:
     ```
     TaskCLI list done
     ```

## Notes

- The `ID` for tasks is a number automatically assigned when a task is created.
- The task statuses available are **To-Do**, **In-Progress**, and **Done**.

## License

This project is open-source and free to use.

---

Developed by Sibirajen.

