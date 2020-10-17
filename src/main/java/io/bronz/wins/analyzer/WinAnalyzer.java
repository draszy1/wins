package io.bronz.wins.analyzer;

import io.bronz.wins.data.HistoricalResult;
import io.bronz.wins.file.ResultFileReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WinAnalyzer {

    private final ResultFileReader resultFileReader;

    public void analyzeResults() {
        List<HistoricalResult> historicalResults = resultFileReader.getHistoricalResults();

        for (HistoricalResult historicalResult : historicalResults) {
            log.info("Date: {}, Result: {}", historicalResult.getDate(), historicalResult.getResult());
        }
    }
}
