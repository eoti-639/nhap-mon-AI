package Lab1_Task1;

public class Agent {
	
	private AgentProgram program;
	
	public Agent() {
		
	}
	
	public Agent(AgentProgram ag) {
		this.program = ag;
	}
	
	public Action execute(Percept p) {
		if(program != null)
			return program.execute(p);
		return NoOpAction.NO_OP;
	}
}