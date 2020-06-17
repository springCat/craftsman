package com.alibaba.craftsman.tunnel;

import com.alibaba.craftsman.tunnel.database.craftsman.UserProfileTunnel;
import com.alibaba.craftsman.tunnel.database.craftsman.dataobject.UserProfileDO;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This is Tunnel Test, no need to mock, and no regression needed as well
 *
 * @author Frank Zhang
 * @date 2019-02-27 5:31 PM
 */
public class UserProfileTunnelTest {
    @Autowired
    private UserProfileTunnel userProfileTunnel;

    public void testCRUD(){
        String userId = Math.random()+"UserProfileTunnelTest";

        UserProfileDO userProfileDO = new UserProfileDO();
        userProfileDO.setUserId(userId);
        userProfileDO.setDep("alibaba");
        userProfileDO.setIsManager("n");
        userProfileDO.setUserName("Frank");
        userProfileDO.setRole("DEV");

        userProfileTunnel.create(userProfileDO);

        userProfileDO = userProfileTunnel.getByUserId(userId);
        Assert.assertEquals(userId, userProfileDO.getUserId());

        userProfileTunnel.delete(userId);
        Assert.assertNull(userProfileTunnel.getByUserId(userId));
    }
}
