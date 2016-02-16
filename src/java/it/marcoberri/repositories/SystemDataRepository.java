package it.marcoberri.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import it.marcoberri.model.SystemData;

@Repository
public interface SystemDataRepository extends MongoRepository<SystemData, String> {

	SystemData findFirstByOrderByTsDesc();

}