package com.dao;

import com.entity.YundongCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YundongCollectionView;

/**
 * 运动教程收藏 Dao 接口
 *
 * @author 
 */
public interface YundongCollectionDao extends BaseMapper<YundongCollectionEntity> {

   List<YundongCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
