package org.myownstock.user.communities;

import org.myownstock.user.Users.User;

import java.util.List;

public interface CommunityService {
    /**
     *
     * @param community
     * @return
     */
    public Community add(Community community);

    public List<Community> findAll();
}
