import java.util.Objects;

public class Endangered extends Animal {


    private String age;
    public String health;


    public static final String WILDLIFE_TYPE = "endangered";
    //private static ArrayList<Endangered> instances = new ArrayList<>();


    public Endangered(String species, String age, String health) {

        this.species = species;
        // this.animalId = animalId;
        this.id = id;
        this.age = age;
        this.health = health;
        this.type = WILDLIFE_TYPE;
        // instances.add(this);
        //this.id=instances.size();
    }

    //public static ArrayList<Endangered> getInstances() {
    //  return instances;//arraylist represents data type to be returned,
    //}
    public String getSpecies() {
        return species;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getHealth() {

        return health;
    }

    public String getAge() {
        return age;

    }

    public String setHealth() {

        return health;
    }

    public String setAge() {
        return age;

    }
}