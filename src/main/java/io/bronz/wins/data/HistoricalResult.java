package io.bronz.wins.data;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class HistoricalResult {
    private String date;
    private String result;
}
