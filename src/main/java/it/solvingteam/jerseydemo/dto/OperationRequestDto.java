package it.solvingteam.jerseydemo.dto;

import java.util.List;

public class OperationRequestDto {

    private Integer a;
    private Integer b;
    private List<Integer> list;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
