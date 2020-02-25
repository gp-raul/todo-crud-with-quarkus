package br.com.gpraul.controller;

import br.com.gpraul.dto.ToDoDto;
import br.com.gpraul.dto.ToDoMapper;
import br.com.gpraul.model.ToDo;
import br.com.gpraul.service.CreateToDoUserCase;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ToDoController {

    @Inject
    private CreateToDoUserCase createToDo;

    @POST
    public ToDoDto createToDo(final ToDoDto toDoDto) {
       final ToDo toDo = createToDo.create(ToDoMapper.toDomain(toDoDto));

        return ToDoMapper.toDto(toDo);
    }
}
