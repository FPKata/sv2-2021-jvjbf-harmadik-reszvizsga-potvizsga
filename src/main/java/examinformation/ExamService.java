package examinformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ExamService {
    private Map<String, List<Integer>> results = new TreeMap<>();
    private int theoryMax = 0;
    private int practiceMax = 0;

    public Map<String, List<Integer>> getResults() {
        return results;
    }

    public int getTheoryMax() {
        return theoryMax;
    }

    public int getPracticeMax() {
        return practiceMax;
    }

    public void readFromFIle(Path path){
        boolean firstLine = true;

        try(BufferedReader br = Files.newBufferedReader(path)){
            String line;
            while((line = br.readLine()) != null){
                if (firstLine){
                    parseLineFirst(line);
                    firstLine = false;
                }else{
                    parseLine(line);
                }
            }
        }catch(IOException ioe){
            throw new IllegalArgumentException("Cannot read file." + path);
        }
    }

    private void parseLineFirst(String line) {
        String[] temp = line.split(" ");
        theoryMax = Integer.parseInt(temp[0]);
        practiceMax = Integer.parseInt(temp[1]);
    }

    private void parseLine(String line) {
        String[] temp = line.split(";");
        String[] points = temp[1].split(" ");
        if (results.containsKey(temp[0])){
            throw new IllegalArgumentException("Already existing name!");
        }
        results.put(temp[0], new ArrayList<>());
        results.get(temp[0]).add(Integer.parseInt(points[0]));
        results.get(temp[0]).add(Integer.parseInt(points[1]));
    }

    public List<String> findPeopleFailed(){
        List<String> failed = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> actual : results.entrySet()) {
            if (isFailed(actual.getValue().get(0), theoryMax) || isFailed(actual.getValue().get(1), practiceMax)) {
                failed.add(actual.getKey());
            }
        }
        return failed;
    }

    private boolean isFailed(int max_point, int point){
        if ((point * 1.0 / max_point) < 0.51){
            return true;
        }
        return false;
    }

    public  String findBestPerson(){
        int max_sum = 0;
        String best = "";
        for (Map.Entry<String, List<Integer>> actual : results.entrySet()) {
            if (!(isFailed(actual.getValue().get(0), theoryMax) || isFailed(actual.getValue().get(1), practiceMax))) {
                if (actual.getValue().get(0) + actual.getValue().get(1) > max_sum){
                    best = actual.getKey();
                    max_sum = actual.getValue().get(0) + actual.getValue().get(1);
                }
            }
        }
        return best;
    }
}
