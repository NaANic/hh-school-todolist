package ru.hh.springtodolist.project.model;

public enum Urgency {
    IMPORTANT_URGENT("Важно - Срочно"),
    NOT_IMPORTANT_NOT_URGENT("Неважно - Не срочно"),
    NOT_IMPORTANT_URGENT("Неважно - Срочно"),
    IMPORTANT_NOT_URGENT("Важно - Не срочно");
    
    private final String urgencyText;
    
    Urgency(String urgencyText) {
        this.urgencyText = urgencyText;
    }
    
    public String getUrgencyName() {
        return this.urgencyText;
    }
}
