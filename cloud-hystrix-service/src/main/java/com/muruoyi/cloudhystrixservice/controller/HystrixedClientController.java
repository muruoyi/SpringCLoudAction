package com.muruoyi.cloudhystrixservice.controller;

import com.muruoyi.cloudhystrixservice.model.ApiResult;
import com.muruoyi.cloudhystrixservice.model.Todo;
import com.muruoyi.cloudhystrixservice.service.HystrixedClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HystrixedClientController {

    @Autowired
    private HystrixedClientService clientService;

    @GetMapping("/h/todo")
    public ApiResult<List<Todo>> getTodos() {
        return clientService.getTodos();
    }

}
