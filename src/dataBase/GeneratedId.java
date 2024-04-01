package dataBase;

public class GeneratedId {
    public static Long personId = 0L;
    public static Long genPersonId(){
        return ++personId;
    }
}
