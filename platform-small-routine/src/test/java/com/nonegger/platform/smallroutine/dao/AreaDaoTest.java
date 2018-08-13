package com.nonegger.platform.smallroutine.dao;

import com.nonegger.platform.smallroutine.entity.AreaEntity;
import com.nonegger.platform.smallroutine.utils.DarLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryAreas() throws Exception {

        List<AreaEntity> areaEntities = areaDao.queryAreas();
        System.out.println(areaEntities.get(0));
        assertNotNull(areaEntities);
    }

    @Test
    public void queryById() throws Exception {
        AreaEntity areaEntity = areaDao.queryById(1L);
        System.out.println(areaEntity.getAreaName());
    }

    @Test
    public void insertArea() throws Exception {
        AreaEntity areaEntity = new AreaEntity();
        areaEntity.setAreaName("南苑");
        areaEntity.setPriority(3);
        Integer integer = areaDao.insertArea(areaEntity);
        assertEquals(1, integer.intValue());
    }

    @Test
    public void upadateArea() throws Exception {
        AreaEntity areaEntity = new AreaEntity();
        areaEntity.setAreaName("西苑");
        areaEntity.setAreaId(2L);
        Integer updateNum = areaDao.upadateArea(areaEntity);
        DarLog.info("数据库更新：{}", updateNum);

    }

    @Test
    public void deleteAreaById() throws Exception {
        Integer integer = areaDao.deleteAreaById(1L);
        DarLog.info("删除数据库记录：[{}]", integer);
    }

}