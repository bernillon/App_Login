package org.myownstock.user.communities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserToCommunity extends JpaRepository<UserToCommunity, Long> {
    List<UserToCommunity> findByCommunityId(Long communityId);


}
