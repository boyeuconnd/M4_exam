package com.exam.module4.formatter;

import com.exam.module4.model.Country;
import com.exam.module4.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CountryFormatter implements Formatter<Country> {
    @Autowired
    private CountryService countryService;
    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        return  countryService.findOne(Long.parseLong(text));
    }
    @Override
    public String print(Country object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
