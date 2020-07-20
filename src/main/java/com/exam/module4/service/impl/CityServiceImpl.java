package com.exam.module4.service.impl;

import com.exam.module4.model.City;
import com.exam.module4.repositories.CityRepository;
import com.exam.module4.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findOne(Long id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City delete(Long id) {
        City deleteCity = cityRepository.findById(id).get();
        cityRepository.deleteById(id);
        return deleteCity;
    }
}
