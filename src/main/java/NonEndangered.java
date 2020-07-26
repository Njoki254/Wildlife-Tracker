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
    public static NonEndangered find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM nonendangered WHERE id=:id;";
            NonEndangered nonendangered = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(NonEndangered.class);
            return nonendangered;
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }
    public void delete(){
        try(Connection con = DB.sql2o.open()) {
            con.createQuery("DELETE FROM nonendangered WHERE id=:id")
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }


}