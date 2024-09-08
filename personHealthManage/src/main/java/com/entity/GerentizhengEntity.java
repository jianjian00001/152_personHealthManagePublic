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
 * 体检记录
 *
 * @author 
 * @email
 */
@TableName("gerentizheng")
public class GerentizhengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GerentizhengEntity() {

	}

	public GerentizhengEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 当前身高
     */
    @ColumnInfo(comment="当前身高",type="decimal(10,2)")
    @TableField(value = "gerentizheng_num")

    private Double gerentizhengNum;


    /**
     * 当前体重
     */
    @ColumnInfo(comment="当前体重",type="decimal(10,2)")
    @TableField(value = "tizhong_num")

    private Double tizhongNum;


    /**
     * 身体状况
     */
    @ColumnInfo(comment="身体状况",type="int(11)")
    @TableField(value = "shenti_types")

    private Integer shentiTypes;


    /**
     * 饮食照片
     */
    @ColumnInfo(comment="饮食照片",type="varchar(200)")
    @TableField(value = "meishi_photo")

    private String meishiPhoto;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="longtext")
    @TableField(value = "gerentizheng_content")

    private String gerentizhengContent;


    /**
     * 下次体检时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="下次体检时间",type="timestamp")
    @TableField(value = "gerentizheng_time")

    private Date gerentizhengTime;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "gerentizheng_delete")

    private Integer gerentizhengDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间   listShow
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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：当前身高
	 */
    public Double getGerentizhengNum() {
        return gerentizhengNum;
    }
    /**
	 * 设置：当前身高
	 */

    public void setGerentizhengNum(Double gerentizhengNum) {
        this.gerentizhengNum = gerentizhengNum;
    }
    /**
	 * 获取：当前体重
	 */
    public Double getTizhongNum() {
        return tizhongNum;
    }
    /**
	 * 设置：当前体重
	 */

    public void setTizhongNum(Double tizhongNum) {
        this.tizhongNum = tizhongNum;
    }
    /**
	 * 获取：身体状况
	 */
    public Integer getShentiTypes() {
        return shentiTypes;
    }
    /**
	 * 设置：身体状况
	 */

    public void setShentiTypes(Integer shentiTypes) {
        this.shentiTypes = shentiTypes;
    }
    /**
	 * 获取：饮食照片
	 */
    public String getMeishiPhoto() {
        return meishiPhoto;
    }
    /**
	 * 设置：饮食照片
	 */

    public void setMeishiPhoto(String meishiPhoto) {
        this.meishiPhoto = meishiPhoto;
    }
    /**
	 * 获取：备注
	 */
    public String getGerentizhengContent() {
        return gerentizhengContent;
    }
    /**
	 * 设置：备注
	 */

    public void setGerentizhengContent(String gerentizhengContent) {
        this.gerentizhengContent = gerentizhengContent;
    }
    /**
	 * 获取：下次体检时间
	 */
    public Date getGerentizhengTime() {
        return gerentizhengTime;
    }
    /**
	 * 设置：下次体检时间
	 */

    public void setGerentizhengTime(Date gerentizhengTime) {
        this.gerentizhengTime = gerentizhengTime;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getGerentizhengDelete() {
        return gerentizhengDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setGerentizhengDelete(Integer gerentizhengDelete) {
        this.gerentizhengDelete = gerentizhengDelete;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Gerentizheng{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", gerentizhengNum=" + gerentizhengNum +
            ", tizhongNum=" + tizhongNum +
            ", shentiTypes=" + shentiTypes +
            ", meishiPhoto=" + meishiPhoto +
            ", gerentizhengContent=" + gerentizhengContent +
            ", gerentizhengTime=" + DateUtil.convertString(gerentizhengTime,"yyyy-MM-dd") +
            ", gerentizhengDelete=" + gerentizhengDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
