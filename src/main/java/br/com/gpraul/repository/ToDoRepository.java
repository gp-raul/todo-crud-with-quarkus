package br.com.gpraul.repository;

import br.com.gpraul.model.ToDo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ToDoRepository implements PanacheRepository<ToDo> {

    public void deleteByUuid(final String uuid) {
        delete("uuid = ?1", uuid);
    }

    public ToDo findOneById(final String uuid) {
        return find("uuid = ?1", uuid).firstResult();
    }
}
