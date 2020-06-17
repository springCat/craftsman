package com.alibaba.craftsman.tunnel.database.craftsman1;

import com.alibaba.craftsman.tunnel.database.craftsman1.dataobject.UserProfileDO1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * UserProfileTunnel
 *
 * @author Frank Zhang
 * @date 2019-02-27 5:03 PM
 */
@Mapper
public interface UserProfileTunnel1 {
    int create(UserProfileDO1 userProfileDO);

    int update(UserProfileDO1 userProfileDO);

    int delete(String userId);

    UserProfileDO1 getByUserId(String userId);

    List<UserProfileDO1> listByDep(String dep);
}
