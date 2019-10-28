

import com.huwa.entity.User;
import com.huwa.service.UserService;
import com.huwa.serviceImpl.UserServiceImpl;
import org.junit.Test;

public class Service {
     private UserService userService = new  UserServiceImpl();
     @Test
     public  void  userall() throws Exception {
         User user =new User();
         user.setUname("chen");
         user.setPwd("chen");
      User us= userService.userAll(user);
         System.out.println(us);
     }

}
