import java.util.Scanner;
import java.io.*;

public class Rover{

  //Declare global output variables and gives them initial values
  private static int x = 0;
  private static int y = 0;
  private static String direction = "North";

  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

    while (true){ //Main program loop

      //Takes input from user and converts it to upper case string
      System.out.println("Current position is ("+ x + ", " + y + "), direction is " + direction + ". Where should I go?");
      String input_string = scanner.nextLine().toUpperCase();

      //Iterates for every character in the String
      for (int i = 0; i < input_string.length(); i++){

        char current_char = input_string.charAt(i);

        switch(current_char){
          case 'F': move_front();
                    break;
          case 'B': move_back();
                    break;
          case 'R': turn_right();
                    break;
          case 'L': turn_left();
                    break;
          default:  System.out.println("Unrecognized input");
                    break;
        }
      }
    }
  }

  //Handles case for moving to the front
  private static void move_front(){
    switch(direction){
      case "North": y = (y + 1) % 100;
                    break;
      case "South": y = (y - 1) % 100;
                    break;
      case "East":  x = (x + 1) % 100;
                    break;
      case "West":  x = (x - 1) % 100;
                    break;
    }
  }

  //Handles case for moving backwards
  private static void move_back(){
    switch(direction){
      case "North": y = (y - 1) % 100;
                    break;
      case "South": y = (y + 1) % 100;;
                    break;
      case "East":  x = (x - 1) % 100;
                    break;
      case "West":  x = (x + 1) % 100;
                    break;
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
}
