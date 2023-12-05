package by.bsuir.markMiklash.currencyApp.dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ChartEntity {
    @JsonProperty("Cur_ID")
    private int curID;
    private LocalDate date;
    @JsonProperty("cur_OfficialRate")
    private Double curOfficialRate;

    public ChartEntity(int cur_ID, LocalDate date, Double cur_OfficialRate) {
        this.curID = cur_ID;
        this.date = date;
        this.curOfficialRate = cur_OfficialRate;
    }

    public ChartEntity() {
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
