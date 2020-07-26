import java.sql.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.Connection;
import java.util.Objects;

public class Sighting {
    private int id;
    private int animal_id;
    private String location;
    private String rangerName;
    private String rangerEmail;
    private Timestamp time;


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


    }

    //public String getTimeSpotted() {
    //return String.format("%1$TD %1$TR", time);
    //}

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings(location varchar, rangerName varchar, rangerEmail varchar, animal_id)";
            this.id = (int) con.createQuery(sql, true)// generates keys automatically
                    .addParameter("location", this.location)
                    .addParameter("rangerName", this.rangerName)
                    .addParameter("rangerEmail", rangerEmail)
                    .addParameter("animal_id", animal_id)
                    .executeUpdate()
                    .getKey();

        }
    }

    public static List<Sighting> getAllSightings() {
        String querySighting = "SELECT* FROM sightings";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(querySighting)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sighting.class);
        }
    }

    public Timestamp getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return animal_id == sighting.animal_id &&
                Objects.equals(location, sighting.location) &&
                Objects.equals(rangerName, sighting.rangerName)&&
                Objects.equals(rangerEmail, sighting.rangerEmail);

    }

    @Override
    public int hashCode() {
        return Objects.hash(location, rangerName, rangerEmail, animal_id);
    }

}