package models;
import java.util.ArrayList;
import java.util.List;
public class Sede {
    private String nombreSede;
    private List<Campus> campusList;

    public Sede(String nombreSede) {
        this.nombreSede = nombreSede;
        this.campusList = new ArrayList<>();
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public List<Campus> getCampusList() {
        return campusList;
    }

    public void agregarCampus(Campus campus) {
        campusList.add(campus);
    }
    
    @Override
    public String toString() {
        return nombreSede; // Devuelve el nombre de la sede como representación de cadena
    }
}
