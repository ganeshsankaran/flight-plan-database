package hello.beans;

import lombok.Data;

@Data
public class User {
  private int id;
  private String username;
  private String location;
  private String gravatarHash;
}