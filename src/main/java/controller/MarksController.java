package controller;

import model.Marks;
import daoImplementation.MarksDao;
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
public class MarksController {

    @RequestMapping(value = "/Marks", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "CreateMarks";
    }

    @RequestMapping(value = "/MarksList", method = RequestMethod.GET)
    public String list(Locale locale, Model model) {
        MarksDao marksDao = new MarksDao();
        List<Marks> csList = marksDao.findAll();
        model.addAttribute("csList", csList);
        return "ListMarks";
    }

    @RequestMapping(value = "/MarksDelete/{id}")
    public String delete(@PathVariable("id") int courseId, Model model) {
        MarksDao marksDaod = new MarksDao();    
      //  marksDaod.delete(courseId);
        return "redirect:/MarksList";
    }

    @RequestMapping(value = "/FormMarksUpdate/{id}")
    public String update(@PathVariable("id") int courseId, Model model) {
        MarksDao marksDaou = new MarksDao();
        model.addAttribute("cs", marksDaou.findById(courseId));
        return "UpdateMarks";
    }

    @RequestMapping(value = "/createMarks", method = RequestMethod.POST)
    public String createMarks(@Validated Marks c, Model model) {//(@ModelAttribute("student") Marks s) {
        MarksDao marksDaoc = new MarksDao();
//        if (!marksDaoc.existById(c.getMarks1())) {
//            marksDaoc.create(c);
//            return "redirect:/MarksList";
//        } else {
//            model.addAttribute("message", "Marks id exists.Try again");
            return "CreateMarks";
//        }
    }

    @RequestMapping(value = "/courseUpdate")
    public String updateStu(@Validated Marks c, Model model) {
        MarksDao marksDaou = new MarksDao();
        marksDaou.update(c);
        System.out.println("update student");
        return "redirect:/MarksList";
    }
}
