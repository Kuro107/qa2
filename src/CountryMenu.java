import java.util.Arrays;
import java.util.Scanner;

public class CountryMenu {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Connect connect = new Connect();

        boolean exit=true;

        while (exit) {

            System.out.println("Country menu : ");
            System.out.println("( 1 ) add country ");
            System.out.println("( 2 ) delete country");
            System.out.println("( 3 ) edit country ");
            System.out.println("( 4 ) search ");
            System.out.println("( 5 ) show all countries");
            System.out.println("(0) exit ");

            int countryMenuItem = scanner.nextInt();

            if (countryMenuItem == 1) {
                Country country = new Country();
                System.out.println("write country code");
                country.setCountryCode(scanner.next());
                System.out.println("write country name");
                country.setName(scanner.next());
                connect.addCountry(country);
            }
            else if (countryMenuItem == 2) {
                System.out.println("write country code");
               connect.deleteCountry(scanner.next());
            }
            else if (countryMenuItem == 3) {
                Country country = new Country();
                System.out.println("write country code");
                country.setCountryCode(scanner.next());
                System.out.println("write new country name");
                country.setName(scanner.next());
               connect.editCountry(country);
            }
            else if (countryMenuItem == 4) {
                System.out.println("write country code");
                System.out.println( connect.searchCountry(scanner.next()));
            }
            else if (countryMenuItem == 5) {
                System.out.println(connect.showCountries());
            }
            else if (countryMenuItem == 0) {
                System.out.println("exit");
                exit = false;
            }
            else {
                System.out.println(" Error! choose 1,2,3,4,5 or 0");
            }
        }
    }

}
