package me.samarthya.events.jpa.repository;

import me.samarthya.events.model.SessionModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "session", path = "session")
public interface SessionRepository extends CrudRepository<SessionModel, Long> {

    @Query(value = "select s from SessionModel s where s.sAbstract like %:searchTerm%", nativeQuery = false)
    Iterable<SessionModel> findByAbstractValue(@Param("searchTerm") String searchTerm);
}
