enum Move {
  ROCK,
  PAPER,
  SCISSORS,
  LIZARD,
  SPOCK;

  public static Move fromInt(int a) {
    int b = a % 5;
    if (b == 0) return ROCK;
    if (b == 1) return PAPER;
    if (b == 2) return SCISSORS;
    if (b == 3) return LIZARD;
    return SPOCK;
  }

  public String toString() {
    String n = name();
    return n.substring(0, 1).toUpperCase() + n.substring(1).toLowerCase();
  }
  
  public static Result compare(Move p1, Move p2) {
    Result res = new Result();
    res.p1 = p1;
    res.p2 = p2;
    if (p1 == p2) {
      res.winner = WinType.DRAW;
      return res;
    }
    if (p1 == Move.ROCK) {
      if (p2 == Move.PAPER) {
        res.winner = WinType.PLAYER2;
        res.by = "covers";
      } else if (p2 == Move.SCISSORS) {
        res.winner = WinType.PLAYER1;
        res.by = "crushes";
      } else if (p2 == Move.LIZARD) {
        res.winner = WinType.PLAYER1;
        res.by = "crushes";
      } else if (p2 == Move.SPOCK) {
        res.winner = WinType.PLAYER2;
        res.by = "vaporizes";
      }
    } else if (p1 == Move.PAPER) {
      if (p2 == Move.ROCK) {
        res.winner = WinType.PLAYER1;
        res.by = "covers";
      } else if (p2 == Move.SCISSORS) {
        res.winner = WinType.PLAYER2;
        res.by = "cuts";
      } else if (p2 == Move.LIZARD) {
        res.winner = WinType.PLAYER2;
        res.by = "eats";
      } else if (p2 == Move.SPOCK) {
        res.winner = WinType.PLAYER1;
        res.by = "disproves";
      }
    } else if (p1 == Move.SCISSORS) {
      if (p2 == Move.ROCK) {
        res.winner = WinType.PLAYER2;
        res.by = "crushes";
      } else if (p2 == Move.PAPER) {
        res.winner = WinType.PLAYER1;
        res.by = "cuts";
      } else if (p2 == Move.LIZARD) {
        res.winner = WinType.PLAYER1;
        res.by = "decapitates";
      } else if (p2 == Move.SPOCK) {
        res.winner = WinType.PLAYER2;
        res.by = "smashes";
      }
    } else if (p1 == Move.LIZARD) {
      if (p2 == Move.ROCK) {
        res.winner = WinType.PLAYER2;
        res.by = "crushes";
      } else if (p2 == Move.PAPER) {
        res.winner = WinType.PLAYER1;
        res.by = "eats";
      } else if (p2 == Move.SCISSORS) {
        res.winner = WinType.PLAYER2;
        res.by = "decapitates";
      } else if (p2 == Move.SPOCK) {
        res.winner = WinType.PLAYER1;
        res.by = "poisons";
      }
    } else if (p1 == Move.SPOCK) {
      if (p2 == Move.ROCK) {
        res.winner = WinType.PLAYER1;
        res.by = "vaporizes";
      } else if (p2 == Move.PAPER) {
        res.winner = WinType.PLAYER2;
        res.by = "disproves";
      } else if (p2 == Move.SCISSORS) {
        res.winner = WinType.PLAYER1;
        res.by = "smashes";
      } else if (p2 == Move.LIZARD) {
        res.winner = WinType.PLAYER2;
        res.by = "poisons";
      }
    }
    return res;
  }
}