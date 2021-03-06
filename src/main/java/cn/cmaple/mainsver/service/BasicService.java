package cn.cmaple.mainsver.service;

import cn.cmaple.mainsver.mapper.BasicMapper;
import cn.cmaple.mainsver.model.About;
import cn.cmaple.mainsver.model.Cases;
import cn.cmaple.mainsver.model.Programs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名：基础服务类 - BasicService
 * 功能描述：基础服务类，用于处理官网相关无需登陆的相关服务
 * 创建人：CMAPLE
 * 创建日期：2021-07-26
 *
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@Service
public class BasicService {

    /**
     * 引入BasicMapper
     */
    @Autowired
    private BasicMapper basicMapper;

    /**
     * 函数名：查询函数-查询关于页面团队贡献等信息- selectContributionInfo（）
     * 功能描述： 关于页面团队贡献等信息获取函数，获取内容：管理团队、合作贡献、投资等内容信息
     * 输入参数：<按照参数定义顺序>
     * <p>
     * 返回值：Map<String, Object>
     * 异    常：Exception
     * 创建人：CMAPLE
     * 日期：2021-08-11
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
        List<About> abouts = basicMapper.selectContributionInfo();
        //判断获取内容是否为空
        if (abouts.isEmpty()) {
            throw new Exception("获取团队贡献信息无数据！");
        }
        //讲信息分类整理
        for (About a : abouts) {
            if (1 == a.getType()) {
                teams.add(a);
            } else if (2 == a.getType()) {
                contributions.add(a);
            } else {
                investments.add(a);
            }
        }
        re_map.put("teams", teams);
        re_map.put("contributions", contributions);
        re_map.put("investments", investments);
        //组装返回信息
        map.put("RTCODE", "success");
        map.put("RTMSG", "获取团队贡献信息成功！");
        map.put("RTDATA", re_map);
        return map;
    }

    /**
     * 函数名：查询函数-查询服务页面案例信息- selectCases（）
     * 功能描述：服务页面案例信息获取函数，获取内容：名称、图片地址、域名地址、说明信息
     * 输入参数：<按照参数定义顺序>
     * <p>
     * 返回值：Map<String, Object>
     * 异    常：Exception
     * 创建人：CMAPLE
     * 日期：2021-08-11
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
     * 函数名：查询函数-查询服务页面项目信息- selectPrograms（）
     * 功能描述：服务页面项目信息获取函数，获取内容：名称，版本，类型，域名地址，更新时间
     * 输入参数：<按照参数定义顺序>
     * <p>
     * 返回值：Map<String, Object>
     * 异    常：Exception
     * 创建人：CMAPLE
     * 日期：2021-08-11
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