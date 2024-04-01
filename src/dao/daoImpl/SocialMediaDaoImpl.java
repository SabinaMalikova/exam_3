package dao.daoImpl;
import dao.SocialMediaDao;
import dataBase.DataBase;
import model.Person;
import model.SocialMedia;
import java.util.List;

public class SocialMediaDaoImpl implements SocialMediaDao {
    @Override
    public void assignSocialMediaToPerson(Long personId, Long id) {
        for (Person person : DataBase.people) {
            if (person.getId().equals(personId)) {
                for (SocialMedia socialMedia : DataBase.socialMedia) {
                    if (socialMedia.getId().equals(id)) {
                        person.getSocialMedia().add(socialMedia);
                        System.out.println("успешно назначено");
                        return;
                    }
                }
            }
        }
        throw new RuntimeException("не найдено");
    }

    @Override
    public String saveSocialMedia(SocialMedia media) {
        DataBase.socialMedia.add(media);
        return "успешно сохранено";
    }

    @Override
    public SocialMedia getSocialMediaById(Long id) {
        for (SocialMedia socialMedia : DataBase.socialMedia) {
            if (socialMedia.getId().equals(id)) {
                return socialMedia;
            }
        }
        throw new RuntimeException("не найдено");
    }

    @Override
    public List<SocialMedia> getAllSocialMediaByPersonId(Long id) {
        for (Person person : DataBase.people) {
            if (person.getId().equals(id)) {
                return person.getSocialMedia();
            }
        }
        throw new RuntimeException("не найдено");
    }

    @Override
    public void deleteAllSocialMediaByPersonId(Long id) {
        for (Person person : DataBase.people) {
            if (person.getId().equals(id)) {
                DataBase.people.remove(person);
                System.out.println("успешно удалено");
                return;
            }
        }
        throw new RuntimeException("не найдено");
    }


    @Override
    public void deleteSocialMediaById(Long id) {
        for (Person person : DataBase.people) {
            for (SocialMedia socialMedia : person.getSocialMedia()) {
                if (socialMedia.getId().equals(id)){
                    person.getSocialMedia().remove(socialMedia);
                    System.out.println("успешно удалено");
                    return;
                }
            }
        }
        throw new RuntimeException("не найдено");
    }
}
