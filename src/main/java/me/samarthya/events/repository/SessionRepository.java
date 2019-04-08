package me.samarthya.events.repository;

import me.samarthya.events.model.SessionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "session", path = "session")
public interface SessionRepository extends CrudRepository<SessionModel, Long> {

}
