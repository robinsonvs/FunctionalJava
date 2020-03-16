package streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.*;
import static streams._Stream2.Gender.*;

public class _Stream2 {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Marie", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );

        List<Person> people2 = List.of(
                new Person("John", MALE),
                new Person("Marie", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        boolean containsOnlyFemales = people.stream()
                .allMatch(personPredicate);
        out.println(containsOnlyFemales);

        containsOnlyFemales = people.stream()
                .anyMatch(personPredicate);
        out.println(containsOnlyFemales);

        Predicate<Person> personPredicateNoBob = person -> PREFER_NOT_TO_SAY.equals(person.gender);
        containsOnlyFemales = people2.stream()
                .noneMatch(personPredicateNoBob);
        out.println(containsOnlyFemales);

        //*************************************************

    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
