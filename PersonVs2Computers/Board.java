
// Defining a class for the Connect4 game board.
public class Board{

    //Field-Instance Variables.
    protected final int numrows;
    protected final int numcolumns;
    protected final int connectN;
    private static String[][] boardGrid;

    // Constructor for class Board.
    public Board(int numrows, int numcolumns, int connectN) {
        //
        this.numrows = numrows;
        this.numcolumns = numcolumns;
        this.connectN = connectN;
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
    public boolean fourVertical (String token){
        int count;
        for (int col = 0; col < numcolumns; col++){
            count = 0;
            for (int row = 0; row < numrows - (connectN - 1); row++){
                for (int n = 0; n < connectN; n++){
                    if (boardGrid[row + n][col].equals(token)){
                        count = count + 1;
                    }
                    else{
                        count = 0;
                    }
    
                    if (count >= connectN){
                        return true;
                    }
                }
                count = 0;
            }
        }
        return false;
    }

    // Horizontal check.
    public boolean fourHorizontal (String token){
        int count;
        for (int row = 0; row < numrows; row++){
            count = 0;
            for (int col = 0; col < numcolumns - (connectN - 1); col++){
                for (int n = 0; n < connectN ; n++){
                    if (boardGrid[row][col + n].equals(token)){
                        count = count + 1;
                    }
                    else{
                        count = 0;
                    }
    
                    if (count >= connectN){
                        return true;
                    }
                }
                count = 0;
            }
        }
        return false;
    }

    // Diagonal check. Ok.
    public boolean fourDiagonal (String token){
        int count = 0;
        //Right.
        for (int row = numrows - 1; row > connectN - 2; row--){
            count = 0;
            for (int col = 0; col < numcolumns - (connectN - 1); col++){
                for (int n = 0; n < connectN ; n++){
                    if (boardGrid[row - n][col + n].equals(token)){
                        count = count + 1;
                    }
                    else{
                        count = 0;
                    }
    
                    if (count >= connectN){
                        return true;
                    }
                }
                count = 0;
            }
        }

        // Left.
        for (int row = numrows - 1; row > connectN - 2; row--){
            for (int col = connectN - 1; col < numcolumns; col++){
                for (int n = 0; n < connectN ; n++){
                    if (boardGrid[row - n][col - n].equals(token)){
                        count = count + 1;
                    }
                    else{
                        count = 0;
                    }
    
                    if (count >= connectN){
                        return true;
                    }
                }
                count = 0;
            }
        }
        return false;
    }
}