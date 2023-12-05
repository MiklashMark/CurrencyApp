package by.bsuir.markMiklash.currencyApp.controllers.api;

import by.bsuir.markMiklash.currencyApp.core.dto.ChartDTO;
import by.bsuir.markMiklash.currencyApp.core.dto.PeriodFilter;
import by.bsuir.markMiklash.currencyApp.service.api.ICurrencyChartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currencyChart")
public class CurrencyChartRestController {
    private final ICurrencyChartService currencyChartService;

    public CurrencyChartRestController(ICurrencyChartService currencyChartService) {
        this.currencyChartService = currencyChartService;
    }

    @GetMapping("/{period}")
    public List<ChartDTO> get(PeriodFilter filter) {
        return this.currencyChartService.get(filter);
    }
}
