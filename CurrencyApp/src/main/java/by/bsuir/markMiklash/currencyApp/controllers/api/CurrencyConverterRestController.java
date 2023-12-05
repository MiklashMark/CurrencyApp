package by.bsuir.markMiklash.currencyApp.controllers.api;

import by.bsuir.markMiklash.currencyApp.core.dto.ConverterDTO;
import by.bsuir.markMiklash.currencyApp.service.api.ICurrencyConverterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/convert")
public class CurrencyConverterRestController {
    private final ICurrencyConverterService converterService;

    public CurrencyConverterRestController(ICurrencyConverterService converterService) {
        this.converterService = converterService;
    }

    @GetMapping("/{converter}")
    public double get(ConverterDTO converter) {
        return this.converterService.get(converter);
    }
}
