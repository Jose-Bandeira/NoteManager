import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoteManager {
    Scanner scanner = new Scanner(System.in);
    private final List<Note> notes;


    public NoteManager() {
        this.notes = new ArrayList<>();
    }

    public void newNote() {
        System.out.println("note name: ");
        String name = scanner.nextLine();
        System.out.println("note description");
        String description = scanner.nextLine();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt"));
            writer.write(description);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Note note = new Note(name, description);
        notes.add(note);
        System.out.println("Nota " + note.getName() + " adicionada com sucesso");
    }

    public void readNote() {
        System.out.println("Escolha a nota a ser lida: ");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }

        System.out.println("insira o número da nota a ser escolhida: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > notes.size()) {
            System.out.println(" escolha inválida. por favor, escolha um número entre 1 e " + notes.size() + ".");
        } else {
            Note chosenItem;
            chosenItem = (notes.get(choice - 1));
            File file = new File(chosenItem.getName() + ".txt");
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void delete() {
        System.out.println("Escolha a nota que deseja deletar: ");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }

        System.out.println("Insira o número da nota a ser escolhida: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option < 1 || option > notes.size()) {
            System.out.println("Escolha inválida. tente novamente.");
        } else {
            Note userOption = notes.get(option - 1);
            File fileToDelete = new File(userOption.getName() + ".txt");
            if (fileToDelete.exists()) {
                try {
                    if (fileToDelete.delete()) {
                        System.out.println("Note '" + fileToDelete.getName() + "' deleted successfully!");
                        notes.remove(fileToDelete);
                    } else {
                        System.out.println("houve uma falha ao deletar a nota");
                    }
                } catch (SecurityException e) {
                    System.out.println("SecurityException: unable to delete the file due to security restrictions");
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    System.out.println("NullPointerException: the file is null");
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println("An unexpected error ocurred when deleting the file.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("file does not exist.");
            }
        }

    }


    public void exit() {
        System.out.println("Saindo...");
        System.exit(0);
    }
}

