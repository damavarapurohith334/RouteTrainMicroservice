package com.infy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.DTO.TrainDTO;
import com.infy.Entity.Train;
import com.infy.service.TrainService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/trains")
@Validated
@EnableDiscoveryClient
public class TrainController {
	
	@Autowired
    TrainService trainService;
	
	@Autowired
	Environment environment;

    @PostMapping
    public ResponseEntity<Train> createTrain(@RequestBody @Valid TrainDTO  trainDTO) {
        Train createdTrain = trainService.createTrain(trainDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdTrain);
    }

    @GetMapping(value = "/search_Source_destination/{source}/{destination}")
    public ResponseEntity<List<Train>> searchTrains(
            @PathVariable ("source") String source,
            @PathVariable ("destination")String destination) {
		String port = environment.getProperty("local.server.port");

        List<Train> trains = trainService.getTrainsBySourceAndDestination(source, destination);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(trains);
    }
    
    @GetMapping(value = "/byTrainId/{trainId}")
    public ResponseEntity<?>getTrainById(
            @PathVariable ("trainId") Integer trainId)
            {	
            	String port = environment.getProperty("local.server.port");

            	TrainDTO byId = trainService.getById(trainId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(byId);
    }
}
