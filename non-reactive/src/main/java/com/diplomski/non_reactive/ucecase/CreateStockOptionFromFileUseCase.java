package com.diplomski.non_reactive.ucecase;


import com.diplomski.non_reactive.model.StockOption;
import com.diplomski.non_reactive.service.CSVService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class CreateStockOptionFromFileUseCase {

    final CSVService csvService;

    public List<StockOption> create(final MultipartFile multipartFile) throws IOException {
        var inputStream = multipartFile.getInputStream();

        return csvService.parseStockOptions(inputStream);
    }
}
