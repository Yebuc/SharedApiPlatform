package com.yupi.yuapicommon.service;

/**
 *
 */
public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    /**
     * 接口是否调用成功
     *
     * */
    boolean invoke(long interfaceInfoId, long userId);
}
