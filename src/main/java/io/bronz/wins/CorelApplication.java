package io.bronz.wins;

import io.bronz.wins.analyzer.WinAnalyzer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class CorelApplication implements CommandLineRunner {

    private final WinAnalyzer winAnalyzer;

    public static void main(String[] args) {
        SpringApplication.run(CorelApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("fffffffffffffffff");

        winAnalyzer.analyzeResults();
    }
}
