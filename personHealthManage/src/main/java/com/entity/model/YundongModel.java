package com.entity.model;

import com.entity.YundongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 运动教程
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YundongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String yundongName;


    /**
     * 运动照片
     */
    private String yundongPhoto;


    /**
     * 运动类型
     */
    private Integer yundongTypes;


    /**
     * 运动视频
     */
    private String yundongVideo;


    /**
     * 消耗热量
     */
    private Integer yundongNum;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 运动介绍
     */
    private String yundongContent;


    /**
     * 逻辑删除
     */
    private Integer yundongDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
