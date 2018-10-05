public class OpCode {

	/////////////////////////////////////////////////////////
	//		Opcode.java
	//		Executes an opcode and updates registers and memory.
	//
	//		Michael F. R. Jean
	//		umjeanm@cc.umanitoba.ca
	/////////////////////////////////////////////////////////

	//////////////////////////
	//	finalized variables
	//////////////////////////

	// opcode map
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

	public static final int[] ADC = {
		ADC_IMMEDIATE, 	ADC_ABSOLUTE, 	ADC_INDEXED_X, 	ADC_INDEXED_Y, 	ADC_ZERO_PAGE,
		ADC_ZERO_PAGE_X,	ADC_INDIRECT_X,	ADC_INDIRECT_Y};

	public static final int[] AND = {
		AND_IMMEDIATE, 	AND_ABSOLUTE, 	AND_INDEXED_X, 	AND_INDEXED_Y, 	AND_ZERO_PAGE,
		AND_ZERO_PAGE_X, AND_INDIRECT_X, 	AND_INDIRECT_Y};

	public static final int[] ASL = {
		ASL_ABSOLUTE, 	ASL_ACCUMULATOR, 	ASL_INDEXED_X, 	ASL_ZERO_PAGE, 	ASL_ZERO_PAGE_X};

	public static final int[] BIT = {
		BIT_ZERO_PAGE, 	BIT_ABSOLUTE };

	public static final int[] CMP = {
		CMP_IMMEDIATE, 	CMP_ZERO_PAGE, 	CMP_ZERO_PAGE_X,	CMP_ABSOLUTE, CMP_INDEXED_X,
		CMP_INDEXED_Y, 	CMP_INDIRECT_X, 	CMP_INDIRECT_Y};

	public static final int[] CPX = {
		CPX_IMMEDIATE, CPX_ZERO_PAGE,	CPX_ABSOLUTE};

	public static final int[] CPY = {
		CPY_IMMEDIATE, CPY_ZERO_PAGE, CPY_ABSOLUTE};

	public static final int[] DEC = {
		DEC_ZERO_PAGE,	DEC_ZERO_PAGE_X, 	DEC_ABSOLUTE, 	DEC_INDEXED_X};

	public static final int[] EOR = {
		EOR_IMMEDIATE, 	EOR_ZERO_PAGE, 	EOR_ZERO_PAGE_X, 	EOR_ABSOLUTE,
		EOR_INDEXED_X, 	EOR_INDEXED_Y, 	EOR_INDIRECT_X,		EOR_INDIRECT_Y };

	public static final int[] INC = {
		INC_ZERO_PAGE, 	INC_ZERO_PAGE_X, 	INC_ABSOLUTE, 	INC_INDEXED_X};

	public static final int[] JMP = {
		JMP_ABSOLUTE, 	JMP_INDIRECT};

	public static final int[] LDA = {
		LDA_IMMEDIATE, 	LDA_ABSOLUTE, 	LDA_INDEXED_X, 	LDA_INDEXED_Y,
		LDA_ZERO_PAGE, 	LDA_ZERO_PAGE_X, LDA_INDIRECT_X, 	LDA_INDIRECT_Y};

	public static final int[] LDX = {
		LDX_IMMEDIATE, 	LDX_ZERO_PAGE, 	LDX_ZERO_PAGE_Y,	LDX_ABSOLUTE,
		LDX_INDEXED_Y};

	public static final int[] LDY = {
		LDY_IMMEDIATE, 	LDY_ZERO_PAGE, 	LDY_ZERO_PAGE_X, 	LDY_ABSOLUTE, 	LDY_INDEXED_X };

	public static final int[] LSR = {
		LSR_ACCUMULATOR, LSR_ZERO_PAGE, LSR_ZERO_PAGE_X, LSR_ABSOLUTE, LSR_INDEXED_X };

	public static final int[] ORA = {
		ORA_IMMEDIATE, 	ORA_ZERO_PAGE, 	ORA_ZERO_PAGE_X, 	ORA_ABSOLUTE,
		ORA_INDEXED_X, 	ORA_INDEXED_Y, 	ORA_INDIRECT_X,		ORA_INDIRECT_Y};

	public static final int[] ROL = {
		ROL_ACCUMULATOR, 	ROL_ZERO_PAGE, 	ROL_ZERO_PAGE_X, 	ROL_ABSOLUTE,
		ROL_INDEXED_X };

	public static final int[] ROR = {
		ROR_ACCUMULATOR,	ROR_ZERO_PAGE,	ROR_ZERO_PAGE_X, 	ROR_ABSOLUTE, 	ROR_INDEXED_X 	};

	public static final int[] SBC = {
		SBC_IMMEDIATE,	SBC_ZERO_PAGE,	SBC_ZERO_PAGE_X, SBC_ABSOLUTE,
		SBC_INDEXED_X, 	SBC_INDEXED_Y, 	SBC_INDIRECT_X, 	SBC_INDIRECT_Y };

	public static final int[] STA = {
		STA_ABSOLUTE, 	STA_INDEXED_X, 	STA_INDEXED_Y, 	STA_ZERO_PAGE, 	STA_ZERO_PAGE_X };

	public static final int[] STX = {
		STX_ZERO_PAGE, 	STX_ZERO_PAGE_Y, STX_ABSOLUTE};

	public static final int[] STY = {
		STY_ZERO_PAGE, 	STY_ZERO_PAGE_X, STY_ABSOLUTE};

	public static void handle(CleanCommand clean) {
	/*	// determine opcode type
		String opcodeString = "";
		for (int i = 0; i < ADC.size; i++) { if (ADC[i] == opcode)
		for (int i = 0; i < AND.size; i++) { if (AND[i] == opcode)
		for (int i = 0; i < ASL.size; i++) { if (ASL[i] == opcode)
		for (int i = 0; i < BIT.size; i++) { if (BIT[i] == opcode)
		for (int i = 0; i < CMP.size; i++) { if (CMP[i] == opcode)
		for (int i = 0; i < CPX.size; i++) { if (CPX[i] == opcode)
		for (int i = 0; i < CPY.size; i++) { if (CPY[i] == opcode)
		for (int i = 0; i < DEC.size; i++) { if (DEC[i] == opcode)
		for (int i = 0; i < EOR.size; i++) { if (EOR[i] == opcode)
		for (int i = 0; i < INC.size; i++) { if (INC[i] == opcode)
		for (int i = 0; i < JMP.size; i++) { if (JMP[i] == opcode)
		for (int i = 0; i < LDA.size; i++) { if (LDA[i] == opcode)
		for (int i = 0; i < LDX.size; i++) { if (LDX[i] == opcode)
		for (int i = 0; i < LDY.size; i++) { if (LDY[i] == opcode)
		for (int i = 0; i < LSR.size; i++) { if (LSR[i] == opcode)
		for (int i = 0; i < ORA.size; i++) { if (ORA[i] == opcode)
		for (int i = 0; i < ROL.size; i++) { if (ROL[i] == opcode)
		for (int i = 0; i < ROR.size; i++) { if (ROR[i] == opcode)
		for (int i = 0; i < SBC.size; i++) { if (SBC[i] == opcode)
		for (int i = 0; i < STA.size; i++) { if (STA[i] == opcode)
		for (int i = 0; i < STX.size; i++) { if (STX[i] == opcode)
		for (int i = 0; i < STY.size; i++) { if (STY[i] == opcode)
		if (BCC_RELATIVE == opcode)
		if (BCS_RELATIVE == opcode)
		if (BEQ_RELATIVE == opcode)
		if (BMI_RELATIVE == opcode)
		if (BNE_RELATIVE == opcode)
		if (BPL_RELATIVE == opcode)
		if (BRK_IMPLIED  == opcode)
		if (BVC_RELATIVE == opcode)
		if (BVS_RELATIVE == opcode)
		if (CLC_IMPLIED  == opcode)
		if (CLD_IMPLIED  == opcode)
		if (CLI_IMPLIED  == opcode)
		if (CLV_IMPLIED  == opcode)
		if (DEX_IMPLIED  == opcode)
		if (DEY_IMPLIED  == opcode)
		if (INX_IMPLIED  == opcode)
		if (INY_IMPLIED  == opcode)
		if (JSR_ABSOLUTE == opcode)
		if (NOP_IMPLIED  == opcode)
		if (PHA_IMPLIED  == opcode)
		if (PHP_IMPLIED  == opcode)
		if (PLA_IMPLIED  == opcode)
		if (PLP_IMPLIED  == opcode)
		if (RTI_IMPLIED  == opcode)
		if (RTS_IMPLIED  == opcode)
		if (SEC_IMPLIED  == opcode)
		if (SED_IMPLIED  == opcode)
		if (SEI_IMPLIED  == opcode)
		if (TAX_IMPLIED  == opcode)
		if (TAY_IMPLIED  == opcode)
		if (TSX_IMPLIED  == opcode)
		if (TXA_IMPLIED  == opcode)
		if (TXS_IMPLIED  == opcode)
		if (TYA_IMPLIED  == opcode)
		*/
	}
}