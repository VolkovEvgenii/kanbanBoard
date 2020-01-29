package ru.volkov.webApp.KanbanBoard.entity;

public enum TaskImportance {
    LOW ("Низкая"),
    MID ("Средняя"),
    HIGH ("Высокая");

    private String displayValue;

    TaskImportance (String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public static TaskImportance[] returnImportance() {
        return TaskImportance.values();
    }
}
