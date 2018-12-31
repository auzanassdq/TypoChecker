package com.company;

public class Kata {
    private String kata;
    private boolean hasNoPair = true;

    public Kata(String kata) {
        this.kata = kata;
    }

    public String getKata() {
        return kata;
    }

    public void setKata(String kata) {
        this.kata = kata;
    }

    public boolean isHasNoPair() {
        return hasNoPair;
    }

    public void setHasNoPair(boolean hasNoPair) {
        this.hasNoPair = hasNoPair;
    }
}
