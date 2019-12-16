package hello.beans;

import java.util.List;
import lombok.Data;

import hello.beans.End;
import hello.beans.Navaid;

@Data
public class Runway {
  private String ident;
  private double width;
  private double length;
  private double bearing;
  private String surface;
  private double thresholdOffset;
  private double overrunLength;
  private List<End> ends;
  private List<Navaid> navaids;
}