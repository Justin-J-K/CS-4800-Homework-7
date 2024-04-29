package flyweight;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Document implements Serializable {
    private List<Character> characters;

    public Document(String filename) throws IOException {
        loadFromFile(filename);
    }

    public Document(List<Character> characters) {
        this.characters = characters;
    }

    public void saveToFile(String filename) throws IOException {
        try (FileOutputStream fileOutput = new FileOutputStream(filename)) {
            try (ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {
                objectOutput.writeObject(this);
                objectOutput.flush();
            }
        }
    }

    public void loadFromFile(String filename) throws IOException {
        try (FileInputStream fileInput = new FileInputStream(filename)) {
            try (ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
                Document document = (Document) objectInput.readObject();
                this.characters = document.characters;
            } catch (ClassNotFoundException e) {
                throw new IOException(String.format("File \"%s\" is not valid", filename));
            }
        }
    }

    @Override
    public String toString() {
        return characters.stream().map(Character::toString)
                .collect(Collectors.joining("\n"));
    }
}
