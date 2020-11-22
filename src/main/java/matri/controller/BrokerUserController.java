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

import matri.dto.BrokerUser;
import matri.service.BrokerService;


@RestController
@RequestMapping(value={"/brokeruser"})
public class BrokerUserController {
	
	@Autowired
	private BrokerService brokerService;
	
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BrokerUser> getUserById(@PathVariable("id") long id) {
        System.out.println("Fetching BrokerUser with id " + id);
        BrokerUser user = brokerService.findById(id);
        if (user == null) {
            return new ResponseEntity<BrokerUser>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BrokerUser>(user, HttpStatus.OK);
    }
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createUser(@RequestBody BrokerUser user, UriComponentsBuilder ucBuilder){
	     System.out.println("Creating BrokerUser "+user.getFirstName());
	     brokerService.createUser(user);
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/brokeruser/{id}").buildAndExpand(user.getBrokerId()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }

	 @GetMapping(value="/get", headers="Accept=application/json")
	 public List<BrokerUser> getAllUser() {	 
	  List<BrokerUser> tasks=brokerService.getUser();
	  return tasks;
	
	 }
	 /*
	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateUser(@RequestBody BrokerUser currentUser)
	{
		System.out.println("sd");
	BrokerUser user = brokerService.findById(currentUser.getBrokerId());
	if (user==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	brokerService.update(currentUser, currentUser.getBrokerId());
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<BrokerUser> deleteUser(@PathVariable("id") long id){
		BrokerUser user = brokerService.findById(id);
		if (user == null) {
			return new ResponseEntity<BrokerUser>(HttpStatus.NOT_FOUND);
		}
		brokerService.deleteUserById(id);
		return new ResponseEntity<BrokerUser>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<BrokerUser> updateUserPartially(@PathVariable("id") long id, @RequestBody BrokerUser currentUser){
		BrokerUser user = brokerService.findById(id);
		if(user ==null){
			return new ResponseEntity<BrokerUser>(HttpStatus.NOT_FOUND);
		}
		BrokerUser usr =	brokerService.updatePartially(currentUser, id);
		return new ResponseEntity<BrokerUser>(usr, HttpStatus.OK);
	}*/
}
