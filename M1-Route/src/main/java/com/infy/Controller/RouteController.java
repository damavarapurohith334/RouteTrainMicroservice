package com.infy.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.DTO.RouteDTO;
import com.infy.DTO.TrainDTO;
import com.infy.Entityy.Route;
import com.infy.Exceptions.RouteNotFoundException;
import com.infy.Service.RouteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/routes")
@Validated
@EnableDiscoveryClient
public class RouteController {

	@Autowired
	RouteService routeService;

//	String uri = "http://localhost:8081/M2_Train/trains/byTrainId/";

	String uri;
	@Autowired
	DiscoveryClient client;
	
	
	@PostMapping
	public ResponseEntity<String> createRoute(@Valid @RequestBody RouteDTO routeDTO) {
		Integer routeId = routeService.createRoute(routeDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body("Route Id: " + routeId + " Created");

	}

	@GetMapping(value = "/{routeId}")
	public ResponseEntity<String> getRouteById(@PathVariable("routeId") Integer routeId) throws RouteNotFoundException {
		Route routeById = routeService.getRouteById(routeId);

		return ResponseEntity.status(HttpStatus.CREATED).body("Route Details are :" + routeById);

	}

	/*
	 * @GetMapping(value = "/getTrainsListBy_S_D/{source}/{destination}") public
	 * ResponseEntity<?> getTrainsListBySourceAndDestination(@PathVariable("source")
	 * String source,
	 * 
	 * @PathVariable("destination") String destination) { HashMap<String, String>
	 * pathParams = new HashMap<>(); pathParams.put("source", source);
	 * pathParams.put("destination", destination);
	 * System.out.println("before rest"); String uriForSD =
	 * "http://localhost:8081/M2_Train/trains/search_Source_destination/{source}/{destination}";
	 * RestTemplate restTemplate = new RestTemplate(); TrainDTO trainDTO =
	 * restTemplate.getForObject(uriForSD, TrainDTO.class, pathParams);
	 * 
	 * TrainDTO trainDTO2 = new TrainDTO();
	 * trainDTO2.setArrivalTime(trainDTO.getArrivalTime());
	 * trainDTO2.setDepartureTime(trainDTO.getDepartureTime());
	 * trainDTO2.setDestination(trainDTO.getDestination());
	 * trainDTO2.setFare(trainDTO.getFare());
	 * trainDTO2.setSource(trainDTO.getSource());
	 * trainDTO2.setTrainId(trainDTO.getTrainId());
	 * trainDTO2.setTrainName(trainDTO.getTrainName());
	 * trainDTO2.setTrainNumber(trainDTO.getTrainNumber());
	 * 
	 * return ResponseEntity.status(HttpStatus.ACCEPTED).body(trainDTO2); }
	 */
	
	@GetMapping(value = "/getTrainsById/{trainId}")
	public ResponseEntity<?> getTrainsById(@PathVariable Integer trainId) {

//		RouteDTO byRouteId = routeService.getByRouteId(routeId);
		RestTemplate restTemplate = new RestTemplate();
		List<ServiceInstance> instances = client.getInstances("Train_Microservice");
		System.out.println(instances);
		uri=instances.get(0).getUri().toString();
		TrainDTO trainDTO = restTemplate.getForObject(uri+"/M2_Train/trains/byTrainId/"+trainId, TrainDTO.class);
//		TrainDTO trainDTO = restTemplate.getForObject(uri+trainId, TrainDTO.class);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(trainDTO);
	}
}
