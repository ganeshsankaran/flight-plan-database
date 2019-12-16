package hello.beans;

import lombok.Data;

@Data
public class Navaid {
  private String ident;
  private String type;
  private double lat;
  private double lon;
  private String airport;
  private String runway;
  private Long frequency;
  private double slope;
  private double bearing;
  private String name;
  private double elevation;
  private double range;
}