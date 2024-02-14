package com.example.carapi.utils;

import com.example.carapi.dto.CarDto;
import com.example.carapi.model.CarModel;

public class CarMapper {

    public static CarModel toCarModel(CarDto carDto){
        CarModel carModel = new CarModel();
        carModel.setBrand(carDto.getBrand());
        carModel.setModel(carDto.getModel());
        carModel.setColor(carDto.getColor());
        return carModel;
    }
    public static CarDto toCarDto(CarModel carModel) {
        CarDto carDto = new CarDto();
        carDto.setBrand(carModel.getBrand());
        carDto.setModel(carModel.getModel());
        carDto.setColor(carModel.getColor());
        // mapowania innych pól w zależności co chcemy
        return carDto;
    }
}
