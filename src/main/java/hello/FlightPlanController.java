package hello;

import java.util.List;
import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken; 

import hello.beans.Search;
import hello.beans.Plan;
import hello.beans.Airport;
import hello.beans.Weather;

import hello.services.FlightPlanService;
import hello.services.AirportService;
import hello.services.WeatherService;

@Controller
public class FlightPlanController {

  @Autowired
  private FlightPlanService flightPlanService;
  @Autowired
  private AirportService airportService;
  @Autowired
  private WeatherService weatherService;
  @Autowired
  private Gson gson;

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @RequestMapping("/flightplan/search")
  public String flightPlanSearch(Model model) {
    model.addAttribute("search", new Search());
    return "flightplan/search";
  }

  @RequestMapping("/flightplan/results")
  public String flightPlanView(Model model, Search search) {
    search.setIncludeRoute(true);
    String json = flightPlanService.getResults(search.getFromICAO(), search.getToICAO(), search.isIncludeRoute());
    
    Type collectionType = new TypeToken<List<Plan>>(){}.getType();
    List<Plan> plans = gson.fromJson(json, collectionType);
    model.addAttribute("plans", plans);
    return "flightplan/results";
  }
  
  @RequestMapping("/airport/search")
  public String airportSearch(Model model) {
    model.addAttribute("airport", new Airport());
    
    return "airport/search";
  }

  @RequestMapping("/airport/results")
  public String airportResults(Model model, Airport airport) {
    String json = airportService.getAirport(airport.getICAO());

    airport = gson.fromJson(json, Airport.class);
    model.addAttribute("airport", airport);

    return "airport/results";
  }

  @RequestMapping("/weather/search")
  public String weatherSearch(Model model) {
    model.addAttribute("airport", new Airport());
    
    return "weather/search";
  }

  @RequestMapping("/weather/results")
  public String weatherResults(Model model, Airport airport) {
    String json = weatherService.getWeather(airport.getICAO());

    Weather weather = gson.fromJson(json, Weather.class);
    model.addAttribute("weather", weather);
    
    return "weather/results";
  }

}
