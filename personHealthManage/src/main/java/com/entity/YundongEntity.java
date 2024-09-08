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
 * 运动教程
 *
 * @author 
 * @email
 */
@TableName("yundong")
public class YundongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YundongEntity() {

	}

	public YundongEntity(T t) {
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
     * 标题
     */
    @ColumnInfo(comment="标题",type="varchar(200)")
    @TableField(value = "yundong_name")

    private String yundongName;


    /**
     * 运动照片
     */
    @ColumnInfo(comment="运动照片",type="varchar(200)")
    @TableField(value = "yundong_photo")

    private String yundongPhoto;


    /**
     * 运动类型
     */
    @ColumnInfo(comment="运动类型",type="int(11)")
    @TableField(value = "yundong_types")

    private Integer yundongTypes;


    /**
     * 运动视频
     */
    @ColumnInfo(comment="运动视频",type="varchar(200)")
    @TableField(value = "yundong_video")

    private String yundongVideo;


    /**
     * 消耗热量
     */
    @ColumnInfo(comment="消耗热量",type="int(11)")
    @TableField(value = "yundong_num")

    private Integer yundongNum;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 运动介绍
     */
    @ColumnInfo(comment="运动介绍",type="longtext")
    @TableField(value = "yundong_content")

    private String yundongContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "yundong_delete")

    private Integer yundongDelete;


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
	 * 获取：标题
	 */
    public String getYundongName() {
        return yundongName;
    }
    /**
	 * 设置：标题
	 */

    public void setYundongName(String yundongName) {
        this.yundongName = yundongName;
    }
    /**
	 * 获取：运动照片
	 */
    public String getYundongPhoto() {
        return yundongPhoto;
    }
    /**
	 * 设置：运动照片
	 */

    public void setYundongPhoto(String yundongPhoto) {
        this.yundongPhoto = yundongPhoto;
    }
    /**
	 * 获取：运动类型
	 */
    public Integer getYundongTypes() {
        return yundongTypes;
    }
    /**
	 * 设置：运动类型
	 */

    public void setYundongTypes(Integer yundongTypes) {
        this.yundongTypes = yundongTypes;
    }
    /**
	 * 获取：运动视频
	 */
    public String getYundongVideo() {
        return yundongVideo;
    }
    /**
	 * 设置：运动视频
	 */

    public void setYundongVideo(String yundongVideo) {
        this.yundongVideo = yundongVideo;
    }
    /**
	 * 获取：消耗热量
	 */
    public Integer getYundongNum() {
        return yundongNum;
    }
    /**
	 * 设置：消耗热量
	 */

    public void setYundongNum(Integer yundongNum) {
        this.yundongNum = yundongNum;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：运动介绍
	 */
    public String getYundongContent() {
        return yundongContent;
    }
    /**
	 * 设置：运动介绍
	 */

    public void setYundongContent(String yundongContent) {
        this.yundongContent = yundongContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getYundongDelete() {
        return yundongDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setYundongDelete(Integer yundongDelete) {
        this.yundongDelete = yundongDelete;
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
        return "Yundong{" +
            ", id=" + id +
            ", yundongName=" + yundongName +
            ", yundongPhoto=" + yundongPhoto +
            ", yundongTypes=" + yundongTypes +
            ", yundongVideo=" + yundongVideo +
            ", yundongNum=" + yundongNum +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", yundongContent=" + yundongContent +
            ", yundongDelete=" + yundongDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
