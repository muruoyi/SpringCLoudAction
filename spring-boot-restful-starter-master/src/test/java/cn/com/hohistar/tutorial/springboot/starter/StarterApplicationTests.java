package cn.com.hohistar.tutorial.springboot.starter;

import cn.com.hohistar.tutorial.springboot.starter.amqp.Sender;
import cn.com.hohistar.tutorial.springboot.starter.model.Todo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StarterApplicationTests {

	@Autowired
	private Sender sender;


	@Test
	public void sendTest() throws Exception {

		for(int i = 0; i < 1; i++) {
			Todo todo = new Todo();
			todo.setId(i);
			todo.setTitle("Todo: " + i);
			todo.setDesc("Desc for " + i);
			sender.send(todo);
			Thread.currentThread().sleep(1000);
		}
	}

}
