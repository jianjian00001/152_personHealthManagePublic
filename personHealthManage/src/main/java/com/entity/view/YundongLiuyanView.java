package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YundongLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 运动教程留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yundong_liuyan")
public class YundongLiuyanView extends YundongLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;
	//级联表 运动教程
		/**
		* 标题
		*/

		@ColumnInfo(comment="标题",type="varchar(200)")
		private String yundongName;
		/**
		* 运动照片
		*/

		@ColumnInfo(comment="运动照片",type="varchar(200)")
		private String yundongPhoto;
		/**
		* 运动类型
		*/
		@ColumnInfo(comment="运动类型",type="int(11)")
		private Integer yundongTypes;
			/**
			* 运动类型的值
			*/
			@ColumnInfo(comment="运动类型的字典表值",type="varchar(200)")
			private String yundongValue;
		/**
		* 运动视频
		*/

		@ColumnInfo(comment="运动视频",type="varchar(200)")
		private String yundongVideo;
		/**
		* 消耗热量
		*/

		@ColumnInfo(comment="消耗热量",type="int(11)")
		private Integer yundongNum;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 运动介绍
		*/

		@ColumnInfo(comment="运动介绍",type="longtext")
		private String yundongContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yundongDelete;



	public YundongLiuyanView() {

	}

	public YundongLiuyanView(YundongLiuyanEntity yundongLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, yundongLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 联系方式
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}
	//级联表的get和set 运动教程

		/**
		* 获取： 标题
		*/
		public String getYundongName() {
			return yundongName;
		}
		/**
		* 设置： 标题
		*/
		public void setYundongName(String yundongName) {
			this.yundongName = yundongName;
		}

		/**
		* 获取： 运动照片
		*/
		public String getYundongPhoto() {
			return yundongPhoto;
		}
		/**
		* 设置： 运动照片
		*/
		public void setYundongPhoto(String yundongPhoto) {
			this.yundongPhoto = yundongPhoto;
		}
		/**
		* 获取： 运动类型
		*/
		public Integer getYundongTypes() {
			return yundongTypes;
		}
		/**
		* 设置： 运动类型
		*/
		public void setYundongTypes(Integer yundongTypes) {
			this.yundongTypes = yundongTypes;
		}


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

		/**
		* 获取： 运动视频
		*/
		public String getYundongVideo() {
			return yundongVideo;
		}
		/**
		* 设置： 运动视频
		*/
		public void setYundongVideo(String yundongVideo) {
			this.yundongVideo = yundongVideo;
		}

		/**
		* 获取： 消耗热量
		*/
		public Integer getYundongNum() {
			return yundongNum;
		}
		/**
		* 设置： 消耗热量
		*/
		public void setYundongNum(Integer yundongNum) {
			this.yundongNum = yundongNum;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}

		/**
		* 获取： 运动介绍
		*/
		public String getYundongContent() {
			return yundongContent;
		}
		/**
		* 设置： 运动介绍
		*/
		public void setYundongContent(String yundongContent) {
			this.yundongContent = yundongContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYundongDelete() {
			return yundongDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYundongDelete(Integer yundongDelete) {
			this.yundongDelete = yundongDelete;
		}


	@Override
	public String toString() {
		return "YundongLiuyanView{" +
			", yundongName=" + yundongName +
			", yundongPhoto=" + yundongPhoto +
			", yundongVideo=" + yundongVideo +
			", yundongNum=" + yundongNum +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", yundongContent=" + yundongContent +
			", yundongDelete=" + yundongDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhone=" + yonghuPhone +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
