package com.exam.module4.service.impl;

import com.exam.module4.model.Country;
import com.exam.module4.repositories.CountryRepository;
import com.exam.module4.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;
    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findOne(Long id) {
        return countryRepository.findById(id).get();
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country delete(Long id) {
        Country deleteCountry = countryRepository.findById(id).get();
        countryRepository.deleteById(id);
        return deleteCountry;
    }
}
