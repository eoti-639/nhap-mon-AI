package Lab6.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Node {
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		// generateBoard();
		state = new Queen[N];
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {
		int heuristic = 0;
		// Enter your code here
		for(int i = 0; i < state.length; i++) {
			for(int j = i + 1; j < state.length; j++) {
				if(state[i].isConflict(state[j]))
					heuristic++;
			}
		}
		return heuristic;
	}

	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();
		
		for(int i = 0; i < N; i++) {
			Node tmp = new Node(this.state);
			tmp.state[i].move();
			result.add(tmp);
		}
		return result;
	}

	public Node selectNextRandomCandidate() {
		Node result = new Node(this.state);
		Random ran = new Random();
		int i = ran.nextInt(N);
		int row = ran.nextInt(N);
		
		result.state[i].setRow(row);
		return result;
	}
	
	public Node getBestCandidates() {
		List<Node> list = generateAllCandidates();
		
		Node n = list.get(0);
		for(int i = 1; i < list.size(); i++) {
			if(n.getH() > list.get(i).getH())
				n = list.get(i);
		}
		return n;
	}

	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}
}
