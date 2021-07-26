package cn.cmaple.mainsver.service;

import cn.cmaple.mainsver.mapper.OperationLogMapper;
import cn.cmaple.mainsver.model.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @ClassName: OperationLogService
 * @Description: 日志服务类，用于处理日志记录等相关请求
 * @author: CMAPLE
 * @date 2021/7/26 上午9:30
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@Service
public class OperationLogService {

    /**
     * 引入OperationLogMapper
     */
    @Autowired
    private OperationLogMapper operationLogMapper;

    /**
     * 函数名：insert函数-插入日志信息 - insert（）
     * 功能描述： 插入日志信息
     *
     * @param operationLog 日志信息实体类
     *                     返回值：int
     *                     异    常：NULL
     *                     创建人：CMAPLE
     *                     日期：2019-09-25
     */
    public int insert(OperationLog operationLog) {
        return operationLogMapper.insert(operationLog);
    }

}