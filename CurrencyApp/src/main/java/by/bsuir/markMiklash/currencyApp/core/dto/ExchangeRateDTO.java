package by.bsuir.markMiklash.currencyApp.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExchangeRateDTO {
    @JsonProperty("Cur_ID")
    private int curId;
    @JsonProperty("Date")
    private LocalDate date;
    @JsonProperty("Cur_Abbreviation")
    private String curAbbreviation;
    @JsonProperty("Cur_Scale")
    private int curScale;
    @JsonProperty("Cur_Name")
    private String curName;
    @JsonProperty("Cur_OfficialRate")
    private Double curOfficialRate;
    public ExchangeRateDTO() {
        // Пустой конструктор
    }

    public ExchangeRateDTO(int curId, LocalDate date, String curAbbreviation, int curScale, String curName, Double curOfficialRate) {
        this.curId = curId;
        this.date = date;
        this.curAbbreviation = curAbbreviation;
        this.curScale = curScale;
        this.curName = curName;
        this.curOfficialRate = curOfficialRate;
    }

    // Геттеры и сеттеры
    public int getCurId() {
        return curId;
    }

    public void setCurId(int curId) {
        this.curId = curId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCurAbbreviation() {
        return curAbbreviation;
    }

    public void setCurAbbreviation(String curAbbreviation) {
        this.curAbbreviation = curAbbreviation;
    }

    public int getCurScale() {
        return curScale;
    }

    public void setCurScale(int curScale) {
        this.curScale = curScale;
    }

    public String getCurName() {
        return curName;
    }

    public void setCurName(String curName) {
        this.curName = curName;
    }

    public Double getCurOfficialRate() {
        return curOfficialRate;
    }

    public void setCurOfficialRate(Double curOfficialRate) {
        this.curOfficialRate = curOfficialRate;
    }

    // Метод toString
    @Override
    public String toString() {
        return "ExchangeRateEntity{" +
                "curId=" + curId +
                ", date=" + date +
                ", curAbbreviation='" + curAbbreviation + '\'' +
                ", curScale=" + curScale +
                ", curName='" + curName + '\'' +
                ", curOfficialRate=" + curOfficialRate +
                '}';
    }
}
