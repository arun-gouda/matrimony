package matri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matri.dao.FemaleProfileDAO;
import matri.dao.MaleProfileDAO;
import matri.dto.CandidateProfile;

@Service
public class CandidateProfileService {
	
	@Autowired
	private MaleProfileDAO maleProfieDao;
	
	@Autowired
	private FemaleProfileDAO femaleProfileDao;
	

	public CandidateProfile findCandidateById(long candidateId) {
		// TODO Auto-generated method stub
		if(true) {
			return maleProfieDao.getMaleProfileById(candidateId);
		} else {
			return femaleProfileDao.getFemaleProfileById(candidateId);
		}
	}

	public CandidateProfile addCandidate(CandidateProfile candidate) {
		if(true) {
			return maleProfieDao.insertMaleProfile(candidate);
		} else {
			return femaleProfileDao.insertFemaleProfile(candidate);
		}
	}

	public List<CandidateProfile> getAllCandidtes() {
		if(true) {
			return maleProfieDao.getAllMaleProfiles();
		} else {
			return femaleProfileDao.getAllFemaleProfiles();
		}
	}

	public List<CandidateProfile> searchCandidate(CandidateProfile candidate) {
		// TODO Auto-generated method stub
		return null;
	}

}
