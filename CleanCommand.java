public class CleanCommand {

	/////////////////////////////////////////////////////////
	//		CleanCommand.java
	//		A cleaned up command Opcode can use
	//
	//		Michael F. R. Jean
	//		umjeanm@cc.umanitoba.ca
	/////////////////////////////////////////////////////////

	//////////////////////////
	//		instance variables
	//////////////////////////

	private int opcode;
	private int operand;
	private boolean	accumulator;
	private int clockCycles;
	private int displacement;

	//////////////////////////
	//		constructor
	//////////////////////////

	public CleanCommand(int opcode, int operand, int displacement, int clockCycles) {
		this.opcode = opcode;
		this.operand = operand;
		this.accumulator = false;
		this.clockCycles = clockCycles;
		this.displacement = displacement;
	}

	public CleanCommand(int opcode, int operand, int displacement, int clockCycles, boolean accumulator) {
		this.opcode = opcode;
		this.operand = operand;
		this.accumulator = accumulator;
		this.clockCycles = clockCycles;
		this.displacement = displacement;
	}

	//////////////////////////
	//	various methods
	//////////////////////////

	public void setAccumulator(boolean status) { accumulator = status;}
	public void setOperand(int operand) { this.operand = operand; }
	public void setClockCycles(int clockCycles) { this.clockCycles = clockCycles; }
	public void setDisplacement(int displacement) { this.displacement = displacement; }
	public boolean isAccumulator() { return accumulator; }
	public int getOpcode() { return opcode; }
	public int getOperand() { return operand; }
	public int getClockCycles() { return clockCycles; }
	public int getDisplacement() { return displacement; }

} // CleanCommand