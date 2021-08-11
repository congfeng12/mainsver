package cn.cmaple.mainsver.service;

import cn.cmaple.mainsver.mapper.BasicMapper;
import cn.cmaple.mainsver.model.About;
import cn.cmaple.mainsver.model.Basic;
import cn.cmaple.mainsver.model.Cases;
import cn.cmaple.mainsver.model.Programs;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
     * @return Map<String, Object>
     * @author CMAPLE
     * @date 2021/7/26 下午2:04
     */
    public Map<String, Object> selectheadlineNews() throws Exception {
        //初始化返回结构体
        Map<String, Object> map = new HashMap<String, Object>();
        //初始化返回内容
        Basic re_basic = null;
        //查询获取首页展示内容
        List<Basic> basics = basicMapper.selectheadlineNews();
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

    /**
     * @Title: getContributionInfo
     * @Description 关于页面团队贡献等信息获取函数，获取内容：管理团队、合作贡献、投资等内容信息
     * @return Map<String, Object>
     * @throws Exception
     * @author CMAPLE
     * @date 2021/8/11 下午1:25
     */
    public Map<String, Object> selectContributionInfo() throws Exception {
        //初始化返回结构体
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> re_map = new HashMap<String, Object>();
        //管理团队
        List<About> teams = new ArrayList<About>();
        //合作贡献
        List<About> contributions = new ArrayList<About>();
        //赞助
        List<About> investments = new ArrayList<About>();
        //获取所有内容信息
        List<About> abouts =  basicMapper.selectContributionInfo();
        //判断获取内容是否为空
        if (abouts.isEmpty()){
            throw new Exception("获取团队贡献信息无数据！");
        }
        //讲信息分类整理
        for (About a : abouts){
            if (1 == a.getType()){
                teams.add(a);
            } else if (1 == a.getType()){
                contributions.add(a);
            } else {
                investments.add(a);
            }
        }
        re_map.put("teams",teams);
        re_map.put("contributions",contributions);
        re_map.put("investments",investments);
        //组装返回信息
        map.put("RTCODE", "success");
        map.put("RTMSG", "获取团队贡献信息成功！");
        map.put("RTDATA", re_map);
        return map;
    }

    /**
     * @Title: selectCases
     * @Description 服务页面案例信息获取函数，获取内容：名称、图片地址、域名地址、说明信息
     * @return Map<String, Object>
     * @throws Exception
     * @author CMAPLE
     * @date 2021/8/11 下午3:24
     */
    public Map<String, Object> selectCases() throws Exception {
        //初始化返回结构体
        Map<String, Object> map = new HashMap<String, Object>();
        //查询案例信息(查询内容允许为空)
        List<Cases> cases = basicMapper.selectCases();
        //组装返回信息内容
        map.put("RTCODE", "success");
        map.put("RTMSG", "获取案例信息列表成功！");
        map.put("RTDATA", cases);
        return map;
    }

    /**
     * @Title: selectPrograms
     * @Description 服务页面项目信息获取函数，获取内容：名称，版本，类型，域名地址，更新时间
     * @return Map<String, Object>
     * @throws Exception
     * @author CMAPLE
     * @date 2021/8/11 下午3:40
     */
    public Map<String, Object> selectPrograms() throws Exception {
        //初始化返回结构体
        Map<String, Object> map = new HashMap<String, Object>();
        //查询案例信息(查询内容允许为空)
        List<Programs> programs = basicMapper.selectPrograms();
        //组装返回信息内容
        map.put("RTCODE", "success");
        map.put("RTMSG", "获取项目信息列表成功！");
        map.put("RTDATA", programs);
        return map;
    }
}
