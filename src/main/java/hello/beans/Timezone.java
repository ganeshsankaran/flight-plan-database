package hello.beans;

import lombok.Data;

@Data
public class Timezone {
  private String name;
  private int offset;
}