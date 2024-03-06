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


    /**
     * Récupère une communauté spécifique en fonction de son ID.
     *
     * @param id L'ID de la communauté à récupérer.
     * @return La communauté correspondant à l'ID spécifié.
     */
    Community findById(Long id);

}
