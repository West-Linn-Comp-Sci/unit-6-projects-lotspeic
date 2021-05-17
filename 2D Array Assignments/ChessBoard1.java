public class ChessBoard1

{
    public static void main(String[] args)
    {
        //Create an 8x8 2D String array called chess.
        String[] back = {"Rook", "Knight", "Bishop", "Queen", "King", "Bishop", "Knight", "Rook"};
        String[] front = arrayOfEight("Pawn");
        String[] empty = arrayOfEight("-");
        String[][] chess = {back.clone(), front.clone(), empty.clone(), empty.clone(), empty.clone(), empty.clone(), front.clone(), back.clone()};

        //Use this method to print the chess board onto the console
        print(chess);
    }

    public static String[] arrayOfEight(String val) {
        String[] out = new String[8];
        for(int i = 0; i < 8; i++) {
            out[i] = val;
        }
        return out;
    }

    //Do not make alterations to this method!
    public static void print(String[][] array)
    {
        for(String[] row: array)
        {
            for(String thing: row)
            {
                System.out.print(thing + "\t");
            }
            System.out.println();
        }
    }
}
