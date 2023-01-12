package com.fanta.server.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 时间基类
 *
 * @author mmsong
 */
@Data
public class BaseTimeEntity implements Serializable {

    /**
     * 创建时间，新增时自动填充
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间，创建与修改时自动填充
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
