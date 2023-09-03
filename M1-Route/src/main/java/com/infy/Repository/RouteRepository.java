package com.infy.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.Entityy.Route;
@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
}
