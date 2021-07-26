package cn.cmaple.mainsver.service;

import cn.cmaple.mainsver.mapper.BasicMapper;
import cn.cmaple.mainsver.model.Basic;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BasicService
 * @Description: 基础服务类，用于处理官网相关无需登陆的相关服务
 * @author: CMAPLE
 * @date 2021/7/26 上午9:30
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@Service
public class BasicService extends ServiceImpl<BasicMapper, Basic> {

    /**
     * 引入BasicMapper
     */
    @Autowired
    private BasicMapper basicMapper;

    /**
     * @Title: getheadlineNews
     * @Description 主页头条位置信息获取函数，获取内容为：图片链接、标题文字、详细内容链接地址
     * @return Basic
     * @author CMAPLE
     * @date 2021/7/26 下午2:04
     */
    public Map<String, Object> getheadlineNews() throws Exception {
        //初始化返回结构体
        Map<String, Object> map = new HashMap<String, Object>();
        //初始化返回内容
        Basic re_basic = null;
        //查询获取首页展示内容
        List<Basic> basics = basicMapper.getheadlineNews();
        //判断获取集合是否为空否则可能导致程序异常
        //不为空则将首个内容赋予返回内容里
        if (!basics.isEmpty()){
            re_basic = basics.get(0);
            map.put("RTCODE", "success");
            map.put("RTMSG", "获取主页头条位置信息成功！");
            map.put("RTDATA", re_basic);
        }else {
            //这里需要增加全局异常，将问题记录在数据库中
            throw new Exception("获取主页头条位置信息无数据！");
        }
        //返回组装后的内容信息
        return map;
    }

}
