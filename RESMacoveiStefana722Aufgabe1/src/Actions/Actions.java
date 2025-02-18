package Actions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Actions {
    public void filterHigherThan (List<Happened> happenedList, double threshold) {
        Scanner scanner=new Scanner(System.in);
        //threshold=scanner.nextDouble();

        double finalThreshold = threshold;
        Set<Happened> result=happenedList.stream().filter(hap-> hap.getKraftpunkte()> finalThreshold).collect(Collectors.toSet());
        for(Happened happened:result){
            System.out.println(happened.getCharacterName());
        }
    }
    public void numberOfCasesByHospitalName(List<Happened> cases) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("gesamtzahl.txt"))) {
            Map<Stufe, Long> anzahl = cases.stream().collect(Collectors.groupingBy(Happened::getStufe, Collectors.counting()));
            anzahl.forEach((stufe, count) -> {
                System.out.println(stufe + " " + count);
            });
            anzahl.forEach((stufe, count) -> {
                try {
                    bufferedWriter.write(stufe + "%" + count);
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
