package hello.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
@Service
public class WeatherService {

  public WeatherService() {
  }

  public String getWeather(String ICAO) {
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> httpEntity = new HttpEntity<>("body", httpHeaders);

    String url = "https://api.flightplandatabase.com/weather/" + ICAO;
    String response = "";

    try {
      ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
      MediaType contentType = responseEntity.getHeaders().getContentType();
      HttpStatus statusCode = responseEntity.getStatusCode();
      response = responseEntity.getBody();
    } catch (HttpClientErrorException e) {
      response = "{\"error\": \"401: Unauthorized\"}";
    }

    return response;
  }
}