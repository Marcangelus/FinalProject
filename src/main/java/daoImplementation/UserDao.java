/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementation;

import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import HibernateUtil.HibernateUtil;
import daoInterface.UserInter;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/* * @author Marc */
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class UserDao implements UserInter {

//    @Autowired//
//    private SessionFactory sessionFactory;//

    @Transactional//
    public void create(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(user);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Transactional//
    public void delete(int id) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            User user = (User) session.get(User.class, new Integer(id));
            session.delete(user);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Transactional//
    public User findById(String nick,String pass ) {
      Session session = HibernateUtil.getSessionFactory().openSession();
        User auser = null;
        try { 
            String hql = "from User where nickUser = :nickUser and Password=:Password";
            Query query = session.createQuery(hql);
            query.setParameter("nickUser", nick);
            query.setParameter("Password", pass);
            auser = (User) query.uniqueResult();
            
                
        } catch (Exception e) {
            System.out.println("Error has occurred\n" + e);
        } finally {
            System.out.println("closing session");
            session.close();
        }
       return auser;
    }

    @Transactional//
    public List<User> listUsers() {
       Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            System.out.println("Listing Users");
            List<User> users = session.createQuery("from User").list(); // Hibernate Query Language
            return users;
        } catch (Exception e) {
            System.out.println("Error has occurred\n" + e);
        } finally {
            System.out.println("closing session");
            session.close();
        }

        return null;
    }

    @Transactional//
    public void update(User user) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(user);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

//    @Transactional//
   // public boolean existById(User user) {
         public boolean existById(String nick,String pass ) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        boolean t = false;
        try { 
            String hql = "from User where nickUser = :nickUser and Password=:Password";
            Query query = session.createQuery(hql);
            query.setParameter("nickUser", nick);
            query.setParameter("Password", pass);
            User auser = (User) query.uniqueResult();
            if (auser != null) {
                return true;
            }
            session.close();

        } catch (Exception e) {
            System.out.println("Error has occurred\n" + e);
        } finally {
            System.out.println("closing session");
            session.close();
        }
        return t;
    }
}
