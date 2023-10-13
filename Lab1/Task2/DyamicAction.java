package Lab1_Task2;

public class DyamicAction extends Action{
	 
	private String name;
	
	/**
	 * @param name
	 */
	public DyamicAction(String name) {
		this.name = name;
	}

	@Override
	public boolean isNoOp() {
		return false;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	
}
