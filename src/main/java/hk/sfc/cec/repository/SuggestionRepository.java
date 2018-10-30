package hk.sfc.cec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import hk.sfc.cec.domain.FrequencyUsedCentralEntityEntry;

public interface SuggestionRepository extends Repository<FrequencyUsedCentralEntityEntry, String> {

	@Query(value="select ce.ceref, ce.fullname, ls.security_code as stock_code "
			+ " from ce_t_central_entities ce "
			+ " left outer join ce_t_listed_securities ls "
			+ " on ce.ceref = ls.ceref" , nativeQuery = true)
	List<FrequencyUsedCentralEntityEntry> findAllSuggestions();
}
