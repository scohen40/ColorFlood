package ColorFlood;


public class BoardBuilder {

    private Board board;

    private String difficulty;

    public BoardBuilder(String difficulty) {

        this.difficulty = difficulty;

        initializeBoard();
    }

    private void initializeBoard() {
        if(difficulty.equals(Properties.DIFFICULTY[0])) {
            board = new Board(Properties.GAME_COLUMNS_EASY, Properties.GAME_ROWS_EASY);
        }
        else if(difficulty.equals(Properties.DIFFICULTY[1])) {
            board = new Board(Properties.GAME_COLUMNS_MEDIUM, Properties.GAME_ROWS_MEDIUM);
        }
        else if(difficulty.equals(Properties.DIFFICULTY[2])) {
            board = new Board(Properties.GAME_COLUMNS_HARD, Properties.GAME_ROWS_HARD);
        }
    }

    public Board getBoard() {
        return board;
    }

//    private void setUpFirstClickListener() {
//        setUpMouseListener();
//
//        this.addMouseListener(mouseListener);
//    }

//    private void setUpMouseListener() {
//        mouseListener = new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                Point point = e.getPoint();
//
//
//
//                board.setCellActive(col, row);
//
//                System.out.println("clicked: " + point + " " + row + " " + col);
//
//                //removeFirstClickListener();
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        };
//    }
//
//    private void removeFirstClickListener() {
//        this.removeMouseListener(mouseListener);
//    }

}