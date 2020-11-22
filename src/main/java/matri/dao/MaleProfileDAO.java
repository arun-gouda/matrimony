package matri.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import matri.dto.CandidateProfile;

@Repository
public class MaleProfileDAO  extends JdbcDaoSupport {

	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public CandidateProfile insertMaleProfile(CandidateProfile profile) {
		String sql = "INSERT INTO maleprofiles " +
				"(profileId, firstName) VALUES (?, ?)" ;
		
		List<Object> params = new ArrayList<Object>();
		params.add(profile.getProfileId());
		params.add(profile.getFirstName());
		
		getJdbcTemplate().update(sql, params.toArray() /*new Object[]{
				user.getBrokerId(), user.getFirstName()
		}*/);
		return profile;
	}
	
	public void insertMaleProfileList(List<CandidateProfile> users) {
		String sql = "INSERT INTO maleprofiles " + "(profileId, firstName) VALUES (?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				CandidateProfile profile = users.get(i);
				ps.setInt(1, profile.getProfileId());
				ps.setString(2, profile.getFirstName());
			}
			@Override
			public int getBatchSize() {
				return 0;
			}
		});

	}

	public List<CandidateProfile> getAllMaleProfiles(){
		String sql = "SELECT * FROM maleprofiles";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<CandidateProfile> result = new ArrayList<CandidateProfile>();
		for(Map<String, Object> row:rows){
			CandidateProfile profile = new CandidateProfile();
			profile.setProfileId((int) row.get("profileId"));
			profile.setFirstName((String)row.get("firstName"));
			result.add(profile);
		}
		
		return result;
	}

	public CandidateProfile getMaleProfileById(Long profileId) {
		String sql = "SELECT * FROM maleprofiles WHERE profileId = ?";
		return (CandidateProfile)getJdbcTemplate().queryForObject(sql, new Object[]{profileId}, new RowMapper<CandidateProfile>(){
			@Override
			public CandidateProfile mapRow(ResultSet rs, int rwNumber) throws SQLException {
				CandidateProfile profile = new CandidateProfile();
				profile.setProfileId(rs.getInt("profileId"));
				profile.setFirstName(rs.getString("firstName"));
				return profile;
			}
		});
	}
}
