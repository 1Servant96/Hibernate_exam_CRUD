package peaksoft.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.Entity.Person;

import java.util.Properties;

public class DbConnection {
    private static final SessionFactory sessionFactory = createSessionFactory();

    public static SessionFactory createSessionFactory (){
    Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "1234");

        properties.put(Environment.HBM2DDL_AUTO, "create");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");
    Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Person.class);
        return configuration.buildSessionFactory();
}
public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}

