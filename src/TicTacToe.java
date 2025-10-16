import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {
    private int size;
    private Player player;
    private ArrayList<ArrayList<Cell>> board;
    private ArrayList<Integer> coordinates;

    Scanner input = new Scanner(System.in);

    TicTacToe(int size) {
        this.size = size;
        initBoard2D(size);
    }

    public ArrayList<ArrayList<Cell>> initBoard2D(int size) {
        board = new ArrayList();

        for (int i = 0; i < size; ++i) {
            ArrayList<Cell> row = new ArrayList();
            for (int j = 0; j < size; ++j) {
                row.add(new EmptyCell());
            }
            board.add(row);
        }
        return board;
    }

    public void initBoard1D(int size) {
        ArrayList<Cell> board = new ArrayList();
        while (size > board.size()) {
            board.add(new EmptyCell());
        }
        System.out.println(board);
    }

    public void display() {
        for (ArrayList<Cell> row : this.board) {
            for (Cell cell : row) {
                System.out.print(cell.getRepresentation() + "|");
            }
            System.out.println();
        }
    }

    public ArrayList<Integer> getMoveFromPlayer() {
        boolean turnCorrrect = false;
        coordinates = new ArrayList<>();

        while (!turnCorrrect) {
            System.out.print("Enter row: ");
            int row = checkInput(input.nextInt());

            System.out.print("Enter column: ");
            int col = checkInput(input.nextInt());

            coordinates.add(0, row);
            coordinates.add(1, col);

//            System.out.print("x " + coordinates.get(0));
//            System.out.print("y " + coordinates.get(1));

            int x = coordinates.get(0);
            int y = coordinates.get(1);

            if (board.get(x).get(y) instanceof EmptyCell) {
                System.out.println("Empty cell, you can play");
                turnCorrrect = true;
            } else {
                System.out.println("This cell is already taken, choose another one");
            }
            setOwner(x,y,this.player);
        }

        System.out.println(coordinates);

        return coordinates;
    }

    private int checkInput(int coordinate) {
        boolean incorrect = true;
        while (incorrect) {
            if (coordinate >= size) {
                System.out.println("Invalid input: you must enter a number smaller than " + size + ".");
                System.out.print("Enter again: ");
                coordinate = input.nextInt();
            } else {
                incorrect = false;
            }
        }
        return coordinate;
    }

    public void setOwner(int x, int y, Player player) {
        x = coordinates.get(0);
        y = coordinates.get(1);

        this.player = player;
        //String playerRepresentation = player.getRepresentation();

        board.get(x).set(y,new CrossCell());
        display();
    }

}