package com.exam.module4.service;

import com.exam.module4.model.City;

public interface CityService {

    Iterable<City> findAll();
    City findOne(Long id);

    City save(City city);

    City delete(Long id);
}
