package io.bronz.wins.analyzer;

import io.bronz.wins.data.HistoricalResult;
import io.bronz.wins.file.ResultFileReader;
import io.bronz.wins.out.CorelationPresenter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class WinAnalyzer {

    private static final int ONE_WIN = 1;
    private final ResultFileReader resultFileReader;
    private final CorelationPresenter corelationPresenter;

    public void analyzeResults() {
        List<HistoricalResult> historicalResults = getHistoricalResults();

        sameWins(historicalResults);
        occurenceOfDrawnNumber(historicalResults);
    }

    private void sameWins(List<HistoricalResult> historicalResults) {
        Map<String, List<HistoricalResult>> theSameWins = historicalResults.stream()
                .collect(groupingBy(HistoricalResult::getResult))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > ONE_WIN)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));

        corelationPresenter.presentSameWins(theSameWins);
    }

    private void occurenceOfDrawnNumber(List<HistoricalResult> historicalResults) {
        Map<String, Long> occurenceOfDrawnNumber = historicalResults.stream()
                .map(HistoricalResult::getResult)
                .flatMap(numbers -> Arrays.stream(numbers.split(",")))
                .collect(groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        corelationPresenter.presentOccurenceOfNumbers(occurenceOfDrawnNumber, historicalResults.size());
    }

    private List<HistoricalResult> getHistoricalResults() {
        return resultFileReader.getHistoricalResults();
    }
}
