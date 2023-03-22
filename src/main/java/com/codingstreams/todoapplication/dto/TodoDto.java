package com.codingstreams.todoapplication.dto;

import com.codingstreams.todoapplication.model.Todo;

import java.util.Date;

public class TodoDto {
    private String description;
    private Boolean isHighPriority;
    private Date createdOn;
    private Boolean isCompleted;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getHighPriority() {
        return isHighPriority;
    }

    public void setHighPriority(Boolean highPriority) {
        isHighPriority = highPriority;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public Todo convertToEntity(){
        Todo todo = new Todo();
        todo.setDescription(description);
        todo.setCreatedOn(createdOn);
        todo.setHighPriority(isHighPriority);
        todo.setCompleted(isCompleted);

        return todo;
    }
}
