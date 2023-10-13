package Lab2_3_task3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
	
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		int i =1;
		while(!queue.isEmpty()) {
			
			Node current = queue.poll(); 	
			
			if(current.getLabel().equals(goal))
				return current;
			
			for(Edge edge : current.getChildren()) {
				Node child = edge.getEnd();
				if(!queue.contains(child)) {
					child.setParent(current);
					queue.add(child);
				}
			}
			
			System.out.println(i++ +" : " + current + " :" + queue);
		} 	
		
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Queue<Node> queue = new LinkedList<>();		
		root.setLabel(start);
		queue.add(root);
		
		int i =1;
		while(!queue.isEmpty()) {
			
			Node current = queue.poll();
			
			if(current.getLabel().equals(goal))
				return current;
			
			for(Edge edge : current.getChildren()) {
				Node child = edge.getEnd();
				if(!queue.contains(child)) {
					child.setParent(current);
					queue.add(child);
				}
				
			}
			
			System.out.println(i++ +" : " + current + " :" + queue);
		} 	
		return null;
	}

}
