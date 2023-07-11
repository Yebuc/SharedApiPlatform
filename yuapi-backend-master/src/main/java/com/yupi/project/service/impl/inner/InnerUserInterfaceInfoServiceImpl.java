package com.yupi.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.UserInterfaceInfoMapper;
import com.yupi.project.service.UserInterfaceInfoService;
import com.yupi.yuapicommon.model.entity.UserInterfaceInfo;
import com.yupi.yuapicommon.service.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }

    @Override
    public boolean invoke(long interfaceInfoId, long userId) {
        //要得到当前剩余调用次数
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("interfaceInfoId",interfaceInfoId);
        queryWrapper.eq("userId",userId);
        UserInterfaceInfo userInterfaceInfo = userInterfaceInfoMapper.selectOne(queryWrapper);
        if(userInterfaceInfo.getLeftNum() <= 0){ //判断是否还有调用次数
            return false;
        }
        return true;
    }
}
