import java.sql.Timestamp;
import java.util.Scanner;

public class TicketMenu {
    public static void start() {
        Connect connect = new Connect();

        Scanner scanner = new Scanner(System.in);
        boolean exit=true;
        while (exit) {
            System.out.println("Tickets menu : ");
            System.out.println("( 1 ) add ticket ");
            System.out.println("( 2 ) delete ticket");
            System.out.println("( 3 ) edit ticket ");
            System.out.println("( 4 ) search ticket");
            System.out.println("( 5 ) show tickets ");
            System.out.println("( 0 ) exit");

            int ticketMenuItem = scanner.nextInt();

            if (ticketMenuItem == 1) {
                Tickets ticket = new Tickets();
                System.out.println("write client id");
                ticket.setClientId(scanner.nextInt());
                System.out.println("write flight code");
                ticket.setFlightCode(scanner.next());
                System.out.println("write when you take ticket format YYYY-MM-DD HH:MM:SS");
                ticket.setTicketTake(Timestamp.valueOf(scanner.next()+ " " + scanner.next()));
                System.out.println("write your ticket number");
                ticket.setTicketNum(scanner.nextInt());
                connect.addTicket(ticket);
            }
            else if (ticketMenuItem == 2) {
                System.out.println("write ticket number");
                connect.deleteTicket(scanner.next());
            }
            else if (ticketMenuItem == 3) {
                Tickets ticket = new Tickets();
                System.out.println("write ticket id");
                ticket.setId(scanner.nextInt());
                System.out.println("write client id");
                ticket.setClientId(scanner.nextInt());
                System.out.println("write flight code");
                ticket.setFlightCode(scanner.next());
                System.out.println("write when you take ticket format YYYY-MM-DD HH:MM:SS");
                ticket.setTicketTake(Timestamp.valueOf(scanner.next()+ " " + scanner.next()));
                System.out.println("write your ticket number");
                ticket.setTicketNum(scanner.nextInt());
                connect.addTicket(ticket);
                connect.editTicket(ticket);
            }
            else if (ticketMenuItem == 4) {
                System.out.println("write ticket id");
                connect.searchTicket(scanner.next());
            }
            else if (ticketMenuItem == 5) {
                System.out.println(connect.showTickets());
            }
            else if (ticketMenuItem == 0) {
                System.out.println(" exit");
                exit = false;
            }
            else {
                System.out.println("Error! choose number");
            }
        }
    }
    }

