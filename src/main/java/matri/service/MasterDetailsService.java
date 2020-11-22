package matri.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matri.dao.MasterDetailsDAO;
import matri.dto.MasterDetails;

@Service
public class MasterDetailsService {
	
	@Autowired
	private MasterDetailsDAO dao;

	public List<MasterDetails> getMasterDetails(String category) {
		return dao.getMasterDetailsList(category);
	}

	public List<MasterDetails> searchMasterDetails(Map<String, Object> jsonMap) {
		String category = (String) jsonMap.get("category");
		String searchString = (String) jsonMap.get("searchString");
		return dao.searchMasterDetails(category, searchString);
	}

	public List<MasterDetails> getSubCaegoryDetails(long id) {
		return dao.getSubCaegoryDetails(id);
	}

}
