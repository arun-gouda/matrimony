package matri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import matri.dto.CandidateProfile;
import matri.service.CandidateProfileService;

@RestController
@RequestMapping(value = { "/candidate" })
public class CandidateProfileController {
	@Autowired
	private CandidateProfileService service;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CandidateProfile> getCandidateById(@PathVariable("id") long candidateId) {
		System.out.println("Fetching Candidate with id " + candidateId);
		CandidateProfile candidate = service.findCandidateById(candidateId);
		if (candidate == null) {
			return new ResponseEntity<CandidateProfile>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CandidateProfile>(candidate, HttpStatus.OK);
	}

	@PostMapping(value = "/addCandidate", headers = "Accept=application/json")
	public ResponseEntity<Void> addCandidate(@RequestBody CandidateProfile candidate, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating AdminUser " + candidate.getFirstName());
		service.addCandidate(candidate);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/admin/{id}").buildAndExpand(candidate.getProfileId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllCandidtes", headers = "Accept=application/json")
	public List<CandidateProfile> getAllCandidtes() {
		List<CandidateProfile> tasks = service.getAllCandidtes();
		return tasks;

	}
	
	@PostMapping(value = "/searchCandidate", headers = "Accept=application/json")
	public List<CandidateProfile> searchCandidate(@RequestBody CandidateProfile candidate) {
		System.out.println("Searching candidates ");
		List<CandidateProfile> list = service.searchCandidate(candidate);
		
		return list;
	}

	/*
	 * @PutMapping(value = "/update", headers = "Accept=application/json") public
	 * ResponseEntity<String> updateUser(@RequestBody AdminUser currentUser) {
	 * System.out.println("sd"); AdminUser user =
	 * adminService.findById(currentUser.getId()); if (user == null) { return new
	 * ResponseEntity<String>(HttpStatus.NOT_FOUND); }
	 * adminService.update(currentUser, currentUser.getId()); return new
	 * ResponseEntity<String>(HttpStatus.OK); }
	 */

	/*
	 * @DeleteMapping(value="/{id}", headers ="Accept=application/json") public
	 * ResponseEntity<AdminUser> deleteUser(@PathVariable("id") long id){ AdminUser
	 * user = adminService.findById(id); if (user == null) { return new
	 * ResponseEntity<AdminUser>(HttpStatus.NOT_FOUND); }
	 * adminService.deleteUserById(id); return new
	 * ResponseEntity<AdminUser>(HttpStatus.NO_CONTENT); }
	 */

	/*
	 * @PatchMapping(value="/{id}", headers="Accept=application/json") public
	 * ResponseEntity<AdminUser> updateUserPartially(@PathVariable("id") long
	 * id, @RequestBody AdminUser currentUser){ AdminUser user =
	 * adminService.findById(id); if(user ==null){ return new
	 * ResponseEntity<AdminUser>(HttpStatus.NOT_FOUND); } AdminUser usr =
	 * adminService.updatePartially(currentUser, id); return new
	 * ResponseEntity<AdminUser>(usr, HttpStatus.OK); }
	 */



}
