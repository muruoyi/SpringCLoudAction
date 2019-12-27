package cn.com.hohistar.tutorial.springboot.starter.biz;

import cn.com.hohistar.tutorial.springboot.starter.exception.BizException;
import cn.com.hohistar.tutorial.springboot.starter.model.Todo;
import cn.com.hohistar.tutorial.springboot.starter.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Classname TodoBiz
 * @Description TODO
 * @Date 2019/7/10 1:02 PM
 * @Created by jini
 */

@Service
public class TodoBiz {

    @Autowired
    private TodoRepository todoRepository;

    @Transactional
    public List<Todo> listAll() {
        return todoRepository.findAll();
    }

    @Transactional
    public void addTestTodos(List<Todo> todos) {

        todos.forEach(o -> todoRepository.save(o));
    }


    @Transactional
    public void addTodo(Todo todo) {

        if (!"tom".equals(todo.getTitle())) {
            todoRepository.save(todo);
        } else {
            throw new BizException("Title can not be tom");
        }
    }

}
