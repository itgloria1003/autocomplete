package hk.sfc.cec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hk.sfc.cec.domain.SuggestionWrapper;
import hk.sfc.cec.service.SuggestionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
public class AutocompleteController {


	@Autowired 
	SuggestionService suggestionService; 
	

  @RequestMapping(value = "/cesuggest")
  @ResponseBody
  public SuggestionWrapper autocompleteSuggestions(@RequestParam("q") String searchStr) {
   int maxEntry = 20 ;
   ArrayList<String> suggestions = suggestionService.filterCe(searchStr, maxEntry);
   SuggestionWrapper sw = new SuggestionWrapper();
    sw.setSuggestions(suggestions);
    return sw;
  }


}
