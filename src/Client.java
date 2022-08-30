public class Client {
    private Integer id;
    private Integer identify;
    private String passportSeries;
    private String fullName;
    private String gender;
    private String country;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdentify() {
        return identify;
    }

    public void setIdentify(Integer identify) {
        this.identify = identify;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return
                "\nid = " + id +"\n"+
                "identify = " + identify + "\n"+
                "passportSeries = " + passportSeries + "\n" +
                "fullName = " + fullName + "\n" +
                "gender = " + gender + "\n" +
                "country = " + country + "\n" +"_________________________";
    }
}
