package edu.bjtu.microservice.cart.service;

import edu.bjtu.microservice.cart.domain.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8082/api/user/", name = "UserInformationService")
@FeignClient("USER-SERVICE")
public interface UserFeignClient {

    @GetMapping("/api/user/{id}")
    UserInfo findById(@PathVariable("id") Long id);

}
