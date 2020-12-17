package it.solvingteam.jerseydemo.dto;

import java.util.ArrayList;
import java.util.List;

public class ResultArrayResponseDto {

    private List<Double> values = new ArrayList<>();

    public List<Double> getValues() {
        return values;
    }

    public void setValues(List<Double> values) {
        this.values = values;
    }
}
