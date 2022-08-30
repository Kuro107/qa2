package controller;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connect {

    private final String url = "jdbc:postgresql://localhost:5432/qa_work";
    private final String user = "postgres";
    private final String password = "1007";

    public Connection connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void addAirport(Airport airport) {
        String SQL = "INSERT INTO  airport (airport_code,country_code, city) " +
                "VALUES (?, ?, ?)";
        try (Connection connection = connection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, airport.getAirportCode());
            statement.setString(2, airport.getCountryCode());
            statement.setString(3, airport.getCityCode());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void deleteAirport(String code) {
        String SQL = "DELETE FROM airport where airport_code = ?";
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, code);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void editAirport(Airport airport) {
        String SQL = "UPDATE airline set airport_code = ?, country_code = ?, city = ?";
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            System.out.println("write airport code");
            preparedStatement.setString(1, airport.getAirportCode());
            System.out.println("write country code");
            preparedStatement.setString(2, airport.getCountryCode());
            System.out.println("write city code");
            preparedStatement.setString(3, airport.getCityCode());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException ();
        }
    }

    public Airport searchAirport(String code) {
        Airport airport = new Airport();
        String SQL = "SELECT * FROM airport where airport_code = ?";
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                airport.setAirportCode(resultSet.getString("airport_code"));
                airport.setCountryCode(resultSet.getString("country_code"));
                airport.setCityCode(resultSet.getString("city"));

            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return airport;


    }

    public List<Airport> showAirports() {
        List<Airport> airports = new ArrayList<>();
        String SQL = "select * from airport";
        try (Connection connection = connection();
             PreparedStatement statement = connection.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Airport airport = new Airport();
                airport.setAirportCode(resultSet.getString("airport_code"));
                airport.setCountryCode(resultSet.getString("country_code"));
                airport.setCityCode(resultSet.getString("city"));

                airports.add(airport);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        return airports;
    }

    public void addClient(Client client) {
        String SQL = "INSERT INTO clients (identify ,passport_series, full_name, gender,country) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = connection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, client.getIdentify());
            statement.setString(2, client.getPassportSeries());
            statement.setString(3, client.getFullName());
            statement.setString(4, client.getGender());
            statement.setString(5, client.getCountry());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void deleteClient(Integer code) {
        String SQL = "DELETE FROM clients where IDENTIFY = ?";
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, code);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
          throw new RuntimeException();
        }
    }

    public void editClient(Client client) {
        String SQL = "UPDATE clients  set passport_series = ?, full_name = ?, gender = ?, country = ?" +
                "where identify = ?";
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, client.getPassportSeries());
            preparedStatement.setString(2, client.getFullName());
            preparedStatement.setString(3, client.getGender());
            preparedStatement.setString(4, client.getCountry());
            preparedStatement.setInt(5, client.getIdentify());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public Client searchClient(Integer identify) {
        Client client = new Client();
        String SQL_SAVE = "SELECT * FROM clients where identify = ?";
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE)) {
            preparedStatement.setInt(1, identify);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                client.setId(resultSet.getInt("id"));
                client.setPassportSeries(resultSet.getString("passport_series"));
                client.setFullName(resultSet.getString("full_name"));
                client.setGender(resultSet.getString("gender"));
                client.setCountry(resultSet.getString("country"));
                client.setIdentify(resultSet.getInt("identify"));

            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return client;
    }

    public List<Client> showClients() {
        List<Client> clients = new ArrayList<>();
        String SQL = "select * from clients";
        try (Connection connection = connection();
             PreparedStatement statement = connection.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setIdentify(resultSet.getInt("identify"));
                client.setPassportSeries(resultSet.getString("passport_series"));
                client.setFullName(resultSet.getString("full_name"));
                client.setGender(resultSet.getString("gender"));
                client.setCountry(resultSet.getString("country"));

                clients.add(client);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        return clients;
    }

    public void addCountry(Country country) {
        String SQL = "INSERT INTO country (country_code, name) " +
                "VALUES (?, ?)";
        try (Connection connection = connection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, country.getCountryCode());
            statement.setString(2, country.getName());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    public void deleteCountry(String code) {
        String SQL = "DELETE FROM country where country_code = ?";
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, code);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    public void editCountry(Country country) {
        String SQL = "UPDATE country  set name = ?" +
                "where country_code = ?";
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, country.getName());
            preparedStatement.setString(2, country.getCountryCode());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public Country searchCountry(String code) {
        Country country = new Country();
        String SQL = "SELECT * FROM country where country_code = ?";
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                country.setCountryCode(resultSet.getString("country_code"));
                country.setName(resultSet.getString("name"));


            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return country;
    }

    public List<Country> showCountries() {
        List<Country> countries = new ArrayList<>();
        String SQL = "select * from country";
        try (Connection connection = connection();
             PreparedStatement statement = connection.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Country country = new Country();
                country.setCountryCode(resultSet.getString("country_code"));
                country.setName(resultSet.getString("name"));
                countries.add(country);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        return countries;
    }

    public void addFlight(Flight flight) {

        String SQL = "INSERT INTO flight (flight_num, airplane_model , departure_time, departure_from , where_arriving, flight_time, places)" +
                "VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = connection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, flight.getFlightNum());
            stmt.setString(2, flight.getAirplaneModel());
            stmt.setTimestamp(3, flight.getDepartureTime());
            stmt.setString(4, flight.getDepartureFrom());
            stmt.setString(5, flight.getDepartureFrom());
            stmt.setTimestamp(6, flight.getFlightTime());
            stmt.setInt(7, flight.getPlaces());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    public void deleteFlight(String code) {
        String SQL = "DELETE FROM flight where flight_num = ?  ";
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, code);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void editFlight(Flight flight) {
        String SQL = "UPDATE flight  set airplane_model = ?, departure_time =?, departure_from = ?, where_arriving = ?," +
                "flight_time = ?, places = ? " +
                "where flight_num = ?";
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, flight.getAirplaneModel());
            preparedStatement.setTimestamp(2, flight.getDepartureTime());
            preparedStatement.setString(3, flight.getDepartureFrom());
            preparedStatement.setString(4, flight.getWhereArriving());
            preparedStatement.setTimestamp(5, flight.getFlightTime());
            preparedStatement.setInt(6, flight.getPlaces());
            preparedStatement.setString(7, flight.getFlightNum());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public Flight searchFlight(String code) {
        Flight flight = new Flight();
        String SQL = "SELECT * FROM flight where flight_num = ?";
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                flight.setFlightNum(resultSet.getString("flight_num"));
                flight.setAirplaneModel(resultSet.getString("airplane_model"));
                flight.setDepartureTime(resultSet.getTimestamp("departure_time"));
                flight.setDepartureFrom((resultSet.getString("departure_from")));
                flight.setWhereArriving(resultSet.getString("where_arriving"));
                flight.setFlightTime(resultSet.getTimestamp("flight_time"));
                flight.setPlaces((resultSet.getInt("places")));

            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return flight;
    }

    public List<Flight> showFlights() {
        List<Flight> flights = new ArrayList<>();
        String SQL = "select * from flight";
        try (Connection connection = connection();
             PreparedStatement statement = connection.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setFlightNum(resultSet.getString("flight_num"));
                flight.setAirplaneModel(resultSet.getString("airplane_model"));
                flight.setDepartureTime(resultSet.getTimestamp("departure_time"));
                flight.setDepartureFrom((resultSet.getString("departure_from")));
                flight.setWhereArriving(resultSet.getString("where_arriving"));
                flight.setFlightTime(resultSet.getTimestamp("flight_time"));
                flight.setPlaces((resultSet.getInt("places")));

                flights.add(flight);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return flights;

    }

    public void addTicket(Tickets tickets) {
        String SQL = "INSERT INTO tickets (client_id, flight_code , ticket_take, ticket_num )" +
                "VALUES (?,?,?,?)";
        try (Connection conn = connection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, tickets.getClientId());
            stmt.setString(2, tickets.getFlightCode());
            stmt.setTimestamp(3, tickets.getTicketTake());
            stmt.setInt(4, tickets.getTicketNum());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    public void deleteTicket(Integer code) {
        String SQL = "DELETE FROM tickets where ticket_num = ?";
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, code);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    public void editTicket(Tickets ticket) {
        String SQL = "UPDATE tickets  set client_id = ?, flight_code = ?, ticket_take = ?, ticket_num = ?" +
                "where id = ?";
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, ticket.getClientId());
            preparedStatement.setString(2, ticket.getFlightCode());
            preparedStatement.setTimestamp(3, ticket.getTicketTake());
            preparedStatement.setInt(4, ticket.getTicketNum());
            preparedStatement.setInt(5, ticket.getId());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public Tickets searchTicket(Integer code) {
        Tickets ticket = new Tickets();
        String SQL = "SELECT * FROM tickets where id = ?";
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ticket.setId(resultSet.getInt("id"));
                ticket.setTicketNum(resultSet.getInt("client_id"));
                ticket.setFlightCode(resultSet.getString("flight_code"));
                ticket.setTicketTake(resultSet.getTimestamp("ticket_take"));
                ticket.setTicketNum(resultSet.getInt("ticket_num"));

            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return ticket;
    }

    public List<Tickets> showTickets() {
        List<Tickets> tickets = new ArrayList<>();
        String SQL = "select * from tickets";
        try (Connection connection = connection();
             PreparedStatement statement = connection.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Tickets ticket = new Tickets();
                ticket.setId(resultSet.getInt("id"));
                ticket.setClientId(resultSet.getInt("client_id"));
                ticket.setFlightCode(resultSet.getString("flight_code"));
                ticket.setTicketTake(resultSet.getTimestamp("ticket_take"));
                ticket.setTicketNum(resultSet.getInt("ticket_num"));

                tickets.add(ticket);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        return tickets;

    }

    public void changeCountry() {
        String SQL = "UPDATE  airport.country_code set country_code = ?" +
                "where airport_code = ?";
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1,"country_code");

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}





