package org.myownstock.user.communities.Impl;

import org.myownstock.user.Users.IUser;
import org.myownstock.user.communities.Community;
import org.myownstock.user.communities.IUserToCommunity;
import org.myownstock.user.communities.UserToCommunity;
import org.myownstock.user.communities.UserToCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserToCommunityServiceImpl implements UserToCommunityService {
    @Autowired
    IUserToCommunity repository;

    @Override
    public UserToCommunity add(UserToCommunity userToCommunity){
        return repository.save(userToCommunity);
    }
}
