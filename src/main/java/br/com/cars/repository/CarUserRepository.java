package br.com.cars.repository;

import br.com.cars.model.CarUser;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CarUserRepository extends JpaRepository<CarUser, Long> {

	CarUser findByEmail(String email);
	@Query("SELECT u.id FROM CarUser u WHERE u.email = :email")
	Long findIdByEmail(@Param("email") String email);
	default boolean findByCarUser(CarUser carUser) {
		Example<CarUser> carUserExample = Example.of(carUser);
		return this.findOne(carUserExample).isPresent();
	}

}