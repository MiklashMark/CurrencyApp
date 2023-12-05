package by.bsuir.markMiklash.currencyApp.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DateFilter {
    private LocalDate date;
}
