package com.courzelo_for_business.prehiringtests.apirest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  com.courzelo_for_business.prehiringtests.entities.dtos.TestsDTO;
import  com.courzelo_for_business.prehiringtests.servicerest.iservicesrest.IServiceRestTests;

@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping( "/Tests" )
@RestController
public class TestsRestAPI {

	@Autowired
	private IServiceRestTests iTest;
	
	@GetMapping(path = "")
	public List<TestsDTO> getAllTest() {
		return iTest.getAllTests(); 
	}
	
	@GetMapping(path = "/id/{idTest}")
	public TestsDTO getTestById(@PathVariable(name = "idTest") String idTest) {
		return iTest.getByIdTest(idTest); 
	}
	
	
	@GetMapping(path = "/{idBusiness}")
	public List<TestsDTO> getAllTestByBusiness(@PathVariable(name = "idBusiness") String idBusiness) {
		return iTest.getByBusiness(idBusiness); 
	}
	
	@PostMapping(path = "/{idBusiness}")
    public ResponseEntity<TestsDTO> addTest(@RequestBody  @Valid  TestsDTO test,@PathVariable(name = "idBusiness") String idBusiness) {
		
		TestsDTO testResponse = iTest.addTest(test,idBusiness);
		
        return new ResponseEntity<TestsDTO>(testResponse, HttpStatus.CREATED);
    }
	
	
	
	
	@DeleteMapping(path = "/{idTest}")
	public void deleteTest(@PathVariable(name = "idTest") String idTest) {
		iTest.deleteTest(idTest);
		
	}
	
}
