package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		int value = userDao.insert(new Users("kunal", "kunalsh072017@gmail.com", "male", "new delhi"));
//		int value = userDao.update(new Users("RAM PAL", "kunalsh072017@gmail.com", "Male", "new delhi"));
//		int value = userDao.deleteByEmail("sumit.dev2148@gmail.com");
		User value = userDao.getUserByEmail("kunalsh072017@gmail.com");
		System.out.println("VALUE is >>>>>>>>>>>  "  + value.toString());
//		List<User> users = userDao.getUsersByEmail("kunalsh072017@gmail.com");
//		for(User user: users){
//			System.out.println("VALUE is >>>>>>>>>>>  "  + user.toString());
//		}
	}
}
