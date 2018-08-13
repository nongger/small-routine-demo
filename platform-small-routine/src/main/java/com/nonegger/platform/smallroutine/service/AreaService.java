package com.nonegger.platform.smallroutine.service;

import com.nonegger.platform.smallroutine.entity.AreaEntity;

import java.util.List;

/**
 * Project: platform-small-routine
 * Author : Eric
 * Time   : 2018/7/10 9:21
 * Desc   :  *
 */
public interface AreaService {
    List<AreaEntity> getAreasList();
    AreaEntity queryAreaById(Long areaId);
    Boolean addArea(AreaEntity areaEntity);
    Boolean upadateArea(AreaEntity areaEntity);
    Boolean deleteAreaById(Long areaId);

}
