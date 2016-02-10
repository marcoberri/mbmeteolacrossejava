package it.marcoberri.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import it.marcoberri.model.Raw;

@Repository
public interface RawRepository extends MongoRepository<Raw, String> {

	//Raw findOneLastRecord(Sort sort, Limit limit);

}
