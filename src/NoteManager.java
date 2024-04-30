import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoteManager {
    Scanner scanner = new Scanner(System.in);
    private List<Note>notes;


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
        System.out.println("Choose the note you want to read: ");
        for (Note note: notes) {
            for (int i = 0 ; i < notes.size(); i++)
                System.out.println(notes.get(i) + "." + note);
        }
    }

    public void exit() {
        System.out.println("Saindo...");
        System.exit(0);
    }


}
