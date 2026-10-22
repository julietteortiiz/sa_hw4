// 1. create mutants
//      a. read in BuyTicket and add difference
//        b. output to file w m# in mutants file
// 2. compile all mutant files
// 3. apply each test suite to each mutant
// 4. report
//https://www.w3schools.com/java/java_bufferedreader.asp
//https://www.geeksforgeeks.org/java/iterate-over-the-characters-of-a-string-in-java/

import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class mutator {

    public static void createMutant(String filename, char original, char newer){
        try(BufferedReader br = new BufferedReader(new FileReader("src/BuyTicket.java"))){
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
                String line;
                while ((line = br.readLine()) != null) {
                char[] ch = line.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    if (ch[i] == original){
                        ch[i] = newer;
                    }
                }
                writer.write(ch);
                writer.newLine();
            }
            } catch (IOException e){
                System.out.println("Couldnt write");
            }
            
        } catch (IOException e){
            System.out.println("Error reading file");
        }
    }

    public static void main(String[] args){
        createMutant("m1/BuyTicket.java", '>', '<');
        createMutant("m2/BuyTicket.java", '<', '>');
        createMutant("m3/BuyTicket.java", '+', '-');
        createMutant("m4/BuyTicket.java", '-', '+');

    }

}