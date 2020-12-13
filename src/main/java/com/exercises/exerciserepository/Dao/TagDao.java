package com.exercises.exerciserepository.Dao;

import com.exercises.exerciserepository.domain.Tag;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class TagDao {

    @PersistenceContext
    EntityManager entityManager;

    public Tag findById(long id) {
        return entityManager.find(Tag.class, id);
    }

    public void saveAuthor(Tag tag) {
        entityManager.persist(tag);
    }

    public void update(Tag tag) {
        entityManager.merge(tag);
    }

    public void delete(Tag tag) {
        entityManager.remove(entityManager.contains(tag) ?
                tag : entityManager.merge(tag)); }

    public List<Tag> findall() {
        Query query = entityManager.createQuery("SELECT t FROM Tag t");
        return query.getResultList();
    }
}

