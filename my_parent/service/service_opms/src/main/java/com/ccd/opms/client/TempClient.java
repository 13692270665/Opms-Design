package com.ccd.opms.client;

import com.ccd.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * @author :ccd
 * @date : 2023/4/17 11:16
 */
@FeignClient("service-temp")
@Component
public interface TempClient {

    @PostMapping("/temp/count/count")
    Map<String,Integer> getTempCount();

}
