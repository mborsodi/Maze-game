import java.util.Scanner;
import java.util.ArrayList;

public class Maze
{
  
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    Room dungeon = new Room("Dungeon");
    Room jungle = new Room("Jungle");
    Room dragon = new Room("Dragon's lair");
    Room hallway = new Room("hallway");
    Room passageway = new Room("passageway");
    Room tunnel = new Room("tunnel");
    Room ruin = new Room("ruin");
    Room vault = new Room("vault");
    
    jungle.setNorth(ruin);
    ruin.setNorth(tunnel);
    tunnel.setNorth(passageway);
    tunnel.setEast(hallway);
    passageway.setNorth(dungeon);
    dungeon.setEast(dragon);
    hallway.setEast(vault);
    
    boolean start;
    
    System.out.println("Imp: Welcome lost wanderer. You have made it to the mysterious maze of mystery.\nImp: What is your name and race?");
    Player one = new Player(scan.next(), scan.next());
    System.out.println("Imp: You are?! You are the chosen one?! You found us!\nImp: You have to go into the maze and find the Holy Grail.\nImp: Try to come back alive. Are you ready to start your quest?");
    
    if (scan.nextLine() == "yes")
    {
      start = true;
    }
    else
    {
      start = false;
    }
    
    while (start)
    {
      if (one.position == tunnel)
      {
        System.out.println("You are in the tunnel.\nFrom here you can continue north into a passageway, go east into a hallway, or go south to the ruin.");
        
        if (scan.nextLine() == "north")
        {
          one.currentRoom(passageway);
        }
        else if (scan.nextLine() == "east")
        {
          one.currentRoom(hallway);
        }
        else if (scan.nextLine() == "south")
        {
          one.currentRoom(ruin);
        }
      }
     
      if (one.position == passageway)
      {
        System.out.println("You are in the passageway.\nFrom here you can continue north into the dungeon, or go south to the tunnel.");
        
        if (scan.nextLine() == "north")
        {
          one.currentRoom(dungeon);
        }
        else if (scan.nextLine() == "south")
        {
          one.currentRoom(tunnel);
        }
      }
      
      if (one.position == hallway)
      {
        System.out.println("You are in the hallway.\nFrom here you can go east into the vault, or go west into the tunnel.");
        
        if (scan.nextLine() == "east")
        {
          one.currentRoom(vault);
        }
        else if (scan.nextLine() == "west")
        {
          one.currentRoom(tunnel);
        }
      }
      
      if (one.position == dungeon)
      {
        System.out.println("You are in the dungeon.\nFrom here you can go east into the dragon's lair, or go south into the passageway."); 
        if (scan.nextLine() == "east");
        {
          one.currentRoom(dragon);
        }
        else if (scan.nextLine() == "south")
        {
          one.currentRoom(passageway);
        }
      }
        
      if (one.position == jungle)
      {
        
      }
      
      if (one.position == dragon)
      {
        
      }
      
      if (one.position == ruin)
      {
        
      }
      
      if (one.position == vault)
      {
        
      }
    }
    
    
    
  }
}