package com.nonegger.platform.smallroutine.controller;

import com.nonegger.platform.smallroutine.entity.AreaEntity;
import com.nonegger.platform.smallroutine.service.AreaService;
import com.nonegger.platform.smallroutine.utils.DarLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: platform-small-routine
 * Author : Eric
 * Time   : 2018/7/10 9:39
 * Desc   :  *
 */
@RestController
@RequestMapping("/darren")
public class AreaController {

    @Autowired
    private AreaService areaService;


    @RequestMapping(value = "/areaList", method = RequestMethod.GET)
    public Map<String, Object> listArea() {
        DarLog.info("获取区域列表开始");
        Map<String, Object> modelMap = new HashMap<>();
        List<AreaEntity> areasList = areaService.getAreasList();
        modelMap.put("areasList", areasList);
        modelMap.put("status", "SUCCESS");
        DarLog.info("获取区域列表结束{}", areasList);
        return modelMap;
    }

    @RequestMapping(value = "/getAreaById", method = RequestMethod.GET)
    public Map<String, Object> getAreaById(Long areaId) {
        DarLog.info("根据id获取区域信息开始{}", areaId);
        Map<String, Object> modelMap = new HashMap<>();
        AreaEntity areaEntity = areaService.queryAreaById(areaId);
        modelMap.put("area", areaEntity);
        modelMap.put("status", "SUCCESS");
        DarLog.info("根据id获取区域信息结束");
        return modelMap;
    }


    @RequestMapping(value = "/addArea", method = RequestMethod.POST)
    public Map<String, Object> addArea(@RequestBody AreaEntity area) {
        DarLog.info("新增区域信息开始");
        Map<String, Object> modelMap = new HashMap<>();

        Boolean isSuccess = areaService.addArea(area);
        modelMap.put("status", isSuccess ? "SUCCESS" : "FAIL");
        DarLog.info("新增区域信息结束");
        return modelMap;
    }

    @RequestMapping(value = "/modifyArea", method = RequestMethod.POST)
    public Map<String, Object> modifyArea(@RequestBody AreaEntity area) {
        DarLog.info("修改区域信息开始");
        Map<String, Object> modelMap = new HashMap<>();

        Boolean isSuccess = areaService.upadateArea(area);
        modelMap.put("status", isSuccess ? "SUCCESS" : "FAIL");
        DarLog.info("修改区域信息结束");
        return modelMap;
    }

    @RequestMapping(value = "/deleteArea", method = RequestMethod.GET)
    public Map<String, Object> deleteArea(Long areaId) {
        DarLog.info("开始删除一条记录：{}", areaId);
        Map<String, Object> modelMap = new HashMap<>();

        Boolean isSuccess = areaService.deleteAreaById(areaId);
        modelMap.put("status", isSuccess ? "SUCCESS" : "FAIL");
        return modelMap;
    }

}
