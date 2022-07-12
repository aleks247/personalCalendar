import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<event> events = new ArrayList<>();

    public static event searchByName(String name) {
        for (int i = 0; i < events.size(); i++) {
            if (name.equals(events.get(i).name)) {
                return events.get(i);
            }
        }
        return null;
    }

    public static void searchEvent() {
        System.out.println("Enter event title: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        event Event = searchByName(name);
        if (Event != null) {
            System.out.println(Event.name + " " + Event.date + " " + Event.startTime + " " + Event.endTime + " " + Event.notes + " ");
            System.out.println("Do you want to cancel or edit event (1 - Cancel | 2 - Edit | press any key to continue)");
            String option = scan.nextLine();
            switch (option) {
                case "1" -> {
                    System.out.println("Are you sure you want to cancel the event ? (Yes/No)");
                    String checking = scan.nextLine();
                    String checking1 = scan.nextLine();
                    if (checking1.equals("Yes") || checking1.equals("yes")) {
                        events.remove(Event);
                    }
                }
                case "2" -> {
                    System.out.println("Enter new start time: ");
                    Event.startTime = scan.next();
                    System.out.println("Enter new end time: ");
                    Event.endTime = scan.next();
                    System.out.println("Successfully updated the event !");
                }
                default -> System.out.println();
            }
        } else {
            System.out.println("There's no such event");
        }

    }

    public static ArrayList<event> searchByDate(String date) {
        ArrayList<event> result = new ArrayList<>();
        for (int i = 0; i < events.size(); i++) {
            if (date.equals(events.get(i).date)) {
                result.add(events.get(i));
            }
        }
        if (result.size() > 0) {
            return result;
        }
        return null;
    }

    public static void schedule() {
        System.out.println("Enter date(dd/mm/yy): ");
        Scanner scan = new Scanner(System.in);
        String date = scan.nextLine();
        ArrayList<event> eventi = searchByDate(date);
        if (eventi != null) {
            System.out.println("__Daily schedule__");
            for (int i = 0; i < eventi.size(); i++) {
                System.out.println(eventi.get(i).name + " " + eventi.get(i).date + " " + eventi.get(i).startTime + " " + eventi.get(i).endTime + " " + eventi.get(i).notes + " ");
            }
        } else {
            System.out.println("There are no saved events for the day.");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("____Personal Calendar____");
            System.out.println("      Chose option ");
            System.out.println("------------------------");
            System.out.println("|1 - Create an event   |");
            System.out.println("|2 - Daily schedule    |");
            System.out.println("|3 - Search event      |");
            System.out.println("|4 - Find availability |");
            System.out.println("|5 - Exit program      |");
            System.out.println("________________________");
            System.out.print("Enter option: ");

            int option = scan.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("Enter event name: ");
                    String EventName = scan.next();
                    System.out.println("Enter event date (dd/mm/yy): ");
                    String date = scan.next();
                    System.out.println("Enter event start time: ");
                    String start = scan.next();
                    System.out.println("Enter event end time: ");
                    String finish = scan.next();
                    System.out.println("Enter notes to the event: ");
                    String trash = scan.nextLine();
                    String text = scan.nextLine();
                    System.out.println();
                    System.out.println("Event was created successfully!");
                    event Event = new event(EventName, date, start, finish, text);
                    events.add(Event);
                }
                case 2 -> {
                    System.out.println();
                    schedule();
                }
                case 3 -> {
                    System.out.println();
                    searchEvent();
                }
            }
        }
    }
}
