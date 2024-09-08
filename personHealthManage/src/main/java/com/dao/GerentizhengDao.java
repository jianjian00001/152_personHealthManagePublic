package com.dao;

import com.entity.GerentizhengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GerentizhengView;

/**
 * 体检记录 Dao 接口
 *
 * @author 
 */
public interface GerentizhengDao extends BaseMapper<GerentizhengEntity> {

   List<GerentizhengView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
