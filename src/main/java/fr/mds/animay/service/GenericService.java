package fr.mds.animay.service;

import fr.mds.animay.exception.ExistingEntityException;
import fr.mds.animay.exception.NotFoundException;
import fr.mds.animay.model.IdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class GenericService<E extends IdEntity<ID>, ID, R extends JpaRepository<E, ID>> {

    protected final R repository;

    @Autowired
    public GenericService(R repository) {
        this.repository = repository;
    }

    public E findById(ID id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public E create(E entity) {
        if (entity.getId() != null) {
            throw new ExistingEntityException();
        }
        return repository.save(entity);
    }

    public E update(ID id, E entity) {
        entity.setId(id);
        return repository.save(entity);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

}
