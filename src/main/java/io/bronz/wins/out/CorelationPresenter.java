package io.bronz.wins.out;

import io.bronz.wins.data.HistoricalResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CorelationPresenter {
    public void presentSameWins(Map<String, List<HistoricalResult>> theSameWins) {

        if (theSameWins.isEmpty()) {
            System.out.println("THERE WAS NEVER THE SAME SET OF NUMBERS DRAWN.");
        }

        System.out.println("THE SAME WINS DURING HISTORY");
        System.out.println("==============================");

        theSameWins.entrySet().forEach(win -> {
            System.out.println("Numbers: " + win.getKey());
            presentWinDates(win);
        });
    }

    public void presentOccurenceOfNumbers(Map<String, Long> occurenceOfDrawnNumber, int numberOfGames) {
        System.out.println("DRAWN NUMBERS WITH OCCURENCE");

        occurenceOfDrawnNumber.forEach((key, value) -> System.out.println("Number " + key + "\t->\t"
                + value + " times (" + getPercentage(value, numberOfGames) + ")."));
    }

    private void presentWinDates(Map.Entry<String, List<HistoricalResult>> win) {
        for (var winDetails : win.getValue()) {
            System.out.println(winDetails.getDate());
        }

        System.out.println("------------------------------");
    }

    private String getPercentage(long numberOfTimes, int numberOfGames) {
        double percentage = (100 * numberOfTimes) / (double) numberOfGames;

        return String.format("%.2f", percentage) + " %";
    }
}
