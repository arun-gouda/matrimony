package matri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matri.dao.AdminUserDAO;
import matri.dao.BrokerUserDAO;
import matri.dto.BrokerUser;

@Service
public class BrokerService {

	@Autowired
	private BrokerUserDAO brokerDao;

	public void createUser(BrokerUser user) {
		brokerDao.insertBrokerUser(user);
	}

	public List<BrokerUser> getUser() {
		return (List<BrokerUser>) brokerDao.getAllBrokerUsers();
	}

	public BrokerUser findById(long id) {
		return brokerDao.getBrokerUserById(id);
	}



}
