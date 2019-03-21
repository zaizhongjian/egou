package com.json.egou.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "ALL-INTERFACE")
@RequestMapping("/athenUser")
public interface UserCilent {

    @RequestMapping("/athen")
    Boolean athenOrNot();
}