package br.com.calculate.distance.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calculate.distance.dto.MatrixAddressDTO;
import br.com.calculate.distance.serveces.CalculeteService;

@RestController
@RequestMapping(path = "/calculate")
public class CalculateDistanceResource {
	
	@Autowired
	CalculeteService calculeteService;


	@GetMapping(value = "/distance")
	private MatrixAddressDTO loginAdministration(@RequestBody List<String> request)throws Exception {
		
		MatrixAddressDTO returnDTO = calculeteService.requestBody(request);		
		
		return returnDTO;
	}

}