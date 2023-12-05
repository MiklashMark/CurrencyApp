package by.bsuir.markMiklash.currencyApp.controllers.resolver;

import by.bsuir.markMiklash.currencyApp.core.dto.DateFilter;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class NBRBRatesResolver implements HandlerMethodArgumentResolver {
    private static final String EXCHANGE_RATES_DATE_PARAM = "date";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getDeclaringClass().equals(DateFilter.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest req,
                                  WebDataBinderFactory binderFactory) {
        String exchangeRatesDateRaw = req.getParameter(EXCHANGE_RATES_DATE_PARAM);
        LocalDate exchangeRatesDate = null;

        if (exchangeRatesDateRaw != null && !exchangeRatesDateRaw.isBlank()) {
            exchangeRatesDate = LocalDate.parse(exchangeRatesDateRaw, formatter);
        }

        return new DateFilter(exchangeRatesDate);
    }
}
