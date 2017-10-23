package data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MenuDirectory {
    private static List<Menu> menus = new ArrayList<>();

    public static List<Menu> getListOfMenus(){
        return menus;
    }

    public static Menu getMenu(int id){

        for (Menu e : menus) {
            if (e.getId() == id)
                return  e;
        }
        return null;
    }

    public static void addMenu(Menu menu){
        menus.add(menu);
    }

    public static void removeMenu(Menu menu){
        Iterator<Menu> iterator = menus.iterator();
        while(iterator.hasNext()) {
            Menu m = iterator.next();
            if (m.equals(menu)){
                iterator.remove();
                break;
            }
        }
    }

    public static void removeMenu(int id){
        Iterator<Menu> iterator = menus.iterator();
        while(iterator.hasNext()){
            Menu m = iterator.next();
            if(m.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }
}
