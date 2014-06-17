package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * collection.User: alexey
 * Date: 15.06.14
 * Time: 11:07
 * To change this template use File | Settings | File Templates.
 */
public class UsersRepo {

    public List<User> getCollection() {
        return  new ArrayList<User>(){
            {add(new User("1255", "123456"));}
            {add(new User("123", "123345"));}
        };
    }
}
