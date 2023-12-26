import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class TicTacToe
{
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char[][] board = getBoard(3);
		boolean isPlayerX = true;
		char pX_char = 'X';
		char pO_char = 'O';

		while(!isFilled(board)) {
			char cur_player = isPlayerX ? pX_char : pO_char;

			System.out.println(cur_player+" Enter coord:");
			String coord = sc.next();
			isPlayerX = play(board, isPlayerX, coord, pX_char, pO_char);
			printBoard(board);

			if (foundWinner(board, !isPlayerX, pX_char, pO_char)) {
				System.out.println("Winner is " + cur_player);
				break;

			}
		}
	}

	public static void printBoard(char[][] board)
	{
		for(char[] b:board)
		{
			System.out.println(Arrays.toString(b));
		}
	}

	public static boolean isFilled(char[][] board)
	{
		for (char[] chars : board) {
			for (int j = 0; j < board[0].length; j++) {
				if (chars[j] == ' ')
					return false;
			}
		}
		return true;
	}

	public static char[][] getBoard(int n)
	{
		char[][] board = new char[n][n];

		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				board[i][j]=' ';
			}
		}

		return board;
	}

	public static boolean foundWinner(char[][] board, boolean isPlayerX, char pX_char, char pO_char)
	{
		int row = 0;
		int col = 0;
		char cur_player_char = isPlayerX?pX_char:pO_char;

		int points = 0;
		for(int i=row;i<3;i++)
		{
			for(int j=col;j<3;j++)
			{
				if(board[i][j] == cur_player_char)
					points++;
				else
					break;
			}
		}
		if(points==3)
			return true;

		points = 0;
		for(int i=row;i<3;i++)
		{
			for(int j=col;j<3;j++)
			{
				if(board[j][i] == cur_player_char)
					points++;
				else
					break;
			}
		}
		if(points==3)
			return true;

		points = 0;
		for(int i=row;i<3;i++)
		{
			if(board[i][i]==cur_player_char)
				points++;
		}
		if(points==3)
			return true;

		points = 0;
		for(int i=0;i<3;i++)
		{
			if(board[i][board.length-i-1]==cur_player_char)
				points++;
		}
		return points == 3;
	}

	public static boolean play(char[][] board , boolean isPlayerX, String coord, char pX_char,
	                           char pO_char)
	{
		String[] pos = coord.split(",");

		int row = Integer.parseInt(pos[0]);
		int col = Integer.parseInt(pos[1]);

		if(board[row-1][col-1]==' ') {
			board[row - 1][col - 1] = isPlayerX ? pX_char : pO_char;
			return !isPlayerX;
		}
		else {
			System.out.println("False move!");
			return isPlayerX;
		}
	}
}
