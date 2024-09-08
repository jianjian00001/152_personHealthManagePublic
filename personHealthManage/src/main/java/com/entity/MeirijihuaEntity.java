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
 * 每日计划
 *
 * @author 
 * @email
 */
@TableName("meirijihua")
public class MeirijihuaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MeirijihuaEntity() {

	}

	public MeirijihuaEntity(T t) {
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
     * 计划标题
     */
    @ColumnInfo(comment="计划标题",type="varchar(200)")
    @TableField(value = "meirijihua_name")

    private String meirijihuaName;


    /**
     * 饮食计划
     */
    @ColumnInfo(comment="饮食计划",type="longtext")
    @TableField(value = "yinshi_text")

    private String yinshiText;


    /**
     * 运动计划
     */
    @ColumnInfo(comment="运动计划",type="longtext")
    @TableField(value = "yundong_text")

    private String yundongText;


    /**
     * 药品计划
     */
    @ColumnInfo(comment="药品计划",type="longtext")
    @TableField(value = "yaopin_text")

    private String yaopinText;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="longtext")
    @TableField(value = "meirijihua_content")

    private String meirijihuaContent;


    /**
     * 计划时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="计划时间",type="timestamp")
    @TableField(value = "meirijihua_time")

    private Date meirijihuaTime;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "meirijihua_delete")

    private Integer meirijihuaDelete;


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
	 * 获取：计划标题
	 */
    public String getMeirijihuaName() {
        return meirijihuaName;
    }
    /**
	 * 设置：计划标题
	 */

    public void setMeirijihuaName(String meirijihuaName) {
        this.meirijihuaName = meirijihuaName;
    }
    /**
	 * 获取：饮食计划
	 */
    public String getYinshiText() {
        return yinshiText;
    }
    /**
	 * 设置：饮食计划
	 */

    public void setYinshiText(String yinshiText) {
        this.yinshiText = yinshiText;
    }
    /**
	 * 获取：运动计划
	 */
    public String getYundongText() {
        return yundongText;
    }
    /**
	 * 设置：运动计划
	 */

    public void setYundongText(String yundongText) {
        this.yundongText = yundongText;
    }
    /**
	 * 获取：药品计划
	 */
    public String getYaopinText() {
        return yaopinText;
    }
    /**
	 * 设置：药品计划
	 */

    public void setYaopinText(String yaopinText) {
        this.yaopinText = yaopinText;
    }
    /**
	 * 获取：备注
	 */
    public String getMeirijihuaContent() {
        return meirijihuaContent;
    }
    /**
	 * 设置：备注
	 */

    public void setMeirijihuaContent(String meirijihuaContent) {
        this.meirijihuaContent = meirijihuaContent;
    }
    /**
	 * 获取：计划时间
	 */
    public Date getMeirijihuaTime() {
        return meirijihuaTime;
    }
    /**
	 * 设置：计划时间
	 */

    public void setMeirijihuaTime(Date meirijihuaTime) {
        this.meirijihuaTime = meirijihuaTime;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getMeirijihuaDelete() {
        return meirijihuaDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setMeirijihuaDelete(Integer meirijihuaDelete) {
        this.meirijihuaDelete = meirijihuaDelete;
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
        return "Meirijihua{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", meirijihuaName=" + meirijihuaName +
            ", yinshiText=" + yinshiText +
            ", yundongText=" + yundongText +
            ", yaopinText=" + yaopinText +
            ", meirijihuaContent=" + meirijihuaContent +
            ", meirijihuaTime=" + DateUtil.convertString(meirijihuaTime,"yyyy-MM-dd") +
            ", meirijihuaDelete=" + meirijihuaDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
