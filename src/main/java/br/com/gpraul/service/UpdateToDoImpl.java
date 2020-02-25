package br.com.gpraul.service;

import br.com.gpraul.ToDoRepository;
import br.com.gpraul.model.ToDo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@ApplicationScoped
public class UpdateToDoImpl implements  UpdateToDoUserCase {

    private ToDoRepository toDoRepository;

    private FindOneToDoByUuidUserCase findOneToDo;

    @Inject
    public UpdateToDoImpl(final ToDoRepository toDoRepository, final FindOneToDoByUuidUserCase findOneToDo) {
        this.toDoRepository = toDoRepository;
        this.findOneToDo = findOneToDo;
    }

    @Override
    @Transactional
    public ToDo update(final ToDo toDo) {
        final ToDo toDoFound = findOne(toDo.getUuid());

        toDoFound.setTitle(toDo.getTitle());
        toDoFound.setBody(toDo.getBody());
        toDoFound.setPriority(toDo.getPriority());
        toDoFound.setCompleted(toDo.isCompleted());
        toDoFound.setUpdatedAt(LocalDateTime.now());

        return toDoFound;
    }

    private ToDo findOne(final String uuid) {
        return findOneToDo.findOne(uuid);
    }
}
