package br.com.cars.service;

import br.com.cars.dto.CarResponse;
import br.com.cars.model.Car;
import br.com.cars.model.CarUser;

import java.util.List;

public interface ICarService {
    public List<CarResponse> getCars(String userName);
    public List<CarResponse> getAllCars();
    public List<CarResponse> getCarsByUser(String user);
    public void createCar(Car car);
    public CarResponse carToCarResponse(Car car);
    public boolean carUserExists(CarUser carUser);
}
