package by.bsuir.markMiklash.currencyApp.controllers.resolver;

import by.bsuir.markMiklash.currencyApp.core.dto.PeriodFilter;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CurrencyChartResolver implements HandlerMethodArgumentResolver {
    private static final String START_DATE_PARAM = "startDate";
    private static final String END_DATE_PARAM = "endDate";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
       return parameter.getDeclaringClass().equals(PeriodFilter.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest req,
                                  WebDataBinderFactory binderFactory) {
        String startDateRaw = req.getParameter(START_DATE_PARAM);
        LocalDate startDate = null;

        if (startDateRaw != null && !startDateRaw.isBlank()) {
            startDate = LocalDate.parse(startDateRaw, formatter);
        }
        String endDateRaw = req.getParameter(END_DATE_PARAM);
        LocalDate endDate = null;

        if (endDateRaw != null && !endDateRaw.isBlank()) {
            endDate = LocalDate.parse(endDateRaw, formatter);
        }

        return new PeriodFilter(startDate, endDate);
    }
}
