import java.util.Scanner;
import java.lang.Math;

public class Maze
{
  
  private static Player one;
  private static boolean game;
  
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    
    //creating the rooms of the maze
    Room dungeon = new Room("Dungeon", false, true, false);
    Room jungle = new Room("Jungle", false, false, false);
    Room dragon = new Room("Dragon's lair", true, false, true);
    Room hallway = new Room("hallway", false, true, false);
    Room passageway = new Room("passageway", true, false, false);
    Room tunnel = new Room("tunnel", false, true, false);
    Room ruin = new Room("ruin", false, true, false);
    Room vault = new Room("vault", true, false, false);
    
    jungle.setNorth(ruin);
    ruin.setNorth(tunnel);
    tunnel.setNorth(passageway);
    tunnel.setEast(hallway);
    passageway.setNorth(dungeon);
    dungeon.setEast(dragon);
    hallway.setEast(vault);
    
    //introducing game
    System.out.println("What is your name?");
    
    one = new Player(scan.nextLine());
    
    System.out.println("Hi " + one.name + "! Find and kill the dragon to complete the game. Try not to die on the way!");
    System.out.println("Commands:\nnorth - go north\nsouth - go south\neast - go east\nwest - go west\npoints - show current points\nroom - current position\nlook - look for gold coin\nget - get gold coin\nkill - kill dragon or other creatures");
    
    one.currentRoom(jungle);
    
    game = true;
    
    //what happens for each command
    while (game)
    {
      if (one.healthPoints <= 0)
      {
        System.out.println("Oh no! You have no health points! You lose!");
        break;
      }
      
      String command = scan.nextLine();
        
      if (command.equals("north"))
      {
        if (one.position.getNorth() == null)
        {
          System.out.println("There's no room here! Try a different direction!");
        }
        else 
        {
          one.currentRoom(one.position.getNorth());
        }
      }
     
      else if (command.equals("south"))
      {
        if (one.position.getSouth() == null)
        {
          System.out.println("There's no room here! Try a different direction!");
        }
        else 
        {
          one.currentRoom(one.position.getSouth());
        }
        
      }
      else if (command.equals("east"))
      {
        if (one.position.getEast() == null)
        {
          System.out.println("There's no room here! Try a different direction!");
        }
        else 
        {
          one.currentRoom(one.position.getEast());
        }
      }
      else if (command.equals("west"))
      {
        if (one.position.getWest() == null)
        {
          System.out.println("There's no room here! Try a different direction!");
        }
        else 
        {
          one.currentRoom(one.position.getWest());
        }
      }
      else if (command.equals("points"))
      {
        System.out.println("You currently have " + one.healthPoints + " health points.");
      }
      else if (command.equals("look"))
      {
        if (one.position.coin == true)
        {
          System.out.println("You found a coin!");
        }
        else
        {
          System.out.println("Sorry, there's no coin here!");
        }
      }
      else if (command.equals("get"))
      {
        if (one.position.coin == true)
        {
          one.healthPoints += (int) ((Math.random() + 1) * 10);
          System.out.println("You found a gold coin! You now have " + one.healthPoints + " health points!");
        }
        else
        {
          System.out.println("Sorry, there's no coin here!");
        }
      }
      else if (command.equals("room"))
      {
        System.out.println("You are currently in the " + one.position.name + ".");
      }
      else if (command.equals("kill"))
      {
        if (one.position.creature == true)
        {
          System.out.println("You just killed the creature!");
          one.position.creature = false;
        }
        else if (one.position.dragon == true)
        {
          System.out.println("You just killed the dragon!");
          game = false;
          System.out.println("Yay! You win!");
          break;
        }
        else
        {
          System.out.println("There is nothing here to kill!");
        }
      }
      else 
      {
        System.out.println("That is not a command. Please try again.");
      }
    }
  }
  
  
  //seperate method for the troll's riddles 
  public static void riddles()
  {
    Scanner scan = new Scanner(System.in);
    
    System.out.println("To get past the troll to the Holy Grail, you have to answer his riddles! Good Luck!");
    System.out.println("Troll: 'What is your name?'");
    
    if (scan.nextLine().equals(one.name))
    {
      System.out.println("Troll: 'Correct!'");
    }
    else
    {
      System.out.println("Troll: 'That is wrong! You will be thrown into the Gorge of Eternal Peril!'\nGame over! You lose!");
      game = false;
      return;
    }
    
    System.out.println("Troll: 'What is your quest?'");
    scan.nextLine();
    System.out.println("Troll: 'Correct!'");
    
    System.out.println("Troll: 'What is the air speed velocity of an unladen swallow?'");
    String thing = scan.nextLine();
    
    if (thing.toLowerCase().contains("european") && thing.toLowerCase().contains("european"))
    {
      System.out.println("Troll: 'What? I don't know that!'\nThe troll gets thrown in the Gorge of Eternal Peril!\nTroll: 'AhhhhH!!!!!!!'\nCongratulations! You completed the riddles! You have found the Holy Grail!");  
      one.healthPoints += 50;
      System.out.println("You now have " + one.healthPoints + " health points!");
    }
    else
    {
      System.out.println("Troll: 'That is wrong! You will be thrown into the Gorge of Eternal Peril!'\nGame over! You lose!");
      game = false;
      return;
    }
  }
  
  
  
  
}