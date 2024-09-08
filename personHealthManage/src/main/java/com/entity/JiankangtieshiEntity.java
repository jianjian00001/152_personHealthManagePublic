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
 * 健康贴士
 *
 * @author 
 * @email
 */
@TableName("jiankangtieshi")
public class JiankangtieshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiankangtieshiEntity() {

	}

	public JiankangtieshiEntity(T t) {
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
     * 贴士标题
     */
    @ColumnInfo(comment="贴士标题",type="varchar(200)")
    @TableField(value = "jiankangtieshi_name")

    private String jiankangtieshiName;


    /**
     * 贴士类型
     */
    @ColumnInfo(comment="贴士类型",type="int(11)")
    @TableField(value = "jiankangtieshi_types")

    private Integer jiankangtieshiTypes;


    /**
     * 贴士图片
     */
    @ColumnInfo(comment="贴士图片",type="varchar(200)")
    @TableField(value = "jiankangtieshi_photo")

    private String jiankangtieshiPhoto;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 贴士详情
     */
    @ColumnInfo(comment="贴士详情",type="longtext")
    @TableField(value = "jiankangtieshi_content")

    private String jiankangtieshiContent;


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
	 * 获取：贴士标题
	 */
    public String getJiankangtieshiName() {
        return jiankangtieshiName;
    }
    /**
	 * 设置：贴士标题
	 */

    public void setJiankangtieshiName(String jiankangtieshiName) {
        this.jiankangtieshiName = jiankangtieshiName;
    }
    /**
	 * 获取：贴士类型
	 */
    public Integer getJiankangtieshiTypes() {
        return jiankangtieshiTypes;
    }
    /**
	 * 设置：贴士类型
	 */

    public void setJiankangtieshiTypes(Integer jiankangtieshiTypes) {
        this.jiankangtieshiTypes = jiankangtieshiTypes;
    }
    /**
	 * 获取：贴士图片
	 */
    public String getJiankangtieshiPhoto() {
        return jiankangtieshiPhoto;
    }
    /**
	 * 设置：贴士图片
	 */

    public void setJiankangtieshiPhoto(String jiankangtieshiPhoto) {
        this.jiankangtieshiPhoto = jiankangtieshiPhoto;
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
	 * 获取：贴士详情
	 */
    public String getJiankangtieshiContent() {
        return jiankangtieshiContent;
    }
    /**
	 * 设置：贴士详情
	 */

    public void setJiankangtieshiContent(String jiankangtieshiContent) {
        this.jiankangtieshiContent = jiankangtieshiContent;
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
        return "Jiankangtieshi{" +
            ", id=" + id +
            ", jiankangtieshiName=" + jiankangtieshiName +
            ", jiankangtieshiTypes=" + jiankangtieshiTypes +
            ", jiankangtieshiPhoto=" + jiankangtieshiPhoto +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", jiankangtieshiContent=" + jiankangtieshiContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
