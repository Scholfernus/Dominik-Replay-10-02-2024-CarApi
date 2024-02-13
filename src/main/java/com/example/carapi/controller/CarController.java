package com.example.carapi.controller;

import com.example.carapi.dto.CarDto;
import com.example.carapi.model.CarModel;
import com.example.carapi.service.CarService;
import com.example.carapi.utils.error.CarNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cars", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class CarController {
    //    private List<CarModel> carsList;
    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<CarModel>> getAllCars() {
        try {
            List<CarModel> carsList = carService.getCarList();
            return ResponseEntity.ok(carsList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarModel> getCarById(@PathVariable Long id) {
        try {
            CarModel carModel = carService.getCarById(id);
            return ResponseEntity.ok(carModel);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<CarModel>> getCarsByColor(@PathVariable String color) {
        try {
            List<CarModel> carList = carService.getCarsByColor(color);
            return ResponseEntity.ok(carList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<CarModel> addCar(@RequestBody CarModel car) {
        try {
            carService.addCar(car);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarModel> deleteCarById(@PathVariable Long id) {
        try {
            carService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PatchMapping("/{id}/color")
    public ResponseEntity<CarDto> editCarColorById(@PathVariable Long id,
                                                   @RequestBody CarDto carDto) {
        try {
            CarDto updateCar = carService.updateCarColor(id, carDto);
            return ResponseEntity.ok(updateCar);
        }catch (CarNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
