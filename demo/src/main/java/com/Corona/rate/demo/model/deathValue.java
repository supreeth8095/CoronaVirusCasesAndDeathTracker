package com.Corona.rate.demo.model;

public class deathValue {

    private String deathIndex;
    private String deathCountry;
    private String totalDeathCount;

    public String getDeathIndex() {
        return deathIndex;
    }

    public void setDeathIndex(String deathIndex) {
        this.deathIndex = deathIndex;
    }

    public String getDeathCountry() {
        return deathCountry;
    }

    public void setDeathCountry(String deathCountry) {
        this.deathCountry = deathCountry;
    }

    public String getTotalDeathCount() {
        return totalDeathCount;
    }

    public void setTotalDeathCount(String totalDeathCount) {
        this.totalDeathCount = totalDeathCount;
    }

    @Override
    public String toString() {
        return "deathValue{" +
                "deathIndex='" + deathIndex + '\'' +
                ", deathCountry='" + deathCountry + '\'' +
                ", totalDeathCount='" + totalDeathCount + '\'' +
                '}';
    }
}
