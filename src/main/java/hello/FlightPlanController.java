package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.google.gson.Gson;

import hello.beans.Airport;
import hello.beans.Weather;

import hello.services.AirportService;
import hello.services.WeatherService;

@Controller
public class FlightPlanController {

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
