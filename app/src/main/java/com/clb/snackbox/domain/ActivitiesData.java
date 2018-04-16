package com.clb.snackbox.domain;

import java.io.Serializable;

public class ActivitiesData implements Serializable {

    private String instruction;
    private String fullPrice;
    private String breakPrice;

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(String fullPrice) {
        this.fullPrice = fullPrice;
    }

    public String getBreakPrice() {
        return breakPrice;
    }

    public void setBreakPrice(String breakPrice) {
        this.breakPrice = breakPrice;
    }

    @Override
    public String toString() {
        return "ActivitesData{" +
                "instruction='" + instruction + '\'' +
                ", fullPrice='" + fullPrice + '\'' +
                ", breakPrice='" + breakPrice + '\'' +
                '}';
    }
}
