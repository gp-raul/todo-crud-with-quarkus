package br.com.gpraul;

import br.com.gpraul.model.ToDo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ToDoRepository implements PanacheRepository<ToDo> {


}
