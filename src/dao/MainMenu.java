package dao;

import controller.*;

import java.util.Scanner;

public class MainMenu {

    public static void start() {

        Scanner sc = new Scanner(System.in);
        while (true) {

            int menuItem;

            System.out.println(" Main menu : ");
            System.out.println("( 1 ) Work with flight ");
            System.out.println("( 2 ) Work with country ");
            System.out.println("( 3 ) Work with airport ");
            System.out.println("( 4 ) Work with client ");
            System.out.println("( 5 ) Work with ticket ");
            System.out.println("( 0 ) Exit ");

            menuItem = sc.nextInt();

            if (menuItem == 1) {
                FlightMenu.start();
            }
            else if (menuItem == 2) {
                CountryMenu.start();
            }
            else
            if (menuItem == 3) {
                AirportMenu.start();
            }
            else if (menuItem == 4) {
                ClientMenu.start();
            }
            else if (menuItem == 5) {
                TicketMenu.start();
            }
            else if (menuItem == 0) {
                System.out.println(" Exit ");
                return;
            }
            else {
                System.out.println(" Error! write number in menu !  ");
            }
        }
    }
}
