package com.qualtrics.jdustin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            ArrayList<String> input = new ArrayList<>();
            Scanner scanner = new Scanner(new File("primary/input/input.txt"));
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }

            Solution solution = new Solution(input);
            int numNice = solution.getNumNice();
            System.out.println(numNice);

            Solution_2 solution_2 = new Solution_2(input);
            int numNice_2 = solution_2.getNumNice();
            System.out.println(numNice_2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
