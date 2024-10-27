package oit.is.z2310.kaizi.janken.model;

public class Match {
  int id;
  String userName1;
  String userName2;
  String user1Hand;
  String user2Hand;

  public int getId() {
    return id;
  }

  public String getUserName1() {
    return userName1;
  }

  public String getUserName2() {
    return userName2;
  }

  public String getUser1Hand() {
    return user1Hand;
  }

  public String getUser2Hand() {
    return user2Hand;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setUserName1(String userName1) {
    this.userName1 = userName1;
  }

  public void setUserName2(String userName2) {
    this.userName2 = userName2;
  }

  public void setUser1Hand(String user1Hand) {
    this.user1Hand = user1Hand;
  }

  public void setUser2Hand(String user2Hand) {
    this.user2Hand = user2Hand;
  }
}
