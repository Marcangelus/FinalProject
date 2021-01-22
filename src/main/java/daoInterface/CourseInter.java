package daoInterface;

import java.util.List;
import model.Course;

/**
 *
 * @author Marc
 */
public interface CourseInter {

    boolean create(Course course);

    void delete(int id);

    void update(Course course);

    Course findById(int id);

    List<Course> findAll();

    boolean existById(int id);
}
