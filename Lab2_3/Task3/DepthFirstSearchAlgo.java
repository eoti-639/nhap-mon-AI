package Lab2_3_task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		
		Stack<Node> stack = new Stack<Node>();
		
		stack.add(root);
		int i = 1;
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			
			if(current.getLabel().equals(goal))
				return current;
			
			for(Edge edge : current.getChildren()) {
				Node child = edge.getEnd();
				if(!stack.contains(child)) {
					child.setParent(current);
					stack.add(child);
				}
			}
			
			System.out.println(i++ + " : " + current + " : " + stack);
			
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Stack<Node> stack = new Stack<Node>();
		
		root.setLabel(start);
		stack.add(root);
		int i = 1;
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			
			if(current.getLabel().equals(goal))
				return current;
			
			for(Edge edge : current.getChildren()) {
				Node child = edge.getEnd();
				if(!stack.contains(child)) {
					child.setParent(current);
					stack.add(child);
				}
			}
			
			System.out.println(i++ + " : " + current + " : " + stack);
			
		}
		return null;
	}

}
