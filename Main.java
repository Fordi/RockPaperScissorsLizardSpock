import java.util.Scanner;
import java.util.Date;

class Main {
  private int players;
  
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    while (true) {
      System.out.println("Welcome to Rock Paper Scissors Lizard Spock");
      System.out.println("Please pick a play mode:");
      System.out.println("1. Player v. Computer");
      System.out.println("2. Player v. Player");
      System.out.println("3. Quit");
      int players = inp.nextInt();
      if (players == 3) break;
      if (players < 1 || players > 2) {
        System.out.println("Bad input; please pick '1', '2' or '3'");
        continue;
      }
      while (new Main(players).play(inp));
    }
    System.out.println("Goodbye!");
    inp.close();
  }
  public Main(int players) {
    this.players = players;
  }
  public boolean play(Scanner inp) {
    if (players == 1) {
      play1Player(inp);
    } else if (players == 2) {
      play2Players(inp);
    }
    System.out.print("Again? (Y/N)");
    while (true) {
      String c = inp.next().toLowerCase();
      if (c.equals("y")) return true;
      if (c.equals("n")) return false;
      System.out.println("'Y' or 'N', please.");
    }
  }
  public void play1Player(Scanner inp) {
    System.out.println("Choose your weapon...");
    System.out.println("1. Rock");
    System.out.println("2. Paper");
    System.out.println("3. Scissors");
    System.out.println("4. Lizard");
    System.out.println("5. Spock");
  }
  public void play2Players(Scanner inp) {
    System.out.println("Say together: 'ONE TWO THREE SHOOT'");
    System.out.println("Type your selection on 'SHOOT'");
    System.out.println("If there's too much time between them, you'll have to go again.");
    System.out.println("Player 1           Player 2");
    System.out.println("1.        Rock           .6");
    System.out.println("2.        Paper          .7");
    System.out.println("3.        Scissors       .8");
    System.out.println("4.        Lizard         .9");
    System.out.println("5.        Spock          .0");
    int a;
    int b;
    inp.useDelimiter("\\s*");
    try {
      a = Integer.parseInt(inp.next());
      long first = new Date().getTime();
      System.out.print("...");
      b = Integer.parseInt(inp.next());
      long second = new Date().getTime();
      if (second - first > 500) {
        System.out.println("Too long between chars; please try again.");
        play2Players(inp);
        return;
      }
    } catch (Exception e) {
      System.out.println("Please enter a number between 1..5 for player 1 and 6..0 for player 2");
      play2Players(inp);
      return;      
    }
    inp.reset();
    // Both players picked from the same side
    if ((a > 5 && b > 5) || (a <= 5 && b <= 5)) {
      System.out.println("Player 1 is 1..5, player 2 is 6..0");
      play2Players(inp);
      return;
    }
    Move p1;
    Move p2;
    if (a <= 5) {
      p1 = Move.fromInt(a);
      p2 = Move.fromInt(b);
    } else {
      p1 = Move.fromInt(b);
      p2 = Move.fromInt(a);
    }
    Result res = Move.compare(p1, p2);
    
  }
}