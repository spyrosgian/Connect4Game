
//Importing the class Random of the java.util package so we can generate random integers.
import java.util.Random;

// Defining a class for the computer player.
// Subclass of the superclass Participants.
public class Computer extends Participants{

    // Constructor for the class User.
    public Computer(String name, String token){
        super(name, token);
    }

    // Defining method random call which generated random integer numbers (range: 0 - number of columns +1).
    public int randomCol (int numcolumns){
        Random random = new Random();
        int col = random.nextInt(numcolumns+1);
        return col;
    }
}