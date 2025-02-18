package Actions;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Actions {
    public void filterHigherThan (List<Happened> happenedList, double threshold) {
        Scanner scanner=new Scanner(System.in);
        threshold=scanner.nextDouble();
        double finalThreshold = threshold;
        Set<Happened> result=happenedList.stream().filter(hap-> hap.getKraftpunkte()> finalThreshold).collect(Collectors.toSet());
        for(Happened happened:result){
            System.out.println(happened.getCharacterName());
        }
    }
}
