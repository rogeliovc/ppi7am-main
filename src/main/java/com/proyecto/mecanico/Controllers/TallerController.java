package com.proyecto.mecanico.Controllers;

import com.proyecto.mecanico.Models.TallerModel;
import com.proyecto.mecanico.Services.TallerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class TallerController {
    @Autowired
    TallerServices tallerServices;

    @PostMapping()
    public TallerModel saveCar(@RequestBody TallerModel car){
        return tallerServices.saveCar(car);
    }
    @PutMapping()
    public TallerModel editCar(@RequestBody TallerModel car){
        return tallerServices.editCar(car);
    }

    @GetMapping()
    public ArrayList<TallerModel> getAllCar(){
        return tallerServices.getAllCar();
    }


    @GetMapping("/findCarById/{id}")
    public Optional<TallerModel> findCarById(@PathVariable Long id){
        return tallerServices.findCarById(id);
    }

    @GetMapping("/findCarByPlate/{plate}")
    public Optional<ArrayList<TallerModel>> findCarByPlate(@PathVariable String plate){
        return tallerServices.findCarByPlate(plate);
    }


    @GetMapping("/findCarByName/{name}")
    public Optional<ArrayList<TallerModel>> findCarByName(@PathVariable String name){
        return tallerServices.findCarByName(name);
    }
    @DeleteMapping("/delete-car-by-id")
    public String deleteCarById(@RequestParam("id") Long id){
        return tallerServices.deleteCarById(id);
    }

}