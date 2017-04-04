import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by usmannoor on 04/04/2017.
 */
public class Main {

    public static void start(Session session, SessionFactory factory) throws IOException {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1: Find cords of a city");
            System.out.println("2: Find Nearby cities");
            int input = sc.nextInt();
            if (input == 1) {
                System.out.println("Enter name");
                String s = Integer.toString(sc.nextInt());
                session = factory.openSession();
                City city = (City) session.get(City.class, s);
                session.close();
                System.out.println("Longitude1" + city.longitude + "Latitude" + city.latitude);
            }
            if (input == 2) {
            }
        }
    }
}
