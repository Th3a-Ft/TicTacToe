import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {
    private int size;
    private Player firstPlayer;
    private Player secondPlayer;
    private ArrayList<ArrayList<Cell>> board;
    private ArrayList<Integer> coordinates;
    private Player currentPlayer;

    Scanner input = new Scanner(System.in);

    /**
     * Constructor of the class TicTacToe
     *
     * @param size = size of a side of the board (the board is a square so the number of cell equal size*size)
     */
    TicTacToe(int size) {
        this.size = size;
        initBoard2D(size);
    }

    /**
     * Create the 2D array to create the board
     *
     * @param size = size of a side of the board
     * @return an array of an array (2D array)
     */
    private ArrayList<ArrayList<Cell>> initBoard2D(int size) {
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

    /**
     * Create a 1D array
     *
     * @param size = size of the board
     */
    public void initBoard1D(int size) {
        ArrayList<Cell> board = new ArrayList();
        while (size > board.size()) {
            board.add(new Cell());
        }
        System.out.println(board);
    }

    /**
     * Display the board each time this method is called
     */
    private void display() {
        for (ArrayList<Cell> row : this.board) {
            for (Cell cell : row) {
                System.out.print(cell.getRepresentation() + "|");
            }
            System.out.println();
        }
    }

    /**
     * The player enter an int for the row and for the col and check if the Cell is empty or not
     *
     * @return the coordinates enter by the player (x,y)
     */
    private ArrayList<Integer> getMoveFromPlayer() {
        boolean turnCorrrect = false;
        coordinates = new ArrayList<>();

        while (!turnCorrrect) {
            System.out.print("Enter row: ");

            int row = checkInput(input.nextInt());

            System.out.print("Enter column: ");
            int col = checkInput(input.nextInt());

            coordinates.add(0, row);
            coordinates.add(1, col);

            int x = coordinates.get(0);
            int y = coordinates.get(1);

            if (board.get(x).get(y).getRepresentation().equals("   ")) {
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

    /**
     * Check that the value enter by the user to choose a row and a col are valid
     *
     * @param coordinate = input by the player
     * @return the correct input
     */
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

    /**
     * Give the ownership of the cell to a player according the cell he played
     *
     * @param x      is the row choose by the player
     * @param y      is the col choose by the player
     * @param player is the player currently playing
     */
    private void setOwner(int x, int y, Player player) {
        board.get(x).set(y, new Cell(player.getRepresentation()));
        display();
    }

    /**
     * Launch the game, let both players play one after another and end the game if a condition is met (victory or draw)
     */
    public void play() {
        initPlayers();
        currentPlayer = firstPlayer;

        System.out.println(firstPlayer.getName() + " against " + secondPlayer.getName());

        while (true) {
            getMoveFromPlayer();

            if (isOver()) {
//                System.out.println(currentPlayer.getName() + " you won!");
                break;
            }
            currentPlayer = (currentPlayer == firstPlayer) ? secondPlayer : firstPlayer;
            System.out.println(currentPlayer.getName() + " it's your turn to play");
        }
    }

    /**
     * Initialize the players and give a representation (x or o) to the second player according the representation chosen by the first player
     *
     */
    public void initPlayers() {
        firstPlayer = new Player(initPlayerName(), initChoicePlayer());

        System.out.println(firstPlayer.getName() + " " + firstPlayer.getRepresentation());

        if (firstPlayer.getRepresentation().equals(" X ")) {
            secondPlayer = new Player(initPlayerName(), " O ");
            System.out.println(secondPlayer.getName() + " " + secondPlayer.getRepresentation());
        } else if (firstPlayer.getRepresentation().equals(" O ")) {
            secondPlayer = new Player(initPlayerName(), " X ");
            System.out.println(secondPlayer.getName() + " " + secondPlayer.getRepresentation());
        }
    }

    /**
     * Initialize the name of a player
     *
     * @return (string) name of the player
     */
    private String initPlayerName() {
        System.out.println("Enter player name: ");
        String namePlayer = input.nextLine();
        System.out.println("Welcome " + namePlayer + "! ");
        return namePlayer;
    }

    /**
     * Initialize the representation (x or o) choosen by the first player
     *
     * @return (string) representation of the player " X " or " O "
     */
    private String initChoicePlayer() {
        System.out.println("Choose between X and O to play:");
        String choicePlayer = input.nextLine().toUpperCase();

        while (!choicePlayer.equals("X") && !choicePlayer.equals("O")) {
            System.out.println("Invalid input, try again");
            choicePlayer = input.nextLine().toUpperCase();
        }
        if (choicePlayer.equals("X")) {
            return " X ";
        }
        if (choicePlayer.equals("O")) {
            return " O ";
        }
        return choicePlayer;
    }


    /**
     * Check if the bord is full or not
     *
     * @return if true the game stops / if false the came continues
     */
    private boolean isFull() {
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board.size(); ++j) {
                if (board.get(i).get(j).getRepresentation().equals("   ")) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if a row is full or not with the same representation (x or o)
     *
     * @return if true stop the game with a winner / if false the game continues
     */
    private boolean rowWinner() {
        int x = coordinates.get(0);
        int count = 0;
        for (int i = 0; i < board.size(); ++i) {
            if (board.get(x).get(i).getRepresentation().equals(currentPlayer.getRepresentation())) {
                count++;
                if (count == board.size()) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Check if the current player wins by counting the number of his representation (x or o) in the col
     *
     * @return true if number is equal to the size of the board and the player win or false if it's not
     */
    private boolean colWinner() {
        int y = coordinates.get(1);
        int count = 0;
        for (int i = 0; i < board.size(); ++i) {
            if (board.get(i).get(y).getRepresentation().equals(currentPlayer.getRepresentation())) {
                count++;
                if (count == board.size()) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Check if the diag going down if fill with the same representation or not
     *
     * @return true if the cells are all the same (win for the player with this representation) / false if all the cells are not the same
     */
    private boolean diagDownWinner() {
        int count = 0;

        for (int i = 1; i < board.size(); ++i) {
            if (board.get(i).get(i).getRepresentation().equals("   ")) {
                return false;
            }
            if (board.get(i).get(i).getRepresentation().equals(board.get(i - 1).get(i - 1).getRepresentation())) {
                count++;
                if (count == board.size() - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if the diag UP is fill with the same representation
     *
     * @return true if the cells are all the same (win for the player with this representation) / false if all the cells are not the same
     */
    private boolean diagUpWinner() {
        int size = board.size();
        String first = board.get(size - 1).get(0).getRepresentation();

        if (first.equals("   ")) {
            return false;
        }

        for (int i = 1; i < size; i++) {
            String current = board.get(size - 1 - i).get(i).getRepresentation();
            if (!current.equals(first)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if a condition to end the game is met
     *
     * @return (boolean) if true, a player won the game or the board is full
     */
    private boolean isOver() {
        if (diagDownWinner() || diagUpWinner() || rowWinner() || colWinner()) {
            System.out.println(currentPlayer.getName() + " won!");
            return true;
        } else if (isFull()) {
            System.out.println("The board is full.");
            return true;
        }
        return false;
    }

}
