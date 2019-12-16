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
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class FlightPlanService {
  private String auth;

  public FlightPlanService(@Value("${api_key}") String apiKey) {
    this.auth = "Basic " + new String(apiKey+ ":");
  }

  public String getResults(String fromICAO, String toICAO, boolean includeRoute) {
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    httpHeaders.set("Authorization", this.auth);

    HttpEntity<String> httpEntity = new HttpEntity<>("body", httpHeaders);

    String uri = "https://api.flightplandatabase.com/search/plans";
    String params = String.format("?fromICAO=%s&toICAO=%s&includeRoute=%s", 
                    fromICAO, toICAO, includeRoute);
    String url = uri + params;
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