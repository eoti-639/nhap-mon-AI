package Lab2_3_task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		List<Node> list = new ArrayList<>();
		Stack<Node> stack = new Stack<Node>();
		
		stack.add(root);
		int i = 1;
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			
			if(current.getLabel().equals(goal))
				return current;
			list.add(current);
			
			Collections.sort(current.getChildren(), new Comparator<Edge>() {

				@Override
				public int compare(Edge o1, Edge o2) {
					// TODO Auto-generated method stub
					return o2.getEnd().getLabel().compareTo(o1.getEnd().getLabel());
				}
			});
			
			for(Edge edge : current.getChildren()) {
				Node child = edge.getEnd();
				if(!list.contains(child)) {
					child.setParent(current);
					list.add(child);
					stack.add(child);
				}
			}
			
			System.out.println(i++ + " : " + current + " : " + stack);
			
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		List<Node> list = new ArrayList<>();
		Stack<Node> stack = new Stack<Node>();
		
		root.setLabel(start);
		stack.add(root);
		int i = 1;
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			
			if(current.getLabel().equals(goal))
				return current;
			list.add(current);
			
			Collections.sort(current.getChildren(), new Comparator<Edge>() {

				@Override
				public int compare(Edge o1, Edge o2) {
					// TODO Auto-generated method stub
					return o2.getEnd().getLabel().compareTo(o1.getEnd().getLabel());
				}
			});
			
			for(Edge edge : current.getChildren()) {
				Node child = edge.getEnd();
				if(!list.contains(child)) {
					child.setParent(current);
					list.add(child);
					stack.add(child);
				}
			}
			
			System.out.println(i++ + " : " + current + " : " + stack);
			
		}
		return null;
	}

}
