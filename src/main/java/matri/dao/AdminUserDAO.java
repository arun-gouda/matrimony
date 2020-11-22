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

import matri.dto.AdminUser;


@Repository
public class AdminUserDAO extends JdbcDaoSupport {

	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public void insertAdminUser(AdminUser user) {
		String sql = "INSERT INTO adminUser " +
				"(id, firstName) VALUES (?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				user.getId(), user.getFirstName()
		});
	}
	
	public void insertAdminUsers(List<AdminUser> users) {
		String sql = "INSERT INTO adminUser " + "(id, firstName) VALUES (?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				AdminUser user = users.get(i);
				ps.setInt(1, user.getId());
				ps.setString(2, user.getFirstName());
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return 0;
			}
			
		});

	}

	public List<AdminUser> getAllAdminUsers(){
		String sql = "SELECT * FROM adminUser";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<AdminUser> result = new ArrayList<AdminUser>();
		for(Map<String, Object> row:rows){
			AdminUser user = new AdminUser();
			user.setId((int) row.get("id"));
			user.setFirstName((String)row.get("firstName"));
			result.add(user);
		}
		
		return result;
	}

	public AdminUser getAdminUserById(Long empId) {
		String sql = "SELECT * FROM adminUser WHERE empId = ?";
		return (AdminUser)getJdbcTemplate().queryForObject(sql, new Object[]{empId}, new RowMapper<AdminUser>(){
			@Override
			public AdminUser mapRow(ResultSet rs, int rwNumber) throws SQLException {
				AdminUser user = new AdminUser();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				return user;
			}
		});
	}
	
	
	
}
