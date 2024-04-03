package br.com.cars.service.impl;

import br.com.cars.dto.CarResponse;
import br.com.cars.model.Car;
import br.com.cars.model.CarUser;
import br.com.cars.repository.CarRepository;
import br.com.cars.repository.CarUserRepository;
import br.com.cars.service.ICarService;
import org.modelmapper.ModelMapper;
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
    public List<CarResponse> getCars(String userName) {
        return userName == null ? this.getAllCars() : this.getCarsByUser(userName);
    }

    @Override
    public List<CarResponse> getAllCars() {
        List<Car> cars = carRepository.findAll();

        return cars.stream().map(this::carToCarResponse).toList();
    }

    @Override
    public List<CarResponse> getCarsByUser(String user) {
        CarUser carUser = carUserRepository.findByName(user);
        List<Car> cars = carRepository.findByCarUser(carUser);
        return cars.stream().map(this::carToCarResponse).toList();
    }

    @Override
    public void createCar(Car car) {
        carRepository.save(car);
    }


    @Override
    public CarResponse carToCarResponse(Car car) {
        return mapper.map(car, CarResponse.class);
    }
}
