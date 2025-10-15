import java.util.ArrayList;

public class TicTacToe {
    private int size;

    TicTacToe(int size) {
        this.size = size;
    }

    private ArrayList<ArrayList<Cell>> initBoard2D(int size) {
        ArrayList<ArrayList<Cell>> board = new ArrayList();

        for(int i = 0; i < size; ++i) {
            ArrayList<Cell> row = new ArrayList();

            for(int j = 0; j < size; ++j) {
                row.add(new EmptyCell());
            }

            board.add(row);
            System.out.println(row);
        }

        return board;
    }

    public void initBoard1D(int size) {
        ArrayList<Cell> board = new ArrayList();

        while(size > board.size()) {
            board.add(new EmptyCell());
        }

        System.out.println(board);
    }

    public void display() {
        for(ArrayList<Cell> row : this.initBoard2D(this.size)) {
            for(Cell cell : row) {
                System.out.print(cell);
            }
        }

    }
}