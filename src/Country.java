public class Country {

    private String countryCode;
    private String name;


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\ncountryCode = " + countryCode + "\n" +
                "name = " + name ;
    }
}
