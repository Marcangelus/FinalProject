package controller;

import model.Student;
import daoImplementation.StudentDao;
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
public class StudentController {

    @RequestMapping(value = "/Student", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "CreateStudent";
    }

    @RequestMapping(value = "/StudentList", method = RequestMethod.GET)
    public String list(Locale locale, Model model) {
        StudentDao stDao = new StudentDao();
        List<Student> studList = stDao.findAll();
        model.addAttribute("studList", studList);
        return "ListStudent";
    }

    @RequestMapping(value = "/StudentDelete/{id}")
    public String delete(@PathVariable("id") int studentId, Model model) {
        StudentDao stDaod = new StudentDao();
        System.out.println("studentId " + studentId);
        stDaod.delete(studentId);
        return "redirect:/StudentList";
    }

    @RequestMapping(value = "/FormStudentUpdate/{id}")
    public String update(@PathVariable("id") int studentId, Model model) {
        StudentDao stDaou = new StudentDao();
        model.addAttribute("Stu", stDaou.findById(studentId));
        return "UpdateStudent";
    }

    @RequestMapping(value = "/createStudent", method = RequestMethod.POST)
    public String createStudent(@Validated Student s, Model model) {//(@ModelAttribute("student") Student s) {
        StudentDao stDaoc = new StudentDao();
        if (!stDaoc.existById(s.getStudentId())) {
            stDaoc.createStud(s);
            return "redirect:/StudentList";
        } else {
            model.addAttribute("message", "Student id exists.Try again");
            return "CreateStudent";
        }
    }

    @RequestMapping(value = "/studentUpdate")
    public String updateStu(@Validated Student s, Model model) {
        StudentDao stDaou = new StudentDao();
        System.out.println(" "+s.getStudentId());
        stDaou.update(s);
        System.out.println("update student");
        //model.addAttribute("Stu", s);
        return "redirect:/StudentList";
    }
}
