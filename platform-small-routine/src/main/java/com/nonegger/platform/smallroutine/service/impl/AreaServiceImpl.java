package com.nonegger.platform.smallroutine.service.impl;

import com.nonegger.platform.smallroutine.dao.AreaDao;
import com.nonegger.platform.smallroutine.entity.AreaEntity;
import com.nonegger.platform.smallroutine.exception.ExceptionEnum;
import com.nonegger.platform.smallroutine.service.AreaService;
import com.nonegger.platform.smallroutine.utils.DarLog;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Project: platform-small-routine
 * Author : Eric
 * Time   : 2018/7/10 9:23
 * Desc   :  *
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<AreaEntity> getAreasList() {
        List<AreaEntity> areaEntities = null;
        try {
            areaEntities = areaDao.queryAreas();
        } catch (Exception e) {
            DarLog.error("获取信息列表失败！{}", e.getMessage());
            throw ExceptionEnum.DB_SELECT_FAILED.createException();
        }
        return areaEntities;
    }

    @Override
    public AreaEntity queryAreaById(Long areaId) {
        //int i = 1 / 0;
        AreaEntity areaEntity = null;
        try {
            areaEntity = areaDao.queryById(areaId);
        } catch (Exception e) {
            DarLog.error("获取区域信息失败！{}", e.getMessage());
            throw ExceptionEnum.DB_SELECT_FAILED.createException();
        }

        return areaEntity;
    }

    @Transactional
    @Override
    public Boolean addArea(AreaEntity areaEntity) {
        try {
            // 基本参数校验
            if (StringUtils.isNotBlank(areaEntity.getAreaName())) {
                Integer line = areaDao.insertArea(areaEntity);
                if (line > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            DarLog.error("新增区域信息失败！{}", e.getMessage());
        }
        return false;
    }

    @Transactional
    @Override
    public Boolean upadateArea(AreaEntity areaEntity) {
        try {
            if (areaEntity.getAreaId() != null && areaEntity.getAreaId() > 0) {
                Integer integer = areaDao.upadateArea(areaEntity);
                if (integer > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            DarLog.error("更新区域信息异常！{}", e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean deleteAreaById(Long areaId) {
        try {
            if (areaId != null && areaId > 0) {
                Integer line = areaDao.deleteAreaById(areaId);
                if (line > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            DarLog.error("删除区域信息异常！{}", e.getMessage());
        }
        return false;
    }
}
