import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
 
public class GradeAnalyzer {
 
    public static void main(String[] args) {
        ArrayList<Integer> scores = readScores("scores.txt");
        double average = calculateAverage(scores);
        
        System.out.println(String.format("Total Scores processed: %d%n",  scores.size()));
        System.out.println(String.format("Average score: %.2f%n", average));

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for(int i = 0; i < scores.size(); i++){
            int score = scores.get(i);
            if(score > highest){
                highest = score;
            }
            else if(score < lowest){
                lowest = score;
            }
        }

        System.out.println(String.format("Highest score: %d%n", highest));
        System.out.println(String.format("Lowest score: %d%n", lowest));

        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        for(int i = 0; i < scores.size(); i++){
            int score = scores.get(i);
            if(score >= 90)
                countA++;
            else if(score >= 80 && score <= 89)
                countB++;
            else if(score >= 70 && score <= 79)
                countC++;
            else if(score >= 60 && score <= 69)
                countD++;
            else
                countF++;
        }

        writeReport(scores, average, highest, lowest, "report.txt", countA, countB, countC, countD, countF);

        System.out.println(String.format("Grade Distribution:"));
        System.out.println(String.format("%n%n"));
        System.out.println(String.format("A (90-100): %d%n", countA));
        System.out.println(String.format("B (80-89): %d%n", countB));
        System.out.println(String.format("C (70-79): %d%n", countC));
        System.out.println(String.format("D (60-69): %d%n", countD));
        System.out.println(String.format("F (below 60): %d%n", countF));

    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = reader.readLine()) != null){
                try {
                    line = line.trim();
                    if(!line.isEmpty()){
                        int score = Integer.parseInt(line);
                        scores.add(score);
                    }
                } catch (Exception e) {
                    System.out.println("Error, wrong number format");
                }
            }
        }
        catch(IOException ex){
            System.out.println("File not found!");
        }
        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        double average = 0.0;
        int total = 0;
        if(scores.isEmpty())
            return average;
        else {
            for(int i = 0; i < scores.size(); i++){
                total += scores.get(i);
            }
            average = total/scores.size();
        }
        return average;
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile, int countA, int countB, int countC, int countD, int countF) {
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            writer.write(String.format("=== Grade Analysis Report ==="));

            writer.write(String.format("%n%n"));

            writer.write(String.format("Total Scores processed: %d%n",  scores.size()));

            writer.write(String.format("%n"));

            writer.write(String.format("Average score: %.2f%n", avg));
            writer.write(String.format("Highest score: %d%n", high));
            writer.write(String.format("Lowest score: %d%n", low));

            writer.write(String.format("%n"));

            writer.write(String.format("Grade Distribution:"));

            writer.write(String.format("%n%n"));

            writer.write(String.format("A (90-100): %d%n", countA));
            writer.write(String.format("B (80-89): %d%n", countB));
            writer.write(String.format("C (70-79): %d%n", countC));
            writer.write(String.format("D (60-69): %d%n", countD));
            writer.write(String.format("F (below 60): %d%n", countF));
            
        }catch(IOException ex){
            System.out.println("Error! File not found");
        }
    }
} 