import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Animal {
    public String species;
    public int id;
    public String type;

public int getId(){return id;}

public String getSpecies(){ return species; }

public String getType(){ return type; }
    //overrides are for avoiding duplicate objects that can cause errors, make it easier to retrieve information
    //overide indicates that method underneath should replace method of same name built in java

    //hashcode is necessary for every time you implemente equals override, haschode calculates on memory level whether two objects are the same,
    // its needed to prevent instability
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(species, animal.species) &&
                Objects.equals(type, animal.type);
    }
    @Override
    public int hashCode() {
        return Objects.hash(species, type);
    }
    public void save(){
        try (Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals(name, type) VALUES(:name,:type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name",this.species)
                    .addParameter("type",this.type)
                    .executeUpdate()
                    .getKey();
        }
    }


}

