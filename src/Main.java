import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NoteManager noteManager = new NoteManager();
        while (true){
            int option = 0;
            System.out.println("Welcome to the Note Manager!");
            System.out.println("1. Create note");
            System.out.println("2. Read note");
            System.out.println("3. Delete note");
            System.out.println("4. Exit");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    noteManager.newNote();
                    break;
                case 2:
                    noteManager.readNote();
                    break;
                case 3:

                case 4:
                        noteManager.exit();
                        break;
                default:
                    System.out.println("Invalid command. use the numbers 1-4 to access one option. please try again.");
            }
        }
    }
}
