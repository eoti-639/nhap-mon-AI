package Lab5;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class GBFS implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new
				PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		Set<Node> explored = new HashSet<>();
		
		frontier.add(model.getInitialState());
		model.getInitialState().setH(model.computeH2(model.getInitialState()));
		int i =0;
		while(!frontier.isEmpty()){
			Node current = frontier.poll();
			
			System.out.println("H: " + current.getH());
			explored.add(current);	
			System.out.println(i++ + ": \n" + current);
			if(current.equals(model.getGoalState()))
				return current;
			
			for(Node child : model.getSuccessors(current)) {
				if(!frontier.contains(child))
					explored.add(child);
			}
		}
		
		return null;
	}

}
