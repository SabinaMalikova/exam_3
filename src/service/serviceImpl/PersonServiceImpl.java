package service.serviceImpl;

import Myexception.MyException;
import dataBase.DataBase;
import model.Person;
import service.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService {


    @Override
    public void savePerson(Person person) {
        boolean isTrue = false;
        try {
            for (Person person1 : DataBase.people) {
                if (person1.getFirstName().equalsIgnoreCase(person.getFirstName()) && person1.getLastName().equalsIgnoreCase(person.getLastName())) {
                    isTrue = true;
                    break;
                }
            }
            if (!isTrue) {
                DataBase.people.add(person);
                System.out.println("успешно добавлено");
            } else {
                throw new MyException("такой человек с ФиО уже существует");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Person> getAllPerson() {
        return DataBase.people;
    }

    @Override
    public Person getPersonByName(String name) {
        try {
            for (Person person : DataBase.people) {
                if (person.getFirstName().equalsIgnoreCase(name)) {
                    return person;
                }
            }
            throw new MyException("нет с таким именем");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Person updatePersonById(Long id) {
        try {
            for (int i = 0; i < DataBase.people.size(); i++) {
                Person person = DataBase.people.get(i);
                if (person.getId().equals(id)) {
                    DataBase.people.set(i, person);
                    return person;
                }
            }
            throw new MyException("нет еловека с таким Id ");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deletePersonById(Long id) {
        try {
            for (Person person : DataBase.people) {
                if (person.getId().equals(id)) {
                    DataBase.people.remove(person);
                    return "успешно удалено";
                }
            }
            throw new MyException("нет такой группы");
        } catch (MyException e) {
            return e.getMessage();
        }
    }
}
