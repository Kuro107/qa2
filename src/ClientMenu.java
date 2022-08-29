import java.util.Scanner;

public class ClientMenu {


    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Connect connect = new Connect();
        boolean exit=true;
        while (exit) {
            System.out.println("client menu : ");
            System.out.println("( 1 ) add client ");
            System.out.println("( 2 ) delete client");
            System.out.println("( 3 ) edit client with passportNum ");
            System.out.println("( 4 ) search client");
            System.out.println("( 5 ) show all clients");
            System.out.println("( 0 ) exit");

            int clientMenuItem = scanner.nextInt();

            if (clientMenuItem == 1) {
                Client client = new Client();
                System.out.println("write client identifyNum (id)");
                client.setIdentify(scanner.nextInt());
                System.out.println("write passport series");
                client.setPassportSeries(scanner.next());
                System.out.println("write clients full name");
                scanner.nextLine();
                client.setFullName(scanner.nextLine());
                System.out.println("write clients gender");
                client.setGender(scanner.next());
                System.out.println("write clients country");
                client.setCountry(scanner.next());
                connect.addClient(client);
            }
            else if (clientMenuItem == 2) {
                System.out.println("write clients identify number");
                connect.deleteClient(scanner.next());
            }
            else if (clientMenuItem == 3) {
                Client client = new Client();
                System.out.println("write clients identify number to edit");
                client.setIdentify(scanner.nextInt());
                System.out.println("write new passport series");
                client.setPassportSeries(scanner.next());
                System.out.println("write new full name");
                scanner.nextLine();
                client.setFullName(scanner.nextLine());
                System.out.println("write new gender");
                client.setGender(scanner.next());
                System.out.println("write new country");
                client.setCountry(scanner.next());
                connect.editClient(client);
            }
            else if (clientMenuItem == 4) {
                System.out.println("write identify num to search client");
                connect.searchClient(scanner.nextInt());
            }
            else if (clientMenuItem == 5) {
                connect.showClients();
            }
            else if (clientMenuItem == 0) {
                System.out.println(" Выход из программы");
                exit = false;
            }
            else {
                System.out.println(" Ошибка ! Введите цифру из меню ! ");
            }
        }

    }
}
