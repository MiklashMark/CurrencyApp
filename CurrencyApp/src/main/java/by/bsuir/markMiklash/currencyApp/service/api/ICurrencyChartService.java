package by.bsuir.markMiklash.currencyApp.service.api;

import by.bsuir.markMiklash.currencyApp.core.dto.ChartDTO;
import by.bsuir.markMiklash.currencyApp.core.dto.DateFilter;
import by.bsuir.markMiklash.currencyApp.core.dto.ExchangeRateDTO;
import by.bsuir.markMiklash.currencyApp.core.dto.PeriodFilter;

import java.util.List;

public interface ICurrencyChartService {
    List<ChartDTO> get(PeriodFilter filter);
}
