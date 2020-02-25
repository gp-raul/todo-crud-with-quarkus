package br.com.gpraul.dto;

import br.com.gpraul.model.ToDo;

public class ToDoMapper {

    public static ToDo toDomain(final ToDoDto toDoDto) {
        return new ToDo.Builder(toDoDto.getTitle(), toDoDto.getBody())
                    .uuid(toDoDto.getUuid())
                    .isCompleted(toDoDto.isCompleted())
                    .priority(toDoDto.getPriority())
                    .build();
    }

    public static ToDoDto toDto(final ToDo toDo) {
        return new ToDoDto.Builder(toDo.getTitle(), toDo.getBody())
                .uuid(toDo.getUuid())
                .isCompleted(toDo.isCompleted())
                .priority(toDo.getPriority())
                .build();
    }
}
