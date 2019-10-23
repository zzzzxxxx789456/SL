package com.qiudaozhang.service.impl;

import com.qiudaozhang.mapper.CountryDao;
import com.qiudaozhang.model.Country;
import com.qiudaozhang.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 深圳邱道长
 * @since 2019/10/7
 */
@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDao countryDao;

    @Override
    public List<Country> findAll() {
        return countryDao.findAll();
    }
}
