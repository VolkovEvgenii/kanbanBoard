package ru.volkov.webApp.KanbanBoard.entity;

public enum ProjectStage {
    //Этапы проекта
    CONTRACT,       //Рабочие этапы по договору
    AGREEMENT,      //Различные согласования
    ROUTING,        //Работа на проектной документацией
    MATERIAL,       //Работа над закупками материалов
    MOBILIZATION,   //Мобилизация на объект
    WORK,           //Работы на объекте
    DOCUMENTATION,  //Исполнительная документация
    DEMOBILIZATION  //Демобилизация с объекта
}
