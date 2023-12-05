package by.bsuir.markMiklash.currencyApp.service;


import by.bsuir.markMiklash.currencyApp.core.dto.ChartDTO;
import by.bsuir.markMiklash.currencyApp.core.dto.PeriodFilter;
import by.bsuir.markMiklash.currencyApp.service.api.ICurrencyChartService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CurrencyChartService implements ICurrencyChartService {
    @Override
    public List<ChartDTO> get(PeriodFilter filter) {
        RestTemplate restTemplate = new RestTemplate();

        StringBuilder uri = new StringBuilder("https://api.nbrb.by/exrates/rates/dynamics/");
        if (filter != null) {
            uri.append("431?")
                    .append("&startDate=")
                    .append(filter.getStartDate())
                    .append("&endDate=")
                    .append(filter.getEndDate());
        }

        HttpEntity<String> entity = new HttpEntity<>("parameters");
        ResponseEntity<List<ChartDTO>> response = null;
        try {
            response = restTemplate.exchange(
                    uri.toString(),
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<>() {
                    }
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert response != null;
        return response.getBody();
    }
}
