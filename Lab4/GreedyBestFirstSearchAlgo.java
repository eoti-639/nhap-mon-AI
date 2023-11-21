package Lab4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		List<Node> explored = new ArrayList<>();
		PriorityQueue<Node> frontier = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				Double h1 = o1.getH();
				Double h2 = o2.getH();
				int result = h1.compareTo(h2);
				if (result == 0)
				return o1.getLabel().compareTo(o2.getLabel());
				else
				return result;
			}
		});
		
		frontier.add(root);
		Node current = null;
		while(!frontier.isEmpty()) {
			current = frontier.poll();
			if(current.getLabel().equals(goal))
				return current;
			explored.add(current);
			
			for(Edge e : current.getChildren()) {
				Node child = e.getEnd();
				if(!explored.contains(child) && !frontier.contains(child)) {
					child.setParent(current);
					child.setG(current.getG() + e.getWeight());
					frontier.add(child);
				}
			}
		}
		
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
