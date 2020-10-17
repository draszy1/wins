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
import java.util.List;

@Slf4j
@Component
public class ResultFileReader {

    @Value("classpath:lotto.txt")
    private Resource historicalResultsFile;

    public List<HistoricalResult> getHistoricalResults() {

        try {
            File file = historicalResultsFile.getFile();
            String all = new String(Files.readAllBytes(file.toPath()));
            log.info(all);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
