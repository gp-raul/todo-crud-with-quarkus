package br.com.gpraul.service;

import br.com.gpraul.repository.ToDoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class DeleteToDoImpl implements DeleteToDoUserCase {

    private final ToDoRepository toDoRepository;

    @Inject
    public DeleteToDoImpl(final ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    @Transactional
    public void delete(final String uuid) {
        toDoRepository.deleteByUuid(uuid);
    }
}
