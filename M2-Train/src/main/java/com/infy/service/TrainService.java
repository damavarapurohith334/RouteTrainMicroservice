package com.infy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.DTO.TrainDTO;
import com.infy.Entity.Train;
import com.infy.Repository.TrainRepository;

@Service
public class TrainService {
	@Autowired
    TrainRepository trainRepository;

    
  

    public Train createTrain(TrainDTO trainDTO) {
    	
    	Train train = new Train();
    	DTO_ToTrainEntity(trainDTO, train);

    	return trainRepository.saveAndFlush(train);
    }


    public List<Train> getTrainsBySourceAndDestination(String source, String destination) {
        return trainRepository.findBySourceAndDestinationIgnoreCase(source, destination);
    }
    
    
    
    
    //conversion of DTO to entity
    private void DTO_ToTrainEntity(TrainDTO trainDTO, Train train) {
    	train.setArrivalTime(trainDTO.getArrivalTime());
    	train.setDepartureTime(trainDTO.getDepartureTime());
    	train.setDestination(trainDTO.getDestination());
    	train.setFare(trainDTO.getFare());
    	train.setSource(trainDTO.getSource());
    	train.setTrainName(trainDTO.getTrainName());
    	train.setTrainNumber(trainDTO.getTrainNumber());
    }


	public TrainDTO getById(Integer trainId) {
		Optional<Train> findById = trainRepository.findById(trainId);
		
		TrainDTO dto = new TrainDTO();
		if (findById.isPresent()) {
			Train train = findById.get();
			dto.setArrivalTime(train.getArrivalTime());
			dto.setDepartureTime(train.getDepartureTime());
			dto.setDestination(train.getDestination());
			dto.setFare(train.getFare());
			dto.setSource(train.getSource());
			dto.setTrainId(train.getTrainId());
			dto.setTrainName(train.getTrainName());
			dto.setTrainNumber(train.getTrainNumber());
		}
//		BeanUtils.copyProperties(train, dto);
		
		return dto;
	}
}
