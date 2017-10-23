package data;

import java.util.Collection;
import java.util.List;

/**
 * Util class
 */
public class Util {
    /*public static boolean contains(List<EventOrganization> list, EventOrganization org) {
        //System.out.println(list.size());
        //System.out.println(org.getName());
        //System.out.println(list.contains(org));
        return list.contains(org);
    }

    public static boolean contains(List<User> list, User user) {
        //System.out.println(list.size());
        //System.out.println(org.getName());
        //System.out.println(list.contains(org));
        return list.contains(user);
    }*/

    public static boolean contains(Collection<?> coll, Object o) {
        return coll.contains(o);
    }
}
