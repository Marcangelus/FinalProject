package HibernateUtil;

import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class HibernateUtil {

    @Autowired
    private static SessionFactory sessionFactory;

    @Transactional//
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            sessionFactory = new Configuration().configure().buildSessionFactory();
//            Configuration configuration = new Configuration().configure();
//            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
//                    applySettings(configuration.getProperties());
//            //SessionFactory factory = configuration.buildSessionFactory(builder.build());
//               sessionFactory= configuration.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }
}
