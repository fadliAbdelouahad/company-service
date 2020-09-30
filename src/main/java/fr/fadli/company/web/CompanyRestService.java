package fr.fadli.company.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class CompanyRestService {

    @Value("${xparam}")
    private int xParam;
    @Value("${yparam}")
    private int yParam;
    @Value("${me}")
    private String me;


    @GetMapping("/myConfig")
    public Map<String, Object> myConfig(){
        Map<String, Object> params = new HashMap<>();
        params.put("xParam", xParam);
        params.put("yParam", yParam);
        params.put("me", me);
        params.put("threadName", Thread.currentThread().getName());
        return params;
    }

}
