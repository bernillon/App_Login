package org.myownstock.user.communities.Impl;

import org.myownstock.user.communities.IUserToCommunity;
import org.myownstock.user.communities.UserToCommunity;
import org.myownstock.user.communities.UserToCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserToCommunityServiceImpl implements UserToCommunityService {

    @Autowired
    private IUserToCommunity repository;

    @Override
    public UserToCommunity add(UserToCommunity userToCommunity) {
        return repository.save(userToCommunity);
    }

    @Override
    public List<UserToCommunity> getUsersByCommunityId(Long communityId) {
        return repository.findByCommunityId(communityId);
    }
}
