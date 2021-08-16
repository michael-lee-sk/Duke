import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {

        final String INTRO = "Hello! I'm Duke\n" +
                "What can I do for you?";

        final String OUTRO = "Bye. Hope to see you again soon!";
        Scanner sc = new Scanner(System.in);

        ArrayList<Task> lst = new ArrayList<>();
        String command;

//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);

        System.out.println(INTRO);
        while (true) {
            command = sc.nextLine();

            if (command.equals("bye")) {
                System.out.println(OUTRO);
                break;

            } else if (command.equals("list")) {

                System.out.println("Here are the tasks in your list:");

                for (int i = 0; i < lst.size(); i++) {
                    Task currentTask = lst.get(i);
                    System.out.println((i + 1) + "." + currentTask.getStatusAndDescription() );
                }

            }  else if (command.substring(0, 4).equals("done")) {

            int index = Integer.parseInt(command.substring(5)) - 1;
            String subtext = "Nice! I've marked this task as done:\n";

            Task currentTask = lst.get(index);
            currentTask.setDone();
            System.out.println(subtext + currentTask.getStatusAndDescription());

            } else if (command.substring(0, 4).equals("todo")) {

                ToDo toDo = new ToDo(command.substring(5));
                lst.add(toDo);
                System.out.format("Got it. I've added this task:\n" + toDo.getStatusAndDescription() + "\n"
                        + "Now you have %d tasks in this list.\n", lst.size());

            } else if (command.substring(0, 8).equals("deadline")) {

                int escapeIndex = command.lastIndexOf("/");
                Deadline deadline = new Deadline(command.substring(9, escapeIndex - 1), command.substring(escapeIndex + 4));
                lst.add(deadline);
                System.out.format("Got it. I've added this task:\n" + deadline.getStatusAndDescription() + "\n"
                        + "Now you have %d tasks in this list.\n", lst.size());

            } else if (command.substring(0, 5).equals("event")) {

                int escapeIndex = command.lastIndexOf("/");
                Deadline deadline = new Deadline(command.substring(6, escapeIndex - 1), command.substring(escapeIndex + 4));
                lst.add(deadline);
                System.out.format("Got it. I've added this task:\n" + deadline.getStatusAndDescription() + "\n"
                        + "Now you have %d tasks in this list.\n", lst.size());
            } else {
                lst.add(new Task(command));
                System.out.println("added: " + command);
            }
        }
    }
}
