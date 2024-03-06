package org.myownstock.user.communities;

import org.myownstock.user.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/communities")
public class CommunityController {

    @Autowired
    CommunityService communityService;
    @PostMapping
    public Community add(@RequestBody Community community){

        return communityService.add(community);
    }

    @GetMapping
    public List<Community> findAll(){return communityService.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Community> findById(@PathVariable Long id) {
        Community community = communityService.findById(id);
        if (community != null) {
            return ResponseEntity.ok().body(community);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
