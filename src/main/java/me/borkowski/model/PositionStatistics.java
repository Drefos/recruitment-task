package me.borkowski.model;

public class PositionStatistics {

    private String position;
    private Long amount;

    public PositionStatistics(Position position, Long amount) {
        this.position = position.positionName;
        this.amount = amount;
    }

    public String getPosition() {
        return position;
    }

    public Long getAmount() {
        return amount;
    }
}
