package ejerciciosClasesJava2;

enum LeafType {
    PERENNE, CADUCA
}

public class Arbol {
    // Attributes.
    static int numTrees = 0;
    private double height;
    private int birthYear;
    private String council;
    private String commonName;
    private String latinName;
    private LeafType leafType;
    private Coordenada localizacion;
    private String date ="";

    // Constructor.
    public Arbol () {
        incrementCounter();
    }
    public Arbol (String commonName, String latinName, double height, String council, int birthYear, int leafType) {
        this.commonName = commonName;
        this.latinName = latinName;
        this.height = height;
        this.council = council;
        this.birthYear = birthYear;
        if (leafType == 1) {
            this.leafType = LeafType.PERENNE;
        } else {
            this.leafType = LeafType.CADUCA;
        }
        incrementCounter();
    }

    // Own Methods.
    public static void incrementCounter() {
        numTrees++;
    }

    public void transplantar (Coordenada traspaso) {
        this.localizacion = traspaso;
    }

    public void transplantar (Coordenada traspaso, String fecha) {
        this.localizacion = traspaso;
        this.date = fecha;
    }

    // Getters.

    public double getHeight() { return height; }

    public int getBirthYear() { return birthYear; }

    public String getCouncil() { return council; }

    public String getCommonName() { return commonName; }

    public String getLatinName() { return latinName; }

    public LeafType getLeafType() { return leafType; }

    public Coordenada getLocalizacion() { return localizacion; }

    public String toString() {
        return "Nombre: " + String.format("%5s",commonName) +
                "\nNombre Latino: " + String.format("%5s", latinName) +
                "\nTipo de hoja: " + String.format("%5s", leafType) +
                "\nAltura: " + String.format("%5.2f", height) +
                "\nConcello: " + String.format("%5s", council)+
                "\nAño nacimiento: " + String.format("%5d", birthYear);
    }

    // Setters.

    public void setHeight(double height) { this.height = height; }

    public void setBirthYear(int birthYear) { this.birthYear = birthYear; }

    public void setCouncil(String council) { this.council = council; }

    public void setCommonName(String commonName) { this.commonName = commonName; }

    public void setLatinName(String latinName) { this.latinName = latinName; }

    public void setLeafType(LeafType leafType) { this.leafType = leafType; }

    public void setLocalizacion(Coordenada localizacion) { this.localizacion = localizacion; }
}
