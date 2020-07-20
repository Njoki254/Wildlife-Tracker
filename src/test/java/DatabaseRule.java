import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

    @Override
    //trying to customise the already existing before method
    //connects one to database, connect form to database for input to be sent
    protected void before() {
        //JDBC is an internal API that allows us to connect to a database.
        //new sql20 object is created so methods can be run such as open and close, making database available in entire file
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", null, null);  //Those with linux or windows use two strings for username and password
    }

    @Override
    //delete data there initially so we can have new input
    protected void after() {
        //function of DB is to connect automatcially to database making work easier
        try(Connection con = DB.sql2o.open()) {
            String deleteRangersQuery = "DELETE FROM sightings *;";
            String deleteAnimalsQuery = "DELETE FROM animals *;";
            con.createQuery(deleteRangersQuery).executeUpdate();
            con.createQuery(deleteAnimalsQuery).executeUpdate();
        }
    }

}