package cn.com.hohistar.tutorial.springboot.starter.repository;

import cn.com.hohistar.tutorial.springboot.starter.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname TodoRepository
 * @Description TODO
 * @Date 2019/7/10 1:01 PM
 * @Created by jini
 */

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
