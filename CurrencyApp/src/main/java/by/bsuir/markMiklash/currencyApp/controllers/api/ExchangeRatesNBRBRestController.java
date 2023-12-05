package by.bsuir.markMiklash.currencyApp.controllers.api;


import by.bsuir.markMiklash.currencyApp.core.dto.DateFilter;
import by.bsuir.markMiklash.currencyApp.core.dto.ExchangeRateDTO;

import by.bsuir.markMiklash.currencyApp.service.api.IExchangeRatesNBRBService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nbrbRate")
public class ExchangeRatesNBRBRestController {
    private final IExchangeRatesNBRBService nbrbService;

    public ExchangeRatesNBRBRestController(IExchangeRatesNBRBService nbrbService) {
        this.nbrbService = nbrbService;
    }

    @GetMapping()
    public List<ExchangeRateDTO> get() {
        return this.nbrbService.get();
    }

    @GetMapping("/{date}")
    public List<ExchangeRateDTO> get(DateFilter date) {
        return this.nbrbService.get(date);
    }
}

