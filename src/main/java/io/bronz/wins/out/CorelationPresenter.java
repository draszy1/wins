package io.bronz.wins.out;

import io.bronz.wins.data.HistoricalResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CorelationPresenter {
    public void presentSameWins(Map<String, List<HistoricalResult>> theSameWins) {

        if (theSameWins.isEmpty()) {
            System.out.println("\nTHERE WAS NEVER THE SAME SET OF NUMBERS DRAWN.");
        }

        System.out.println("\nTHE SAME WINS DURING HISTORY");
        System.out.println("==============================");

        theSameWins.entrySet().forEach(win -> {
            System.out.println("Numbers: " + win.getKey());
            presentWinDates(win);
        });
    }

    public void presentOccurenceOfNumbers(Map<String, Long> occurenceOfDrawnNumber, int numberOfGames) {
        System.out.println("\nDRAWN NUMBERS WITH OCCURENCE");
        System.out.println("==============================");

        occurenceOfDrawnNumber.forEach((key, value) -> System.out.println("Number " + key + "\t->\t"
                + value + " times (" + getPercentage(value, numberOfGames) + ")."));
    }

    public void presentBenfordDistribution(Map<Integer, Long> benfordNumbers, long numberOfGames) {
        System.out.println("\nBENFORD'S DISTRIBUTION");
        System.out.println("==============================");

        benfordNumbers.forEach((key, value) -> System.out.println("Number beginning from " + key + "\t->\t"
                + value + " times (" + getPercentage(value, numberOfGames) + ")."));
    }

    private void presentWinDates(Map.Entry<String, List<HistoricalResult>> win) {
        for (var winDetails : win.getValue()) {
            System.out.println(winDetails.getDate());
        }

        System.out.println("------------------------------");
    }

    private String getPercentage(long numberOfTimes, long numberOfGames) {
        double percentage = (100 * numberOfTimes) / (double) numberOfGames;

        return String.format("%.2f", percentage) + " %";
    }
}
