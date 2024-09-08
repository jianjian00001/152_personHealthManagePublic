package com.entity.model;

import com.entity.GerentizhengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 体检记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GerentizhengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 当前身高
     */
    private Double gerentizhengNum;


    /**
     * 当前体重
     */
    private Double tizhongNum;


    /**
     * 身体状况
     */
    private Integer shentiTypes;


    /**
     * 饮食照片
     */
    private String meishiPhoto;


    /**
     * 备注
     */
    private String gerentizhengContent;


    /**
     * 下次体检时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date gerentizhengTime;


    /**
     * 逻辑删除
     */
    private Integer gerentizhengDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
