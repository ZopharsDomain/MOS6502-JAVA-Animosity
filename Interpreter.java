public class Interpreter {

///////////////
//
//	this is a very simple front-end interpreter for the framework 6502.
//	do not expect this to work properly!
//
///////////////

	static Memory m = new Memory();
	static int org = 0x200;

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


	public static void main(String[] args) {

		m.write(0x6002, 0xff);
		w(ADC_IMMEDIATE);
		w(0x12);
		w(AND_ABSOLUTE);
		w(0x2);
		w(0x60);
		w(ASL_ABSOLUTE);
		w(0x2);
		w(0xFF);
		w(NOP_IMPLIED);
		w(JSR_ABSOLUTE);
		w(0x2);
		w(0xFF);
		w(BCC_RELATIVE);
		w(0xff);
		w(ASL_ACCUMULATOR);
		Core.setMemory(m);
		Core.setOrigin(0x200);
		Core.step();
		Core.step();
		Core.step();
		Core.step();
		Core.step();
		Core.step();
		Core.step();


	}

	public static void w(int a) {
		m.write(org, a);
		org++;
	}


}