package cn.cmaple.mainsver.controller;

import cn.cmaple.mainsver.annotation.PassToken;
import cn.cmaple.mainsver.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: BasicController
 * @Description: 基础服务类，用于处理官网相关无需登陆的相关服务
 * @author: CMAPLE
 * @date 2021/7/23 下午1:32
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@RestController
@RequestMapping("/basic")
public class BasicController {

    @Autowired
    private BasicService basicService;
    
    /**
     * @Title: getContributionInfo
     * @Description 关于页面团队贡献等信息获取函数，获取内容：管理团队、合作贡献、投资等内容信息
     * @return Map<String, Object>
     * @throws Exception
     * @author CMAPLE
     * @date 2021/8/11 下午1:38
     */
    @PassToken
    @RequestMapping(value = "/contributionInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> selectContributionInfo() throws Exception {
        return  basicService.selectContributionInfo();
    }
    
    /**
     * @Title: selectCases
     * @Description 服务页面案例信息获取函数，获取内容：名称、图片地址、域名地址、说明信息
     * @return Map<String, Object>
     * @throws Exception
     * @author CMAPLE
     * @date 2021/8/11 下午3:29
     */
    @PassToken
    @RequestMapping(value = "/cases", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> selectCases() throws Exception {
        return  basicService.selectCases();
    }

    /**
     * @Title: selectPrograms
     * @Description 服务页面项目信息获取函数，获取内容：名称，版本，类型，域名地址，更新时间
     * @return Map<String, Object>
     * @throws Exception
     * @author CMAPLE
     * @date 2021/8/11 下午3:41
     */
    @PassToken
    @RequestMapping(value = "/programs", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> selectPrograms() throws Exception {
        return  basicService.selectPrograms();
    }
}
