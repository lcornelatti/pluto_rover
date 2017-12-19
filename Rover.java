import java.util.Scanner;
import java.io.*;

public class Rover{

  //Declare global output variables and gives them initial values
  private static int x = 0;
  private static int y = 0;
  private static int obstacleX = 0;
  private static int obstacleY = 0;
  private static String direction = "North";

  public static void main(String[] args){

    //Scanner for user input
    Scanner scanner = new Scanner(System.in);

    while (true){ //Main program loop

      //Takes input from user and converts it to upper case string
      System.out.println("Current position is ("+ x + ", " + y + "), direction is " + direction + ". Where should I go?");
      String input_string = scanner.nextLine().toUpperCase();
      boolean obstacle_found = false;

      //Iterates for every character in the String
      for (int i = 0; i < input_string.length(); i++){

        char current_char = input_string.charAt(i);

        switch(current_char){
          case 'F': if (!move_front()) obstacle_found = true;
                    break;
          case 'B': if (!move_back()) obstacle_found = true;
                    break;
          case 'R': turn_right();
                    break;
          case 'L': turn_left();
                    break;
          default:  System.out.println("Unrecognized input " + current_char + " . Character ignored");
                    break;
        }

        if (obstacle_found){ //If an obstacle is found, the loop breaks and the rover notifies its stopping
          System.out.println("Obstacle found at (" + obstacleX + ", " + obstacleY + "). Rover stopped");
          break;
        }
      }
    }
  }

  //Handles case for moving to the front
  private static boolean move_front(){
    int targetX = x;
    int targetY = y;
    switch(direction){
      case "North": targetY = (y + 1) % 100;
                    break;
      case "South": targetY = (y == 0)? 99 : y - 1;
                    break;
      case "East":  targetX = (x + 1) % 100;
                    break;
      case "West":  targetX = (x == 0)? 99 : x - 1;
                    break;
    }
    if (obstacleAt(targetX, targetY)) {
      obstacleX = targetX;
      obstacleY = targetY;
      return false;
    }
    else {
      x = targetX;
      y = targetY;
      return true;
    }
  }

  //Handles case for moving backwards
  private static boolean move_back(){
    int targetX = x;
    int targetY = y;
    switch(direction){
      case "North": targetY = (y == 0)? 99 : y - 1;
                    break;
      case "South": targetY = (y + 1) % 100;
                    break;
      case "East":  targetX = (x == 0)? 99 : x - 1;
                    break;
      case "West":  targetX = (x + 1) % 100;
                    break;
    }
    if (obstacleAt(targetX, targetY)) {
      obstacleX = targetX;
      obstacleY = targetY;
      return false;
    }
    else {
      x = targetX;
      y = targetY;
      return true;
    }
  }

  //Handles case for turning right
  private static void turn_right(){
    switch(direction){
      case "North": direction = "East";
                    break;
      case "South": direction = "West";
                    break;
      case "East":  direction = "South";
                    break;
      case "West":  direction = "North";
                    break;
    }
  }

  //Handles case for turning left
  private static void turn_left(){
    switch(direction){
      case "North": direction = "West";
                    break;
      case "South": direction = "East";
                    break;
      case "East":  direction = "North";
                    break;
      case "West":  direction = "South";
                    break;
    }
  }

  //Simple method for obstacle detection (there are only obstacles at places where x and y are divisible by 5, except at the origin)
  private static boolean obstacleAt(int x, int y){
    if (x % 5 == 0 && y && 5 == 0 && !(x == 0 && y == 0)) return true;
    else return false;
  }
}
