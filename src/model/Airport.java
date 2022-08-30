package model;

public class Airport {

    private String airportCode;
    private String countryCode;
    private String cityCode;

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Override
    public String toString() {
        return
                "\nairportCode = " + airportCode + "\n" +
                "countryCode = " + countryCode + "\n" +
                "cityCode = " + cityCode ;
    }
}