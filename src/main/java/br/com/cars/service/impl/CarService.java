package br.com.cars.service.impl;

import br.com.cars.controller.impl.CarController;
import br.com.cars.dto.CarResponse;
import br.com.cars.model.Car;
import br.com.cars.model.CarUser;
import br.com.cars.repository.CarRepository;
import br.com.cars.repository.CarUserRepository;
import br.com.cars.service.ICarService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService {
    ModelMapper mapper = new ModelMapper();

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarUserRepository carUserRepository;

    @Override
    public List<CarResponse> getCars(String email) {
        return email == null ? this.getAllCars() : this.getCarsByUser(email);
    }

    @Override
    public List<CarResponse> getAllCars() {
        List<Car> cars = carRepository.findAll();

        return cars.stream().map(this::carToCarResponse).toList();
    }

    @Override
    public List<CarResponse> getCarsByUser(String email) {
        CarUser carUser = carUserRepository.findByEmail(email);
        List<Car> cars = carRepository.findByCarUser(carUser);
        return cars.stream().map(this::carToCarResponse).toList();
    }

    @Override
    public void createCar(Car car) {
        if (!this.carUserExists(car.getCarUser())) {
            throw new IllegalArgumentException("User not found!");
        }

        CarUser carUserWithId = carUserRepository.findByEmail(car.getCarUser().getEmail());
        car.setCarUser(carUserWithId);
        carRepository.save(car);
    }

    @Override
    public CarResponse carToCarResponse(Car car) {
        return mapper.map(car, CarResponse.class);
    }

    @Override
    public boolean carUserExists(CarUser carUser) {
        return carUserRepository.findByCarUser(carUser);
    }
}
