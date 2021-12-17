package com.monaco.telecom.service;

import com.monaco.telecom.dao.MonacoServiceDao;
import com.monaco.telecom.model.MonacoServiceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MonacoService implements MonacoServiceInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonacoService.class);

    @Autowired
    MonacoServiceDao monacoServiceDao;


    @Override
    public List<MonacoServiceModel> getMonacoServices() {
        LOGGER.info("get monaco services");
        return monacoServiceDao.selectMonacoServices();
    }

    @Override
    public MonacoServiceModel getMonacoService(Integer id) {
        LOGGER.info("get monaco service {}",id);
        return monacoServiceDao.selectMonacoService(id);
    }

    @Override
    public Boolean addMonacoService(MonacoServiceModel monacoServiceModel) {
        LOGGER.info("add monaco service {}",monacoServiceModel.toString());
        return monacoServiceDao.addMonacoService(monacoServiceModel);
    }

    @Override
    public int updateMonacoService(MonacoServiceModel monacoServiceModel) {
        LOGGER.info("update monaco service {}",monacoServiceModel.toString());
        return monacoServiceDao.updateMonacoService(monacoServiceModel);
    }
}
