package Lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.text.AsyncBoxView.ChildLocator;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;//Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	
	List<Node> population = new ArrayList<Node>();
	
	Random rd = new Random();
	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}
	
	public Node execute() {
		initPopulation();
		Node child = new Node();
		int k = 0;
		while(k++ < MAX_ITERATIONS) {
			List<Node> newPopulation = new ArrayList<>();
			for(int i =0; i < POP_SIZE; i++) {
				Node x = getParentByRandomSelection();
				Node y = getParentByRandomSelection();
				child = reproduce(x, y);
				if(rd.nextDouble() < MAX_ITERATIONS) {
					mutate(child);
				}
				if(child.getH() == 0) {
					return child;
				}
				newPopulation.add(child);
			}// end for
			population = newPopulation;
		}
		Collections.sort(population);
	return population.get(0);
	}
	// Mutate an individual by selecting a random Queen and 
	//move it to a random row.
	public void mutate(Node node) {
		int i = rd.nextInt(Node.N);
		int row = rd.nextInt(Node.N);
		node.setRow(i, row);
	}
	
	//Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		Node child = new Node();
		int c = rd.nextInt(Node.N);
		for(int i=0; i < c; i++) {
			child.setRow(i, x.getRow(i));
		}
		
		for(int i = c+1; i < Node.N; i++) {
			child.setRow(i, y.getRow(i));
		}
	return child;
	}
	// Select K individuals from the population at random and 
	//select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
	// Enter your code here
	return null;
	}
	//Select a random parent from the population
	public Node getParentByRandomSelection() {
		Node parent = new Node();
		int c = rd.nextInt(Node.N);
		for(int i = 0; i < c; i++) {
			parent = population.get(i);
		}
	return parent;
	}
}
