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

        for (var win : theSameWins.entrySet()) {
            System.out.println("Numbers: " + win.getKey());

            presentWinDates(win);
        }
    }

    private void presentWinDates(Map.Entry<String, List<HistoricalResult>> win) {
        for (var winDetails : win.getValue()) {
            System.out.println(winDetails.getDate());
        }

        System.out.println("---------------------");
    }
}
