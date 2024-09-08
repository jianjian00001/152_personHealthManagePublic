package com.dao;

import com.entity.YundongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YundongView;

/**
 * 运动教程 Dao 接口
 *
 * @author 
 */
public interface YundongDao extends BaseMapper<YundongEntity> {

   List<YundongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
