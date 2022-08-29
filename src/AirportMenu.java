import java.util.Scanner;

public class AirportMenu {


    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Connect connect = new Connect();
        Airport airport = new Airport();
        boolean exit=true;
        while (exit) {
            System.out.println("airport menu : ");
            System.out.println("( 1 ) add airport ");
            System.out.println("( 2 ) delete airport");
            System.out.println("( 3 ) edit airport ");
            System.out.println("( 4 ) search airport from code ");
            System.out.println("( 5 ) show all airports ");
            System.out.println("( 0 ) exit");

            int airportMenuItem = scanner.nextInt();

            if (airportMenuItem == 1) {

                System.out.println("write airport code");
                airport.setAirportCode(scanner.next());
                System.out.println("write country code");
                airport.setCountryCode(scanner.next());
                System.out.println("write city code");
                airport.setCityCode(scanner.next());
                connect.addAirport(airport);
            }
            else if (airportMenuItem == 2) {
                System.out.println("write airport CODE");
                connect.deleteAirport(scanner.next());
            }
            else if (airportMenuItem == 3) {

                System.out.println("write airport code");
                airport.setAirportCode(scanner.next());
                System.out.println("write country code");
                airport.setCountryCode(scanner.next());
                System.out.println("write city code");
                airport.setCityCode(scanner.next());
                connect.editAirport(airport);
            }
            else if (airportMenuItem == 4) {
                System.out.println("write airport code");
                connect.searchAirport(scanner.next());
            }
            else if (airportMenuItem == 5) {
                connect.showAirports();
            }
            else if (airportMenuItem == 0) {
                System.out.println(" to exit");
                exit = false;
            }
            else {
                System.out.println(" error! write number in menu ! ");
            }
        }
    }


}

