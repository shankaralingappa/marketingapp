package com.marketingapp7.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp7.dto.LeadDto;
import com.marketingapp7.entity.Lead;
import com.marketingapp7.repository.LeadRepository;
//28-april-2023

@RestController
@RequestMapping("/api/leads")
public class LeadRestController
{
  @Autowired
  private LeadRepository leadRepo;
  
  //http://localhost:8080/api/leads
    @GetMapping
	public List<Lead> getAllLeads()
	{
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
    
    @PostMapping
    public void createLead(@RequestBody Lead lead)
    {
    	leadRepo.save(lead);
    }
    
    //http://localhost:8080/api/leads/13
    @DeleteMapping("{id}")
    public void deleteLead(@PathVariable("id") long id)
    {
    	leadRepo.deleteById(id);
    }
    
  //http://localhost:8080/api/leads/1
    @PutMapping("{id}")
    public void Update(@PathVariable("id") long id, @RequestBody LeadDto dto)
    {
    	Lead lead=new Lead();
    	lead.setId(id);
    	lead.setFirstName(dto.getFirstName());
    	lead.setLastName(dto.getLastName());
    	lead.setEmail(dto.getEmail());
    	lead.setMobile(dto.getMobile());
    	leadRepo.save(lead);
    }
    
}
