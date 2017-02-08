import java.util.Scanner;

/* 
 * Evelyn Pirnia
 * ICS 475 
 * 
 *  Homework 1 Programming Assignment
 *  Problem: Detection of mutation between 2 sequences 
 *  Input: Two DNA sequences of the same length 
 */
public class detectmutation {	
	public static void main(String[] args) {
		// read in sequences, check if they have the same length, error if not
		
		Scanner in = new Scanner(System.in);
		System.out.println("> Enter the first sequence then press enter. Enter the second sequence then "
				+ "press enter.");
		System.out.println("> Example input: ATGCCGTCT" + '\n' + "                 ATGCCGTCA");
		String first = in.next().trim();
		String second = in.next().trim();

		if(first.length() == second.length()) {			
			// transcription
			System.out.println("> Are the sequences forward or reverse? 5' or 3'? ");
			System.out.println("> Example input: forward 5");
			String input = in.next().trim();
			int num = in.nextInt();
			in.close();			
			System.out.println('\n' + "Generating Report.............................. ");
			first = transcription(first, input, num);
			second = transcription(second, input, num);
			
			// translation
			String firsta = translate(first.toLowerCase());
			String seconda = translate(second.toLowerCase());
			
			// compare sequences and find mismatch(es) 
			System.out.println("> NUCLEOTIDES ");
			System.out.println("Sequence 1: " + first.toUpperCase());
			System.out.println("Sequence 2: " + second.toUpperCase());
			findmismatches(first.toUpperCase().toCharArray(), second.toUpperCase().toCharArray());	
			System.out.println("> AMINO ACIDS ");
			System.out.println("Sequence 1: " + firsta.toUpperCase());
			System.out.println("Sequence 2: " + seconda.toUpperCase());
			findmismatches(firsta.toUpperCase().toCharArray(), seconda.toUpperCase().toCharArray());
			
		} else 
			System.out.println("> ERROR: Above sequences do not have the same length.");	
	}

	/* 
	 * find, count, and print mismatches
	 */
	private static void findmismatches(char[] one, char[] two) {
		System.out.print("Mutations: ");
		int count = 0;
		
		for(int i = 0; i < one.length ; i++) {
			if(one[i] != two[i]) {
				System.out.print(one[i] + "" + (i+1) + "" + two[i] + " ");
				count++;
			}
		}
		if(count == 0) {
			System.out.print("none");
		}
		System.out.println();
		System.out.println("Number of mutations: " + count);
	}

	/* 
	 * translation: 
	 * for every 3 nucleotides, find the corresponding amino acid letter
	 */
	private static String translate(String seq) {
		char[] sequence = seq.toCharArray();
		char[] aminos = new char[sequence.length / 3];
		int j = 0;
		
		for( int i = 0; i < sequence.length; i=(i+3) ) {
			String temp = seq.substring(i, i+3);
			if(temp.equalsIgnoreCase("uuu") || temp.equalsIgnoreCase("uuc")) {
				aminos[j] = 'f';
				j++;
			} else if(temp.equalsIgnoreCase("uua") || temp.equalsIgnoreCase("uug") 
					|| temp.equalsIgnoreCase("cuu") || temp.equalsIgnoreCase("cuc") 
					|| temp.equalsIgnoreCase("cua") || temp.equalsIgnoreCase("cug")) {
				aminos[j] = 'l';
				j++;
			} else if(temp.equalsIgnoreCase("auu") || temp.equalsIgnoreCase("auc")
					|| temp.equalsIgnoreCase("aua")) {
				aminos[j] = 'i';
				j++;
			} else if(temp.equalsIgnoreCase("aug") || temp.equalsIgnoreCase("ugg")) {
				aminos[j] = 'w';
				j++;
			} else if(temp.equalsIgnoreCase("guu") || temp.equalsIgnoreCase("guc") 
					|| temp.equalsIgnoreCase("gua") || temp.equalsIgnoreCase("gug")) {
				aminos[j] = 'v';
				j++;
			} else if(temp.equalsIgnoreCase("ucu") || temp.equalsIgnoreCase("ucc")
					|| temp.equalsIgnoreCase("uca") || temp.equalsIgnoreCase("ucg")
					|| temp.equalsIgnoreCase("agu") || temp.equalsIgnoreCase("agc")) {
				aminos[j] = 's';
				j++;
			} else if(temp.equalsIgnoreCase("ccu") || temp.equalsIgnoreCase("ccc") 
					|| temp.equalsIgnoreCase("cca") || temp.equalsIgnoreCase("ccg")) {
				aminos[j] = 'p';
				j++;
			} else if(temp.equalsIgnoreCase("acu") || temp.equalsIgnoreCase("acc") 
					|| temp.equalsIgnoreCase("aca") || temp.equalsIgnoreCase("acg")) {
				aminos[j] = 't';
				j++;
			} else if(temp.equalsIgnoreCase("gcu") || temp.equalsIgnoreCase("gcc")
					|| temp.equalsIgnoreCase("gca") || temp.equalsIgnoreCase("gcg")) {
				aminos[j] = 'a';
				j++;
			} else if(temp.equalsIgnoreCase("uau") || temp.equalsIgnoreCase("uac")) {
				aminos[j] = 'y';
				j++;
			} else if(temp.equalsIgnoreCase("cau") || temp.equalsIgnoreCase("cac")) {
				aminos[j] = 'h';
				j++;
			} else if(temp.equalsIgnoreCase("caa") || temp.equalsIgnoreCase("cag")) {
				aminos[j] = 'q';
				j++;
			} else if(temp.equalsIgnoreCase("aau") || temp.equalsIgnoreCase("aac")) {
				aminos[j] = 'n';
				j++;
			} else if(temp.equalsIgnoreCase("aaa") || temp.equalsIgnoreCase("aag")) {
				aminos[j] = 'k';
				j++;
			} else if(temp.equalsIgnoreCase("gau") || temp.equalsIgnoreCase("gac")) {
				aminos[j] = 'd';
				j++;
			} else if(temp.equalsIgnoreCase("gaa") || temp.equalsIgnoreCase("gag")) {
				aminos[j] = 'e';
				j++;
			} else if(temp.equalsIgnoreCase("ugu") || temp.equalsIgnoreCase("ugc")) {
				aminos[j] = 'c';
				j++;
			} else if(temp.equalsIgnoreCase("cgu") || temp.equalsIgnoreCase("cgc")
					|| temp.equalsIgnoreCase("cga") || temp.equalsIgnoreCase("cgg")
					|| temp.equalsIgnoreCase("aga") || temp.equalsIgnoreCase("agg")) {
				aminos[j] = 'r';
				j++;
			} else if(temp.equalsIgnoreCase("ggu") || temp.equalsIgnoreCase("ggc")
					|| temp.equalsIgnoreCase("gga") || temp.equalsIgnoreCase("ggg")) {
				aminos[j] = 'g';
				j++;
			} else {
				// do not increment j
			}
		}
		return String.copyValueOf(aminos);
	}

	/*
	 * transcription: 
	 * 
	 * if reverse, 5 -> flip, find the complement 
	 *    reverse, 3 -> find the complement
	 *    forward, 5 -> continue
	 *    forward, 3 -> flip
	 *    
	 * change T to U for everything
	 */
	private static String transcription(String sequence, String instruct, int num) {
		if (instruct.equalsIgnoreCase("reverse") == true && num == 5) {
			sequence = new StringBuilder(sequence).reverse().toString();
			sequence = findcomplement(sequence.toLowerCase().toCharArray());				
		} else if(instruct.equalsIgnoreCase("reverse") == true && num == 3) {
				sequence = findcomplement(sequence.toLowerCase().toCharArray());
		} else if(instruct.equalsIgnoreCase("forward") == true && num == 3) {
				sequence = new StringBuilder(sequence).reverse().toString();				
		}
		sequence = changetoU(sequence.toLowerCase().toCharArray());		
		return sequence;
	}

	/* 
	 * for every T, change to U
	 */
	private static String changetoU(char[] sequence) {
		for(int i = 0; i < sequence.length; i++) {
			if(sequence[i] == 't') 
				sequence[i] = 'u';
		}
		return String.copyValueOf(sequence);
	}

	/* 
	 * find the complement sequence 
	 */
	private static String findcomplement(char[] sequence) {
		for(int i = 0; i < sequence.length; i++) {
			switch(sequence[i]) { 
				case ('a'): sequence[i] = 't'; break;
				case ('t'): sequence[i] = 'a'; break;
				case ('c'): sequence[i] = 'g'; break;
				case ('g'): sequence[i] = 'c'; break;
				default: 
					System.out.println("ERROR: invalid sequence.");
			}
		}
		return String.copyValueOf(sequence);
	}
}
