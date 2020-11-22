package matri.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import matri.dto.MasterDetails;

@Repository
public class MasterDetailsDAO  extends JdbcDaoSupport {
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	public List<MasterDetails> getMasterDetailsList(String category) {
		String sql = "SELECT * FROM master_details  where category='"+category+"' ";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<MasterDetails> result = new ArrayList<MasterDetails>();
		for(Map<String, Object> row:rows){
			MasterDetails masterDetails = new MasterDetails();
			masterDetails.setId((int) row.get("id"));
			masterDetails.setCategory((String)row.get("category"));
			masterDetails.setValue((String)row.get("value"));
			result.add(masterDetails);
		}
		return result;
	}

	public List<MasterDetails> searchMasterDetails(String category, String searchString) {
		String sql = "SELECT * FROM master_details where category='"+category+"' and value like '%"+searchString+"%' ";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<MasterDetails> result = new ArrayList<MasterDetails>();
		for(Map<String, Object> row:rows){
			MasterDetails masterDetails = new MasterDetails();
			masterDetails.setId((int) row.get("id"));
			masterDetails.setCategory((String)row.get("category"));
			masterDetails.setValue((String)row.get("value"));
			result.add(masterDetails);
		}
		return result;
	}
	
	public List<MasterDetails> getSubCaegoryDetails(long id) {
		String sql = "SELECT * FROM master_details where relatedId='"+id+"'";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<MasterDetails> result = new ArrayList<MasterDetails>();
		for(Map<String, Object> row:rows){
			MasterDetails masterDetails = new MasterDetails();
			masterDetails.setId((int) row.get("id"));
			masterDetails.setCategory((String)row.get("category"));
			masterDetails.setValue((String)row.get("value"));
			result.add(masterDetails);
		}
		return result;
	}

}
