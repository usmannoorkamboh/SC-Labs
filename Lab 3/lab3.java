/**
 * Created by usmannoor on 01/03/2017.
 */

public class lab3 {

    public int small_availability = 4;
    public int medium_availability = 8;
    public int xl_availability = 1;
    public int l_availability = 3;
    public int opening_time = 1100;
    public int closing_time = 2200;
    public int[] t = new int[12];

    public int reserve(int people, int timeslot) {

        //for booking small table
        if (people <= 2) {
            if (small_availability == 0) {
                System.out.print("No table is available\n");
            } else {
                for (int i = 0; i < 12; i++) {
                    t[i] = 4;
                }
                if (timeslot < opening_time || timeslot > closing_time) {
                    System.out.print("No bookings in this time.\n");
                } else {
                    int slot = (timeslot / 100) - 11;
                    if (t[slot] == 0) {
                        System.out.print("No slot available at that time.\n");
                    } else {
                        small_availability--;
                        t[slot]--;
                        System.out.print("Successful at time: " + timeslot + "\n");
                        return 1;
                    }
                }
            }
            //Booking for medium table
        } else if (people <= 4) {
            if (medium_availability == 0) {
                System.out.print("No table is available\n");
            } else {
                for (int i = 0; i < 12; i++) {
                    t[i] = 8;
                }
                if (timeslot < opening_time || timeslot > closing_time) {
                    System.out.print("No bookings in this time.\n");
                } else {
                    int slot = (timeslot / 100) - 11;
                    if (t[slot] == 0) {
                        System.out.print("No slot available at that time.\n");
                    } else {
                        medium_availability--;
                        t[slot]--;
                        System.out.print("Successful at time: " + timeslot + "\n");
                        return 1;
                    }
                }
            }
            //Booking for large table
        } else if (people <= 6) {
            if (l_availability == 0) {
                System.out.print("No table is available\n");
            } else {
                for (int i = 0; i < 12; i++) {
                    t[i] = 3;
                }
                if (timeslot < opening_time || timeslot > closing_time) {
                    System.out.print("No bookings in this time.\n");
                } else {
                    int slot = (timeslot / 100) - 11;
                    if (t[slot] == 0) {
                        System.out.print("No slot available at that time.\n");
                    } else {
                        l_availability--;
                        t[slot]--;
                        System.out.print("Successful at time: " + timeslot + "\n");
                        return 1;
                    }
                }
            }
            //Booking for extra largetable
        } else if (people <= 12) {
            if (xl_availability == 0) {
                System.out.print("No table is available\n");
            } else {
                for (int i = 0; i < 12; i++) {
                    t[i] = 1;
                }
                if (timeslot < opening_time || timeslot > closing_time) {
                    System.out.print("No bookings in this time.\n");
                } else {
                    int slot = (timeslot / 100) - 11;
                    if (t[slot] == 0) {
                        System.out.print("No slot available at that time.\n");
                    } else {
                        xl_availability--;
                        t[slot]--;
                        System.out.print("Successful at time: " + timeslot + "\n");
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        lab3 l1 = new lab3();

        l1.reserve(1, 2200);
        l1.reserve(3, 1200);
        l1.reserve(3, 1200);
        l1.reserve(3, 1200);
        l1.reserve(3, 1200);
        l1.reserve(3, 1200);
        l1.reserve(3, 1200);
        l1.reserve(3, 1200);
        l1.reserve(3, 1200);



    }

}
