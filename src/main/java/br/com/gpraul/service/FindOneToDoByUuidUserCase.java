package br.com.gpraul.service;

import br.com.gpraul.model.ToDo;

public interface FindOneToDoByUuidUserCase {

    ToDo findOne(String uuid);
}
