package com.example.carapi.service;

import com.example.carapi.dto.CarDto;
import com.example.carapi.model.CarModel;
import com.example.carapi.repository.CarRepository;
import com.example.carapi.utils.CarMapper;
import com.example.carapi.utils.error.CarNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void addCar(CarModel car) {
        carRepository.save(car);
    }
    public List<CarModel> getCarList() {
        return carRepository.findAll();
    }

    public CarModel getCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new RuntimeException("empty"));
    }

    public List<CarModel> getCarsByColor(String color) {
        return carRepository.listCarsByColor(color);
    }

    public CarDto updateCarColor(Long id, CarDto carDto) {
        CarModel car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car not found"));
                car.setColor(carDto.getColor());
        CarModel newModel = carRepository.save(car);
        return CarMapper.toCarDto(newModel);

    }

    public void remove(Long id) {
        carRepository.deleteById(id);
    }
}
