package br.com.gpraul.service;

import br.com.gpraul.repository.ToDoRepository;
import br.com.gpraul.model.ToDo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class CreateToDoUserCaseImpl implements CreateToDoUserCase {

    private ToDoRepository toDoRepository;

    @Inject
    public CreateToDoUserCaseImpl(final ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    @Transactional
    public ToDo create(final ToDo toDo) {
       toDoRepository.persist(toDo);

        return toDo;
    }
}
