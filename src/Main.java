import dataBase.GeneratedId;
import model.Person;
import service.PersonService;
import service.serviceImpl.PersonServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonServiceImpl();
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    1.savePerson()
                    2.getAllPerson()
                    3.getPersonByName()
                    4.updatePersonById()
                    5.deletePersonById()
                    6.exit
                    """);
            switch (new Scanner(System.in).nextLine()){
                case "1": {
                    Person person = new Person();
                    System.out.println("имя: ");
                    person.setFirstName(new Scanner(System.in).nextLine());
                    System.out.println("фамилия: ");
                    person.setLastName(new Scanner(System.in).nextLine());
                    System.out.println("email: ");
                    person.setEmail(new Scanner(System.in).nextLine());
                    System.out.println("age: ");
                    person.setAge(new Scanner(System.in).nextInt());
                    person.setId(GeneratedId.genPersonId());
                    System.out.println("личный ID: ");
                    personService.savePerson(person);
                    break;
                }
                case "2":{
                    System.out.println(personService.getAllPerson());
                    break;
                }
                case "3":{
                    System.out.println("Введите имя: ");
                    System.out.println(personService.getPersonByName(new Scanner(System.in).nextLine()));
                    break;
                }
                case "4":{
                    System.out.println();
                    personService.updatePersonById(new Scanner(System.in).nextLong());
                    break;
                }
                case "5":{
                    System.out.println("введите Id: ");
                    System.out.println(personService.deletePersonById(new Scanner(System.in).nextLong()));
                    break;
                }
                case "6":{
                    exit = true;
                    break;
                }
            }
        }
    }
}