package me.samarthya.events.jpa.repository;

import me.samarthya.events.model.LocationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "location", path = "location")
public interface LocationRepository extends CrudRepository<LocationModel, Long> {
}
