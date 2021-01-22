package daoImplementation;

import model.Course;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import HibernateUtil.HibernateUtil;
import daoInterface.CourseInter;
import java.util.List;

/* @author Marc */
public class CourseDao implements CourseInter {

    public boolean create(Course course) {
        if (!existById(course.getCourseId())) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            try {
                session.save(course);
                tx.commit();
                session.close();

            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public void update(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            try {
                session.update(course);
                tx.commit();
                session.close();

            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
            }
    }

    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Course course = (Course) session.get(Course.class, new Integer(id));
            session.delete(course);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public Course findById(int id) {
        Course course = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            course = (Course) session.get(Course.class, new Integer(id));
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return course;
    }

    public List<Course> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            System.out.println("Listing Courses");
            List<Course> courses = session.createQuery("from Course").list(); // Hibernate Query Language
            return courses;
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
