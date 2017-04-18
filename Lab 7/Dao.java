import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Dao {
    SessionFactory factory;
    Session session;
    ServiceRegistry serviceRegistry;

    public void save() throws IOException {


        //creating configuration object
        Configuration cfg = new Configuration();

        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

        //creating seession factory object
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        factory = cfg.buildSessionFactory(serviceRegistry);
        System.out.println("CSV Read Successful");
        String csvFile = "/Users/usmannoor/Desktop/test_two-anon.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";


        br = new BufferedReader(new FileReader(csvFile));
        session = factory.openSession();
        Transaction t = session.beginTransaction();
        line = br.readLine();
        line = br.readLine();
        while ((line = br.readLine()) != null) {
            // use comma as separator

            String[] col = line.split(cvsSplitBy);
            if (col.length < 15) {
                break;
            }
            // System.out.println(line);
            passwords p = new passwords();

            p.setUserid((col[0]));
            p.setScheme(col[2]);
            p.setTime_per_unit(Double.valueOf(col[3].substring(1, col[3].length() - 1)));
            p.setState(col[4]);

            p.setTime_taken_c1(col[6].substring(1, col[6].length() - 1));
            p.setState_c1(col[7]);

            p.setTime_taken_c2(col[9].substring(1, col[9].length() - 1));
            p.setState_c2(col[10]);

            p.setTime_taken_c3(col[11].substring(1, col[11].length() - 1));
            p.setState_c3(col[12]);

            p.setTime_taken_c4(col[14].substring(1, col[14].length() - 1));
            p.setState_c4(col[15]);

            p.setTime_taken_c5(col[17].substring(1, col[17].length() - 1));
            p.setState_c5(col[18]);

            p.setTime_taken_c6(col[20].substring(1, col[20].length() - 1));
            p.setState_c6(col[21]);


        }

        t.commit();
        session.close();
    }

    void printall() {
        session = factory.openSession();

        //fetch all the data
        String hql = "FROM passwords";
        Query query = session.createQuery(hql);
        List results = query.list();
        System.out.println(results.size());
        for (int i = 0; i < results.size(); i++) {
            System.out.println(((passwords) results.get(i)).getUserid());

        }
        session.close();
    }


}

