package by.bsuir.markMiklash.currencyApp.service.api;

import by.bsuir.markMiklash.currencyApp.core.dto.DateFilter;
import by.bsuir.markMiklash.currencyApp.core.dto.ExchangeRateDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IExchangeRatesNBRBService {
    List<ExchangeRateDTO> get(DateFilter dateFilter);
    List<ExchangeRateDTO> get();
}
