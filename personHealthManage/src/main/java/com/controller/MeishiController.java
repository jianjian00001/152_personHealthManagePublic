
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
 * 健康食谱
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/meishi")
public class MeishiController {
    private static final Logger logger = LoggerFactory.getLogger(MeishiController.class);

    private static final String TABLE_NAME = "meishi";

    @Autowired
    private MeishiService meishiService;


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
    private YundongService yundongService;//运动教程
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
        params.put("meishiDeleteStart",1);params.put("meishiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = meishiService.queryPage(params);

        //字典表数据转换
        List<MeishiView> list =(List<MeishiView>)page.getList();
        for(MeishiView c:list){
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
        MeishiEntity meishi = meishiService.selectById(id);
        if(meishi !=null){
            //entity转view
            MeishiView view = new MeishiView();
            BeanUtils.copyProperties( meishi , view );//把实体数据重构到view中
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
    public R save(@RequestBody MeishiEntity meishi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,meishi:{}",this.getClass().getName(),meishi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<MeishiEntity> queryWrapper = new EntityWrapper<MeishiEntity>()
            .eq("meishi_name", meishi.getMeishiName())
            .eq("meishi_types", meishi.getMeishiTypes())
            .eq("meishi_num", meishi.getMeishiNum())
            .eq("zan_number", meishi.getZanNumber())
            .eq("cai_number", meishi.getCaiNumber())
            .eq("meishi_delete", meishi.getMeishiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MeishiEntity meishiEntity = meishiService.selectOne(queryWrapper);
        if(meishiEntity==null){
            meishi.setMeishiDelete(1);
            meishi.setInsertTime(new Date());
            meishi.setCreateTime(new Date());
            meishiService.insert(meishi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MeishiEntity meishi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,meishi:{}",this.getClass().getName(),meishi.toString());
        MeishiEntity oldMeishiEntity = meishiService.selectById(meishi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(meishi.getMeishiPhoto()) || "null".equals(meishi.getMeishiPhoto())){
                meishi.setMeishiPhoto(null);
        }

            meishiService.updateById(meishi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<MeishiEntity> oldMeishiList =meishiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<MeishiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            MeishiEntity meishiEntity = new MeishiEntity();
            meishiEntity.setId(id);
            meishiEntity.setMeishiDelete(2);
            list.add(meishiEntity);
        }
        if(list != null && list.size() >0){
            meishiService.updateBatchById(list);
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
            List<MeishiEntity> meishiList = new ArrayList<>();//上传的东西
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
                            MeishiEntity meishiEntity = new MeishiEntity();
//                            meishiEntity.setMeishiName(data.get(0));                    //食谱标题 要改的
//                            meishiEntity.setMeishiPhoto("");//详情和图片
//                            meishiEntity.setMeishiTypes(Integer.valueOf(data.get(0)));   //食谱类型 要改的
//                            meishiEntity.setMeishiNum(Integer.valueOf(data.get(0)));   //所含热量 要改的
//                            meishiEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            meishiEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            meishiEntity.setMeishiContent("");//详情和图片
//                            meishiEntity.setMeishiDelete(1);//逻辑删除字段
//                            meishiEntity.setInsertTime(date);//时间
//                            meishiEntity.setCreateTime(date);//时间
                            meishiList.add(meishiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        meishiService.insertBatch(meishiList);
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
        List<MeishiView> returnMeishiViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = meishiCollectionService.queryPage(params1);
        List<MeishiCollectionView> collectionViewsList =(List<MeishiCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(MeishiCollectionView collectionView:collectionViewsList){
            Integer meishiTypes = collectionView.getMeishiTypes();
            if(typeMap.containsKey(meishiTypes)){
                typeMap.put(meishiTypes,typeMap.get(meishiTypes)+1);
            }else{
                typeMap.put(meishiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("meishiTypes",type);
            PageUtils pageUtils1 = meishiService.queryPage(params2);
            List<MeishiView> meishiViewList =(List<MeishiView>)pageUtils1.getList();
            returnMeishiViewList.addAll(meishiViewList);
            if(returnMeishiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = meishiService.queryPage(params);
        if(returnMeishiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnMeishiViewList.size();//要添加的数量
            List<MeishiView> meishiViewList =(List<MeishiView>)page.getList();
            for(MeishiView meishiView:meishiViewList){
                Boolean addFlag = true;
                for(MeishiView returnMeishiView:returnMeishiViewList){
                    if(returnMeishiView.getId().intValue() ==meishiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnMeishiViewList.add(meishiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnMeishiViewList = returnMeishiViewList.subList(0, limit);
        }

        for(MeishiView c:returnMeishiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnMeishiViewList);
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
        PageUtils page = meishiService.queryPage(params);

        //字典表数据转换
        List<MeishiView> list =(List<MeishiView>)page.getList();
        for(MeishiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MeishiEntity meishi = meishiService.selectById(id);
            if(meishi !=null){


                //entity转view
                MeishiView view = new MeishiView();
                BeanUtils.copyProperties( meishi , view );//把实体数据重构到view中

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
    public R add(@RequestBody MeishiEntity meishi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,meishi:{}",this.getClass().getName(),meishi.toString());
        Wrapper<MeishiEntity> queryWrapper = new EntityWrapper<MeishiEntity>()
            .eq("meishi_name", meishi.getMeishiName())
            .eq("meishi_types", meishi.getMeishiTypes())
            .eq("meishi_num", meishi.getMeishiNum())
            .eq("zan_number", meishi.getZanNumber())
            .eq("cai_number", meishi.getCaiNumber())
            .eq("meishi_delete", meishi.getMeishiDelete())
//            .notIn("meishi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MeishiEntity meishiEntity = meishiService.selectOne(queryWrapper);
        if(meishiEntity==null){
                meishi.setZanNumber(1);
                meishi.setCaiNumber(1);
            meishi.setMeishiDelete(1);
            meishi.setInsertTime(new Date());
            meishi.setCreateTime(new Date());
        meishiService.insert(meishi);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

