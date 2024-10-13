package com.springrest1.springrest1.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springrest1.springrest1.entities.load;// Ensure the import is correct
import com.springrest1.springrest1.services.Loadservices;

@RestController
public class mycontroller {
	@Autowired
	private Loadservices loadservice;

    @GetMapping("/home")
    public String home() {
        return "This is the homepage";
    }

    @GetMapping("/load")
    public List<load> getloads(){
    	return this.loadservice.getloads();
    }
    @GetMapping("/load/{shipperId}")
    public  load getload(@PathVariable String shipperId) {
    	return this.loadservice.getloads(Long.parseLong(shipperId));
    	
    }
    @PostMapping("/load")
    public load addload(@RequestBody load Load) {
    	return this.loadservice.addload(Load);
    	
    	
    }
    @PutMapping("/load/{shipperId}")
    public load updateload(@RequestBody load Load) {
    	return this.loadservice.updateload(Load);
     }
    
    
    @DeleteMapping("/load/{shipperId}")
    public ResponseEntity<HttpStatus> deleteLoad(@PathVariable String shipperId ){
    	try {
    		this.loadservice.deleteLoad(Long.parseLong(shipperId));
    		return new ResponseEntity<>(HttpStatus.OK);}
    	catch (Exception e) {
      		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);}
    	}
    }
    	
    


