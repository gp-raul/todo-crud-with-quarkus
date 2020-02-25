package br.com.gpraul.service;

import br.com.gpraul.repository.ToDoRepository;
import br.com.gpraul.model.ToDo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FindOneToDoByUuidImpl implements FindOneToDoByUuidUserCase {

    private ToDoRepository toDoRepository;

    @Inject
    public FindOneToDoByUuidImpl(final ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public ToDo findOne(String uuid) {
        return toDoRepository.findOneById(uuid);
    }
}
