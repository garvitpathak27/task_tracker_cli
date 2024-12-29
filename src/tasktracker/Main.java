package tasktracker;


public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: task-cli <command> [options]");
            return;
        }

        TaskManager taskManager = new TaskManager();
        String command = args[0];

        switch (command) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Usage: task-cli add <description>");
                } else {
                    taskManager.addTask(args[1]);
                }
                break;

            case "update":
                if (args.length < 3) {
                    System.out.println("Usage: task-cli update <id> <description>");
                } else {
                    taskManager.updateTask(Integer.parseInt(args[1]), args[2]);
                }
                break;

            case "delete":
                if (args.length < 2) {
                    System.out.println("Usage: task-cli delete <id>");
                } else {
                    taskManager.deleteTask(Integer.parseInt(args[1]));
                }
                break;

            case "mark-in-progress":
                if (args.length < 2) {
                    System.out.println("Usage: task-cli mark-in-progress <id>");
                } else {
                    taskManager.markTaskStatus(Integer.parseInt(args[1]), "in-progress");
                }
                break;

            case "mark-done":
                if (args.length < 2) {
                    System.out.println("Usage: task-cli mark-done <id>");
                } else {
                    taskManager.markTaskStatus(Integer.parseInt(args[1]), "done");
                }
                break;

            case "list":
                if (args.length < 2) {
                    taskManager.listTasks(null);
                } else {
                    taskManager.listTasks(args[1]);
                }
                break;

            default:
                System.out.println("Unknown command.");
                break;
        }
    }
}
