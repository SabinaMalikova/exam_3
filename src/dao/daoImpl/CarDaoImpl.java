package dao.daoImpl;
import dao.CarDao;
import dataBase.DataBase;
import model.Car;
import model.Person;
import java.util.List;

public class CarDaoImpl implements CarDao {
    @Override
    public void saveCar(Long id, Car car) {
        for (Person person : DataBase.people) {
            if (person.getId().equals(id)) {
                person.getCars().add(car);
                System.out.println("успешно сохранено");
            }
        }
        throw new RuntimeException("не найдено");
    }

    @Override
    public List<Car> getCarByPersonId(Long id) {
        for (Person person : DataBase.people) {
            if (person.getId().equals(id)) {
                return person.getCars();
            }
        }
        throw new RuntimeException("не найдено");
    }

    @Override
    public Car getCarById(Long id) {
        for (Person person : DataBase.people) {
            for (Car car : person.getCars()) {
                if (person.getId().equals(id)) {
                    return car;
                }

            }
        }
        throw new RuntimeException("не найдено");
    }

    @Override
    public void updateCarById(Long id, Car car) {
        for (Person person : DataBase.people) {
            for (Car car1 : person.getCars()) {
                if (car1.getId().equals(id)) {
                    car1.setName(car.getName());
                    car1.setModel(car.getModel());
                    car1.setYear(car.getYear());
                    return;
                }
            }
        }
        throw new RuntimeException("не найдено");


    }

    @Override
    public String deleteCarById(Long id) {
        for (Person person : DataBase.people) {
            for (Car car : person.getCars()) {
                if (car.getId().equals(id)) {
                    person.getCars().remove(car);
                    return "успешно удалено";
                }

            }
        }
        throw new RuntimeException("не найдено");
    }
}
