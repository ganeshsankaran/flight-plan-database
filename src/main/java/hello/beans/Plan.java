package hello.beans;

import lombok.Data;
import hello.beans.User;
import hello.beans.Application;
import hello.beans.Route;

import java.util.List;

@Data
public class Plan {
  private int id;
  private String fromICAO;
  private String toICAO;
  private String fromName;
  private String toName;
  private String flightNumber;
  private double distance;
  private int maxAltitude;
  private int waypoints;
  private int likes;
  private int downloads;
  private int popularity;
  private String notes;
  private String encodedPolyline;
  private String createdAt;
  private String updatedAt;
  private List<String> tags;
  private User user;
  private Application application;
  private Route route;
}