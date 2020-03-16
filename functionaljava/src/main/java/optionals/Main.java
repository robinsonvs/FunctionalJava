package optionals;

import java.util.Optional;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");
        out.println(value);

        Object value2 = Optional.ofNullable("null")
                .orElseThrow(() -> new IllegalStateException("exception"));
        out.println(value2);

        Optional.ofNullable("john@gmail.com")
                .ifPresent(email -> out.println("Sending email to " + email));

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> out.println("Sending email to " + email),
                        () -> out.println("Cannot send email"));

        //**************************************************

        Person person = new Person("james", null);
        String email = person
                .getEmail()
                .map(String::toLowerCase)
                .orElse("email not provided");
        out.println(email);

    }
}

class Person {
    private final String name;
    private final String email;

    Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}
