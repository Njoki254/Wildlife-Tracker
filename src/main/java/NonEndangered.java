import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;

public class NonEndangered extends Animal {

    public static final String DATABASE_TYPE = "nonendangered";

    public NonEndangered(){
        this.species = species;
        this.type = DATABASE_TYPE;
    }
    public static List<NonEndangered> getAllNonEndangered() {
        try (Connection con = DB.sql2o.open()){
            String queryNonEndangered = "SELECT * FROM animals WHERE type='nonendangered'";
            return con.createQuery(queryNonEndangered)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(NonEndangered.class);
        }
    }


}