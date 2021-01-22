package controller;

import model.Course;
import daoImplementation.CourseDao;
import java.util.Locale;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* @author Marc */
@Controller
public class CourseController {

    @RequestMapping(value = "/Course", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "CreateCourse";
    }

    @RequestMapping(value = "/CourseList", method = RequestMethod.GET)
    public String list(Locale locale, Model model) {
        CourseDao courseDao = new CourseDao();
        List<Course> csList = courseDao.findAll();
        model.addAttribute("csList", csList);
        return "ListCourse";
    }

    @RequestMapping(value = "/CourseDelete/{id}")
    public String delete(@PathVariable("id") int courseId, Model model) {
        CourseDao courseDaod = new CourseDao();    
        courseDaod.delete(courseId);
        return "redirect:/CourseList";
    }

    @RequestMapping(value = "/FormCourseUpdate/{id}")
    public String update(@PathVariable("id") int courseId, Model model) {
        CourseDao courseDaou = new CourseDao();
        model.addAttribute("cs", courseDaou.findById(courseId));
        return "UpdateCourse";
    }

    @RequestMapping(value = "/createCourse", method = RequestMethod.POST)
    public String createCourse(@Validated Course c, Model model) {//(@ModelAttribute("student") Course s) {
        CourseDao courseDaoc = new CourseDao();
        if (!courseDaoc.existById(c.getCourseId())) {
            courseDaoc.create(c);
            return "redirect:/CourseList";
        } else {
            model.addAttribute("message", "Course id exists.Try again");
            return "CreateCourse";
        }
    }

    @RequestMapping(value = "/courseUpdate")
    public String updateStu(@Validated Course c, Model model) {
        CourseDao courseDaou = new CourseDao();
        courseDaou.update(c);
        System.out.println("update student");
        return "redirect:/CourseList";
    }
}
