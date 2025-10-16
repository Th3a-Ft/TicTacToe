import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {
    private int size;
    private Player player;
    private ArrayList<ArrayList<Cell>> board;
    private ArrayList<Integer> coordinates;
    private Player currentPlayer;

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
                row.add(new Cell());
            }
            board.add(row);
        }
        return board;
    }

    public void initBoard1D(int size) {
        ArrayList<Cell> board = new ArrayList();
        while (size > board.size()) {
            board.add(new Cell());
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
            setOwner(x, y, currentPlayer);
        }

        System.out.println(coordinates);

        return coordinates;
    }

    private int checkInput(int coordinate) {
        boolean incorrect = true;
        while (incorrect) {
            if (coordinate >= size || coordinate < 0) {
                System.out.println("Invalid input: you must enter a number smaller than " + size + "and greater than 0.");
                System.out.print("Enter again: ");
                coordinate = input.nextInt();
            } else {
                incorrect = false;
            }
        }
        return coordinate;
    }

    private void setOwner(int x, int y, Player player) {
        board.get(x).set(y, new CrossCell());
        display();
    }

    public void play() {
        Player firstPlayer = initPlayer();
        Player secondPlayer = initPlayer();
        currentPlayer = firstPlayer;

        boolean readyToPlay = false;
        while (!readyToPlay) {
            if (firstPlayer.getRepresentation().equals(secondPlayer.getRepresentation())) {
                System.out.println("You have the same pawn, please try again to be able to play");
                firstPlayer = initPlayer();
                secondPlayer = initPlayer();
            } else {
                readyToPlay = true;
            }
        }

        System.out.println(firstPlayer.getName() + " against " + secondPlayer.getName());
        while (!isFull()) {
            System.out.println(currentPlayer.getName() + " it's your turn to play");
            getMoveFromPlayer();
            currentPlayer = (currentPlayer == firstPlayer) ? secondPlayer : firstPlayer;
        }
    }

    public Player initPlayer() {
        System.out.println("Enter player name: ");
        String namePlayer = input.nextLine();
        System.out.println("Welcome " + namePlayer + "! ");
        System.out.println("Choose between X and O to play:");
        String choicePlayer = input.nextLine().toUpperCase();

        boolean incorrectChoice = true;

        while (incorrectChoice)
            if (choicePlayer.equals("X")) {
                player = new Player(namePlayer, "X");
                incorrectChoice = false;
            } else if (choicePlayer.equals("O")) {
                player = new Player(namePlayer, "O");
                incorrectChoice = false;
            } else {
                System.out.println("Invalid input, try again");
                choicePlayer = input.nextLine();
            }
        System.out.println(player.getName()+" " + player.getRepresentation());
        return player;
    }

    public boolean isFull() {
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board.size(); ++j) {
                if (board.get(i).get(j) instanceof EmptyCell) {
                    return false;
                }
            }
        }
        System.out.println("The board is full.");
        return true;
    }
}