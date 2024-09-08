package com.entity.vo;

import com.entity.YundongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 运动教程
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yundong")
public class YundongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 标题
     */

    @TableField(value = "yundong_name")
    private String yundongName;


    /**
     * 运动照片
     */

    @TableField(value = "yundong_photo")
    private String yundongPhoto;


    /**
     * 运动类型
     */

    @TableField(value = "yundong_types")
    private Integer yundongTypes;


    /**
     * 运动视频
     */

    @TableField(value = "yundong_video")
    private String yundongVideo;


    /**
     * 消耗热量
     */

    @TableField(value = "yundong_num")
    private Integer yundongNum;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 运动介绍
     */

    @TableField(value = "yundong_content")
    private String yundongContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "yundong_delete")
    private Integer yundongDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：标题
	 */
    public String getYundongName() {
        return yundongName;
    }


    /**
	 * 获取：标题
	 */

    public void setYundongName(String yundongName) {
        this.yundongName = yundongName;
    }
    /**
	 * 设置：运动照片
	 */
    public String getYundongPhoto() {
        return yundongPhoto;
    }


    /**
	 * 获取：运动照片
	 */

    public void setYundongPhoto(String yundongPhoto) {
        this.yundongPhoto = yundongPhoto;
    }
    /**
	 * 设置：运动类型
	 */
    public Integer getYundongTypes() {
        return yundongTypes;
    }


    /**
	 * 获取：运动类型
	 */

    public void setYundongTypes(Integer yundongTypes) {
        this.yundongTypes = yundongTypes;
    }
    /**
	 * 设置：运动视频
	 */
    public String getYundongVideo() {
        return yundongVideo;
    }


    /**
	 * 获取：运动视频
	 */

    public void setYundongVideo(String yundongVideo) {
        this.yundongVideo = yundongVideo;
    }
    /**
	 * 设置：消耗热量
	 */
    public Integer getYundongNum() {
        return yundongNum;
    }


    /**
	 * 获取：消耗热量
	 */

    public void setYundongNum(Integer yundongNum) {
        this.yundongNum = yundongNum;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：运动介绍
	 */
    public String getYundongContent() {
        return yundongContent;
    }


    /**
	 * 获取：运动介绍
	 */

    public void setYundongContent(String yundongContent) {
        this.yundongContent = yundongContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getYundongDelete() {
        return yundongDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setYundongDelete(Integer yundongDelete) {
        this.yundongDelete = yundongDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
