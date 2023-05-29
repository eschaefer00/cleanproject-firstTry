package de.dhbw.cleanproject.adapter.mappers.todo.update;

public interface RawUpdateTodoData {
    String getTitle();
    String getDescription();
    String getCategoryAggregateId();
    String getPriority();
    String getDeadline();
    String getStatus();
    int getPoints();
    String scopeAggregateId();
}



