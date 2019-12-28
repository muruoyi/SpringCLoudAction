package cn.com.hohistar.tutorial.springboot.starter.api;

import cn.com.hohistar.tutorial.springboot.starter.api.vo.ApiResult;
import cn.com.hohistar.tutorial.springboot.starter.biz.TodoBiz;
import cn.com.hohistar.tutorial.springboot.starter.exception.BizException;
import cn.com.hohistar.tutorial.springboot.starter.model.Todo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/todo")
public class TodoApi {

    @Autowired
    private TodoBiz todoBiz;

    @GetMapping("/ok")
    public String ok() {
        return "ok";
    }

    @GetMapping("/todoList")
    public ApiResult getTodoList() {

        ApiResult.ApiResultBuilder builder = ApiResult.builder().succ(true).build().toBuilder();

        List<Todo> list = todoBiz.listAll();
        try {
            Thread.currentThread().sleep(20 * 1000);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return builder.data(list).succ(true).msg("success").code("200").build();
    }

    @GetMapping("/test/add/todos")
    public String testAddTodos() {


        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo(null, "Call Metting", ""));
        todos.add(new Todo(null, "Print File", ""));

        todoBiz.addTestTodos(todos);

        return "ok";

    }

    @PostMapping
    @ApiOperation(value = "add a todo", notes = "在新增时，id是不需要的，title is requried.")
    public ApiResult addTodo(@Valid @RequestBody Todo todo) {

        ApiResult.ApiResultBuilder builder = ApiResult.builder().succ(true).build().toBuilder();

        todoBiz.addTodo(todo);

        return builder.build();
    }

}
