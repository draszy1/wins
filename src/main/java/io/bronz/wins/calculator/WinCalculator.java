package io.bronz.wins.calculator;

import io.bronz.wins.data.HistoricalResult;
import io.bronz.wins.file.ResultFileReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WinCalculator {

    private final ResultFileReader resultFileReader;

    public void analyzeResults() {
        List<HistoricalResult> historicalResults = resultFileReader.getHistoricalResults();
    }
}
