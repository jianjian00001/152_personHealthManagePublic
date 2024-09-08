
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 运动教程
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yundong")
public class YundongController {
    private static final Logger logger = LoggerFactory.getLogger(YundongController.class);

    private static final String TABLE_NAME = "yundong";

    @Autowired
    private YundongService yundongService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GerentizhengService gerentizhengService;//体检记录
    @Autowired
    private JiankangtieshiService jiankangtieshiService;//健康贴士
    @Autowired
    private MeirijihuaService meirijihuaService;//每日计划
    @Autowired
    private MeishiService meishiService;//健康食谱
    @Autowired
    private MeishiCollectionService meishiCollectionService;//健康食谱收藏
    @Autowired
    private MeishiLiuyanService meishiLiuyanService;//健康食谱留言
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private YaopinService yaopinService;//药品信息
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private YundongCollectionService yundongCollectionService;//运动教程收藏
    @Autowired
    private YundongLiuyanService yundongLiuyanService;//运动教程留言
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("yundongDeleteStart",1);params.put("yundongDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = yundongService.queryPage(params);

        //字典表数据转换
        List<YundongView> list =(List<YundongView>)page.getList();
        for(YundongView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YundongEntity yundong = yundongService.selectById(id);
        if(yundong !=null){
            //entity转view
            YundongView view = new YundongView();
            BeanUtils.copyProperties( yundong , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YundongEntity yundong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yundong:{}",this.getClass().getName(),yundong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YundongEntity> queryWrapper = new EntityWrapper<YundongEntity>()
            .eq("yundong_name", yundong.getYundongName())
            .eq("yundong_types", yundong.getYundongTypes())
            .eq("yundong_video", yundong.getYundongVideo())
            .eq("yundong_num", yundong.getYundongNum())
            .eq("zan_number", yundong.getZanNumber())
            .eq("cai_number", yundong.getCaiNumber())
            .eq("yundong_delete", yundong.getYundongDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YundongEntity yundongEntity = yundongService.selectOne(queryWrapper);
        if(yundongEntity==null){
            yundong.setYundongDelete(1);
            yundong.setInsertTime(new Date());
            yundong.setCreateTime(new Date());
            yundongService.insert(yundong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YundongEntity yundong, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yundong:{}",this.getClass().getName(),yundong.toString());
        YundongEntity oldYundongEntity = yundongService.selectById(yundong.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(yundong.getYundongPhoto()) || "null".equals(yundong.getYundongPhoto())){
                yundong.setYundongPhoto(null);
        }
        if("".equals(yundong.getYundongVideo()) || "null".equals(yundong.getYundongVideo())){
                yundong.setYundongVideo(null);
        }

            yundongService.updateById(yundong);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YundongEntity> oldYundongList =yundongService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<YundongEntity> list = new ArrayList<>();
        for(Integer id:ids){
            YundongEntity yundongEntity = new YundongEntity();
            yundongEntity.setId(id);
            yundongEntity.setYundongDelete(2);
            list.add(yundongEntity);
        }
        if(list != null && list.size() >0){
            yundongService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<YundongEntity> yundongList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YundongEntity yundongEntity = new YundongEntity();
//                            yundongEntity.setYundongName(data.get(0));                    //标题 要改的
//                            yundongEntity.setYundongPhoto("");//详情和图片
//                            yundongEntity.setYundongTypes(Integer.valueOf(data.get(0)));   //运动类型 要改的
//                            yundongEntity.setYundongVideo(data.get(0));                    //运动视频 要改的
//                            yundongEntity.setYundongNum(Integer.valueOf(data.get(0)));   //消耗热量 要改的
//                            yundongEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            yundongEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            yundongEntity.setYundongContent("");//详情和图片
//                            yundongEntity.setYundongDelete(1);//逻辑删除字段
//                            yundongEntity.setInsertTime(date);//时间
//                            yundongEntity.setCreateTime(date);//时间
                            yundongList.add(yundongEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yundongService.insertBatch(yundongList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<YundongView> returnYundongViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = yundongCollectionService.queryPage(params1);
        List<YundongCollectionView> collectionViewsList =(List<YundongCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(YundongCollectionView collectionView:collectionViewsList){
            Integer yundongTypes = collectionView.getYundongTypes();
            if(typeMap.containsKey(yundongTypes)){
                typeMap.put(yundongTypes,typeMap.get(yundongTypes)+1);
            }else{
                typeMap.put(yundongTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("yundongTypes",type);
            PageUtils pageUtils1 = yundongService.queryPage(params2);
            List<YundongView> yundongViewList =(List<YundongView>)pageUtils1.getList();
            returnYundongViewList.addAll(yundongViewList);
            if(returnYundongViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = yundongService.queryPage(params);
        if(returnYundongViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnYundongViewList.size();//要添加的数量
            List<YundongView> yundongViewList =(List<YundongView>)page.getList();
            for(YundongView yundongView:yundongViewList){
                Boolean addFlag = true;
                for(YundongView returnYundongView:returnYundongViewList){
                    if(returnYundongView.getId().intValue() ==yundongView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnYundongViewList.add(yundongView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnYundongViewList = returnYundongViewList.subList(0, limit);
        }

        for(YundongView c:returnYundongViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnYundongViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = yundongService.queryPage(params);

        //字典表数据转换
        List<YundongView> list =(List<YundongView>)page.getList();
        for(YundongView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YundongEntity yundong = yundongService.selectById(id);
            if(yundong !=null){


                //entity转view
                YundongView view = new YundongView();
                BeanUtils.copyProperties( yundong , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody YundongEntity yundong, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yundong:{}",this.getClass().getName(),yundong.toString());
        Wrapper<YundongEntity> queryWrapper = new EntityWrapper<YundongEntity>()
            .eq("yundong_name", yundong.getYundongName())
            .eq("yundong_types", yundong.getYundongTypes())
            .eq("yundong_video", yundong.getYundongVideo())
            .eq("yundong_num", yundong.getYundongNum())
            .eq("zan_number", yundong.getZanNumber())
            .eq("cai_number", yundong.getCaiNumber())
            .eq("yundong_delete", yundong.getYundongDelete())
//            .notIn("yundong_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YundongEntity yundongEntity = yundongService.selectOne(queryWrapper);
        if(yundongEntity==null){
                yundong.setZanNumber(1);
                yundong.setCaiNumber(1);
            yundong.setYundongDelete(1);
            yundong.setInsertTime(new Date());
            yundong.setCreateTime(new Date());
        yundongService.insert(yundong);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

