package oit.is.z2310.kaizi.janken.model;

import org.apache.ibatis.jdbc.Null;

public class Janken {
  private String username = null;

  public Janken() {
  }

  // Getter
  public String getUsername() {
    return username;
  }

  // Setter
  public void setUsername(String username) {
    this.username = username;
  }
}
