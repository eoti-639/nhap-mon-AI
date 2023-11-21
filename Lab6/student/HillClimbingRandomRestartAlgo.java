/**
 * 
 */
package Lab6.student;

public final class HillClimbingRandomRestartAlgo implements ILocalSearchAlgo{
	
	int randomRestarts = 0;
	
	@Override
	public Node excute(Node initialState) {
		HillClimbingSearchAlgo algo = new HillClimbingSearchAlgo();
		Node state = algo.excute(initialState);
		
		while(state.getH() != 0) {
			state = new Node();
			state.generateBoard();
			randomRestarts++;
			algo.stepClimbedAfterRandomRestart = 0;
			state = algo.excute(state);
		}
		
		System.out.println("Step climbeb: " + algo.stepClimbed);
		System.out.println("Number restart: " + randomRestarts);
		System.out.println("Step climbed after random restart: " + algo.stepClimbedAfterRandomRestart);
		return state;
	}

}
