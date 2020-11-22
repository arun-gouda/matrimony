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

import matri.dto.AdminUser;
import matri.service.AdminService;

@RestController
@RequestMapping(value = { "/admin" })
public class AdminController {
	@Autowired
	private AdminService adminService;

	@GetMapping(value = "/getUserById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminUser> getUserById(@PathVariable("id") long id) {
		System.out.println("Fetching AdminUser with id " + id);
		AdminUser user = adminService.findById(id);
		if (user == null) {
			return new ResponseEntity<AdminUser>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AdminUser>(user, HttpStatus.OK);
	}

	@PostMapping(value = "/create", headers = "Accept=application/json")
	public ResponseEntity<Void> createUser(@RequestBody AdminUser user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating AdminUser " + user.getFirstName());
		adminService.createUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/admin/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllUser", headers = "Accept=application/json")
	public List<AdminUser> getAllUser() {
		List<AdminUser> tasks = adminService.getUser();
		return tasks;

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
