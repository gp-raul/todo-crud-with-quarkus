package br.com.gpraul.controller;

import br.com.gpraul.dto.ToDoDto;
import br.com.gpraul.dto.ToDoMapper;
import br.com.gpraul.model.ToDo;
import br.com.gpraul.service.CreateToDoUserCase;
import br.com.gpraul.service.FindAllToDoUserCase;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/api/v1/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ToDoController {

    private CreateToDoUserCase createToDo;

    private FindAllToDoUserCase findAllToDo;

    @Inject
    public ToDoController(final CreateToDoUserCase createToDo, final FindAllToDoUserCase findAllToDo) {
        this.createToDo = createToDo;
        this.findAllToDo = findAllToDo;
    }

    @POST
    public ToDoDto create(final ToDoDto toDoDto) {
       final ToDo toDo = createToDo.create(ToDoMapper.toDomain(toDoDto));

        return ToDoMapper.toDto(toDo);
    }

    @GET
    public List<ToDoDto> findAll() {
        return findAllToDo.findAll().stream()
                .map(x -> ToDoMapper.toDto(x))
                .collect(Collectors.toList());
    }
}
