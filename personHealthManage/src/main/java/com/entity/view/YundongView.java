package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YundongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 运动教程
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yundong")
public class YundongView extends YundongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 运动类型的值
	*/
	@ColumnInfo(comment="运动类型的字典表值",type="varchar(200)")
	private String yundongValue;




	public YundongView() {

	}

	public YundongView(YundongEntity yundongEntity) {
		try {
			BeanUtils.copyProperties(this, yundongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 运动类型的值
	*/
	public String getYundongValue() {
		return yundongValue;
	}
	/**
	* 设置： 运动类型的值
	*/
	public void setYundongValue(String yundongValue) {
		this.yundongValue = yundongValue;
	}




	@Override
	public String toString() {
		return "YundongView{" +
			", yundongValue=" + yundongValue +
			"} " + super.toString();
	}
}
