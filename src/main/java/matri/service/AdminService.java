package matri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import matri.dao.AdminUserDAO;
import matri.dto.AdminUser;

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminUserDAO adminDao;

	public void createUser(AdminUser user) {
		adminDao.insertAdminUser(user);
	}

	public List<AdminUser> getUser() {
		return (List<AdminUser>) adminDao.getAllAdminUsers();
	}

	public AdminUser findById(long id) {
		return adminDao.getAdminUserById(id);
	}

}
