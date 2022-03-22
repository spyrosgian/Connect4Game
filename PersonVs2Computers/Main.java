
// Class Main which include the main method that created a new object of GameLogic.
public class Main {
    public static void main(String[] args) {
        int winCon;

        //Passing winnining condition as a command line arguemenr 2 < N < 7.
        if (args.length == 0){
            System.out.println("2 < winning conditon < 7.");
            System.out.println("Default value will be used.");
            winCon = 4;
            System.out.println("Winning condition: "+ winCon);
            System.out.println();
            new GameLogic(winCon);
        }
        else if (Integer.parseInt(args[0])<=2 ||Integer.parseInt(args[0])>=7){
            System.out.println("2 <winning conditon < 7");
            System.out.println("Game will be terminated.");
        }
        else {
            winCon = Integer.parseInt(args[0]);
            System.out.println("Winning condition: "+ winCon);
            System.out.println();
            new GameLogic(winCon);
        }
    }
}