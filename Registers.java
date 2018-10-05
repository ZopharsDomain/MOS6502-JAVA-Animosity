public class Registers {

	/////////////////////////////////////////////////////////
	//		Registers.java
	//		Register set for the 6502
	//
	//		Michael F. R. Jean
	//		umjeanm@cc.umanitoba.ca
	/////////////////////////////////////////////////////////

	//////////////////////////
	//		finalized variables
	//////////////////////////

	// status flag conditions
	public static final int CARRY = 0x1;
	public static final int ZERO = 0x2;
	public static final int INTERRUPT = 0x4;
	public static final int DECIMAL = 0x8;		// not used in this cpu
	public static final int BREAK = 0x10;
	public static final int OVERFLOW = 0x40;
	public static final int SIGN = 0x80;

	// stack
	public static final int STACK_BEGIN = 0x100;
	public static final int STACK_END = 0x1ff;

	//////////////////////////
	//		instance variables
	//////////////////////////

	public int x;	// x index
	public int y;	// y index
	public int ac;	// accumulator
	public int sp;	// stack pointer
	public int pc;	// program counter
	public int ps;	// processor status

	//////////////////////////
	//		constructor
	//////////////////////////

	public Registers() {
		// clear everything
		x = 0x00;
		y = 0x00;
		ac = 0x00;
		sp = 0x1ff;
		pc = 0x00;
		ps = 0x00;
	}

	//////////////////////////
	//		stack pointer routines
	//////////////////////////

	public void bumpUpStackPointer() {
		if (sp > STACK_BEGIN)
			sp++;
	}

	public void bumpDownStackPointer() {
		if (sp < STACK_END)
			sp--;
	}

	//////////////////////////
	//		status register routines
	//////////////////////////

	// checks for various status flag conditions
	public boolean isCarry() { return ((ps & CARRY) == CARRY); }
	public boolean isZero() { return ((ps & ZERO) == ZERO); }
	public boolean isInterrupt() { return ((ps & INTERRUPT) == INTERRUPT); }
	public boolean isDecimal() { return ((ps & DECIMAL) == DECIMAL); }
	public boolean isBreak() { return ((ps & BREAK) == BREAK); }
	public boolean isOverflow() { return ((ps & OVERFLOW) == OVERFLOW); }
	public boolean isSign() { return ((ps & SIGN) == SIGN); }

	// sets for various status flag conditions
	public void setCarry(boolean condition) {
		if (!isCarry() && condition)			ps += CARRY;
		else if (isCarry() && !condition)		ps -= CARRY;
	}

	public void setZero(boolean condition) {
		if (!isZero() && condition)				ps += ZERO;
		else if (isZero() && !condition)		ps -= ZERO;
	}

	public void setInterrupt(boolean condition) {
		if (!isInterrupt() && condition)		ps += INTERRUPT;
		else if (isInterrupt() && !condition)	ps -= INTERRUPT;
	}

	public void setDecimal(boolean condition) {
		if (!isDecimal() && condition)			ps += DECIMAL;
		else if (isDecimal() && !condition)		ps -= DECIMAL;
	}

	public void setBreak(boolean condition) {
		if (!isBreak() && condition)			ps += BREAK;
		else if (isBreak() && condition)		ps -= BREAK;
	}

	public void setOverflow(boolean condition) {
		if (!isOverflow() && condition)			ps += OVERFLOW;
		else if (isOverflow() && !condition)	ps -= OVERFLOW;
	}

	public void setSign(boolean condition) {
		if (!isSign() && condition)				ps += SIGN;
		else if (isSign() && !condition)		ps -= SIGN;
	}

} // Registers
