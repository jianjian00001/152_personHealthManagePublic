package com.entity.model;

import com.entity.JiankangtieshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 健康贴士
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiankangtieshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 贴士标题
     */
    private String jiankangtieshiName;


    /**
     * 贴士类型
     */
    private Integer jiankangtieshiTypes;


    /**
     * 贴士图片
     */
    private String jiankangtieshiPhoto;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 贴士详情
     */
    private String jiankangtieshiContent;


    /**
     * 创建时间 show1 show2 nameShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
