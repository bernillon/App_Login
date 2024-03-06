package org.myownstock.user.communities;

import org.myownstock.user.helpers.services.Service;

import java.util.List;


public interface UserToCommunityService extends Service<UserToCommunity> {

    List<UserToCommunity> getUsersByCommunityId(Long communityId);

}
