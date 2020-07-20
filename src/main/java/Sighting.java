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

    public static List<NonEndangered> getAllSightings() {
        try (Connection con = DB.sql2o.open()){
            String queryNonEndangered = "SELECT* FROM sightings WHERE animal_id = :animalId ORDER BY timestamp DESC";
            return con.createQuery(queryNonEndangered)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(NonEndangered.class);
        }
    }

    public static Sighting find(int id) {
        String sql = "SELECT* FROM sightings WHERE id=:id;";
        try(Connection con = DB.sql2o.open()) {

            Sighting sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }
    public void updateSighting() {
        String sql = "UPDATE sightings SET location = :location, rangerName = :rangerName WHERE id = :id";

        try(Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("location", location)
                    .addParameter("rangerName", rangerName)
                    .addParameter("rangerEmail", rangerEmail)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }
    public void deleteSighting(){
        try(Connection con = DB.sql2o.open()) {
            con.createQuery("DELETE FROM sightings WHERE id=:id")
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }
}