public class RawCommand {

	/////////////////////////////////////////////////////////
	//		RawCommand.java
	//		A raw opcode command.
	//
	//		Michael F. R. Jean
	//		umjeanm@cc.umanitoba.ca
	/////////////////////////////////////////////////////////

	//////////////////////////
	//		instance variables
	//////////////////////////

	public int opcode;
	public int operand;

	//////////////////////////
	//		constructor
	//////////////////////////

	public RawCommand(int opcode, int operand) {
		this.opcode = opcode;
		this.operand = operand;
	}

	public int getOpcode() { return opcode; }
	public int getOperand() { return operand; }

} // RawCommand

