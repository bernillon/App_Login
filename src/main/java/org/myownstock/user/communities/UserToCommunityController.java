package org.myownstock.user.communities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/communities")
public class UserToCommunityController {

        @Autowired
        private UserToCommunityService service;
        @PostMapping("/people")
        public ResponseEntity<?> add(@RequestBody UserToCommunity userToCommunity){
            service.add(userToCommunity);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }


}

