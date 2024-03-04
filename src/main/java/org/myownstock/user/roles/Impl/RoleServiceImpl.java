package org.myownstock.user.roles.Impl;

import org.myownstock.user.roles.IRole;
import org.myownstock.user.roles.Role;
import org.myownstock.user.roles.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private IRole roleRepository;

    public Role add(Role role){
        role = roleRepository.save(role);
        return role;
    }
    @Override
    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }

}
