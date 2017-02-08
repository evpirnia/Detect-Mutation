# Detect-Mutation
Assignment 1 of ICS 475 </br>
Given two DNA sequences of the same length, determine the number of mutations between the two sequences. </br>

### Instructions
$ javac detectmutation.java
$ java detectmutation

### Thought Process
Step 1: Read in sequences and verify that the 2 sequences have the same length. If not indicate error.</br>
Step 2: Transcription: manipulate the sequences based on the information provided by the user: Forward or Reverse, 5’ or 3’. Also (change T for U)</br>
Step 3: Translation: generate the protein sequences.</br>
Step 4: Compare sequences and find mismatch(es) in the nucleotide sequences and the protein sequences. Indicate the number of mismatch(es). If none indicate 0</br>
Note: Code needs to run without error! If your code doesn’t run your grade will be zero. We will test all options using the two sequences found in resources.</br>

### Example of program's output (Forward, 5’)

Mutation(s) nucleotide: C24U</br>
Number of nucleotide mutation(s): 2</br>
Number of amino acid mutation(s): 0</br>
Sequence 1 Nucleotides: AUGCCGUCUUCUGUCUCGUGGGGCAUC </br>
Sequence 2 Nucleotides: AUGCCGUCUUCGGUCUCGUGGGGUAUC </br>
Sequence 1 Amino Acids: MPSSVSWGI </br>
Sequence 2 Amino Acids: MPSSVSWGI </br>

Source: Chapter 2 (Computational Manipulation of DNA) from Exploring Bioinformatics a Project-Based Approach (second edition) by Caroline St-Clair and Jonathan E. Visick, Jones & Bartlett
