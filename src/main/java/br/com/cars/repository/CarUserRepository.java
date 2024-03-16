package br.com.cars.repository;

import br.com.cars.model.CarUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarUserRepository extends JpaRepository<CarUser, Long> {

	CarUser findByName(String name);

}