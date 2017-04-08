import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by usmannoor on 04/04/2017.
 */
public class Main {

    //the great circle formula
    public static double great_circle(double latA, double lngA, double latB, double lngB) {
        double pk = 180 / Math.PI;

        double a1 = latA / pk;
        double a2 = lngA / pk;
        double b1 = latB / pk;
        double b2 = lngB / pk;

        double t1 = Math.cos(a1) * Math.cos(a2) * Math.cos(b1) * Math.cos(b2);
        double t2 = Math.cos(a1) * Math.sin(a2) * Math.cos(b1) * Math.sin(b2);
        double t3 = Math.sin(a1) * Math.sin(b1);
        double tt = Math.acos(t1 + t2 + t3);

        return 3959 * tt;
    }

    public static void run(Session session, SessionFactory factory) throws IOException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("MENU:");
            System.out.println("1. Find a City's Latitude/Longitude");
            System.out.println("2. Find a City's Neighbors");
            System.out.println("3. Find distance between cities");
            System.out.println("4. Find cities by numbers");
            int input = scanner.nextInt();
            if (input == 1) {

                System.out.println("Enter the city name: ");
                String user_input = scanner.next();
                session = factory.openSession();

                String hql = "FROM City where ciity like '%" + user_input + "%'";
                Query query = session.createQuery(hql);
                List results = query.list();
                City c = (City) results.get(0);

                System.out.println("Longitude " + c.longitude);
                System.out.println("Latitude " + c.latitude);
                session.close();

            }
            if (input == 2) {

                session = factory.openSession();

                System.out.println("Enter the city name: ");
                String user_input1 = scanner.next();
                String hql1 = "FROM City where ciity like '%" + user_input1 + "%'";
                Query query1 = session.createQuery(hql1);
                List results1 = query1.list();
                System.out.println(results1.size());
                City city = (City) results1.get(0);

                session.close();

                session = factory.openSession();

                String hql = "FROM City";
                Query query = session.createQuery(hql);
                List results = query.list();
                System.out.println(results.size());
                int names = 5;
                for (int i = 0; i < results.size(); i++) {
                    if (names > 0 && great_circle(Double.parseDouble(city.latitude), Double.parseDouble(city.longitude), Double.parseDouble(((City) results.get(i)).latitude), Double.parseDouble(((City) results.get(i)).longitude)) < 100) {
                        if (((City) results.get(i)).ciity.length() > 2) {
                            System.out.println(((City) results.get(i)).ciity);
                            names--;
                        }
                    }
                }
                session.close();

            }

            if (input == 3) {
                session = factory.openSession();

                System.out.println("Enter 1st City Name");
                String s = scanner.next();
                System.out.println(s);

                String hql1 = "FROM City where ciity like '%" + s + "%'";
                Query query1 = session.createQuery(hql1);
                List results1 = query1.list();
                System.out.println(results1.size());
                City city = (City) results1.get(0);

                session.close();

                session = factory.openSession();

                System.out.println("Enter 2nd City Name");
                s = scanner.next();
                System.out.println(s);

                hql1 = "FROM City where ciity like '%" + s + "%'";
                query1 = session.createQuery(hql1);
                results1 = query1.list();
                System.out.println(results1.size());
                City city1 = (City) results1.get(0);

                session.close();

                Double dist = great_circle(Double.parseDouble(city.latitude),
                        Double.parseDouble(city.longitude),
                        Double.parseDouble(city1.latitude),
                        Double.parseDouble(city1.longitude)
                );

                System.out.println("Distance is:" + dist);
            }

            if (input == 4) {
                System.out.println("Enter Latitude");
                double lat = scanner.nextDouble();
                System.out.println("Enter Longitude");
                double lon = scanner.nextDouble();

                session = factory.openSession();

                String hql = "FROM City";
                Query query = session.createQuery(hql);
                List results = query.list();
                System.out.println(results.size());
                int names = 5;
                for (int i = 0; i < results.size(); i++) {
                    if (names > 0 && great_circle(lat, lon, Double.parseDouble(((City) results.get(i)).latitude), Double.parseDouble(((City) results.get(i)).longitude)) < 100) {
                        if (((City) results.get(i)).ciity.length() > 2) {
                            System.out.println(((City) results.get(i)).ciity);
                            names--;
                        }
                    }
                }
                session.close();

            }
        }
    }
}
