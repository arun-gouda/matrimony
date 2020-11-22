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

@Repository
public class BrokerUserDAO extends JdbcDaoSupport {

	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public void insertBrokerUser(BrokerUser user) {
		String sql = "INSERT INTO brokeruser " +
				"(brokerId, firstName) VALUES (?, ?)" ;
		
		List<Object> params = new ArrayList<Object>();
		params.add(user.getBrokerId());
		params.add(user.getFirstName());
		
		getJdbcTemplate().update(sql, params.toArray() /*new Object[]{
				user.getBrokerId(), user.getFirstName()
		}*/);
	}
	
	public void insertBrokerUsers(List<BrokerUser> users) {
		String sql = "INSERT INTO brokeruser " + "(brokerId, firstName) VALUES (?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				BrokerUser user = users.get(i);
				ps.setInt(1, user.getBrokerId());
				ps.setString(2, user.getFirstName());
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return 0;
			}
			
		});

	}

	public List<BrokerUser> getAllBrokerUsers(){
		String sql = "SELECT * FROM brokeruser";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<BrokerUser> result = new ArrayList<BrokerUser>();
		for(Map<String, Object> row:rows){
			BrokerUser user = new BrokerUser();
			user.setBrokerId((int) row.get("brokerId"));
			user.setFirstName((String)row.get("firstName"));
			result.add(user);
		}
		
		return result;
	}

	public BrokerUser getBrokerUserById(Long brokerId) {
		String sql = "SELECT * FROM brokeruser WHERE brokerId = ?";
		return (BrokerUser)getJdbcTemplate().queryForObject(sql, new Object[]{brokerId}, new RowMapper<BrokerUser>(){
			@Override
			public BrokerUser mapRow(ResultSet rs, int rwNumber) throws SQLException {
				BrokerUser user = new BrokerUser();
				user.setBrokerId(rs.getInt("brokerId"));
				user.setFirstName(rs.getString("firstName"));
				return user;
			}
		});
	}
	
	
	
}


