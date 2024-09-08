package com.dao;

import com.entity.JiankangtieshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiankangtieshiView;

/**
 * 健康贴士 Dao 接口
 *
 * @author 
 */
public interface JiankangtieshiDao extends BaseMapper<JiankangtieshiEntity> {

   List<JiankangtieshiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
