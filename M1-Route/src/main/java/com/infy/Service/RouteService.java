package com.infy.Service;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.DTO.RouteDTO;
import com.infy.Entityy.Route;
import com.infy.Exceptions.RouteNotFoundException;
import com.infy.Repository.RouteRepository;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    public Integer createRoute(RouteDTO routeDTO) {
    	
    	Route route= new  Route();
    	route.setDestination(routeDTO.getDestination());
    	route.setSource(routeDTO.getSource());
    	Route savedRoute = routeRepository.save(route);
    	return savedRoute.getRouteId();
      
    }
    
    
    public Route getRouteById(Integer routeId) throws RouteNotFoundException {
       
            
            Optional<Route> findById = routeRepository.findById(routeId);
            if (findById.isPresent()) {
            	Route route = findById.get();
            	return route;
            } else {
                throw new RouteNotFoundException("Route with ID " + routeId+ " not found");
            }
        }


	public RouteDTO getByRouteId(Integer routeId) {

		RouteDTO dto= new RouteDTO();
		Optional<Route> findById = routeRepository.findById(routeId);
		if (findById.isPresent()) {
			Route route = findById.get();
			BeanUtils.copyProperties(route, dto);
		}
		return dto;
	}
    
}
