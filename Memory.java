public class Memory {

	/////////////////////////////////////////////////////////
	//		Memory.java
	//		The memory for the 6502 unit
	//
	//		Michael F. R. Jean
	//		umjeanm@cc.umanitoba.ca
	/////////////////////////////////////////////////////////

	//////////////////////////
	//		finalized variables
	//////////////////////////

	public static final int SIZE_MEMORY = 0x10000;

	//////////////////////////
	//		instance variables
	//////////////////////////

	public int[] memory;

	//////////////////////////
	//		constructor
	//////////////////////////

	public Memory() {
		memory = new int[SIZE_MEMORY];
	}

	//////////////////////////
	//		methods for accessing and changing memory
	//////////////////////////

	// read():: returns memory from a location
	public int read(int location) {
		if (location >= SIZE_MEMORY)
			return 0x00;
		else
			return memory[location];
	}

	// write():: writes a byte into memory
	public void write(int location, int data) {
		if (location < SIZE_MEMORY)
			memory[location] = (data & 0xff);
	}

	// push():: pushes data onto the stack
	public void push(int data) {
		memory[Core.regs.sp] = data;
		Core.regs.bumpUpStackPointer();
	}

	// pull():: pulls data off the stack
	public int pull() {
		int fromStack = memory[Core.regs.sp];
		Core.regs.bumpDownStackPointer();
		return fromStack;
	}

} // Memory
