
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
 * 体检记录
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gerentizheng")
public class GerentizhengController {
    private static final Logger logger = LoggerFactory.getLogger(GerentizhengController.class);

    private static final String TABLE_NAME = "gerentizheng";

    @Autowired
    private GerentizhengService gerentizhengService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
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
        params.put("gerentizhengDeleteStart",1);params.put("gerentizhengDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = gerentizhengService.queryPage(params);

        //字典表数据转换
        List<GerentizhengView> list =(List<GerentizhengView>)page.getList();
        for(GerentizhengView c:list){
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
        GerentizhengEntity gerentizheng = gerentizhengService.selectById(id);
        if(gerentizheng !=null){
            //entity转view
            GerentizhengView view = new GerentizhengView();
            BeanUtils.copyProperties( gerentizheng , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(gerentizheng.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody GerentizhengEntity gerentizheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gerentizheng:{}",this.getClass().getName(),gerentizheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            gerentizheng.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        if(gerentizheng.getTizhongNum() != null && gerentizheng.getGerentizhengNum() != null){
            double v = gerentizheng.getTizhongNum() / (gerentizheng.getGerentizhengNum() * gerentizheng.getGerentizhengNum());
            if(v <= 18.4){//消瘦
                gerentizheng.setShentiTypes(1);
            }else if(v>=18.5 && v<=23.9){
                gerentizheng.setShentiTypes(2);
            }else if(v>=24 && v<=27.9){
                gerentizheng.setShentiTypes(3);
            }else{
                gerentizheng.setShentiTypes(4);
            }
        }
        gerentizheng.setGerentizhengDelete(1);
        gerentizheng.setInsertTime(new Date());
            gerentizheng.setCreateTime(new Date());
            gerentizhengService.insert(gerentizheng);
            return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GerentizhengEntity gerentizheng, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,gerentizheng:{}",this.getClass().getName(),gerentizheng.toString());
        GerentizhengEntity oldGerentizhengEntity = gerentizhengService.selectById(gerentizheng.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            gerentizheng.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(gerentizheng.getMeishiPhoto()) || "null".equals(gerentizheng.getMeishiPhoto())){
                gerentizheng.setMeishiPhoto(null);
        }

            gerentizhengService.updateById(gerentizheng);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<GerentizhengEntity> oldGerentizhengList =gerentizhengService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<GerentizhengEntity> list = new ArrayList<>();
        for(Integer id:ids){
            GerentizhengEntity gerentizhengEntity = new GerentizhengEntity();
            gerentizhengEntity.setId(id);
            gerentizhengEntity.setGerentizhengDelete(2);
            list.add(gerentizhengEntity);
        }
        if(list != null && list.size() >0){
            gerentizhengService.updateBatchById(list);
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
            List<GerentizhengEntity> gerentizhengList = new ArrayList<>();//上传的东西
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
                            GerentizhengEntity gerentizhengEntity = new GerentizhengEntity();
//                            gerentizhengEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            gerentizhengEntity.setGerentizhengNum(data.get(0));                    //当前身高 要改的
//                            gerentizhengEntity.setTizhongNum(data.get(0));                    //当前体重 要改的
//                            gerentizhengEntity.setShentiTypes(Integer.valueOf(data.get(0)));   //身体状况 要改的
//                            gerentizhengEntity.setMeishiPhoto("");//详情和图片
//                            gerentizhengEntity.setGerentizhengContent("");//详情和图片
//                            gerentizhengEntity.setGerentizhengTime(sdf.parse(data.get(0)));          //下次体检时间 要改的
//                            gerentizhengEntity.setGerentizhengDelete(1);//逻辑删除字段
//                            gerentizhengEntity.setInsertTime(date);//时间
//                            gerentizhengEntity.setCreateTime(date);//时间
                            gerentizhengList.add(gerentizhengEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        gerentizhengService.insertBatch(gerentizhengList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = gerentizhengService.queryPage(params);

        //字典表数据转换
        List<GerentizhengView> list =(List<GerentizhengView>)page.getList();
        for(GerentizhengView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GerentizhengEntity gerentizheng = gerentizhengService.selectById(id);
            if(gerentizheng !=null){


                //entity转view
                GerentizhengView view = new GerentizhengView();
                BeanUtils.copyProperties( gerentizheng , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(gerentizheng.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R add(@RequestBody GerentizhengEntity gerentizheng, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,gerentizheng:{}",this.getClass().getName(),gerentizheng.toString());
        Wrapper<GerentizhengEntity> queryWrapper = new EntityWrapper<GerentizhengEntity>()
            .eq("yonghu_id", gerentizheng.getYonghuId())
            .eq("shenti_types", gerentizheng.getShentiTypes())
            .eq("gerentizheng_delete", gerentizheng.getGerentizhengDelete())
//            .notIn("gerentizheng_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GerentizhengEntity gerentizhengEntity = gerentizhengService.selectOne(queryWrapper);
        if(gerentizhengEntity==null){
            gerentizheng.setGerentizhengDelete(1);
            gerentizheng.setInsertTime(new Date());
            gerentizheng.setCreateTime(new Date());
        gerentizhengService.insert(gerentizheng);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

