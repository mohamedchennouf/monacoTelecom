package com.monaco.telecom.service;

import com.monaco.telecom.model.MonacoServiceModel;

import java.util.List;

public interface MonacoServiceInterface {

    public List<MonacoServiceModel> getMonacoServices();

    public MonacoServiceModel getMonacoService(Integer id);

    public Boolean addMonacoService(MonacoServiceModel monacoServiceModel);

    public int updateMonacoService(MonacoServiceModel monacoServiceModel);
}
