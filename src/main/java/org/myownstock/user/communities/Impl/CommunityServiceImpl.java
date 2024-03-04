package org.myownstock.user.communities.Impl;

import org.myownstock.user.communities.Community;
import org.myownstock.user.communities.CommunityService;
import org.myownstock.user.communities.ICommunity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private ICommunity repository;

    @Override
    public Community add (Community community){
        return repository.save(community);
    }

    @Override
    public List<Community> findAll() {return repository.findAll();}
}
