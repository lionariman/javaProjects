package serialisation;

// Serializetion
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

// Exceptions
import java.io.IOException;

// Array
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static List<Person> createPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Amogus", 100));
        people.add(new Person("Person", 250));
        people.add(new Person("Master", 500));
        people.add(new Person("Oracul", 750));
        people.add(new Person("God", 1000));
        return people;
    }

    public static void serialize(List<Person> people) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objects.bin"));
        oos.writeObject(people);
        oos.close();
    }

    public static List<Person> deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objects.bin"));
        List<Person> people = (List<Person>) ois.readObject();
        return people;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("... Create array of people ...");
        List<Person> people = createPeople();
        System.out.println(people);

        System.out.println("<< SERIALISATION >>");
        serialize(people);

        System.out.println("<< DESERIALISATION >>");
        List<Person> peopleRestored = deserialize();

        System.out.println("... Get new array of people and print them all");
        System.out.println(peopleRestored);
    }
}
