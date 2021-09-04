import javax.print.attribute.standard.PresentationDirection;

public class Move {
    public static boolean definesMove(int row1, int col1,int row2, int col2, int rows, int columns){
        //for(int i=0;)
        return false;
    }

    public Move(int row1, int col1, int row2, int col2, int rows, int columns){
        definesMove(row1, col1, row2, col2, rows, columns);
    }
    public int startRow(){return 1;}
    public int startcolumn(){return 1;}
    public int endtRow(){return 1;}
    public int endcolumn(){return 1;}
    public Direction direction(){return null;}
    public int rows(){return 1;}
    public int columns(){return 1;}

}
