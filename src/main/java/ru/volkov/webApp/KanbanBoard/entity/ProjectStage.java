package ru.volkov.webApp.KanbanBoard.entity;

public enum ProjectStage {
    //Этапы проекта
    CONTRACT ("Контракт"),       //Рабочие этапы по договору
    AGREEMENT ("Согласования"),      //Различные согласования
    ROUTING ("Организация и технология"),        //Работа на проектной документацией
    WORK ("Работа на объекте"),           //Работы на объекте
    DOCUMENTATION ("Документация"),  //Исполнительная документация
    MOBIL_DEMOBIL ("Мобилизация / Демобилизация"); //Демобилизация с объекта

    private final String displayValue;

    ProjectStage (String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue () {
        return displayValue;
    }

    public static ProjectStage[] returnStages() {
        return ProjectStage.values();
    }
}

