public class Room
{
  String name;
  boolean goldCoin;
  
  private Room north;
  private Room south;
  private Room east;
  private Room west;
  
  
  public Room(String name)
  {
    this.name = name;
  }
  
  public void goldCoin()
  {
    this.goldCoin = true;
  }
  
  public void setNorth(Room other)
  {
    this.north = other;
    other.south = this;
  }
  
  public void setSouth(Room other)
  {
    this.south = other;
    other.north = this;
  }
  
  public void setEast(Room other)
  {
    this.east = other;
    other.west = this;
  }
  
  public void setWest(Room other)
  {
    this.west = other;
    other.east = this;
  }
}