import java.sql.Timestamp;

public class Tickets {
    private Integer id;
    private Integer clientId;
    private String flightCode;
    private Timestamp ticketTake;
    private  Integer ticketNum;

    public void setId(Integer id) {
        this.id = id; }
    public Integer getId() {
        return id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public Timestamp getTicketTake() {
        return ticketTake;
    }

    public void setTicketTake(Timestamp ticketTake) {
        this.ticketTake = ticketTake;
    }

    public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", flightCode='" + flightCode + '\'' +
                ", ticketTake=" + ticketTake +
                ", ticketNum=" + ticketNum +
                '}';
    }
}
