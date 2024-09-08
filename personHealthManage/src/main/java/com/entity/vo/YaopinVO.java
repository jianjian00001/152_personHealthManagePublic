package com.entity.vo;

import com.entity.YaopinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 药品信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yaopin")
public class YaopinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 药品名称
     */

    @TableField(value = "yaopin_name")
    private String yaopinName;


    /**
     * 药品照片
     */

    @TableField(value = "yaopin_photo")
    private String yaopinPhoto;


    /**
     * 药品类型
     */

    @TableField(value = "yaopin_types")
    private Integer yaopinTypes;


    /**
     * 药品作用
     */

    @TableField(value = "yaopin_zuoyng")
    private String yaopinZuoyng;


    /**
     * 药品成分
     */

    @TableField(value = "yaopin_chengfen")
    private String yaopinChengfen;


    /**
     * 药品详情
     */

    @TableField(value = "yaopin_content")
    private String yaopinContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "yaopin_delete")
    private Integer yaopinDelete;


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
	 * 设置：药品名称
	 */
    public String getYaopinName() {
        return yaopinName;
    }


    /**
	 * 获取：药品名称
	 */

    public void setYaopinName(String yaopinName) {
        this.yaopinName = yaopinName;
    }
    /**
	 * 设置：药品照片
	 */
    public String getYaopinPhoto() {
        return yaopinPhoto;
    }


    /**
	 * 获取：药品照片
	 */

    public void setYaopinPhoto(String yaopinPhoto) {
        this.yaopinPhoto = yaopinPhoto;
    }
    /**
	 * 设置：药品类型
	 */
    public Integer getYaopinTypes() {
        return yaopinTypes;
    }


    /**
	 * 获取：药品类型
	 */

    public void setYaopinTypes(Integer yaopinTypes) {
        this.yaopinTypes = yaopinTypes;
    }
    /**
	 * 设置：药品作用
	 */
    public String getYaopinZuoyng() {
        return yaopinZuoyng;
    }


    /**
	 * 获取：药品作用
	 */

    public void setYaopinZuoyng(String yaopinZuoyng) {
        this.yaopinZuoyng = yaopinZuoyng;
    }
    /**
	 * 设置：药品成分
	 */
    public String getYaopinChengfen() {
        return yaopinChengfen;
    }


    /**
	 * 获取：药品成分
	 */

    public void setYaopinChengfen(String yaopinChengfen) {
        this.yaopinChengfen = yaopinChengfen;
    }
    /**
	 * 设置：药品详情
	 */
    public String getYaopinContent() {
        return yaopinContent;
    }


    /**
	 * 获取：药品详情
	 */

    public void setYaopinContent(String yaopinContent) {
        this.yaopinContent = yaopinContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getYaopinDelete() {
        return yaopinDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setYaopinDelete(Integer yaopinDelete) {
        this.yaopinDelete = yaopinDelete;
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
