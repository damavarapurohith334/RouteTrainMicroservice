package com.infy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.Entity.Train;
import java.util.List;


public interface TrainRepository extends JpaRepository<Train, Integer>{

	List<Train> findBySourceAndDestinationIgnoreCase(String source, String destination);
}
