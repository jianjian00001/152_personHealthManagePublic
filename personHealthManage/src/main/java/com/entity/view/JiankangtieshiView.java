package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiankangtieshiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 健康贴士
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiankangtieshi")
public class JiankangtieshiView extends JiankangtieshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 贴士类型的值
	*/
	@ColumnInfo(comment="贴士类型的字典表值",type="varchar(200)")
	private String jiankangtieshiValue;




	public JiankangtieshiView() {

	}

	public JiankangtieshiView(JiankangtieshiEntity jiankangtieshiEntity) {
		try {
			BeanUtils.copyProperties(this, jiankangtieshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 贴士类型的值
	*/
	public String getJiankangtieshiValue() {
		return jiankangtieshiValue;
	}
	/**
	* 设置： 贴士类型的值
	*/
	public void setJiankangtieshiValue(String jiankangtieshiValue) {
		this.jiankangtieshiValue = jiankangtieshiValue;
	}




	@Override
	public String toString() {
		return "JiankangtieshiView{" +
			", jiankangtieshiValue=" + jiankangtieshiValue +
			"} " + super.toString();
	}
}
