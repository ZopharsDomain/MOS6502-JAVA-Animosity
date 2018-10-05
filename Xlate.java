public class Xlate {

	/////////////////////////////////////////////////////////
	//		Xlate.java
	//		Really ugly static stuff to convert opcodes
	//
	//		Michael F. R. Jean
	//		umjeanm@cc.umanitoba.ca
	/////////////////////////////////////////////////////////

	//////////////////////////
	//	finalized variables
	//////////////////////////

	// various addressing modes
	public static final int ADDR_IMMEDIATE = 0;
	public static final int ADDR_ABSOLUTE = 1;
	public static final int ADDR_INDEXED_X = 2;
	public static final int ADDR_INDEXED_Y = 3;
	public static final int ADDR_ZERO_PAGE = 4;
	public static final int ADDR_ZERO_PAGE_X = 5;
	public static final int ADDR_INDIRECT = 6;
	public static final int ADDR_ACCUMULATOR = 7;
	public static final int ADDR_IMPLIED = 8;
	public static final int ADDR_RELATIVE = 9;
	public static final int ADDR_ZERO_PAGE_Y = 10;
	public static final int ADDR_INDIRECT_X = 11;
	public static final int ADDR_INDIRECT_Y = 12;

	// basic opcode map
	public static final int ADC = 0;
	public static final int AND = 1;
	public static final int ASL = 2;
	public static final int BCC = 3;
	public static final int BCS = 4;
	public static final int BEQ = 5;
	public static final int BIT = 6;
	public static final int BMI = 7;
	public static final int BNE = 8;
	public static final int BPL = 9;
	public static final int BRK = 10;
	public static final int BVC = 11;
	public static final int BVS = 12;
	public static final int CLC = 13;
	public static final int CLD = 14;
	public static final int CLI = 15;
	public static final int CLV = 16;
	public static final int CMP = 17;
	public static final int CPX = 18;
	public static final int CPY = 19;
	public static final int DEC = 20;
	public static final int DEX = 21;
	public static final int DEY = 22;
	public static final int EOR = 23;
	public static final int INC = 24;
	public static final int INX = 25;
	public static final int INY = 26;
	public static final int JMP = 27;
	public static final int JSR = 28;
	public static final int LDA = 29;
	public static final int LDX = 30;
	public static final int LDY = 31;
	public static final int LSR = 32;
	public static final int NOP = 33;
	public static final int ORA = 34;
	public static final int PHA = 35;
	public static final int PHP = 36;
	public static final int PLA = 37;
	public static final int PLP = 38;
	public static final int ROL = 39;
	public static final int ROR = 40;
	public static final int RTI = 41;
	public static final int RTS = 42;
	public static final int SBC = 43;
	public static final int SEC = 44;
	public static final int SED = 45;
	public static final int SEI = 46;
	public static final int STA = 47;
	public static final int STX = 48;
	public static final int STY = 49;
	public static final int TAX = 50;
	public static final int TAY = 51;
	public static final int TSX = 52;
	public static final int TXA = 53;
	public static final int TXS = 54;
	public static final int TYA = 55;

	// opcode in address map
	public static final int ADC_IMMEDIATE = 0x69; 		// ADC
	public static final int ADC_ABSOLUTE = 0x6D;
	public static final int ADC_INDEXED_X = 0x7D;
	public static final int ADC_INDEXED_Y = 0x79;
	public static final int ADC_ZERO_PAGE = 0x65;
	public static final int ADC_ZERO_PAGE_X = 0x75;
	public static final int ADC_INDIRECT_X = 0x61;
	public static final int ADC_INDIRECT_Y = 0x71;
	public static final int AND_IMMEDIATE = 0x29; 		// AND
	public static final int AND_ABSOLUTE = 0x2D;
	public static final int AND_INDEXED_X = 0x3D;
	public static final int AND_INDEXED_Y = 0x39;
	public static final int AND_ZERO_PAGE = 0x25;
	public static final int AND_ZERO_PAGE_X = 0x35;
	public static final int AND_INDIRECT_X = 0x21;
	public static final int AND_INDIRECT_Y = 0x31;
	public static final int ASL_ABSOLUTE = 0x0E;		// ASL
	public static final int ASL_ACCUMULATOR = 0x0A;
	public static final int ASL_INDEXED_X = 0x1E;
	public static final int ASL_ZERO_PAGE = 0x06;
	public static final int ASL_ZERO_PAGE_X = 0x16;
	public static final int BCC_RELATIVE = 0x90;		// BCC
	public static final int BCS_RELATIVE = 0xB0;		// BCS
	public static final int BEQ_RELATIVE = 0xF0;		// BEQ
	public static final int BIT_ZERO_PAGE = 0x24;		// BIT
	public static final int BIT_ABSOLUTE = 0x2C;
	public static final int BMI_RELATIVE = 0x30;		// BMI
	public static final int BNE_RELATIVE = 0xD0;		// BNE
	public static final int BPL_RELATIVE = 0x10;		// BPL
	public static final int BRK_IMPLIED = 0x00;			// BRK
	public static final int BVC_RELATIVE = 0x50;		// BVC
	public static final int BVS_RELATIVE = 0x70;		// BVS
	public static final int CLC_IMPLIED = 0x18;			// CLC
	public static final int CLD_IMPLIED = 0xD8;			// CLD (UNUSED)
	public static final int CLI_IMPLIED = 0x58;			// CLI
	public static final int CLV_IMPLIED = 0xB8;			// CLV
	public static final int CMP_IMMEDIATE = 0xC9;		// CMP
	public static final int CMP_ZERO_PAGE = 0xC5;
	public static final int CMP_ZERO_PAGE_X = 0xD5;
	public static final int CMP_ABSOLUTE = 0xCD;
	public static final int CMP_INDEXED_X = 0xDD;
	public static final int CMP_INDEXED_Y = 0xD9;
	public static final int CMP_INDIRECT_X = 0xC1;
	public static final int CMP_INDIRECT_Y = 0xD1;
	public static final int CPX_IMMEDIATE = 0xE0;		// CPX
	public static final int CPX_ZERO_PAGE = 0xE4;
	public static final int CPX_ABSOLUTE = 0xEC;
	public static final int CPY_IMMEDIATE = 0xC0;		// CPY
	public static final int CPY_ZERO_PAGE = 0xC4;
	public static final int CPY_ABSOLUTE = 0xCC;
	public static final int DEC_ZERO_PAGE = 0xC6;		// DEC
	public static final int DEC_ZERO_PAGE_X = 0xD6;
	public static final int DEC_ABSOLUTE = 0xCE;
	public static final int DEC_INDEXED_X = 0xDE;
	public static final int DEX_IMPLIED = 0xCA;			// DEX
	public static final int DEY_IMPLIED = 0x88;			// DEY
	public static final int EOR_IMMEDIATE = 0x49;		// EOR
	public static final int EOR_ZERO_PAGE = 0x45;
	public static final int EOR_ZERO_PAGE_X = 0x55;
	public static final int EOR_ABSOLUTE = 0x40;
	public static final int EOR_INDEXED_X = 0x5D;
	public static final int EOR_INDEXED_Y = 0x59;
	public static final int EOR_INDIRECT_X = 0x41;
	public static final int EOR_INDIRECT_Y = 0x51;
	public static final int INC_ZERO_PAGE = 0xE6;		// INC
	public static final int INC_ZERO_PAGE_X = 0xF6;
	public static final int INC_ABSOLUTE = 0xEE;
	public static final int INC_INDEXED_X = 0xFE;
	public static final int INX_IMPLIED = 0xE8;			// INX
	public static final int INY_IMPLIED = 0xC8;			// INY
	public static final int JMP_ABSOLUTE = 0x4C;		// JMP
	public static final int JMP_INDIRECT = 0x6C;
	public static final int JSR_ABSOLUTE = 0x20;		// JSR
	public static final int LDA_IMMEDIATE = 0xA9; 		// LDA
	public static final int LDA_ABSOLUTE = 0xAD;
	public static final int LDA_INDEXED_X = 0xBD;
	public static final int LDA_INDEXED_Y = 0xB9;
	public static final int LDA_ZERO_PAGE = 0xA5;
	public static final int LDA_ZERO_PAGE_X = 0xB5;
	public static final int LDA_INDIRECT_X = 0xA1;
	public static final int LDA_INDIRECT_Y = 0xB1;
	public static final int LDX_IMMEDIATE = 0xA2;		// LDX
	public static final int LDX_ZERO_PAGE = 0xA6;
	public static final int LDX_ZERO_PAGE_Y = 0xB6;
	public static final int LDX_ABSOLUTE = 0xAE;
	public static final int LDX_INDEXED_Y = 0xBE;
	public static final int LDY_IMMEDIATE = 0xA0;		// LDY
	public static final int LDY_ZERO_PAGE = 0xA4;
	public static final int LDY_ZERO_PAGE_X = 0xB4;
	public static final int LDY_ABSOLUTE = 0xAC;
	public static final int LDY_INDEXED_X = 0xBC;
	public static final int LSR_ACCUMULATOR = 0x4A;		// LSR
	public static final int LSR_ZERO_PAGE = 0x46;
	public static final int LSR_ZERO_PAGE_X = 0x56;
	public static final int LSR_ABSOLUTE = 0x4E;
	public static final int LSR_INDEXED_X = 0x5E;
	public static final int NOP_IMPLIED = 0xEA;			// NOP
	public static final int ORA_IMMEDIATE = 0x09;		// ORA
	public static final int ORA_ZERO_PAGE = 0x05;
	public static final int ORA_ZERO_PAGE_X = 0x15;
	public static final int ORA_ABSOLUTE = 0x0D;
	public static final int ORA_INDEXED_X = 0x1D;
	public static final int ORA_INDEXED_Y = 0x19;
	public static final int ORA_INDIRECT_X = 0x01;
	public static final int ORA_INDIRECT_Y = 0x11;
	public static final int PHA_IMPLIED = 0x48;			// PHA
	public static final int PHP_IMPLIED = 0x08;			// PHP
	public static final int PLA_IMPLIED = 0x68;			// PLA
	public static final int PLP_IMPLIED = 0x28;			// PLP
	public static final int ROL_ACCUMULATOR = 0x2A;		// ROL
	public static final int ROL_ZERO_PAGE = 0x26;
	public static final int ROL_ZERO_PAGE_X = 0x36;
	public static final int ROL_ABSOLUTE = 0x2E;
	public static final int ROL_INDEXED_X = 0x3E;
	public static final int ROR_ACCUMULATOR = 0x6A;		// ROR
	public static final int ROR_ZERO_PAGE = 0x66;
	public static final int ROR_ZERO_PAGE_X = 0x76;
	public static final int ROR_ABSOLUTE = 0x6E;
	public static final int ROR_INDEXED_X = 0x7E;
	public static final int RTI_IMPLIED = 0x4D;			// RTI
	public static final int RTS_IMPLIED = 0x60;			// RTS
	public static final int SBC_IMMEDIATE = 0xE9;		// SBC
	public static final int SBC_ZERO_PAGE = 0xE5;
	public static final int SBC_ZERO_PAGE_X = 0xF5;
	public static final int SBC_ABSOLUTE = 0xED;
	public static final int SBC_INDEXED_X = 0xFD;
	public static final int SBC_INDEXED_Y = 0xF9;
	public static final int SBC_INDIRECT_X = 0xE1;
	public static final int SBC_INDIRECT_Y = 0xF1;
	public static final int SEC_IMPLIED = 0x38;			// SEC
	public static final int SED_IMPLIED = 0xF8;			// SED (UNUSED)
	public static final int SEI_IMPLIED = 0x78;			// SEI
	public static final int STA_ABSOLUTE = 0x8D;		// STA
	public static final int STA_INDEXED_X = 0x9D;
	public static final int STA_INDEXED_Y = 0x99;
	public static final int STA_ZERO_PAGE = 0x85;
	public static final int STA_ZERO_PAGE_X = 0x95;
	public static final int STA_INDIRECT_X = 0x81;
	public static final int STA_INDIRECT_Y = 0x91;
	public static final int STX_ZERO_PAGE = 0x86;		// STX
	public static final int STX_ZERO_PAGE_Y = 0x96;
	public static final int STX_ABSOLUTE = 0x8E;
	public static final int STY_ZERO_PAGE = 0x84;		// STY
	public static final int STY_ZERO_PAGE_X = 0x94;
	public static final int STY_ABSOLUTE = 0x8C;
	public static final int TAX_IMPLIED = 0xAA;			// TAX
	public static final int TAY_IMPLIED = 0xA8;			// TAY
	public static final int TSX_IMPLIED = 0xBA;			// TSX
	public static final int TXA_IMPLIED = 0x8A;			// TXA
	public static final int TXS_IMPLIED = 0x9A;			// TXS
	public static final int TYA_IMPLIED = 0x98;			// TYA

	// commands like LDA #$00 (2 byte commands)
	public static final int[] SINGLE_OPERAND = {
		ADC_IMMEDIATE,		ADC_ZERO_PAGE, 		ADC_ZERO_PAGE_X,
		AND_IMMEDIATE,
		AND_ZERO_PAGE, 		AND_ZERO_PAGE_X,
		ASL_ZERO_PAGE,		ASL_ZERO_PAGE_X,
		ASL_INDEXED_X, 		BCC_RELATIVE,		BCS_RELATIVE,
		BEQ_RELATIVE, 		BIT_ZERO_PAGE,		BMI_RELATIVE,
		BNE_RELATIVE, 		BPL_RELATIVE,		BPL_RELATIVE,
		BVC_RELATIVE, 		CMP_IMMEDIATE,		CMP_ZERO_PAGE,
		CMP_ZERO_PAGE_X, 	CPX_IMMEDIATE,		CPX_ZERO_PAGE,
		CPY_IMMEDIATE,		CPY_ZERO_PAGE,		DEC_ZERO_PAGE,
		DEC_ZERO_PAGE_X,
		EOR_IMMEDIATE,		EOR_ZERO_PAGE, 		EOR_ZERO_PAGE_X,
		INC_ZERO_PAGE,		INC_ZERO_PAGE_X, 	LDA_IMMEDIATE,
		LDA_ZERO_PAGE,		LDA_ZERO_PAGE_X,
		LDX_IMMEDIATE, 		LDX_ZERO_PAGE,
		LDX_ZERO_PAGE_Y, 	LDY_IMMEDIATE, 		LDY_ZERO_PAGE,
		LDY_ZERO_PAGE_X, 	LSR_ZERO_PAGE, 		LSR_ZERO_PAGE_X,
		ORA_IMMEDIATE, 		ORA_ZERO_PAGE, 		ORA_ZERO_PAGE_X,
		ROL_ZERO_PAGE, 		ROL_ZERO_PAGE_X, 	ROR_ZERO_PAGE,
		ROR_ZERO_PAGE, 		SBC_ZERO_PAGE, 		SBC_ZERO_PAGE_X,
		SBC_IMMEDIATE, 		STA_ZERO_PAGE, 		STA_ZERO_PAGE_X,
		STX_ZERO_PAGE, 		STX_ZERO_PAGE_Y, 	STY_ZERO_PAGE,
		STY_ZERO_PAGE_X};

	// commands like LDA $4000 (3 byte commands)
	public static final int[] DOUBLE_OPERAND = {
		ADC_INDIRECT_X,		ADC_INDIRECT_Y,		AND_INDIRECT_X,
		ADC_ABSOLUTE,		ADC_INDEXED_X,		ADC_INDEXED_Y,
		AND_ABSOLUTE,		AND_INDEXED_X,		AND_INDEXED_Y,
		ASL_ABSOLUTE,		AND_INDIRECT_Y,		LDA_INDIRECT_Y,
		BIT_ABSOLUTE,		CMP_ABSOLUTE,		CMP_INDEXED_X,
		CMP_INDEXED_Y,		CMP_INDIRECT_X,		CMP_INDIRECT_Y,
		CPX_ABSOLUTE,		CPY_ABSOLUTE,		DEC_ABSOLUTE,
		DEC_INDEXED_X,		EOR_ABSOLUTE,		EOR_INDEXED_X,
		EOR_INDEXED_Y,		EOR_INDIRECT_X,		EOR_INDIRECT_Y,
		INC_ABSOLUTE,		INC_INDEXED_X,		JMP_ABSOLUTE,
		JMP_INDIRECT,		JSR_ABSOLUTE,		LDA_ABSOLUTE,
		LDA_INDEXED_X,		LDA_INDEXED_Y,		LDX_ABSOLUTE,
		LDX_INDEXED_Y,		LDY_ABSOLUTE,		LDY_INDEXED_X,
		LSR_ABSOLUTE,		LSR_INDEXED_X,		ORA_ABSOLUTE,
		ORA_INDEXED_X,		ORA_INDEXED_Y,		ORA_INDIRECT_X,
		ORA_INDIRECT_Y,		ROL_ABSOLUTE,		ROL_INDEXED_X,
		ROR_ABSOLUTE,		ROR_INDEXED_X,		SBC_ABSOLUTE,
		SBC_INDEXED_X,		SBC_INDEXED_Y,		SBC_INDIRECT_X,
		SBC_INDIRECT_Y,		STA_ABSOLUTE,		STA_INDEXED_X,
		STA_INDEXED_Y,		STX_ABSOLUTE,		STY_ABSOLUTE,
		LDA_INDIRECT_X,};

	// commands like ROL,A (1 byte commands)
	public static final int[] NO_OPERAND = {
		ASL_ACCUMULATOR,	CLC_IMPLIED,		CLD_IMPLIED,
		CLI_IMPLIED,		CLV_IMPLIED,		DEX_IMPLIED,
		DEY_IMPLIED,		INX_IMPLIED,		INY_IMPLIED,
		BRK_IMPLIED,		NOP_IMPLIED,		PHA_IMPLIED,
		PHP_IMPLIED,		PLA_IMPLIED,		PLP_IMPLIED,
		RTI_IMPLIED,		RTS_IMPLIED,		SEC_IMPLIED,
		SEI_IMPLIED,		TAX_IMPLIED,		TAY_IMPLIED,
		TSX_IMPLIED,		TXA_IMPLIED,		TXS_IMPLIED,
		TYA_IMPLIED,		ROL_ACCUMULATOR,	ROR_ACCUMULATOR};

	// getLowHigh():: converts two memory locations low/high into their final status
	// 				  i.e. given $4000=$6 $4001=$20, getLowHigh($4000) returns mem@$2006
	public static int getLowHigh(int location) {
		int low = Core.memory.read(location);
		int high = Core.memory.read(location+1);
		int value = (high << 8) + low;		// high shifts to make (A=high b=low) 0xAAAAbbbb
		return value;
	}

	private static int getLowHigh(int low, int high) {
		int addr = (high << 8) + low;		// high shifts to make (A=high b=low) 0xAAAAbbbb
		return addr;
	}


	// convertToRaw()::	Converts an opcode in memory to a raw command
	public static RawCommand convertToRaw(int location) {

		int opcode = Core.memory.read(location);

		// check for 2 byte command (1 byte operand)
		for (int i = 0; i < SINGLE_OPERAND.length; i++) {
			if (opcode == SINGLE_OPERAND[i])
				return new RawCommand(opcode, Core.memory.read(location+1));
		}

		// check for 3 byte command (2 byte operand)
		for (int i = 0; i < DOUBLE_OPERAND.length; i++) {
			if (opcode == DOUBLE_OPERAND[i])
				return new RawCommand(opcode, getLowHigh(location+1));
		}

		// check for 1 byte command (no operand)
		for (int i = 0; i < NO_OPERAND.length; i++) {
			if (opcode == NO_OPERAND[i])
				return new RawCommand(opcode, -1);
		}

		// uh oh..
		return null;
	}

	// xlateAddress():: depending on addressing mode, forces everything into IMMEDIATE
	public static int xlateAddress(int value, int addressMode) {
		if (addressMode == ADDR_IMMEDIATE)
			return value;
		else if (addressMode == ADDR_ABSOLUTE || addressMode == ADDR_ZERO_PAGE) // all the same shit
			return Core.memory.read(value);
		else if (addressMode == ADDR_INDEXED_X || addressMode == ADDR_ZERO_PAGE_X)
			return Core.memory.read(value + Core.regs.x);
		else if (addressMode == ADDR_ZERO_PAGE_Y)
			return Core.memory.read(value + Core.regs.y);
		else if (addressMode == ADDR_INDEXED_Y)
			return Core.memory.read(value + Core.regs.y);
		else if (addressMode == ADDR_INDIRECT_X) {
			int addr = value + Core.regs.x;
			if (addr > 0xff)
				addr &= 0xff;
			int rtr = getLowHigh(Core.memory.read(addr), Core.memory.read(addr+1));
			return Core.memory.read(rtr);
		} else if (addressMode == ADDR_INDIRECT_Y) {
			int rtr = getLowHigh(Core.memory.read(value), Core.memory.read(value+1));
			rtr += Core.regs.y;
			return Core.memory.read(rtr);
		} else 	// uh oh..
			return 0x00;
	}

	// xlateIndex():: grabs real memory location depending on index absolute
	public static int xlateIndex(int value, int addressMode) {
		if (addressMode == ADDR_ABSOLUTE || addressMode == ADDR_ZERO_PAGE)
			return value;
		else if (addressMode == ADDR_INDEXED_X || addressMode == ADDR_ZERO_PAGE_X)
			return value + Core.regs.x;
		else if (addressMode == ADDR_INDEXED_Y)
			return value + Core.regs.y;
		else if (addressMode == ADDR_INDIRECT_X) {
			int addr = value + Core.regs.x;
			if (addr > 0xff)
				addr &= 0xff;
			int rtr = getLowHigh(Core.memory.read(addr), Core.memory.read(addr+1));
			return rtr;
		} else if (addressMode == ADDR_INDIRECT_Y) {
			int rtr = getLowHigh(Core.memory.read(value), Core.memory.read(value+1));
			rtr += Core.regs.y;
			return rtr;
		} else
			return 0x00;
	}

	// checkPage()
	// checks page boundries.. really gross routine.. returns clock cycles to add..
	public static int checkPage(RawCommand cmd, int addr) {
		if (addr == ADDR_INDEXED_X ||
			addr == ADDR_INDEXED_Y ||
			addr == ADDR_INDIRECT_Y) {

			if ((cmd.getOpcode() == (AND) || cmd.getOpcode() == (ORA) || cmd.getOpcode() == (SBC))
				&& addr  == ADDR_INDIRECT_Y) { // weird ones
				// do nothing.
			} else {

				if (cmd.getOpcode() == (ADC) ||
					cmd.getOpcode() == (AND) ||
					cmd.getOpcode() == (CMP) ||
					cmd.getOpcode() == (EOR) ||
					cmd.getOpcode() == (LDA) ||
					cmd.getOpcode() == (LDX) ||
					cmd.getOpcode() == (LDY) ||
					cmd.getOpcode() == (ORA) ||
					cmd.getOpcode() == (SBC)) {

						if (addr == ADDR_INDEXED_X &&
							((Core.regs.x+cmd.getOperand()) & 0xff) < (cmd.getOperand() & 0xff))
							return 1;
						else if (addr == ADDR_INDEXED_Y &&
							((Core.regs.y+cmd.getOperand()) & 0xff) < (cmd.getOperand() & 0xff))
							return 1;
						else if (addr == ADDR_INDIRECT_Y &&
							 ((( getLowHigh(Core.memory.read(cmd.getOperand()), Core.memory.read((cmd.getOperand() + 1) + Core.regs.y )) & 0xff)
								< ((getLowHigh(Core.memory.read(cmd.getOperand()), Core.memory.read(cmd.getOperand() + 1)) & 0xff)))))
							return 1;
						else
							return 0;
				}
			}
		}
		return 0;	// if we got here we suck.
	}

	// relative():: calculates relative address for branch-on commands
	public static int relative(int src) {
		int rtr = src & 0x7f;
		if ((src & 0x80) == 0x80) 	// -ve
			return (-rtr);
		else 						// +ve
			return rtr;
	}

	// convertToClean():: Converts a raw command into a clean command.. sucky
	public static CleanCommand convertToClean(RawCommand raw) {
		int opcode = raw.opcode;
		int operand = raw.operand;
		CleanCommand clean = new CleanCommand(opcode, operand, 0, 0);

		switch(opcode) {
			case ADC_IMMEDIATE: 	return new CleanCommand(ADC, xlateAddress(operand, ADDR_IMMEDIATE), 2, 2);
			case ADC_ZERO_PAGE: 	return new CleanCommand(ADC, xlateAddress(operand, ADDR_ZERO_PAGE), 2, 3);
			case ADC_ZERO_PAGE_X: 	return new CleanCommand(ADC, xlateAddress(operand, ADDR_ZERO_PAGE_X), 2, 4);
			case ADC_ABSOLUTE:	 	return new CleanCommand(ADC, xlateAddress(operand, ADDR_ABSOLUTE), 3, 4);
			case ADC_INDEXED_X:		return new CleanCommand(ADC, xlateAddress(operand, ADDR_INDEXED_X), 3, 4 + checkPage(raw, ADDR_INDEXED_X));
			case ADC_INDEXED_Y:	 	return new CleanCommand(ADC, xlateAddress(operand, ADDR_INDEXED_Y), 3, 4 + checkPage(raw, ADDR_INDEXED_Y));
			case ADC_INDIRECT_X:	return new CleanCommand(ADC, xlateAddress(operand, ADDR_INDIRECT_X), 2, 6);
			case ADC_INDIRECT_Y:	return new CleanCommand(ADC, xlateAddress(operand, ADDR_INDIRECT_Y), 2, 5 + checkPage(raw, ADDR_INDIRECT_Y));
			case AND_IMMEDIATE: 	return new CleanCommand(AND, xlateAddress(operand, ADDR_IMMEDIATE), 2, 2);
			case AND_ZERO_PAGE: 	return new CleanCommand(AND, xlateAddress(operand, ADDR_ZERO_PAGE), 2, 3);
			case AND_ZERO_PAGE_X: 	return new CleanCommand(AND, xlateAddress(operand, ADDR_ZERO_PAGE_X), 2, 4);
			case AND_ABSOLUTE:	 	return new CleanCommand(AND, xlateAddress(operand, ADDR_ABSOLUTE), 3, 4);
			case AND_INDEXED_X:		return new CleanCommand(AND, xlateAddress(operand, ADDR_INDEXED_X), 3, 4 + checkPage(raw, ADDR_INDEXED_X));
			case AND_INDEXED_Y:	 	return new CleanCommand(AND, xlateAddress(operand, ADDR_INDEXED_Y), 3, 4 + checkPage(raw, ADDR_INDEXED_Y));
			case AND_INDIRECT_X:	return new CleanCommand(AND, xlateAddress(operand, ADDR_INDIRECT_X), 2, 6);
			case AND_INDIRECT_Y:	return new CleanCommand(AND, xlateAddress(operand, ADDR_INDIRECT_Y), 2, 5 + checkPage(raw, ADDR_INDIRECT_Y));
			case ASL_ACCUMULATOR: 	return new CleanCommand(ASL, 0x00, 1, 2, true);
			case ASL_ZERO_PAGE: 	return new CleanCommand(ASL, xlateIndex(operand, ADDR_ZERO_PAGE), 2, 5);
			case ASL_ZERO_PAGE_X: 	return new CleanCommand(ASL, xlateIndex(operand, ADDR_ZERO_PAGE_X), 2, 6);
			case ASL_ABSOLUTE:	 	return new CleanCommand(ASL, xlateIndex(operand, ADDR_ABSOLUTE), 3, 6);
			case ASL_INDEXED_X:		return new CleanCommand(ASL, xlateIndex(operand, ADDR_INDEXED_X), 3, 7);

			case BIT_ZERO_PAGE: 	return new CleanCommand(BIT, xlateAddress(operand, ADDR_ZERO_PAGE), 2, 3);
			case BIT_ABSOLUTE:	 	return new CleanCommand(BIT, xlateAddress(operand, ADDR_ABSOLUTE), 3, 4);

			case BCC_RELATIVE: 		return new CleanCommand(BCC, relative(operand), 2, 2);
			case BCS_RELATIVE: 		return new CleanCommand(BCS, relative(operand), 2, 2);
			case BEQ_RELATIVE: 		return new CleanCommand(BEQ, relative(operand), 2, 2);
			case BMI_RELATIVE: 		return new CleanCommand(BMI, relative(operand), 2, 2);
			case BNE_RELATIVE: 		return new CleanCommand(BNE, relative(operand), 2, 2);
			case BPL_RELATIVE: 		return new CleanCommand(BPL, relative(operand), 2, 2);
			case BVC_RELATIVE: 		return new CleanCommand(BVC, relative(operand), 2, 2);
			case BVS_RELATIVE: 		return new CleanCommand(BVS, relative(operand), 2, 2);

			case CLC_IMPLIED: 		return new CleanCommand(CLC, 0x00, 1, 2);
			case CLD_IMPLIED: 		return new CleanCommand(CLD, 0x00, 1, 2);
			case CLI_IMPLIED: 		return new CleanCommand(CLI, 0x00, 1, 2);
			case CLV_IMPLIED: 		return new CleanCommand(CLV, 0x00, 1, 2);
			case CMP_IMMEDIATE: 	return new CleanCommand(CMP, xlateAddress(operand, ADDR_IMMEDIATE), 2, 2);
			case CMP_ZERO_PAGE: 	return new CleanCommand(CMP, xlateAddress(operand, ADDR_ZERO_PAGE), 2, 3);
			case CMP_ZERO_PAGE_X: 	return new CleanCommand(CMP, xlateAddress(operand, ADDR_ZERO_PAGE_X), 2, 4);
			case CMP_ABSOLUTE:	 	return new CleanCommand(CMP, xlateAddress(operand, ADDR_ABSOLUTE), 3, 4);
			case CMP_INDEXED_X:		return new CleanCommand(CMP, xlateAddress(operand, ADDR_INDEXED_X), 3, 4 + checkPage(raw, ADDR_INDEXED_X));
			case CMP_INDEXED_Y:	 	return new CleanCommand(CMP, xlateAddress(operand, ADDR_INDEXED_Y), 3, 4 + checkPage(raw, ADDR_INDEXED_Y));
			case CMP_INDIRECT_X:	return new CleanCommand(CMP, xlateAddress(operand, ADDR_INDIRECT_X), 2, 6);
			case CMP_INDIRECT_Y:	return new CleanCommand(CMP, xlateAddress(operand, ADDR_INDIRECT_Y), 2, 5 + checkPage(raw, ADDR_INDIRECT_Y));
			case CPX_IMMEDIATE: 	return new CleanCommand(CPX, xlateAddress(operand, ADDR_IMMEDIATE), 2, 2);
			case CPX_ZERO_PAGE: 	return new CleanCommand(CPX, xlateAddress(operand, ADDR_ZERO_PAGE), 2, 3);
			case CPX_ABSOLUTE:	 	return new CleanCommand(CPX, xlateAddress(operand, ADDR_ABSOLUTE), 3, 4);
			case CPY_IMMEDIATE: 	return new CleanCommand(CPY, xlateAddress(operand, ADDR_IMMEDIATE), 2, 2);
			case CPY_ZERO_PAGE: 	return new CleanCommand(CPY, xlateAddress(operand, ADDR_ZERO_PAGE), 2, 3);
			case CPY_ABSOLUTE:	 	return new CleanCommand(CPY, xlateAddress(operand, ADDR_ABSOLUTE), 3, 4);

			case DEC_ZERO_PAGE: 	return new CleanCommand(DEC, xlateIndex(operand, ADDR_ZERO_PAGE), 2, 5);
			case DEC_ZERO_PAGE_X: 	return new CleanCommand(DEC, xlateIndex(operand, ADDR_ZERO_PAGE_X), 2, 6);
			case DEC_ABSOLUTE:	 	return new CleanCommand(DEC, xlateIndex(operand, ADDR_ABSOLUTE), 3, 6);
			case DEC_INDEXED_X:		return new CleanCommand(DEC, xlateIndex(operand, ADDR_INDEXED_X), 3, 7);
			case DEX_IMPLIED:		return new CleanCommand(DEX, 0x00, 1, 2);
			case DEY_IMPLIED:		return new CleanCommand(DEY, 0x00, 1, 2);

			case EOR_IMMEDIATE: 	return new CleanCommand(EOR, xlateAddress(operand, ADDR_IMMEDIATE), 2, 2);
			case EOR_ZERO_PAGE: 	return new CleanCommand(EOR, xlateAddress(operand, ADDR_ZERO_PAGE), 2, 3);
			case EOR_ZERO_PAGE_X: 	return new CleanCommand(EOR, xlateAddress(operand, ADDR_ZERO_PAGE_X), 2, 4);
			case EOR_ABSOLUTE:	 	return new CleanCommand(EOR, xlateAddress(operand, ADDR_ABSOLUTE), 3, 4);
			case EOR_INDEXED_X:		return new CleanCommand(EOR, xlateAddress(operand, ADDR_INDEXED_X), 3, 4 + checkPage(raw, ADDR_INDEXED_X));
			case EOR_INDEXED_Y:	 	return new CleanCommand(EOR, xlateAddress(operand, ADDR_INDEXED_Y), 3, 4 + checkPage(raw, ADDR_INDEXED_Y));
			case EOR_INDIRECT_X:	return new CleanCommand(EOR, xlateAddress(operand, ADDR_INDIRECT_X), 2, 6);
			case EOR_INDIRECT_Y:	return new CleanCommand(EOR, xlateAddress(operand, ADDR_INDIRECT_Y), 2, 5 + checkPage(raw, ADDR_INDIRECT_Y));

			case INC_ZERO_PAGE: 	return new CleanCommand(INC, xlateIndex(operand, ADDR_ZERO_PAGE), 2, 5);
			case INC_ZERO_PAGE_X: 	return new CleanCommand(INC, xlateIndex(operand, ADDR_ZERO_PAGE_X), 2, 6);
			case INC_ABSOLUTE:	 	return new CleanCommand(INC, xlateIndex(operand, ADDR_ABSOLUTE), 3, 6);
			case INC_INDEXED_X:		return new CleanCommand(INC, xlateIndex(operand, ADDR_INDEXED_X), 3, 7);
			case INX_IMPLIED:		return new CleanCommand(INX, 0x00, 1, 2);
			case INY_IMPLIED:		return new CleanCommand(INY, 0x00, 1, 2);

			case JMP_ABSOLUTE:	 	return new CleanCommand(JMP, operand, 3, 3);
			case JMP_INDIRECT:	 	return new CleanCommand(JMP, Core.memory.read(operand), 3, 5);
			case JSR_ABSOLUTE:	 	return new CleanCommand(JSR, operand, 3, 6);

			case LDA_IMMEDIATE: 	return new CleanCommand(LDA, xlateAddress(operand, ADDR_IMMEDIATE), 2, 2);
			case LDA_ZERO_PAGE: 	return new CleanCommand(LDA, xlateAddress(operand, ADDR_ZERO_PAGE), 2, 3);
			case LDA_ZERO_PAGE_X: 	return new CleanCommand(LDA, xlateAddress(operand, ADDR_ZERO_PAGE_X), 2, 4);
			case LDA_ABSOLUTE:	 	return new CleanCommand(LDA, xlateAddress(operand, ADDR_ABSOLUTE), 3, 4);
			case LDA_INDEXED_X:		return new CleanCommand(LDA, xlateAddress(operand, ADDR_INDEXED_X), 3, 4 + checkPage(raw, ADDR_INDEXED_X));
			case LDA_INDEXED_Y:	 	return new CleanCommand(LDA, xlateAddress(operand, ADDR_INDEXED_Y), 3, 4 + checkPage(raw, ADDR_INDEXED_Y));
			case LDA_INDIRECT_X:	return new CleanCommand(LDA, xlateAddress(operand, ADDR_INDIRECT_X), 2, 6);
			case LDA_INDIRECT_Y:	return new CleanCommand(LDA, xlateAddress(operand, ADDR_INDIRECT_Y), 2, 5 + checkPage(raw, ADDR_INDIRECT_Y));
			case LDX_IMMEDIATE: 	return new CleanCommand(LDX, xlateAddress(operand, ADDR_IMMEDIATE), 2, 2);
			case LDX_ZERO_PAGE: 	return new CleanCommand(LDX, xlateAddress(operand, ADDR_ZERO_PAGE), 2, 3);
			case LDX_ZERO_PAGE_Y: 	return new CleanCommand(LDX, xlateAddress(operand, ADDR_ZERO_PAGE_Y), 2, 4);
			case LDX_ABSOLUTE:	 	return new CleanCommand(LDX, xlateAddress(operand, ADDR_ABSOLUTE), 3, 4);
			case LDX_INDEXED_Y:		return new CleanCommand(LDX, xlateAddress(operand, ADDR_INDEXED_Y), 3, 4 + checkPage(raw, ADDR_INDEXED_Y));
			case LDY_IMMEDIATE: 	return new CleanCommand(LDY, xlateAddress(operand, ADDR_IMMEDIATE), 2, 2);
			case LDY_ZERO_PAGE: 	return new CleanCommand(LDY, xlateAddress(operand, ADDR_ZERO_PAGE), 2, 3);
			case LDY_ZERO_PAGE_X: 	return new CleanCommand(LDY, xlateAddress(operand, ADDR_ZERO_PAGE_X), 2, 4);
			case LDY_ABSOLUTE:	 	return new CleanCommand(LDY, xlateAddress(operand, ADDR_ABSOLUTE), 3, 4);
			case LDY_INDEXED_X:		return new CleanCommand(LDY, xlateAddress(operand, ADDR_INDEXED_X), 3, 4 + checkPage(raw, ADDR_INDEXED_X));
			case LSR_ACCUMULATOR: 	return new CleanCommand(LSR, 0x00, 1, 2, true);
			case LSR_ZERO_PAGE: 	return new CleanCommand(LSR, xlateIndex(operand, ADDR_ZERO_PAGE), 2, 5);
			case LSR_ZERO_PAGE_X: 	return new CleanCommand(LSR, xlateIndex(operand, ADDR_ZERO_PAGE_X), 2, 6);
			case LSR_ABSOLUTE:	 	return new CleanCommand(LSR, xlateIndex(operand, ADDR_ABSOLUTE), 3, 6);
			case LSR_INDEXED_X:		return new CleanCommand(LSR, xlateIndex(operand, ADDR_INDEXED_X), 3, 7);

			case NOP_IMPLIED:		return new CleanCommand(NOP, 0x00, 1, 2);

			case ORA_IMMEDIATE: 	return new CleanCommand(ORA, xlateAddress(operand, ADDR_IMMEDIATE), 2, 2);
			case ORA_ZERO_PAGE: 	return new CleanCommand(ORA, xlateAddress(operand, ADDR_ZERO_PAGE), 2, 3);
			case ORA_ZERO_PAGE_X: 	return new CleanCommand(ORA, xlateAddress(operand, ADDR_ZERO_PAGE_X), 2, 4);
			case ORA_ABSOLUTE:	 	return new CleanCommand(ORA, xlateAddress(operand, ADDR_ABSOLUTE), 3, 4);
			case ORA_INDEXED_X:		return new CleanCommand(ORA, xlateAddress(operand, ADDR_INDEXED_X), 3, 4 + checkPage(raw, ADDR_INDEXED_X));
			case ORA_INDEXED_Y:	 	return new CleanCommand(ORA, xlateAddress(operand, ADDR_INDEXED_Y), 3, 4 + checkPage(raw, ADDR_INDEXED_Y));
			case ORA_INDIRECT_X:	return new CleanCommand(ORA, xlateAddress(operand, ADDR_INDIRECT_X), 2, 6);
			case ORA_INDIRECT_Y:	return new CleanCommand(ORA, xlateAddress(operand, ADDR_INDIRECT_Y), 2, 5 + checkPage(raw, ADDR_INDIRECT_Y));

			case PHA_IMPLIED:		return new CleanCommand(PHA, 0x00, 1, 3);
			case PHP_IMPLIED:		return new CleanCommand(PHP, 0x00, 1, 3);
			case PLA_IMPLIED:		return new CleanCommand(PLA, 0x00, 1, 3);
			case PLP_IMPLIED:		return new CleanCommand(PLP, 0x00, 1, 3);

			case ROL_ACCUMULATOR: 	return new CleanCommand(ROL, 0x00, 1, 2, true);
			case ROL_ZERO_PAGE: 	return new CleanCommand(ROL, xlateIndex(operand, ADDR_ZERO_PAGE), 2, 5);
			case ROL_ZERO_PAGE_X: 	return new CleanCommand(ROL, xlateIndex(operand, ADDR_ZERO_PAGE_X), 2, 6);
			case ROL_ABSOLUTE:	 	return new CleanCommand(ROL, xlateIndex(operand, ADDR_ABSOLUTE), 3, 6);
			case ROL_INDEXED_X:		return new CleanCommand(ROL, xlateIndex(operand, ADDR_INDEXED_X), 3, 7);
			case ROR_ACCUMULATOR: 	return new CleanCommand(ROR, 0x00, 1, 2, true);
			case ROR_ZERO_PAGE: 	return new CleanCommand(ROR, xlateIndex(operand, ADDR_ZERO_PAGE), 2, 5);
			case ROR_ZERO_PAGE_X: 	return new CleanCommand(ROR, xlateIndex(operand, ADDR_ZERO_PAGE_X), 2, 6);
			case ROR_ABSOLUTE:	 	return new CleanCommand(ROR, xlateIndex(operand, ADDR_ABSOLUTE), 3, 6);
			case ROR_INDEXED_X:		return new CleanCommand(ROR, xlateIndex(operand, ADDR_INDEXED_X), 3, 7);
			case RTI_IMPLIED:		return new CleanCommand(RTI, 0x00, 1, 6);
			case RTS_IMPLIED:		return new CleanCommand(RTS, 0x00, 1, 6);

			case SBC_IMMEDIATE: 	return new CleanCommand(SBC, xlateAddress(operand, ADDR_IMMEDIATE), 2, 2);
			case SBC_ZERO_PAGE: 	return new CleanCommand(SBC, xlateAddress(operand, ADDR_ZERO_PAGE), 2, 3);
			case SBC_ZERO_PAGE_X: 	return new CleanCommand(SBC, xlateAddress(operand, ADDR_ZERO_PAGE_X), 2, 4);
			case SBC_ABSOLUTE:	 	return new CleanCommand(SBC, xlateAddress(operand, ADDR_ABSOLUTE), 3, 4);
			case SBC_INDEXED_X:		return new CleanCommand(SBC, xlateAddress(operand, ADDR_INDEXED_X), 3, 4 + checkPage(raw, ADDR_INDEXED_X));
			case SBC_INDEXED_Y:	 	return new CleanCommand(SBC, xlateAddress(operand, ADDR_INDEXED_Y), 3, 4 + checkPage(raw, ADDR_INDEXED_Y));
			case SBC_INDIRECT_X:	return new CleanCommand(SBC, xlateAddress(operand, ADDR_INDIRECT_X), 2, 6);
			case SBC_INDIRECT_Y:	return new CleanCommand(SBC, xlateAddress(operand, ADDR_INDIRECT_Y), 2, 5 + checkPage(raw, ADDR_INDIRECT_Y));
			case SEC_IMPLIED: 		return new CleanCommand(CLC, 0x00, 1, 2);
			case SED_IMPLIED: 		return new CleanCommand(CLD, 0x00, 1, 2);
			case SEI_IMPLIED: 		return new CleanCommand(CLI, 0x00, 1, 2);
			case STA_ZERO_PAGE: 	return new CleanCommand(STA, xlateIndex(operand, ADDR_ZERO_PAGE), 2, 3);
			case STA_ZERO_PAGE_X: 	return new CleanCommand(STA, xlateIndex(operand, ADDR_ZERO_PAGE_X), 2, 4);
			case STA_ABSOLUTE:	 	return new CleanCommand(STA, xlateIndex(operand, ADDR_ABSOLUTE), 3, 4);
			case STA_INDEXED_X:		return new CleanCommand(STA, xlateIndex(operand, ADDR_INDEXED_X), 3, 5);
			case STA_INDEXED_Y:	 	return new CleanCommand(STA, xlateIndex(operand, ADDR_INDEXED_Y), 3, 5);
			case STA_INDIRECT_X:	return new CleanCommand(STA, xlateIndex(operand, ADDR_INDIRECT_X), 2, 6);
			case STA_INDIRECT_Y:	return new CleanCommand(STA, xlateIndex(operand, ADDR_INDIRECT_Y), 2, 6);
			case STX_ZERO_PAGE: 	return new CleanCommand(STX, xlateIndex(operand, ADDR_ZERO_PAGE), 2, 3);
			case STX_ZERO_PAGE_Y: 	return new CleanCommand(STX, xlateIndex(operand, ADDR_ZERO_PAGE_Y), 2, 4);
			case STX_ABSOLUTE:	 	return new CleanCommand(STX, xlateIndex(operand, ADDR_ABSOLUTE), 3, 4);
			case STY_ZERO_PAGE: 	return new CleanCommand(STY, xlateIndex(operand, ADDR_ZERO_PAGE), 2, 3);
			case STY_ZERO_PAGE_X: 	return new CleanCommand(STY, xlateIndex(operand, ADDR_ZERO_PAGE_X), 2, 4);
			case STY_ABSOLUTE:	 	return new CleanCommand(STY, xlateIndex(operand, ADDR_ABSOLUTE), 3, 4);

			case TAX_IMPLIED:		return new CleanCommand(TAX, 0x00, 1, 3);
			case TAY_IMPLIED:		return new CleanCommand(TAY, 0x00, 1, 3);
			case TSX_IMPLIED:		return new CleanCommand(TSX, 0x00, 1, 3);
			case TXA_IMPLIED:		return new CleanCommand(TXA, 0x00, 1, 3);
			case TXS_IMPLIED:		return new CleanCommand(TXS, 0x00, 1, 3);
			case TYA_IMPLIED:		return new CleanCommand(TYA, 0x00, 1, 3);
		}

		// oops.. something buggered..
		return null;
	}
} // Xlate