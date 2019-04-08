package me.samarthya.events.repository;

import me.samarthya.events.model.EventsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Data abstraction via repository.
 * CrudRepository interface acts primarily as a marker interface to capture the types to work with and to help you to
 * discover interfaces that extend this one. The CrudRepository provides sophisticated CRUD functionality for the
 * entity class that is being managed.
 */
@RepositoryRestResource(collectionResourceRel = "events", path = "events")
public interface EventRepository extends CrudRepository<EventsModel, Long> {

}
