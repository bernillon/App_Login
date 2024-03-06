package org.myownstock.user.communities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/communities")
public class UserToCommunityController {

    @Autowired
    private UserToCommunityService userToCommunityService;

    @PostMapping("/people")
        public ResponseEntity<?> add(@RequestBody UserToCommunity userToCommunity){
            userToCommunityService.add(userToCommunity);
            return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/{communityId}/users")
    public ResponseEntity<List<UserToCommunity>> getUsersByCommunityId(@PathVariable Long communityId) {
        List<UserToCommunity> userToCommunities = userToCommunityService.getUsersByCommunityId(communityId);
        return ResponseEntity.ok(userToCommunities);
    }



}

