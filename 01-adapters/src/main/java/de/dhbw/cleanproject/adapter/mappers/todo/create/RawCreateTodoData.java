package de.dhbw.cleanproject.adapter.mappers.todo.create;

public interface RawCreateTodoData {
    String getTitle();
    String getDescription();
    String getCategoryAggregateId();
    String getPriority();
    String getDeadline();
    String getStatus();
    int getPoints();
    String getScopeAggregateId();
}