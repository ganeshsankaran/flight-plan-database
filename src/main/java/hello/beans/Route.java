package hello.beans;

import lombok.Data;

import java.util.List;

@Data
public class Route {
  private List<Node> nodes;
}