import java.sql.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Sighting implements SightingInterface {
    private int id;
    private int animal_id;
    private String location;
    private String rangerName;
    private String rangerEmail;
    private Timestamp timestamp;
    private static ArrayList<Sighting> instances = new ArrayList<>();

    public Sighting(String location, String rangerName, String rangerEmail, int animal_id) {
        if (rangerName.equals("")) {
            throw new IllegalArgumentException("Please enter Ranger name.");
        }
        if (rangerEmail.equals("")) {
            throw new IllegalArgumentException("Please enter Ranger email.");
        }
        this.animal_id = animal_id;
        this.location = location;
        this.rangerName = rangerName;
        this.rangerEmail = rangerEmail;
        this.save();
        instances.add(this);
        this.id = instances.size();
    }

    public int getId() {
        return id;
    }

    public int getAnimalId() {
        return animal_id;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public String getRangerEmail() {
        return rangerEmail;
    }

    public String getTimeSpotted() {
        return String.format("%1$TD %1$TR", timestamp);
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public void setRangerEmail(String rangerEmail) {
        this.rangerEmail = rangerEmail;
    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }
}