package it.marcoberri.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import it.marcoberri.model.Raw;

@Repository
public interface RawRepository extends MongoRepository<Raw, String> {

	@Query(fields = "{ WS:1, WC:1, t1 : 1, h1 : 1, press: 1, tsMillis:1, ts : 1}")
	List<Raw> findByTsMillisGreaterThanOrderByTsDesc(long millis);

	Long countByTsMillisGreaterThan(long millis);

	Raw findFirstByOrderByTsDesc();

}