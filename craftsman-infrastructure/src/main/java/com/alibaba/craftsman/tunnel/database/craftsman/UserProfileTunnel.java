package com.alibaba.craftsman.tunnel.database.craftsman;

import com.alibaba.craftsman.tunnel.database.craftsman.dataobject.UserProfileDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * UserProfileTunnel
 *
 * @author Frank Zhang
 * @date 2019-02-27 5:03 PM
 */
@Mapper
public interface UserProfileTunnel {
    int create(UserProfileDO userProfileDO);

    int update(UserProfileDO userProfileDO);

    int delete(String userId);

    UserProfileDO getByUserId(String userId);

    List<UserProfileDO> listByDep(String dep);
}
