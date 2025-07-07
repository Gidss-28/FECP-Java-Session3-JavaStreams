package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaStreams {
    public static void main (String[] args){
        // Activity 1
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> isOdd = n -> n % 2 != 0;

        List<Integer> oddNumbers = numbers.stream().filter(isOdd).toList();
        // Activity 1 Output
        System.out.println("Odd Numbers: " + oddNumbers);

        // Activity 2
        List<String> names = Arrays.asList("Alice", "Adam", "Bob", "Angela", "Brian");

        Predicate<String> startsWithA = s -> s.startsWith("A");

        List<String> nameStartsWithA = names.stream().filter(startsWithA).toList();
        // Activity 2 Output
        System.out.println("Names starting with A: " + nameStartsWithA);

        // Activity 3
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squaredIntegers= integers.stream().map(number -> number * number).toList();
        // Activity 3 Output
        System.out.println("Squared Numbers: " + squaredIntegers);

        // Activity 4
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> greaterThanFive = n -> n > 5;

        Predicate<Integer> combined = isEven.and(greaterThanFive);

        List<Integer> combinedPredicate = numberList.stream().filter(combined).toList();
        // Activity 4 Output
        System.out.println("Even and >5: " + combinedPredicate);

        // Activity 5
        List<Person> people = Arrays.asList(new Person("Gideon", 22),
                new Person("Kayne", 15),
                new Person("Dz", 48),
                new Person("Luis", 30),
                new Person("Earl", 27));

        Consumer<Person> printPerson = System.out::println;

        // Sort by age ascendingly
        System.out.println("Sort by age (ascending):");
        people.sort(Comparator.comparingInt(Person::getAge));
        people.forEach(printPerson);
        System.out.println();
        // Sort by name alphabetically
        System.out.println("Sort by name (ascending):");
        people.sort(Comparator.comparing(Person::getName));
        people.forEach(printPerson);
        System.out.println();
        // Sort by age descendingly
        System.out.println("Sort by age (descending):");
        people.sort(Comparator.comparingInt(Person::getAge).reversed());
        people.forEach(printPerson);
        System.out.println();
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " - " + age;
    }
}
