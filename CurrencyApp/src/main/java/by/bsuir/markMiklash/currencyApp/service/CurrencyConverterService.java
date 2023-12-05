package by.bsuir.markMiklash.currencyApp.service;

import by.bsuir.markMiklash.currencyApp.core.dto.ConverterDTO;
import by.bsuir.markMiklash.currencyApp.core.dto.ExchangeRateDTO;
import by.bsuir.markMiklash.currencyApp.service.api.ICurrencyConverterService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class CurrencyConverterService implements ICurrencyConverterService {
    @Override
    public Double get(ConverterDTO dto) {
        double firstCurValue = (dto.getFirstCur() == 1) ? 1 : getCurValue(dto.getFirstCur());
        double secondCurValue = (dto.getSecondCur() == 1) ? 1 : getCurValue(dto.getSecondCur());

        double result = firstCurValue * dto.getFirstValue() / secondCurValue;

        if (dto.getFirstCur() == 456 || dto.getSecondCur() == 456) {
            result *= 100;
        }

        return result;
    }
    private double getCurValue(int curId) {
        RestTemplate restTemplate = new RestTemplate();
        StringBuilder uri = new StringBuilder("https://api.nbrb.by/exrates/rates/");
        uri.append(curId);

        HttpEntity<String> entity = new HttpEntity<>("parameters");
        ResponseEntity<ExchangeRateDTO> response = null;
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
        return Objects.requireNonNull(response.getBody()).getCurOfficialRate();
    }
}
