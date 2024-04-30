package EjercicioBaseDatos.Models;

public class Department {
    // Attributes:
    private int code;
    private String name;
    private String city;
    private int idProvince;

    // Constructors:
    public Department(int code, String name, String city, int idProvince) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.idProvince = idProvince;
    }

    public Department(String name, String city, int idProvince) {
        this.name = name;
        this.city = city;
        this.idProvince = idProvince;
    }

    public Department () {}

    // Setters
    public void setCode(int code) { this.code = code; }

    public void setName(String name) { this.name = name; }

    public void setCity(String city) { this.city = city; }

    public void setIdProvince(int idProvince) { this.idProvince = idProvince; }

    // Getters
    public int getCode() { return code; }

    public String getName() { return name; }

    public String getCity() { return city; }

    public int getIdProvince() { return idProvince; }

    // ToString
    @Override
    public String toString() {
        return "Department{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", idProvince=" + idProvince +
                '}';
    }
}
