

import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Endangered extends Animal {


    private String age;
    public String health;

//discrimination column
    public static final String DATABASE_TYPE = "endangered";

    public static final String HEALTHY ="healthy";
    public static final String OKAY ="okay";
    public static final String ILL ="ill";
    public static final String NEWBORN ="newborn";
    public static final String YOUNG ="young";
    public static final String ADULT ="adult";
    //private static ArrayList<Endangered> instances = new ArrayList<>();


    public Endangered(String species) {

        this.species = species;
        // this.animalId = animalId;

        this.type = DATABASE_TYPE;
        // instances.add(this);
        //this.id=instances.size();
    }

    //public static ArrayList<Endangered> getInstances() {
    //  return instances;//arraylist represents data type to be returned,
    //}


    public String getHealth() {

        return health;
    }

    public String getAge() {
        return age;

    }

  /*  public String setHealth() {

        return health;
    }

    public String setAge() {
        return age;

    }*/


    public static List<Endangered> getAllEndangered() {
        try (Connection con = DB.sql2o.open()){
            String queryEndangered = "SELECT * FROM animals WHERE type='endangered'";
            return con.createQuery(queryEndangered)
                    .executeAndFetch(Endangered.class);
        }
    }
    public void saveAge(String age){
        String sql = "UPDATE animals SET age=:age WHERE id=:id";
        try (Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("age", age)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }
    public void saveHealth(String health){
        String sql = "UPDATE animals SET health=:health WHERE id=:id";
        try (Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("health", health)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }
}