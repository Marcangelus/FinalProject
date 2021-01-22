package daoInterface;

import java.util.List;
import model.Marks;

/**
 *
 * @author Marc
 */
public interface MarksInter {

    boolean create(Marks marks);

    void delete(int studentid, int courseid);

    void deleteC(int courseid);

    void deleteS(int studentid);

    void update(Marks marks);

    Marks findById(int studentid, int courseid);

    List<Marks> findById(int student);

    List<Marks> findAll();

    public List<Marks> findAllS();

    boolean existById(int studentid);

    boolean existByIdS(int studentid);

    boolean existByIdC(int courseid);

}
