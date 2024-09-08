package com.entity.vo;

import com.entity.MeirijihuaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 每日计划
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("meirijihua")
public class MeirijihuaVO implements Serializable {
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
     * 计划标题
     */

    @TableField(value = "meirijihua_name")
    private String meirijihuaName;


    /**
     * 饮食计划
     */

    @TableField(value = "yinshi_text")
    private String yinshiText;


    /**
     * 运动计划
     */

    @TableField(value = "yundong_text")
    private String yundongText;


    /**
     * 药品计划
     */

    @TableField(value = "yaopin_text")
    private String yaopinText;


    /**
     * 备注
     */

    @TableField(value = "meirijihua_content")
    private String meirijihuaContent;


    /**
     * 计划时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "meirijihua_time")
    private Date meirijihuaTime;


    /**
     * 逻辑删除
     */

    @TableField(value = "meirijihua_delete")
    private Integer meirijihuaDelete;


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
	 * 设置：计划标题
	 */
    public String getMeirijihuaName() {
        return meirijihuaName;
    }


    /**
	 * 获取：计划标题
	 */

    public void setMeirijihuaName(String meirijihuaName) {
        this.meirijihuaName = meirijihuaName;
    }
    /**
	 * 设置：饮食计划
	 */
    public String getYinshiText() {
        return yinshiText;
    }


    /**
	 * 获取：饮食计划
	 */

    public void setYinshiText(String yinshiText) {
        this.yinshiText = yinshiText;
    }
    /**
	 * 设置：运动计划
	 */
    public String getYundongText() {
        return yundongText;
    }


    /**
	 * 获取：运动计划
	 */

    public void setYundongText(String yundongText) {
        this.yundongText = yundongText;
    }
    /**
	 * 设置：药品计划
	 */
    public String getYaopinText() {
        return yaopinText;
    }


    /**
	 * 获取：药品计划
	 */

    public void setYaopinText(String yaopinText) {
        this.yaopinText = yaopinText;
    }
    /**
	 * 设置：备注
	 */
    public String getMeirijihuaContent() {
        return meirijihuaContent;
    }


    /**
	 * 获取：备注
	 */

    public void setMeirijihuaContent(String meirijihuaContent) {
        this.meirijihuaContent = meirijihuaContent;
    }
    /**
	 * 设置：计划时间
	 */
    public Date getMeirijihuaTime() {
        return meirijihuaTime;
    }


    /**
	 * 获取：计划时间
	 */

    public void setMeirijihuaTime(Date meirijihuaTime) {
        this.meirijihuaTime = meirijihuaTime;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getMeirijihuaDelete() {
        return meirijihuaDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setMeirijihuaDelete(Integer meirijihuaDelete) {
        this.meirijihuaDelete = meirijihuaDelete;
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
