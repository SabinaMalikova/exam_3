import dataBase.GeneratedId;
import model.Car;
import model.Person;
import model.SocialMedia;
import service.CarService;
import service.PersonService;
import service.SocialMediaService;
import service.serviceImpl.CarServiceImpl;
import service.serviceImpl.PersonServiceImpl;
import service.serviceImpl.SocialMediaServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonServiceImpl();
        CarService carService = new CarServiceImpl();
        SocialMediaService socialMediaService = new SocialMediaServiceImpl();

        try {
            while (true) {
                System.out.println("""
                        1. save person                                       
                        2. get all person                 
                        3. get person by name             
                        4. update person bu id                    
                        5. deleted person by id    
                        6. save media                             
                        7. assign media to person
                        8. get social media by id  
                        9. get all media 
                        10. delete media by person id
                        11. delete media by id
                        12. save car
                        13. get car by person id
                        14. update car by id
                        15. delete cr=ar by id   
                             """);
                switch (new Scanner(System.in).nextLine()) {
                    case "1" -> {
                        Person person = new Person();
                        System.out.println("Введите имя ");
                        person.setFirstName(new Scanner(System.in).nextLine());
                        System.out.println("Введите фамилию");
                        person.setLastName(new Scanner(System.in).nextLine());
                        System.out.println("Введите возраст");
                        person.setAge(new Scanner(System.in).nextInt());
                        System.out.println("Введите email");
                        person.setEmail(new Scanner(System.in).nextLine());
                        person.setId(GeneratedId.getPersonId());
                        personService.savePerson(person);
                    }
                    case "2" -> {
                        System.out.println(personService.getAllPerson());
                    }
                    case "3" -> {
                        System.out.println("Введите имя");
                        System.out.println(personService.getPersonByName(new Scanner(System.in).nextLine()));
                    }
                    case "4" -> {
                        System.out.println("Введите ID человека которого нужно обновить");
                        Long id = new Scanner(System.in).nextLong();
                        Person person = new Person();
                        System.out.println("Введите новое имя");
                        person.setFirstName(new Scanner(System.in).nextLine());
                        System.out.println("Введите фамилию");
                        person.setLastName(new Scanner(System.in).nextLine());
                        System.out.println("Введите возраст");
                        person.setAge(new Scanner(System.in).nextInt());
                        System.out.println("Введите email");
                        person.setEmail(new Scanner(System.in).nextLine());
                        System.out.println(personService.updatePersonById(id, person));
                    }
                    case "5" -> {
                        System.out.println("Введите ID человека которого нужно удалить");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println(personService.deletePersonById(id));
                    }
                    case "6"->{
                        SocialMedia socialMedia = new SocialMedia();
                        System.out.println("Введите имя");
                        socialMedia.setName(new Scanner(System.in).nextLine());
                        socialMedia.setId(GeneratedId.getMediaId());
                        System.out.println(socialMediaService.saveSocialMedia(socialMedia));
                    }
                    case "7"->{
                        System.out.println("Введите id человека ");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("Введите id social media  ");
                        Long mediaId = new Scanner(System.in).nextLong();
                        socialMediaService.assignSocialMediaToPerson(id,mediaId);
                    }
                    case "8"->{
                        System.out.println("Введите id social media  ");
                        Long mediaId = new Scanner(System.in).nextLong();
                        System.out.println(socialMediaService.getSocialMediaById(mediaId));
                    }
                    case "9"->{
                        System.out.println("Введите id человека  ");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println(socialMediaService.getAllSocialMediaByPersonId(id));
                    }
                    case "10"->{
                        System.out.println("Введите id человека  ");
                        Long id = new Scanner(System.in).nextLong();
                        socialMediaService.deleteAllSocialMediaByPersonId(id);
                    }
                    case "11"->{
                        System.out.println("Введите id social media  ");
                        Long mediaId = new Scanner(System.in).nextLong();
                        socialMediaService.deleteSocialMediaById(mediaId);
                    }
                    case "12" -> {
                        Car car = new Car();
                        System.out.println("Введите имя ");
                        car.setName(new Scanner(System.in).nextLine());
                        System.out.println("Введите model");
                        car.setModel(new Scanner(System.in).nextLine());
                        System.out.println("Введите год выпуска ");
                        car.setYear(LocalDate.of(new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt()));
                        car.setId(GeneratedId.getCarId());
                        System.out.println("Введите id человека");
                        Long id = new Scanner(System.in).nextLong();
                        carService.saveCar(id, car);
                    }
                    case "13" -> {
                        System.out.println("Введите id человека");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println(carService.getCarById(id));
                    }
                    case "14" -> {
                        Car car = new Car();
                        System.out.println("Введите id машины ");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("Введите новое имя");
                        car.setName(new Scanner(System.in).nextLine());
                        System.out.println("Введите model");
                        car.setModel(new Scanner(System.in).nextLine());
                        System.out.println("Введите год выпуска ");
                        car.setYear(LocalDate.of(new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt()));
                        carService.updateCarById(id, car);
                    }
                    case "15" -> {
                        System.out.println("Введите id машины  ");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println(carService.deleteCarById(id));
                    }
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(" exception ");
        }
    }
}