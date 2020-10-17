package io.bronz.wins.file;

import io.bronz.wins.data.HistoricalResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ResultFileReader {

    @Value("classpath:lotto.txt")
    private Resource historicalResultsFile;

    public List<HistoricalResult> getHistoricalResults() {

        try {
            File file = historicalResultsFile.getFile();

            return Files.lines(file.toPath())
                    .map(this::buildResult)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            log.error("There was a problem with reading input result file.");
        }

        return Collections.emptyList();
    }

    private HistoricalResult buildResult(String line) {
        String[] resultParts = line.split(" ");

        return HistoricalResult.builder()
                .date(resultParts[0])
                .result(resultParts[1])
                .build();
    }
}
