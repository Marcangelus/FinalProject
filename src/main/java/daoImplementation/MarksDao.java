package daoImplementation;

import daoInterface.MarksInter;
import HibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import model.Marks;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/* @author Marc */
public class MarksDao implements MarksInter {
 private SessionFactory sessionFactory;//
    public boolean create(Marks marks) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(marks);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public void delete(int studentid, int courseid) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            String hql = "delete from Marks m where m.student = :student and m.course=:course";
            // String hql = "delete from Marks where student = " +studentid+ " and course="+courseid;
            System.out.println(" " + hql);
            Query query = session.createQuery(hql);
            query.setParameter("student", studentid);
            query.setParameter("course", courseid);

            int rowsAffected = query.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deleted " + rowsAffected + " rows.");
            }
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error has occurred\n" + e);
        } finally {
            System.out.println("closing session");
            session.close();
        }
    }

    public void deleteC(int courseid) {
       Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            String hql = "delete from Marks m where m.course=:course";
            System.out.println(" " + hql);
            Query query = session.createQuery(hql);
            query.setParameter("course", courseid);

            int rowsAffected = query.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deleted " + rowsAffected + " rows.");
            }
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error has occurred\n" + e);
        } finally {
            System.out.println("closing session");
            session.close();
        }
    }

    public void deleteS(int studentid) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            String hql = "delete from Marks m where m.student = :student";
            System.out.println(" " + hql);
            Query query = session.createQuery(hql);
            query.setParameter("student", studentid);
            int rowsAffected = query.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deleted " + rowsAffected + " rows.");
            }
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error has occurred\n" + e);
        } finally {
            System.out.println("closing session");
            session.close();
        }
    }

    public void update(Marks marks) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(marks);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

//    public Marks findById(int studentid) {
//        Marks marks = null;
//        Session session = this.sessionFactory.getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            marks = (Marks) session.get(Marks.class, new Integer(studentid));
//            tx.commit();
//            session.close();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        }
//        return marks;
//    }
    public List<Marks> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            System.out.println("Listing Markss");
            List<Marks> markss = session.createQuery("from Marks").list(); // Hibernate Query Language
            return markss;
        } catch (Exception e) {
            System.out.println("Error has occurred\n" + e);
        } finally {
            System.out.println("closing session");
            session.close();
        }
        return null;
    }

    public List<Marks> findAllS() {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            String hql = "select distinct m.student FROM Marks m";
//           // Query query = session.createQuery(hql);
            Query query = session.createQuery(hql);
            List<Integer> markss = query.list();
            List<Marks> markk = new ArrayList();
            for (Integer mr : markss) {
                Marks marks = new Marks();
                marks.setStudent(mr);
                markk.add(marks);
            }
            return markk;
        } catch (Exception e) {
            System.out.println("Error has occurred\n" + e);
        } finally {
            System.out.println("closing session");
            session.close();
        }
        return null;
    }

    public boolean existById(int studentid, int courseid) {
        if (findById(studentid, courseid) == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean existByIdS(int studentid) {
        if (findById(studentid) == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean existByIdC(int courseid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Marks findById(int studentid, int courseid) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            String hql = "from Marks where student = :student and course=:course";
            Query query = session.createQuery(hql);
            query.setParameter("student", studentid);
            query.setParameter("course", courseid);
            Marks marks = (Marks) query.uniqueResult();
            session.close();
            return marks;
        } catch (Exception e) {
            System.out.println("Error has occurred\n" + e);
        } finally {
            System.out.println("closing session");
            session.close();
        }
        return null;
    }

    public boolean existById(int studentid) {
        if (findById(studentid) == null) {
            return false;
        } else {
            return true;
        }
    }

    public List<Marks> findById(int student) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            String hql = "from Marks where student = " + student;
            List<Marks> markss = session.createQuery(hql).list();
            session.close();
            return markss;
        } catch (Exception e) {
            System.out.println("Error has occurred\n" + e);
        } finally {
            System.out.println("closing session");
            session.close();
        }
        return null;
    }
}
