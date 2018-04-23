package me.borkowski.model;

public class PositionStatistics {

    private String position;
    private Long amount;

    public PositionStatistics(String position, Long amount) {
        this.position = position;
        this.amount = amount;
    }

    public String getPosition() {
        return position;
    }

    public Long getAmount() {
        return amount;
    }
}
