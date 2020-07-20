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
        post("/sighting/new", (req, res)-> {
            Map<String, Object> model = new HashMap<>();
            int animal_id = Integer.parseInt(req.queryParams("animal_id"));
            String rangerName = req.queryParams("rangerName");
            String location = req.queryParams("location");
            String rangerEmail = req.queryParams("rangerEmail");
            Sighting newSighting = new Sighting(location, rangerName, rangerEmail,animal_id );
            newSighting.save();
            model.put("newSighting", newSighting);
            return new ModelAndView(model, "Success.hbs");
        }, new HandlebarsTemplateEngine());
        post("/animal/new", (req, res)-> {
            Map<String, Object> model = new HashMap<>();
            int animal_id = Integer.parseInt(req.queryParams("animal_id"));
            String rangerName = req.queryParams("rangerName");
            String location = req.queryParams("location");
            String rangerEmail = req.queryParams("rangerEmail");
            Sighting newSighting = new Sighting(location, rangerName, rangerEmail,animal_id );
            newSighting.save();
            model.put("newSighting", newSighting);
            return new ModelAndView(model, "Success.hbs");
        }, new HandlebarsTemplateEngine());


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