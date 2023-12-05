package by.bsuir.markMiklash.currencyApp.controllers.resolver;

import by.bsuir.markMiklash.currencyApp.core.dto.ConverterDTO;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CurrencyConverterResolver implements HandlerMethodArgumentResolver {
    private static final String FIRST_VALUE_PARAM = "firstValue";
    private static final String FIRST_CUR_PARAM = "firstCur";
    private static final String SECOND_CUR_PARAM = "secondCur";
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getDeclaringClass().equals(ConverterDTO.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest req,
                                  WebDataBinderFactory binderFactory)  {
        String firstValueRaw = req.getParameter(FIRST_VALUE_PARAM);
        double firstValue = 0;
        if (firstValueRaw != null  && !firstValueRaw.isBlank()) {
            firstValue = Double.parseDouble(firstValueRaw);
        }

        String firstCurRaw = req.getParameter(FIRST_CUR_PARAM);
        int firstCur = 0;
        if (firstCurRaw != null  && !firstCurRaw.isBlank()) {
            firstCur = Integer.parseInt(firstCurRaw);
        }

        String secondCurRaw = req.getParameter(SECOND_CUR_PARAM);
        int secondCur = 0;
        if (secondCurRaw != null  && !secondCurRaw.isBlank()) {
            secondCur = Integer.parseInt(secondCurRaw);
        }

        return new ConverterDTO(firstValue, firstCur, secondCur);

    }
}
