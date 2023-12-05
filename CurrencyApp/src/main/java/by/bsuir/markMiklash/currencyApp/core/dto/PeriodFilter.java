package by.bsuir.markMiklash.currencyApp.core.dto;

import java.time.LocalDate;

public class PeriodFilter {
    private LocalDate startDate;
    private LocalDate endDate;

    public PeriodFilter() {
    }

    public PeriodFilter(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "PeriodFilter{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
