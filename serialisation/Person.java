package serialisation;

import java.io.Serializable;

public record Person(String name, int age) implements Serializable {

    private static final long SerialVersionUID = 4862926644813533707L;

    @Override
    public String toString() {
        return name + " has " + age;
    }
}
