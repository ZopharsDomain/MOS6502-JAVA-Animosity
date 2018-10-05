public class Core {

	/////////////////////////////////////////////////////////
	//		Core.java
	//		Acts as the CPU core for an NMOS 6502
	//
	//		Michael F. R. Jean
	//		umjeanm@cc.umanitoba.ca
	/////////////////////////////////////////////////////////

	//////////////////////////
	//		instance variables
	//////////////////////////

	public static Registers regs = new Registers();
	public static Clock clock = new Clock();
	public static Memory memory = new Memory();
	public static int origin = 0x00;

	// step():: passes a command into the opcode handler
	public static void step() {
		//
		// 	program execution is as follows:
		//
		//		(1) 	raw command cmd, which contains an opcode and
		//				an operand (16 or 8 bit) is translated into a
		//				clean command. which contains the opcode type,
		//				translated operand (absolute becomes immediate),
		//				and some status flags if the handler needs them.
		//				These flags can include "accumulator", which tells
		//				some commands that work with ,A options if they are
		//				being handed a valid operand or to use AC. Probably
		//				more status flags will need to be added.
		//
		//		(2)	The clean command is executed, and registers/memory are
		//				updated accordingly
		//
		//		(3)	The clock is updated based on the command. The clean
		//				object also contains the clock cycles required by a
		//				given command.
		//
		//		(4)	The program counter is updated.
		//
		//		(5) The IO handler is given a copy of the clean command
		//			to see if it needs to handle any IO (ie, STA $2001)
		//
		System.out.print("cmd@" + regs.pc + ": ");
		RawCommand raw = Xlate.convertToRaw(regs.pc);
		System.out.print("[raw oc: " + raw.getOpcode() + " or: " + raw.getOperand() + "]");
		CleanCommand clean = Xlate.convertToClean(raw);
		System.out.print("[cln oc: " + clean.getOpcode() + " or: " + clean.getOperand() + " cl: "
			+ clean.getClockCycles() + " ds: " + clean.getDisplacement() + " (a:" + clean.isAccumulator() + ")");
		OpCode.handle(clean);	// execute instruction

		// update pc/clock
		clock.update(clean.getClockCycles());
		regs.pc += clean.getDisplacement();
		System.out.println(" [pex clock@" + clock.getClock() + " pc@" + regs.pc + "]");

		//IOHandler.handle(clean);	// verify io
	}

	// setOrigin():: moves the initial execution point to a new int, and updates PC
	public static void setOrigin(int norigin) {
		origin = norigin;
		regs.pc = origin;
	}

	// setMemory():: replace memory with some new object
	public static void setMemory(Memory m) {
		memory = m;
	}

} // Core
