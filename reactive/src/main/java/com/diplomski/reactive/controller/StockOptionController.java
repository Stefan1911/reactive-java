package com.diplomski.reactive.controller;

import com.diplomski.reactive.model.StockOption;
import com.diplomski.reactive.model.StockQuote;
import com.diplomski.reactive.usecase.CreateStockOptionFromFileUseCase;
import com.diplomski.reactive.usecase.CreateStockOptionUseCase;
import com.diplomski.reactive.usecase.CreateStockQuoteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/option")
@RequiredArgsConstructor
public class StockOptionController {

    private final CreateStockOptionUseCase createStockOptionUseCase;

    private final CreateStockOptionFromFileUseCase createStockOptionFromFileUseCase;

    @PostMapping
    public Mono<ResponseEntity<StockOption>> create(@RequestBody StockOption stockOption) {
        return createStockOptionUseCase.create(stockOption)
                .map(ResponseEntity::ok);
    }

    @PostMapping("/upload")
    public Mono<ResponseEntity<List<StockOption>>> uploadFile(@RequestPart("file") Mono<FilePart> filePartMono) {

       return filePartMono
               .flatMap(createStockOptionFromFileUseCase::create)
               .map(ResponseEntity::ok);
    }
}
