package org.myownstock.user.communities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserToCommunity extends JpaRepository<UserToCommunity, Long> {
}
