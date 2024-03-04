package org.myownstock.user.communities;

import org.myownstock.user.cities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommunity extends JpaRepository<Community, Long> {
}
