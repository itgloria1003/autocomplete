package hk.sfc.cec.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hk.sfc.cec.domain.FrequencyUsedCentralEntityEntry;
import hk.sfc.cec.repository.SuggestionRepository;

@Service
public class SuggestionService {
	@Autowired
	SuggestionRepository suggestionRepository;
	private List<FrequencyUsedCentralEntityEntry> ceList = null;
	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    
	@PostConstruct
	public void init() {
		logger.info("initialize...");
		if (ceList==null) {
			ceList = suggestionRepository.findAllSuggestions();
		}
	}
	public void reloadList() {
		logger.info("reloading list...");
		ceList = suggestionRepository.findAllSuggestions();
	}
	
	public ArrayList<String> filterCe(String searchStr, int maxEntry) {
		List<String> result = new  ArrayList<String>();
		for (FrequencyUsedCentralEntityEntry entry: ceList) {
			if (entry.getFullname().toLowerCase().contains(searchStr.toLowerCase())) {
				result.add(entry.getCeref() + "-" + entry.getFullname());
		      }
		}

	    int n = result.size() > maxEntry? maxEntry : result.size();
	    ArrayList<String>sulb = new ArrayList<>(result.subList(0, n));

		return sulb;
	}
	
}
