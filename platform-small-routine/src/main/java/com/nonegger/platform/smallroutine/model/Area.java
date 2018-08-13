package com.nonegger.platform.smallroutine.model;

import lombok.Data;

import java.util.Date;

/**
 * @author Eric
 * @date 2018/7/4 23:20
 */
@Data
public class Area {
    private Long area_id;
    private String area_name;
    private Integer priority;
    private Date ctime;
    private Date mtime;
    private Integer isDelete;
}
