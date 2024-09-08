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
 * 健康食谱
 *
 * @author 
 * @email
 */
@TableName("meishi")
public class MeishiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MeishiEntity() {

	}

	public MeishiEntity(T t) {
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
     * 食谱标题
     */
    @ColumnInfo(comment="食谱标题",type="varchar(200)")
    @TableField(value = "meishi_name")

    private String meishiName;


    /**
     * 食谱照片
     */
    @ColumnInfo(comment="食谱照片",type="varchar(200)")
    @TableField(value = "meishi_photo")

    private String meishiPhoto;


    /**
     * 食谱类型
     */
    @ColumnInfo(comment="食谱类型",type="int(11)")
    @TableField(value = "meishi_types")

    private Integer meishiTypes;


    /**
     * 所含热量
     */
    @ColumnInfo(comment="所含热量",type="int(11)")
    @TableField(value = "meishi_num")

    private Integer meishiNum;


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
     * 制作教程
     */
    @ColumnInfo(comment="制作教程",type="longtext")
    @TableField(value = "meishi_content")

    private String meishiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "meishi_delete")

    private Integer meishiDelete;


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
	 * 获取：食谱标题
	 */
    public String getMeishiName() {
        return meishiName;
    }
    /**
	 * 设置：食谱标题
	 */

    public void setMeishiName(String meishiName) {
        this.meishiName = meishiName;
    }
    /**
	 * 获取：食谱照片
	 */
    public String getMeishiPhoto() {
        return meishiPhoto;
    }
    /**
	 * 设置：食谱照片
	 */

    public void setMeishiPhoto(String meishiPhoto) {
        this.meishiPhoto = meishiPhoto;
    }
    /**
	 * 获取：食谱类型
	 */
    public Integer getMeishiTypes() {
        return meishiTypes;
    }
    /**
	 * 设置：食谱类型
	 */

    public void setMeishiTypes(Integer meishiTypes) {
        this.meishiTypes = meishiTypes;
    }
    /**
	 * 获取：所含热量
	 */
    public Integer getMeishiNum() {
        return meishiNum;
    }
    /**
	 * 设置：所含热量
	 */

    public void setMeishiNum(Integer meishiNum) {
        this.meishiNum = meishiNum;
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
	 * 获取：制作教程
	 */
    public String getMeishiContent() {
        return meishiContent;
    }
    /**
	 * 设置：制作教程
	 */

    public void setMeishiContent(String meishiContent) {
        this.meishiContent = meishiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getMeishiDelete() {
        return meishiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setMeishiDelete(Integer meishiDelete) {
        this.meishiDelete = meishiDelete;
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
        return "Meishi{" +
            ", id=" + id +
            ", meishiName=" + meishiName +
            ", meishiPhoto=" + meishiPhoto +
            ", meishiTypes=" + meishiTypes +
            ", meishiNum=" + meishiNum +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", meishiContent=" + meishiContent +
            ", meishiDelete=" + meishiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
