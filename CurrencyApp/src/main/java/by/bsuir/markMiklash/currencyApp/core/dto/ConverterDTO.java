package by.bsuir.markMiklash.currencyApp.core.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class ConverterDTO {
    private double firstValue;
    private int firstCur;
    private int secondCur;

    public ConverterDTO(double firstValue, int firstCur, int secondCur) {
        this.firstValue = firstValue;
        this.firstCur = firstCur;
        this.secondCur = secondCur;
    }

    public double getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
    }

    public int getFirstCur() {
        return firstCur;
    }

    public void setFirstCur(int firstCur) {
        this.firstCur = firstCur;
    }

    public int getSecondCur() {
        return secondCur;
    }

    public void setSecondCur(int secondCur) {
        this.secondCur = secondCur;
    }
}
