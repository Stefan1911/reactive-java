package com.diplomski.non_reactive.controller;

import com.diplomski.non_reactive.model.StockOption;
import com.diplomski.non_reactive.ucecase.CreateStockOptionFromFileUseCase;
import com.diplomski.non_reactive.ucecase.CreateStockOptionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/option")
@RequiredArgsConstructor
public class StockOptionController {

    private final CreateStockOptionUseCase createStockOptionUseCase;

    private final CreateStockOptionFromFileUseCase createStockOptionFromFileUseCase;

    @PostMapping
    public ResponseEntity<StockOption> create(@RequestBody StockOption stockOption) throws InterruptedException {
        var useCaseResponse = createStockOptionUseCase.create(stockOption);

        return ResponseEntity.ok(useCaseResponse);
    }

    @PostMapping("/upload")
    public ResponseEntity<List<StockOption>> uploadFile(@RequestPart("file") MultipartFile multipartFile) throws IOException {
        final List<StockOption> stockOptions = createStockOptionFromFileUseCase.create(multipartFile);

        return ResponseEntity.ok(stockOptions);
    }
}
