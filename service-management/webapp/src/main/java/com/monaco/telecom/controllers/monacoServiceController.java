package com.monaco.telecom.controllers;


import com.monaco.telecom.model.MonacoServiceModel;
import com.monaco.telecom.service.MonacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class monacoServiceController {

    @Autowired
    MonacoService monacoService;

    @CrossOrigin
    @GetMapping({"/services"})
    public List<MonacoServiceModel> getMonacoServices() {
        return monacoService.getMonacoServices();
    }

    @CrossOrigin
    @GetMapping({"/services/{id}"})
    public MonacoServiceModel getMonacoServiceById(@PathVariable Integer id) {
        return monacoService.getMonacoService(id);
    }

    @CrossOrigin
    @PostMapping(value = {"/services"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Boolean addMonacoService(@RequestBody MonacoServiceModel monacoServiceModel) {
        return monacoService.addMonacoService(monacoServiceModel);
    }

    @CrossOrigin
    @PutMapping(value = {"/services"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int updateMonacoService(@RequestBody MonacoServiceModel monacoServiceModel) {
        return monacoService.updateMonacoService(monacoServiceModel);
    }

}
