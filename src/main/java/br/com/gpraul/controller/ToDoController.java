package br.com.gpraul.controller;

import br.com.gpraul.dto.ToDoDto;
import br.com.gpraul.dto.ToDoMapper;
import br.com.gpraul.model.ToDo;
import br.com.gpraul.service.*;

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

    private DeleteToDoUserCase deleteToDo;

    private FindOneToDoByUuidUserCase findOne;

    private UpdateToDoUserCase updateToDo;

    @Inject
    public ToDoController(final CreateToDoUserCase createToDo, final FindAllToDoUserCase findAllToDo,
                          final DeleteToDoUserCase deleteToDo, final FindOneToDoByUuidUserCase findOne,
                          final UpdateToDoUserCase updateToDo) {
        this.createToDo = createToDo;
        this.findAllToDo = findAllToDo;
        this.deleteToDo = deleteToDo;
        this.findOne = findOne;
        this.updateToDo = updateToDo;
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

    @DELETE
    @Path("/{uuid}")
    public void delete(@PathParam("uuid") final String uuid) {
        deleteToDo.delete(uuid);
    }

    @GET
    @Path("/{uuid}")
    public ToDoDto findOne(@PathParam("uuid") final String uuid) {
        final ToDo toDo = findOne.findOne(uuid);

        return ToDoMapper.toDto(toDo);
    }

    @PUT
    public ToDoDto update(final ToDoDto toDoDto) {
        final ToDo toDoUpdated = updateToDo.update(ToDoMapper.toDomain(toDoDto));

        return ToDoMapper.toDto(toDoUpdated);
    }
}
