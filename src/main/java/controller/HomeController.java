package controller;

//import Service.UserService;
import daoImplementation.UserDao;
import java.util.Locale;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/* @author Marc */
@Controller
public class HomeController {
//    private UserService userService;
//
//    @Autowired(required = true)
//    @Qualifier(value = "userService")
//    public void setCourseService(UserService userService) {
//        this.userService = userService;
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {       
        return "home";
    }

    
   @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String user(@Validated User user, Model model) {
        UserDao userDao = new UserDao();
        System.out.println("User Entering");
        if (userDao.existById(user.getNickUser(),user.getPassword())) {//modificar 
            model.addAttribute("nUser", user.getNickUser());
           // System.out.println("User Found");
          //  model.addAttribute("pKey", user.getPassword());
          switch(userDao.findById(user.getNickUser(),user.getPassword()).getRole()){////modificar 
              case 1:
                  return "index_admon";
                  //break;
              case 2:
                  return "index_teacher";
                  //break;
              case 3: return "index_student";
              default:  return "home";
          }
        } else {
            model.addAttribute("message", "Nick or Password is incorrect.Try again");
            return "home";
        }
    }
}
