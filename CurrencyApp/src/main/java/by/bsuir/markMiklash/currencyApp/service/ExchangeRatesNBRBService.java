package by.bsuir.markMiklash.currencyApp.service;

import by.bsuir.markMiklash.currencyApp.core.dto.DateFilter;
import by.bsuir.markMiklash.currencyApp.core.dto.ExchangeRateDTO;
import by.bsuir.markMiklash.currencyApp.service.api.IExchangeRatesNBRBService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExchangeRatesNBRBService implements IExchangeRatesNBRBService {
    @Override
    public List<ExchangeRateDTO> get(DateFilter dateFilter) {

        RestTemplate restTemplate = new RestTemplate();

        StringBuilder uri = new StringBuilder("https://api.nbrb.by/exrates/rates?periodicity=0");
        if (dateFilter != null) {
            uri.append("&ondate=").append(dateFilter.getDate());
        }

        HttpEntity<String> entity = new HttpEntity<>("parameters");
        ResponseEntity<List<ExchangeRateDTO>> response = null;
        try {
            response = restTemplate.exchange(
                    uri.toString(),
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<>() {}
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert response != null;
        return response.getBody();
    }


    @Override
    public List<ExchangeRateDTO> get() {
        return get(null);
    }
}
