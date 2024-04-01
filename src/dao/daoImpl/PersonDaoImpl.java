package dao.daoImpl;

import dao.PersonDao;
import dataBase.DataBase;
import model.Person;

import java.util.List;

public class PersonDaoImpl implements PersonDao {
    @Override
    public void savePerson(Person person) {
        DataBase.people.add(person);
        System.out.println("успешно сохранено");
    }

    @Override
    public List<Person> getAllPerson() {
        return DataBase.people;
    }

    @Override
    public Person getPersonByName(String name) {
        for (Person person : DataBase.people) {
            if (person.getFirstName().equals(name)) {
                return person;
            }
        }
        throw new RuntimeException("не найдено");
    }

    @Override
    public Person updatePersonById(Long id, Person person) {
        for (Person person1 : DataBase.people) {
            if (person1.getId().equals(id)) {
                person1.setFirstName(person.getFirstName());
                person1.setLastName(person.getLastName());
                person1.setAge(person.getAge());
                person1.setEmail(person.getEmail());
                person1.setId(person.getId());
                return person1;
            }
        }
        throw new RuntimeException("не найдено");
    }

    @Override
    public String deletePersonById(Long id) {
        for (Person person : DataBase.people) {
            if (person.getId().equals(id)) {
                DataBase.people.remove(person);
                return "успешно удалено";
            }
        }
        throw new RuntimeException("не найдено");
    }
}
