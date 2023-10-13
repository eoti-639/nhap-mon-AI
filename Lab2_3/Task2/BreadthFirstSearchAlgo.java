package Lab2_3_task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		List<Node> list = new ArrayList<>();
		Queue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o2.getLabel().compareTo(o1.getLabel());
			}		
		});
		
		queue.add(root);
		int i =1;
		while(!queue.isEmpty()) {
			
			Node current = queue.poll();
			
			if(current.getLabel().equals(goal))
				return current;
			
			list.add(current);
			
			for(Edge edge : current.getChildren()) {
				Node child = edge.getEnd();
				if(!list.contains(child)) {
					child.setParent(current);
					list.add(child);
					queue.add(child);
				}
				
			}
			
			System.out.println(i++ +" : " + current + " :" + queue);
		} 	
		
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		List<Node> list = new ArrayList<>();
		Queue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o2.getLabel().compareTo(o1.getLabel());
			}		
		});
		
		root.setLabel(start);
		queue.add(root);
		
		int i =1;
		while(!queue.isEmpty()) {
			
			Node current = queue.poll();
			
			if(current.getLabel().equals(goal))
				return current;
			
			list.add(current);
			
			for(Edge edge : current.getChildren()) {
				Node child = edge.getEnd();
				if(!list.contains(child)) {
					child.setParent(current);
					list.add(child);
					queue.add(child);
				}
				
			}
			
			System.out.println(i++ +" : " + current + " :" + queue);
		} 	
		return null;
	}

}
