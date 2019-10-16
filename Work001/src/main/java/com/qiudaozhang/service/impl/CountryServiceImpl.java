package com.qiudaozhang.service.impl;

import com.qiudaozhang.mapper.CountryMapper;
import com.qiudaozhang.model.Country;
import com.qiudaozhang.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryMapper countryMapper;
    @Override
    public List<Country> findAll() {
        return countryMapper.findAll();
    }
}
