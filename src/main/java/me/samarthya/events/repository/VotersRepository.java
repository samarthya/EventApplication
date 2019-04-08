package me.samarthya.events.repository;

import me.samarthya.events.model.VotersModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "voter", path = "voter")
public interface VotersRepository extends CrudRepository<VotersModel, Long> {
}
