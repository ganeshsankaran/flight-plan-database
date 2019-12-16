package hello.beans;

import lombok.Data;

@Data
public class Search {
  private String from;
  private String to;
  private String fromICAO;
  private String toICAO;
  private String fromName;
  private String toName;
  private String flightNumber;
  private double distanceMin;
  private double distanceMax;
  private String tags;
  private boolean includeRoute;
  private String page;
  private int limit;
  private String sort;
}