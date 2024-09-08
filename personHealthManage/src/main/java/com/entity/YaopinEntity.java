package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 药品信息
 *
 * @author 
 * @email
 */
@TableName("yaopin")
public class YaopinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YaopinEntity() {

	}

	public YaopinEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 药品名称
     */
    @ColumnInfo(comment="药品名称",type="varchar(200)")
    @TableField(value = "yaopin_name")

    private String yaopinName;


    /**
     * 药品照片
     */
    @ColumnInfo(comment="药品照片",type="varchar(200)")
    @TableField(value = "yaopin_photo")

    private String yaopinPhoto;


    /**
     * 药品类型
     */
    @ColumnInfo(comment="药品类型",type="int(11)")
    @TableField(value = "yaopin_types")

    private Integer yaopinTypes;


    /**
     * 药品作用
     */
    @ColumnInfo(comment="药品作用",type="varchar(200)")
    @TableField(value = "yaopin_zuoyng")

    private String yaopinZuoyng;


    /**
     * 药品成分
     */
    @ColumnInfo(comment="药品成分",type="varchar(200)")
    @TableField(value = "yaopin_chengfen")

    private String yaopinChengfen;


    /**
     * 药品详情
     */
    @ColumnInfo(comment="药品详情",type="longtext")
    @TableField(value = "yaopin_content")

    private String yaopinContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "yaopin_delete")

    private Integer yaopinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：药品名称
	 */
    public String getYaopinName() {
        return yaopinName;
    }
    /**
	 * 设置：药品名称
	 */

    public void setYaopinName(String yaopinName) {
        this.yaopinName = yaopinName;
    }
    /**
	 * 获取：药品照片
	 */
    public String getYaopinPhoto() {
        return yaopinPhoto;
    }
    /**
	 * 设置：药品照片
	 */

    public void setYaopinPhoto(String yaopinPhoto) {
        this.yaopinPhoto = yaopinPhoto;
    }
    /**
	 * 获取：药品类型
	 */
    public Integer getYaopinTypes() {
        return yaopinTypes;
    }
    /**
	 * 设置：药品类型
	 */

    public void setYaopinTypes(Integer yaopinTypes) {
        this.yaopinTypes = yaopinTypes;
    }
    /**
	 * 获取：药品作用
	 */
    public String getYaopinZuoyng() {
        return yaopinZuoyng;
    }
    /**
	 * 设置：药品作用
	 */

    public void setYaopinZuoyng(String yaopinZuoyng) {
        this.yaopinZuoyng = yaopinZuoyng;
    }
    /**
	 * 获取：药品成分
	 */
    public String getYaopinChengfen() {
        return yaopinChengfen;
    }
    /**
	 * 设置：药品成分
	 */

    public void setYaopinChengfen(String yaopinChengfen) {
        this.yaopinChengfen = yaopinChengfen;
    }
    /**
	 * 获取：药品详情
	 */
    public String getYaopinContent() {
        return yaopinContent;
    }
    /**
	 * 设置：药品详情
	 */

    public void setYaopinContent(String yaopinContent) {
        this.yaopinContent = yaopinContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getYaopinDelete() {
        return yaopinDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setYaopinDelete(Integer yaopinDelete) {
        this.yaopinDelete = yaopinDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Yaopin{" +
            ", id=" + id +
            ", yaopinName=" + yaopinName +
            ", yaopinPhoto=" + yaopinPhoto +
            ", yaopinTypes=" + yaopinTypes +
            ", yaopinZuoyng=" + yaopinZuoyng +
            ", yaopinChengfen=" + yaopinChengfen +
            ", yaopinContent=" + yaopinContent +
            ", yaopinDelete=" + yaopinDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
