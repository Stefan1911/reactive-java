package com.diplomski.non_reactive.service;


import com.diplomski.non_reactive.model.StockOption;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Log4j2
@Component
public class CSVService {

    public List<StockOption> parseStockOptions(final InputStream inputStream) {
        var bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        var csvReader = new CSVReaderBuilder(bufferedReader).withSkipLines(1).build();

        return parseStockOptionsList(csvReader);
    }

    private  List<StockOption> parseStockOptionsList(CSVReader csvReader) {
        try {
            return csvReader.readAll().stream()
                    .map(this::parseStockOption)
                    .toList();
        } catch (Exception e) {
            log.error("Row not mapped", e);
            return Collections.emptyList();
        }
    }

    private StockOption parseStockOption(final String[] values) {
        try {
            return new StockOption(
                    Integer.valueOf(values[0]),
                    Float.valueOf(values[1]),
                    Float.valueOf(values[2]),
                    Float.valueOf(values[3]),
                    Float.valueOf(values[4]),
                    Integer.valueOf(values[5]),
                    Float.valueOf(values[6])
            );
        } catch (Exception e) {
            log.error("Row not mapped for values:" + Arrays.toString(values), e);
            return null;
        }
    }
}
