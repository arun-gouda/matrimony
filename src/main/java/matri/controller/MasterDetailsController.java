package matri.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import matri.dto.AdminUser;
import matri.dto.MasterDetails;
import matri.service.MasterDetailsService;

@RestController
@RequestMapping(value = { "/masterDetails" })
public class MasterDetailsController {
	
	@Autowired
	private MasterDetailsService service;
	
	@GetMapping(value = "/getMasterDetailsList/{category}", headers = "Accept=application/json")
	public List<MasterDetails> getMasterDetailsList(@PathVariable("category") String category) {
		List<MasterDetails> tasks = service.getMasterDetails(category);
		return tasks;
	}
	
	@GetMapping(value = "/searchMasterDetails", headers = "Accept=application/json")
	public List<MasterDetails> searchMasterDetails(@RequestBody String bodyString) {
		Map<String, Object> jsonMap = getJson(bodyString);
		List<MasterDetails> tasks = service.searchMasterDetails(jsonMap);
		return tasks;

	}
	
	@GetMapping(value = "/getSubCaegoryDetails/{id}", headers = "Accept=application/json")
	public List<MasterDetails> getSubCaegoryDetails(@PathVariable("id") long id) {
		List<MasterDetails> tasks = service.getSubCaegoryDetails(id);
		return tasks;
	}

	private Map<String, Object> getJson(String bodyString) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			 return objectMapper.readValue(bodyString, new TypeReference<Map<String,Object>>(){});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
