package hello.beans;

import java.util.List;
import lombok.Data;

import hello.beans.Timezone;
import hello.beans.Times;
import hello.beans.Runway;
import hello.beans.Frequency;
import hello.beans.Weather;

@Data
public class Airport {
  private String ICAO;
  private String IATA;
  private String name;
  private String regionName;
  private double elevation;
  private double lat;
  private double lon;
  private double magneticVariation;
  private Timezone timezone;
  private Times times;
  private int runwayCount;
  private List<Runway> runways;
  private List<Frequency> frequencies;
  private Weather weather;
}