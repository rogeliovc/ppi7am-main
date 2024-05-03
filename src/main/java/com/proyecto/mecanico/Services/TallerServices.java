package com.proyecto.mecanico.Services;

import com.proyecto.mecanico.Models.TallerModel;
import com.proyecto.mecanico.Repositories.TallerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class TallerServices {
    @Autowired
    TallerRepository tallerRepository;

    public TallerModel saveCar(TallerModel car){
        if(tallerRepository.findCarModelByPlate(car.getPlate()).toString().equals("Optional[[]]")){
            return tallerRepository.save(car);
        }else{
            TallerModel carError = new TallerModel();
            carError.setId(-1L);
            return carError;
        }
    }

    public ArrayList<TallerModel> getAllCar(){
        return(ArrayList<TallerModel>) tallerRepository.findAll();
    }

    public Optional<TallerModel> findCarById(Long id){
        return tallerRepository.findById(id);
    }

    public TallerModel editCar(TallerModel car){
        return tallerRepository.save(car);
    }

    public String deleteCarById(Long id){
        if(findCarById(id).isPresent()){
            tallerRepository.deleteById(id);
            return "car deleted successfully";
        }else {
            return "car with id="+ id+ " not foud";
        }
    }

    public Optional<ArrayList<TallerModel>> findCarByName(String name){
        return tallerRepository.findCarModelByName(name);
    }

    public Optional<ArrayList<TallerModel>> findCarByPlate(String plate){
        return tallerRepository.findCarModelByPlate(plate);
    }

}
