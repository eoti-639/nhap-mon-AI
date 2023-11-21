package Lab6.student;

public class HillClimbingSearchAlgo implements ILocalSearchAlgo {
	int stepClimbed = 0;
	int stepClimbedAfterRandomRestart = 0;
	@Override
	public Node excute(Node initialState) {
		Node cr = new Node(initialState);
		Node neighbor = null;
		
		while(true) {
			neighbor = cr.getBestCandidates();
			if(neighbor.getH() < cr.getH()) {
				neighbor = cr;
				stepClimbed++;
				stepClimbedAfterRandomRestart++;
			}
			else {
				return cr;
			}
		}
	}

}
