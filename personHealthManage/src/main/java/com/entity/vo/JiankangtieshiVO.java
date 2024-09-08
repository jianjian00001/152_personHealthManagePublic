package com.entity.vo;

import com.entity.JiankangtieshiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 健康贴士
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiankangtieshi")
public class JiankangtieshiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 贴士标题
     */

    @TableField(value = "jiankangtieshi_name")
    private String jiankangtieshiName;


    /**
     * 贴士类型
     */

    @TableField(value = "jiankangtieshi_types")
    private Integer jiankangtieshiTypes;


    /**
     * 贴士图片
     */

    @TableField(value = "jiankangtieshi_photo")
    private String jiankangtieshiPhoto;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 贴士详情
     */

    @TableField(value = "jiankangtieshi_content")
    private String jiankangtieshiContent;


    /**
     * 创建时间 show1 show2 nameShow
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
	 * 设置：贴士标题
	 */
    public String getJiankangtieshiName() {
        return jiankangtieshiName;
    }


    /**
	 * 获取：贴士标题
	 */

    public void setJiankangtieshiName(String jiankangtieshiName) {
        this.jiankangtieshiName = jiankangtieshiName;
    }
    /**
	 * 设置：贴士类型
	 */
    public Integer getJiankangtieshiTypes() {
        return jiankangtieshiTypes;
    }


    /**
	 * 获取：贴士类型
	 */

    public void setJiankangtieshiTypes(Integer jiankangtieshiTypes) {
        this.jiankangtieshiTypes = jiankangtieshiTypes;
    }
    /**
	 * 设置：贴士图片
	 */
    public String getJiankangtieshiPhoto() {
        return jiankangtieshiPhoto;
    }


    /**
	 * 获取：贴士图片
	 */

    public void setJiankangtieshiPhoto(String jiankangtieshiPhoto) {
        this.jiankangtieshiPhoto = jiankangtieshiPhoto;
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
	 * 设置：贴士详情
	 */
    public String getJiankangtieshiContent() {
        return jiankangtieshiContent;
    }


    /**
	 * 获取：贴士详情
	 */

    public void setJiankangtieshiContent(String jiankangtieshiContent) {
        this.jiankangtieshiContent = jiankangtieshiContent;
    }
    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
