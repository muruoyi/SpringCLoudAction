package com.muruoyi.cloudhystrixservice.service;

import com.muruoyi.cloudhystrixservice.model.ApiResult;
import com.muruoyi.cloudhystrixservice.model.Todo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log
@Service
public class HystrixedClientService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "todoFailed")
    public ApiResult<List<Todo>> getTodos() {

        ApiResult<List<Todo> > resp = restTemplate.getForObject("http://cloud-todo-service/todoList", ApiResult.class);

        return resp;
    }

    public ApiResult<List<Todo>> todoFailed() {

        log.info("todo failed");
        ApiResult<List<Todo>> resp = new ApiResult<>();
        resp.setSucc(false);
        return resp;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }

}
