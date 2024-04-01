import dataBase.GeneratedId;
import model.Person;
import service.PersonService;
import service.serviceImpl.PersonServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonServiceImpl();
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            System.out.println("""
                1.savePerson()
                2.getAllPerson()
                3.getPersonByName()
                4.updatePersonById()
                5.deletePersonById()
                6.exit
                """);
            switch (scanner.nextLine()) {
                case "1": {
                    Person person = new Person();
                    System.out.println("имя: ");
                    person.setFirstName(scanner.nextLine());
                    System.out.println("фамилия: ");
                    person.setLastName(scanner.nextLine());
                    System.out.println("email: ");
                    String email = scanner.nextLine();
                    boolean isTrue = false;
                    while (!isTrue) {
                        try {
                            if (email.contains("@")) {
                                isTrue = true;
                            } else {
                                throw new IllegalArgumentException("должен содержать @ ");
                            }
                        } catch (IllegalArgumentException e) {
                            System.err.println(e.getMessage());
                            email = scanner.nextLine();
                        }
                    }
                    person.setEmail(email);
                    System.out.println("age: ");
                    int age = 0;
                    boolean isTrue1 = false;
                    while (!isTrue1) {
                        try {
                            age = Integer.parseInt(scanner.nextLine());
                            if (age > 0 && age < 100) {
                                isTrue1 = true;
                            } else {
                                throw new IllegalArgumentException("неверное значение");
                            }
                        } catch (IllegalArgumentException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    person.setAge(age);
                    person.setId(GeneratedId.genPersonId());
                    System.out.println("личный ID: " + person.getId());
                    personService.savePerson(person);
                    break;
                }
                case "2": {
                    System.out.println(personService.getAllPerson());
                    break;
                }
                case "3": {
                    System.out.println("Введите имя: ");
                    System.out.println(personService.getPersonByName(scanner.nextLine()));
                    break;
                }
                case "4": {
                    Person person = new Person();
                    System.out.println("новое имя: ");
                    person.setFirstName(scanner.nextLine());
                    System.out.println("новая фамилия: ");
                    person.setLastName(scanner.nextLine());
                    System.out.println("новый email: ");
                    String email = scanner.nextLine();
                    boolean isTrue = false;
                    while (!isTrue) {
                        try {
                            if (email.contains("@")) {
                                isTrue = true;
                            } else {
                                throw new IllegalArgumentException("должен содержать @ ");
                            }
                        } catch (IllegalArgumentException e) {
                            System.err.println(e.getMessage());
                            email = scanner.nextLine();
                        }
                    }
                    person.setEmail(email);
                    System.out.println("age: ");
                    int age = 0;
                    boolean isTrue1 = false;
                    while (!isTrue1) {
                        try {
                            age = Integer.parseInt(scanner.nextLine());
                            if (age > 0 && age < 100) {
                                isTrue1 = true;
                            } else {
                                throw new IllegalArgumentException("неверное значение");
                            }
                        } catch (IllegalArgumentException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    person.setAge(age);
                    System.out.println("Введите id: ");
                    personService.updatePersonById(new Scanner(System.in).nextLong(),person);
                    break;
                }
                case "5": {
                    System.out.println("введите ID: ");
                    System.out.println(personService.deletePersonById(new Scanner(System.in).nextLong()));
                    break;
                }
                case "6": {
                    exit = true;
                    break;
                }
            }
        }

    }

}