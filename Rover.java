import java.util.Scanner;
import java.io.*;

public class Rover{

  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    while (true){
      System.out.println("Where should I go?");
      String input_string = scanner.nextLine();

      for (int i = 0; i < input_string.length(); i++){ //Iterates for every character in the String
        char current_char = input_string.charAt(i);

        switch(current_char){
          case 'F': System.out.println("Char is F");
                    break;
          case 'B': System.out.println("Char is B");
                    break;
          case 'R': System.out.println("Char is R");
                    break;
          case 'L': System.out.println("Char is L");
                    break;
          default:  System.out.println("Unrecognized input");
                    break;
        }
      }
    }
  }
}
