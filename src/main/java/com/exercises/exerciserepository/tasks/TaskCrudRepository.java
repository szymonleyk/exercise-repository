package com.exercises.exerciserepository.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TaskCrudRepository extends JpaRepository<Task, Long> {


    @Modifying
    @Transactional
    @Query("update Task t set t.title = :title, t.description = :description where t.id = :id")
    void updateTask(@Param("id") Long id,
                    @Param("title") String title, @Param("description") String description);

}
