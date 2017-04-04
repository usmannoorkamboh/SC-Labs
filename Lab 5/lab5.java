import com.opencsv.CSVReader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by usmannoor on 29/03/2017.
 */
public class lab5 {

    public static void read_data(Session session, SessionFactory factory) {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader("/Users/usmannoor/Desktop/data.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] nextLine;
        try {
            session = factory.openSession();
            Transaction trans = session.beginTransaction();
            nextLine = reader.readNext();
            nextLine = reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line

                City city = new City();
                city.id = nextLine[0];
                city.country = nextLine[1];
                city.region = nextLine[2];
                city.ciity = nextLine[3];
                city.postal_code = nextLine[4];
                city.latitude = nextLine[5];
                city.longitude = nextLine[6];
                city.metro_code = nextLine[7];
                city.area_code = nextLine[8];
            }
            trans.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        //creating configuration object
        Configuration config = new Configuration();

        config.configure("hibernate.cfg.xml");//populates the data of the configuration file

        //creating seession factory object
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory factory = config.buildSessionFactory(serviceRegistry);

        //creating session object

        Session ses = factory.openSession();

        City city = (City) ses.get(City.class, "5");
        ses.close();

        if (city == null) {
            read_data(ses, factory);
        }

        Main prog = new Main();
//        try {
//            prog.start(ses, factory);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
