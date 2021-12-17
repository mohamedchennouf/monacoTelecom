package com.monaco.telecom.service;


import com.monaco.telecom.dao.MonacoServiceDao;
import com.monaco.telecom.model.MonacoServiceModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

public class MonacoServiceTest {

    @InjectMocks
    private MonacoService monacoService;

    @Mock
    private MonacoServiceDao monacoServiceDao;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        MonacoServiceModel monacoServiceModel = new MonacoServiceModel();
        monacoServiceModel.setId(1);
        monacoServiceModel.setTag("tag1");
        monacoServiceModel.setAction("ACTIVE");

        MonacoServiceModel monacoServiceModelTwo = new MonacoServiceModel();
        monacoServiceModelTwo.setId(2);
        monacoServiceModelTwo.setTag("tag2");
        monacoServiceModelTwo.setAction("DISABLE");

        List<MonacoServiceModel> monacoServiceModels = new ArrayList<>();
        monacoServiceModels.add(monacoServiceModel);
        monacoServiceModels.add(monacoServiceModelTwo);

        Mockito.when(monacoServiceDao.selectMonacoServiceMaxId()).thenReturn(2);
        Mockito.when(monacoServiceDao.selectMonacoServices()).thenReturn(monacoServiceModels);
        Mockito.when(monacoServiceDao.selectMonacoService(1)).thenReturn(monacoServiceModel);
        Mockito.when(monacoServiceDao.selectMonacoService(2)).thenReturn(monacoServiceModelTwo);
        Mockito.when(monacoServiceDao.addMonacoService(ArgumentMatchers.any())).thenReturn(false);
    }

    @Test
    public void getMonacoServicesTest(){
        Assert.assertEquals(monacoService.getMonacoServices().size(),2);
        Assert.assertEquals(monacoService.getMonacoServices().get(0).getTag(),"tag1");
        Assert.assertEquals(monacoService.getMonacoServices().get(0).getAction(),"ACTIVE");
    }

    @Test
    public void getMonacoServiceTest(){
        Assert.assertEquals(monacoService.getMonacoService(1).getTag(),"tag1");
        Assert.assertEquals(monacoService.getMonacoService(2).getTag(),"tag2");
    }

    @Test
    public void addUserTest(){
        MonacoServiceModel monacoServiceModel = new MonacoServiceModel();
        monacoServiceModel.setId(12);
        monacoServiceModel.setTag("tag12");
        monacoServiceModel.setAction("ACTIVE");
        Assert.assertFalse(monacoServiceDao.addMonacoService(monacoServiceModel));
    }

}
