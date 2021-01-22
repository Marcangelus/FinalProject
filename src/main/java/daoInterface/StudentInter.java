package daoInterface;

import java.util.List;
import model.Student;

/**
 *
 * @author Marc
 */
public interface StudentInter {

    boolean createStud(Student student);

    void delete(int id);

    void update(Student student);

    Student findById(int id);

    List<Student> findAll();

    boolean existById(int id);

}
