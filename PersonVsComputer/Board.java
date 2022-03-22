
// Defining a class for the Connect4 game board.
public class Board{

    //Field-Instance Variables.
    protected final int numrows;
    protected final int numcolumns;
    private static String[][] boardGrid;

    // Constructor for class Board.
    public Board(int numrows, int numcolumns) {
        //
        this.numrows = numrows;
        this.numcolumns = numcolumns;
        boardGrid = new String [this.numrows][this.numcolumns];
        // Initilizing an empty board.
        for (int i = 0; i < this.numrows; i++){
            for (int j = 0; j < this.numcolumns; j++){
                boardGrid[i][j]="0";
            }
        }
    } 
    
    // Displaying the current state of the board.
    public void displayBoard(){
        System.out.println();
        System.out.println("Current Board State:");
        System.out.println("-------------------------------");
        for (int i = 0; i < this.numrows; i++){
            System.out.print(i+1+" | ");
            for (int j = 0 ; j < this.numcolumns; j++){
                System.out.print(boardGrid[i][j] +" | ");
            }
            System.out.println();
        }
        System.out.print("  | " );
        for (int j = 0; j < this.numcolumns; j++){
            System.out.print((j+1)+" | ");
        }
        System.out.println();
    }

    // Making a move on the boardgrid - placing a token.
    public void placeToken(int column, String token){
        for (int i = this.numrows-1; i>=0; i-- ){
            if (boardGrid[i][column-1].equals("0")){
                boardGrid[i][column-1] = token;
                break;
            }
         }
    }

    // Checking if the selected column has room for another token.
    public boolean hasColumnRoom(int column){
        if (boardGrid[0][column-1].equals("0")){
            return true;
        }
        return false;
    }

    // Checking if board is full.
    public boolean isFull(int numcolumns){
        int counter = 0;
        for (int i = 0; i < numcolumns; i++){
            if (!boardGrid[0][i].equals("0")){
                counter = counter + 1;
            }
            else{
                counter = 0;
            }

            if (counter == numcolumns){
                return true;
            }
        }
        return false;
    }

    // Returning true if there are 4 token in a row anywhere on the board.
    public boolean winnerCheck (String token){
        boolean vertical = fourVertical(token);
        boolean horizontal = fourHorizontal(token);
        boolean diagonal = fourDiagonal (token);
        return vertical || horizontal || diagonal;
    }

    // Vertical check.
    private boolean fourVertical (String token){
        for (int col = 0; col < numcolumns; col++){
            for (int row = 0; row < numrows-3; row++){
                if (boardGrid[row][col].equals(token) &&
                    boardGrid[row+1][col].equals(token) &&
                    boardGrid[row+2][col].equals(token) &&
                    boardGrid[row+3][col].equals(token)){
                    return true;
                }
            }
        }
        return false;
    }

    // Horizontal check.
    private boolean fourHorizontal (String token){
        for (int row = 0; row < numrows; row++){
            for (int col = 0; col < numcolumns-3; col++){
                //System.out.println(row+"  "+col);
                //System.out.print(boardGrid[row][col]+"-");
                if (boardGrid[row][col].equals(token) &&
                    boardGrid[row][col+1].equals(token) &&
                    boardGrid[row][col+2].equals(token) &&
                    boardGrid[row][col+3].equals(token)){
                    return true;
                }
            }
        }
        return false;
    }

    // Diagonal check.
    private boolean fourDiagonal (String token){
        //Right.
        for (int row = numrows-1; row > 2; row--){
            for (int col = 0; col < numcolumns-3; col++){
                if (boardGrid[row][col].equals(token) && 
                    boardGrid[row-1][col+1].equals(token) &&
                    boardGrid[row-2][col+2].equals(token) && 
                    boardGrid[row-3][col+3].equals(token)){
                    return true;
                }
            }
        }
        // Left.
        for (int row = numrows-1; row > 2; row--){
            for (int col = 3; col < numcolumns; col++){
                if (boardGrid[row][col].equals(token) && 
                    boardGrid[row-1][col-1].equals(token) &&
                    boardGrid[row-2][col-2].equals(token) && 
                    boardGrid[row-3][col-3].equals(token)){
                    return true;
                }
            }
        }
        return false;
    }
}