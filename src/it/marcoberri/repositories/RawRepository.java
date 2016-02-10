package it.marcoberri.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import it.marcoberri.models.Raw;

@Repository
public interface RawRepository extends MongoRepository<Raw, String> {
}
