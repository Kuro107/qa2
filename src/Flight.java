
import java.sql.Timestamp;

public class Flight {

    private String flightNum;
    private String airplaneModel;
    private Timestamp departureTime;
    private String departureFrom;
    private String whereArriving;
    private Timestamp flightTime;
    private Integer places;

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {
        this.airplaneModel = airplaneModel;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureFrom() {
        return departureFrom;
    }

    public void setDepartureFrom(String departureFrom) {
        this.departureFrom = departureFrom;
    }

    public String getWhereArriving() {
        return whereArriving;
    }

    public void setWhereArriving(String whereArriving) {
        this.whereArriving = whereArriving;
    }

    public Timestamp getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Timestamp flightTime) {
        this.flightTime = flightTime;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "Flight \n" +
                "flightNum = " + flightNum + "\n" +
                "airplaneModel = " + airplaneModel + "\n" +
                "departureTime = " + departureTime + "\n"+
                "departureFrom = " + departureFrom +"\n" +
                "whereArriving = " + whereArriving + "\n" +
                "flightTime = " + flightTime + "\n"+
                "places=" + places +"\n";
    }
}
