package com.Corona.rate.demo.model;

public class coronaModel {
    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    private String index;
    private String country;
    private String totalCases;
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    @Override
    public String toString() {
        return "Model{" +
                "country='" + country + '\'' +
                ", totalCases='" + totalCases + '\'' +
                '}';
    }
}
