package com.diplomski.reactive.usecase;

import com.diplomski.reactive.model.StockOption;
import com.diplomski.reactive.service.CSVService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class CreateStockOptionFromFileUseCase {

    final CSVService csvService;

    public Mono<List<StockOption>> create(final FilePart file) {
        return DataBufferUtils.join(file.content())
                .map(DataBuffer::asInputStream)
                .map(csvService::parseStockOptions);
    }
}
