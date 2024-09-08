package com.entity.vo;

import com.entity.GerentizhengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 体检记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gerentizheng")
public class GerentizhengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 当前身高
     */

    @TableField(value = "gerentizheng_num")
    private Double gerentizhengNum;


    /**
     * 当前体重
     */

    @TableField(value = "tizhong_num")
    private Double tizhongNum;


    /**
     * 身体状况
     */

    @TableField(value = "shenti_types")
    private Integer shentiTypes;


    /**
     * 饮食照片
     */

    @TableField(value = "meishi_photo")
    private String meishiPhoto;


    /**
     * 备注
     */

    @TableField(value = "gerentizheng_content")
    private String gerentizhengContent;


    /**
     * 下次体检时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "gerentizheng_time")
    private Date gerentizhengTime;


    /**
     * 逻辑删除
     */

    @TableField(value = "gerentizheng_delete")
    private Integer gerentizhengDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：当前身高
	 */
    public Double getGerentizhengNum() {
        return gerentizhengNum;
    }


    /**
	 * 获取：当前身高
	 */

    public void setGerentizhengNum(Double gerentizhengNum) {
        this.gerentizhengNum = gerentizhengNum;
    }
    /**
	 * 设置：当前体重
	 */
    public Double getTizhongNum() {
        return tizhongNum;
    }


    /**
	 * 获取：当前体重
	 */

    public void setTizhongNum(Double tizhongNum) {
        this.tizhongNum = tizhongNum;
    }
    /**
	 * 设置：身体状况
	 */
    public Integer getShentiTypes() {
        return shentiTypes;
    }


    /**
	 * 获取：身体状况
	 */

    public void setShentiTypes(Integer shentiTypes) {
        this.shentiTypes = shentiTypes;
    }
    /**
	 * 设置：饮食照片
	 */
    public String getMeishiPhoto() {
        return meishiPhoto;
    }


    /**
	 * 获取：饮食照片
	 */

    public void setMeishiPhoto(String meishiPhoto) {
        this.meishiPhoto = meishiPhoto;
    }
    /**
	 * 设置：备注
	 */
    public String getGerentizhengContent() {
        return gerentizhengContent;
    }


    /**
	 * 获取：备注
	 */

    public void setGerentizhengContent(String gerentizhengContent) {
        this.gerentizhengContent = gerentizhengContent;
    }
    /**
	 * 设置：下次体检时间
	 */
    public Date getGerentizhengTime() {
        return gerentizhengTime;
    }


    /**
	 * 获取：下次体检时间
	 */

    public void setGerentizhengTime(Date gerentizhengTime) {
        this.gerentizhengTime = gerentizhengTime;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getGerentizhengDelete() {
        return gerentizhengDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setGerentizhengDelete(Integer gerentizhengDelete) {
        this.gerentizhengDelete = gerentizhengDelete;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
