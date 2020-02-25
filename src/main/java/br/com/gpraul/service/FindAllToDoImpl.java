package br.com.gpraul.service;

import br.com.gpraul.repository.ToDoRepository;
import br.com.gpraul.model.ToDo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class FindAllToDoImpl implements FindAllToDoUserCase {

    private ToDoRepository toDoRepository;

    @Inject
    public FindAllToDoImpl(final ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<ToDo> findAll() {
        return toDoRepository.findAll().stream().collect(Collectors.toList());
    }
}
