package com.muruoyi.cloudhystrixservice.service;

import com.muruoyi.cloudhystrixservice.model.ApiResult;
import com.muruoyi.cloudhystrixservice.model.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "cloud-todo-service", fallback = TodoClient.TodoClientFallback.class)
public interface TodoClient {

    @RequestMapping(method = RequestMethod.GET, value = "/todoList")
    ApiResult<List<Todo>> getTodos();

    @Component
    static class TodoClientFallback implements TodoClient {

        @Override
        public ApiResult<List<Todo>> getTodos() {

            ApiResult<List<Todo>> res = new ApiResult<>();
            res.setSucc(false);

            return res;
        }
    }
}
