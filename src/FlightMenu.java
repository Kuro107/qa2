import java.sql.Timestamp;
import java.util.Scanner;

public class FlightMenu {

    public static void start() {
        Connect connect = new Connect();
        Flight flight = new Flight();
        Scanner scanner = new Scanner(System.in);
        boolean exit=true;
        while (exit) {
            System.out.println("Flight menu : ");
            System.out.println("( 1 ) add flight ");
            System.out.println("( 2 ) delete flight");
            System.out.println("( 3 ) edit flight ");
            System.out.println("( 4 ) search flight ");
            System.out.println("( 5 ) all flights ");
            System.out.println("( 0 ) exit");

            int flightMenuItem = scanner.nextInt();

            if (flightMenuItem == 1) {
                System.out.println("write number of flight");
                flight.setFlightNum(scanner.next());
                System.out.println("write airplane model");
                flight.setAirplaneModel(scanner.next());
                System.out.println("write departure time format YYYY-MM-DD HH:MM:SS");
                flight.setDepartureTime(Timestamp.valueOf(scanner.next()+ " " +scanner.next()));
                System.out.println("write airport code departure from");
                flight.setDepartureFrom(scanner.next());
                System.out.println("write airport code where arriving ");
                flight.setWhereArriving(scanner.next());
                System.out.println("write flight time format YYYY-MM-DD HH:MM:SS");
                flight.setFlightTime(Timestamp.valueOf(scanner.next()+ " " +scanner.next()));
                System.out.println("write how much seat places in airplane");
                flight.setPlaces(scanner.nextInt());
                connect.addFlight(flight);
            }
            else if (flightMenuItem == 2) {
                System.out.println("write flight_num");
                connect.deleteFlight(scanner.next());
            }
            else if (flightMenuItem == 3) {
                System.out.println("write number of flight");
                flight.setFlightNum(scanner.next());
                System.out.println("write airplane model");
                flight.setAirplaneModel(scanner.next());
                System.out.println("write departure time format YYYY-MM-DD HH:MM:SS");
                flight.setDepartureTime(Timestamp.valueOf(scanner.next()+ " " + scanner.next()));
                System.out.println("write departure airport code");
                flight.setDepartureFrom(scanner.next());
                System.out.println("write airport code where arriving ");
                flight.setWhereArriving(scanner.next());
                System.out.println("write flight time format YYYY-MM-DD HH:MM:SS");
                flight.setFlightTime(Timestamp.valueOf(scanner.next()+ " " + scanner.next()));
                System.out.println("write how much seat places in airplane");
                flight.setPlaces(scanner.nextInt());
                connect.editFlight(flight);
            }
            else if (flightMenuItem == 4) {
                System.out.println("write number of flight");
                System.out.println( connect.searchFlight(scanner.next()));
            }
            else if (flightMenuItem == 5) {
                System.out.println(connect.showFlights());
            }
            else if (flightMenuItem == 0) {
                System.out.println("exit");
                exit = false;
            }
            else {
                System.out.println(" error, choose number ");
            }
        }
    }
}
