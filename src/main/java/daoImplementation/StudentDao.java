package daoImplementation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import HibernateUtil.HibernateUtil;
import daoInterface.StudentInter;
import java.util.List;
import javax.transaction.Transactional;
import model.Student;
import org.springframework.stereotype.Repository;

/* @author Marc */
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class StudentDao implements StudentInter {
 @Transactional//
    public boolean createStud(Student student) {
        if(!existById(student.getStudentId())){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(student);
            tx.commit();
            session.close();
           
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
           
        }  return true;
        }else  return false;
    }

    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Student student = (Student) session.get(Student.class, new Integer(id));
            session.delete(student);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(student);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public Student findById(int id) {
        Student student = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            student = (Student) session.get(Student.class, new Integer(id));
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return student;
    }

    public List<Student> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            System.out.println("Listing Students");
            List<Student> students = session.createQuery("from Student").list(); // Hibernate Query Language
            return students;
        } catch (Exception e) {
            System.out.println("Error has occurred\n" + e);
        } finally {
            System.out.println("closing session");
            session.close();
        }

        return null;
    }

    public boolean existById(int id) {
        if (findById(id) != null) {
            return true;
        } else {
            return false;
        }
    }
}
