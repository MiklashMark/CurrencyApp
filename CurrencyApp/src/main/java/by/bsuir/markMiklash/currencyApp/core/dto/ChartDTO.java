package by.bsuir.markMiklash.currencyApp.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ChartDTO {
    @JsonProperty("Cur_ID")
    private int curID;
    @JsonProperty("Date")
    private LocalDate date;
    @JsonProperty("Cur_OfficialRate")
    private Double curOfficialRate;

    public ChartDTO(int cur_ID, LocalDate date, Double cur_OfficialRate) {
        this.curID = cur_ID;
        this.date = date;
        this.curOfficialRate = cur_OfficialRate;
    }

    public ChartDTO() {
    }

    public int getCurID() {
        return curID;
    }

    public void setCurID(int curID) {
        this.curID = curID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getCurOfficialRate() {
        return curOfficialRate;
    }

    public void setCurOfficialRate(Double curOfficialRate) {
        this.curOfficialRate = curOfficialRate;
    }
}
