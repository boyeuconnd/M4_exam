package com.exam.module4.repositories;

import com.exam.module4.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends CrudRepository<City,Long> {
}
