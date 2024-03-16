package br.com.cars.repository;

import java.util.List;

import br.com.cars.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Car, Long> {

	List<Car> findByModel(String model);

}