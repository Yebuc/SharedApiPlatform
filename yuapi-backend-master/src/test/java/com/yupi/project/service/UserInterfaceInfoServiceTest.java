package com.yupi.project.service;

import com.yupi.yuapiclientsdk.YuApiClientConfig;
import com.yupi.yuapiclientsdk.client.YuApiClient;
import com.yupi.yuapiclientsdk.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserInterfaceInfoServiceTest {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Test
    public void invokeCount() {
        boolean b = userInterfaceInfoService.invokeCount(1L, 1L);
        Assertions.assertTrue(b);
    }

//    @Resource
//    private YuApiClient yuApiClient;
//    YuApiClientConfig;//这是啥玩意
    @Test
    public void sdk(){
        YuApiClient yuApiClient = new YuApiClient("yupi", "abcdefgh");
        User user = new User("amber");
        yuApiClient.getUsernameByPost(user);
    }
}