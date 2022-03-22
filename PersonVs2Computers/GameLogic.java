
// Importing Scanner method which is used for user's inputs (as an integer).
import java.util.Scanner;

// Defining class GameLogic which includes the main method which is used to run the whole game.
public class GameLogic {

  // Field-Instance variables.
  private final int numrows = 6;
  private final int numcolumns = 7;
  private int col = 0;

  // Constructor of class GameLogic.
  // The winning condition connectN comes from the main class.
  public GameLogic(int connectN) {
    playGame(connectN);
  }

  private void playGame(int connectN){
    // Creating instance objects from our classes.
    Board board = new Board(numrows, numcolumns, connectN);
    Scanner userin = new Scanner(System.in);
    User user1 = new User("User1", "r");
    Computer comp1 = new Computer ("Computer1", "y");
    Computer comp2 = new Computer ("Computer2", "w");


    // Initializing the while loops for the Connect4 game.
    System.out.println("Welcome to Connect4 game.");
    System.out.println("You are playing with Red colour (r). Connect " + connectN + " of your tokens horizontally, vertically or diagonallu to win the game.");
    System.out.println("Good luck.");
    System.out.println();
    board.displayBoard();

    while(!board.winnerCheck(comp2.token)){

      // Setting up variables for user1.
      boolean legitCol = false;
      int move = -1;

      //User1 turn loop.
      while (!legitCol){
        System.out.println();
        System.out.println(user1.name + " enter columnn to place your token (between 1 and "+ numcolumns +"):");

        // Checking if the user's input is an integer through class Scanner method hasNextInt.
        if (userin.hasNextInt()){
          move = userin.nextInt();
          legitCol = true; 

          // Checking if user's input is negative.
          if (move <= 0){
            System.out.println("Column cannot be zero or a negative number. Please try again.");
            legitCol = false;
          }

          // Checking if user's input is greater than numcolumns.
          if (move > numcolumns){
            System.out.println("Column cannot be greater than " + numcolumns +". Please try again.");
            legitCol = false;
          }

          // Checking if the selected legitimate column is full.
          if(move > 0 && move <= numcolumns && !board.hasColumnRoom(move)){
            System.out.println("Column " + move + " is full. Please select a different column.");
            legitCol = false;
          }
        }

        // Checking if the user's input is a character or symbol.
        else {
          System.out.println("No character or symbols are allowed. Please try again.");
          userin.next();
        }

        // If nothing of the above applies.
        if (legitCol && board.hasColumnRoom(move)){
          board.placeToken(move, user1.token);
          board.displayBoard();
        }
      } // End of inner while loop.

      // User1 win check.
      if(board.winnerCheck(user1.token)){
        board.displayBoard();
        break;
      }

      // Checking if board is full.
        if (board.isFull(numcolumns)){
          board.displayBoard();
          break;
        }

      // Setting up variables for Computer1.
      legitCol = false;

      // Computer1 turn loop.
      System.out.println();
      System.out.println(comp1.name + " will now place his token in a random column.");
      while (!legitCol){
        
        col = comp1.randomCol(numcolumns);

        // Checking if random generated integer is zero.
        while (col == 0){
          col = comp1.randomCol(numcolumns);
        }

        // Checking if random selected column is full.
        while (!board.hasColumnRoom(col)){
          col = comp1.randomCol(numcolumns);
        }

        // Checking if board is full.
        if (board.isFull(numcolumns)){
          board.displayBoard();
          break;
        }
        
        board.placeToken(col, comp1.token);
        legitCol = true;
        
      } // End of inner while loop.

      // Computer1 win check.
      if(board.winnerCheck(comp1.token)){
        board.displayBoard();
        break;
      }

      board.displayBoard();

      // Setting up variables for Computer2.
      legitCol = false;

      // Computer2 turn loop.
      System.out.println();
      System.out.println(comp2.name + " will now place his token in a random column.");
      while (!legitCol){
        
        col = comp2.randomCol(numcolumns);

        // Checking if random generated integer is zero.
        while (col == 0){
          col = comp2.randomCol(numcolumns);
        }

        // Checking if random selected column is full.
        while (!board.hasColumnRoom(col)){
          col = comp2.randomCol(numcolumns);
        }

        // Checking if board is full.
        if (board.isFull(numcolumns)){
          board.displayBoard();
          break;
        }
        
        board.placeToken(col, comp2.token);
        legitCol = true;
        
      } // End of inner while loop.

      // Computer2 win check.
      if(board.winnerCheck(comp2.token)){
        board.displayBoard();
        break;
      }

      board.displayBoard();

    } // End of initial while loop.

    // Clolsing method of java.uti.Scanner class.
    userin.close();

    // User1 win check.
    if(board.winnerCheck(user1.token)){
      System.out.print("Nice one " + user1.name + ". You won!");
    }

    // Computer1 win check.
    if(board.winnerCheck(comp1.token)){
      System.out.print("Nice one " + comp1.name + ". You won!");
    }

    // Computer2 win check.
    if(board.winnerCheck(comp2.token)){
      System.out.print("Nice one " + comp2.name + ". You won!");
    }

    // Draw check.
    if (board.isFull(numcolumns)){
      System.out.println("No winner. Better luck next time.");
    }
  }
}