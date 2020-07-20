package com.exam.module4.service;

import com.exam.module4.model.Country;

public interface CountryService {

    Iterable<Country> findAll();
    Country findOne(Long id);

    Country save(Country country);

    Country delete(Long id);
}
