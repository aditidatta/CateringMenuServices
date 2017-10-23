package data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * UserDirectory class, where westore all the Users
 */
public class UserDirectory {

    private static List<User> users = new ArrayList<>();

    public static List<User> getListOfUsers(){
        return users;
    }

    public static User getUser(int CIN){
        int i = 0;
        for (User user: users) {
            if (user.getCIN() == CIN)
                break;
            else
                i++;

        }
        return users.get(i);
    }

    public static void addUser(User user){
        users.add(user);
    }

    public static void removeContact(User user){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User u = iterator.next();
            if(u.equals(user))
                iterator.remove();
        }
    }



}
