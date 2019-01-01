//package test;
//
//import ColorFlood.Board;
//import ColorFlood.Cell;
//import org.junit.Test;
//
//import java.awt.*;
//
//import static junit.framework.TestCase.assertTrue;
//
//
//public class GameOver
//{
//	@Test
//	public void allCellsActiveGameOver()
//	{
//		//given
//		Board board = new Board(2, 2);
//		board.gameBoard[0][0] = new Cell(0, 0, Color.BLUE);
//		board.gameBoard[1][0] = new Cell(1, 0, Color.BLUE);
//		board.gameBoard[0][1] = new Cell(0, 1, Color.BLUE);
//		board.gameBoard[1][1] = new Cell(1, 1, Color.BLUE);
//
//		//when
//		board.selectedColor = Color.BLUE;
//		board.setCellActive(0, 0);
//		board.setCellActive(1, 0);
//		board.setCellActive(0, 1);
//		board.setCellActive(1, 1);
//
//		//then
//		assertTrue(board.gameOver() == true);
//	}
//
//	@Test
//	public void allTimesUpGameOver()
//	{
//		//given
//		Board board = new Board(2, 2);
//
//		//when
//		board.timesUp();
//
//		//then
//		assertTrue(board.gameOver() == true);
//	}
//}
