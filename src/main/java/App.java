import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static spark.Spark.*;
import org.sql2o.*;

public class App {
    public static void main(String[] args) {

        ProcessBuilder process = new ProcessBuilder();
        int port;

        if (process.environment().get("PORT") != null) {
            port = parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);
        //have it here because get methods need something to reference with
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "homepage.hbs");
        }, new HandlebarsTemplateEngine());
        get("/endangered", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "endangeredSpecies.hbs");
        }, new HandlebarsTemplateEngine());
        get("/ranger-guide", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "userGuide.hbs");
        }, new HandlebarsTemplateEngine());
        get("/sighting-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "sightingForm.hbs");
        }, new HandlebarsTemplateEngine());
        get("/sighting-success", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "sightingSuccess.hbs");
        }, new HandlebarsTemplateEngine());
        get("/sighting-edit", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "sightingEdit.hbs");
        }, new HandlebarsTemplateEngine());
        get("/sighting-store", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "sightingStore.hbs");
        }, new HandlebarsTemplateEngine());
        get("/animal-store", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "animalStore.hbs");
        }, new HandlebarsTemplateEngine());
        get("/animal-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "animalForm.hbs");
        }, new HandlebarsTemplateEngine());
        get("/animal-success", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "animalSuccess.hbs");
        }, new HandlebarsTemplateEngine());

        get("/all",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Endangered> endangereds = Endangered.getAllEndangered();
            List<NonEndangered> nonEndangereds = NonEndangered.getAllNonEndangered();
            List<Sighting> sightings = Sighting.getAllSightings();
            model.put("sightings", sightings);
            model.put("endangereds", endangereds);
            model.put("nonEndangereds", nonEndangereds);
            return new ModelAndView(model, "sightingStore.hbs");
        }, new HandlebarsTemplateEngine());
        get("/all/sighting",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> sightings = Sighting.getAllSightings();
            model.put("sightings", sightings);
            return new ModelAndView(model, "sightingStore.hbs");
        }, new HandlebarsTemplateEngine());
        get("/all/endangered",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Endangered> endangereds = Endangered.getAllEndangered();
            model.put("endangereds", endangereds);
            return new ModelAndView(model, "endangeredSpecies.hbs");
        }, new HandlebarsTemplateEngine());
        get("/all/nonEndangered",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<NonEndangered> nonEndangereds = NonEndangered.getAllNonEndangered();
            model.put("nonEndangereds", nonEndangereds);
            return new ModelAndView(model, "animalStore.hbs");
        }, new HandlebarsTemplateEngine());
        post("/sighting/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String rangerName = request.queryParams("rangerName");
            String rangerEmail = request.queryParams("rangerEmail");
            //String[] members = request.queryParamsValues("members"); important line for working with checkboxes
            String location= request.queryParams("location");
            int animal_id=parseInt(request.queryParams("animal_id"));
            // String heroName = request.queryParams("heroName");
            // String heroStrength= request.queryParams("heroStrength");
            // String heroWeakness = request.queryParams("heroWeakness");
            //int heroAge = parseInt(request.params("heroAge"));
            // Hero newHeroes = new Hero(heroName,heroAge,heroStrength,heroWeakness);

            Sighting sighting = new Sighting(location, rangerName, rangerEmail, animal_id);//constructor
            //String members = request.queryParams("members");

            // model.put("newHeroes", newHeroes);
            model.put( "sighting",sighting);//stores the newSquad

            // model.put("members", members);
            return new ModelAndView(model, "Success.hbs");
        }, new HandlebarsTemplateEngine());
        //To get all posts in one place


    //animal CREATE and push to success page routing

    //animal CREATE And save to animal store page routing

    //sighting CREATE and push to success  page routing

    //sighting CREATE and save to sighting store page to be reviewed

    //animal Retrieve routing

    //sighting retrieve routing

    //animal update routing

    //sighting update routing

    //animal delete routing
    // sighting delete routing






    }

}