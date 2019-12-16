package hello.beans;

import lombok.Data;

@Data
public class Frequency {
  private String type;
  private Long frequency;
  private String name;
}