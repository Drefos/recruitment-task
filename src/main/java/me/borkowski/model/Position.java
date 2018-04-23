package me.borkowski.model;

public enum Position {
    DEV("Developer"), TESTER("Tester"), HR("Human resources"), MANAGER("Manager"), DIRECTOR("Director");

    String positionName;

    Position(String positionName) {
        this.positionName = positionName;
    }
}
