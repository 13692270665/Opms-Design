package com.ccd.opms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * @author :ccd
 * @date : 2023/4/17 13:32
 */
@FeignClient("service-kbms")
@Component
public interface KbsClient {

    @PostMapping("/kbms/count/count")
    Map<String,Integer> getKbsCount();
}
