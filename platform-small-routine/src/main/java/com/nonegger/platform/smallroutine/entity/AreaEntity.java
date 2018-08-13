package com.nonegger.platform.smallroutine.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Eric
 * @date 2018/7/9 9:27
 */
@Data
public class AreaEntity {
    private Long areaId;
    private String areaName;
    private Integer priority;
    private String ctime;
    private String mtime;
    private Integer isDelete;
}
