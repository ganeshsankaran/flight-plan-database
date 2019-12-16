package hello.beans;

import lombok.Data;

import hello.beans.Via;

@Data
public class Node {
  private String ident;
  private String type;
  private double lat;
  private double lon;
  private int alt;
  private String name;
  private Via via;
}