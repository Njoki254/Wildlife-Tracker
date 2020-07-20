import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        ProcessBuilder process = new ProcessBuilder();
        int port;

        if (process.environment().get("PORT") != null) {
            port = parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);

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