package Serializacion.Ejercicio2;

public class Cliente {
    // Attributes:
    private String name;
    private String lastName;
    private String phoneNumber;
    private int age;

    // Constructors:
    public Cliente () {}

    public Cliente(String name, String lastName, String phoneNumber, int age) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    // Setter:
    public void setName(String name) { this.name = name; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setAge(int age) { this.age = age; }

    // Getter:
    public String getName() { return name; }

    public String getLastName() { return lastName; }

    public String getPhoneNumber() { return phoneNumber; }

    public int getAge() { return age; }

    // ToString:


    @Override
    public String toString() {
        return "Cliente: " +
                "\nNombre: " + name +
                "\nApellidos: " + lastName +
                "\nTeéfono: " + phoneNumber +
                "\nEdad: " + age;
    }
}
