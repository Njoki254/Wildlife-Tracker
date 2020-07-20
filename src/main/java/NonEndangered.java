import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;

public class NonEndangered extends Animal {

    public static final String WILDLIFE_TYPE = "nonendangered";

    public NonEndangered(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException("Please enter an animal name.");
        }
        this.species = species;
        // this.id= id;
        this.type = type;

    }

    public String getSpecies() {
        return species;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

}