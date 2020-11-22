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

import matri.dto.BrokerUser;
import matri.dto.CandidateProfile;

@Repository
public class FemaleProfileDAO extends JdbcDaoSupport {

	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public CandidateProfile insertFemaleProfile(CandidateProfile profile) {
		String sql = "INSERT INTO femaleprofiles " +
				"(profileId, firstName) VALUES (?, ?)" ;
		
		List<Object> params = new ArrayList<Object>();
		params.add(profile.getProfileId());
		params.add(profile.getFirstName());
		
		getJdbcTemplate().update(sql, params.toArray() /*new Object[]{
				user.getBrokerId(), user.getFirstName()
		}*/);
		return profile;
	}
	
	public void insertFemaleProfileList(List<CandidateProfile> profileList) {
		String sql = "INSERT INTO femaleprofiles " + "(profileId, firstName) VALUES (?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				CandidateProfile user = profileList.get(i);
				ps.setInt(1, user.getProfileId());
				ps.setString(2, user.getFirstName());
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return 0;
			}
			
		});

	}

	public List<CandidateProfile> getAllFemaleProfiles(){
		String sql = "SELECT * FROM femaleprofiles";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<CandidateProfile> result = new ArrayList<CandidateProfile>();
		for(Map<String, Object> row:rows){
			CandidateProfile user = new CandidateProfile();
			user.setProfileId((int) row.get("profileId"));
			user.setFirstName((String)row.get("firstName"));
			result.add(user);
		}
		
		return result;
	}

	public CandidateProfile getFemaleProfileById(Long profileId) {
		String sql = "SELECT * FROM femaleprofiles WHERE profileId = ?";
		return (CandidateProfile)getJdbcTemplate().queryForObject(sql, new Object[]{profileId}, new RowMapper<CandidateProfile>(){
			@Override
			public CandidateProfile mapRow(ResultSet rs, int rwNumber) throws SQLException {
				CandidateProfile user = new CandidateProfile();
				user.setProfileId(rs.getInt("profileId"));
				user.setFirstName(rs.getString("firstName"));
				return user;
			}
		});
	}
	
}
