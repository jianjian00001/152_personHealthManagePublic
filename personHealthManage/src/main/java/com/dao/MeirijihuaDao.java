package com.dao;

import com.entity.MeirijihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MeirijihuaView;

/**
 * 每日计划 Dao 接口
 *
 * @author 
 */
public interface MeirijihuaDao extends BaseMapper<MeirijihuaEntity> {

   List<MeirijihuaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
