package com.nonegger.platform.smallroutine.dao;

import com.nonegger.platform.smallroutine.entity.AreaEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Eric
 * @date 2018/7/9 9:29
 */
@Mapper
public interface AreaDao {
    List<AreaEntity> queryAreas();
    AreaEntity queryById(Long areaId);
    Integer insertArea(AreaEntity areaEntity);
    Integer upadateArea(AreaEntity areaEntity);
    Integer deleteAreaById(Long areaId);

}
