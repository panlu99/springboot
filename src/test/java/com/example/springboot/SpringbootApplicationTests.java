package com.example.springboot;

import com.example.springboot.domin.ComponentPO;
import com.example.springboot.service.UserService;
import com.example.springboot.serviceImpl.AsynchronousImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    private ComponentPO componentPO;

    @Autowired
    private UserService userSerivce;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private AsynchronousImpl asynchronous;

    @Test
    public void contextLoads() {
        Assert.assertEquals(componentPO.getName(), "lily");
    }

    @Test
    public void test() throws Exception {
        // 插入5个用户
        userSerivce.create("a", 1);
        userSerivce.create("b", 2);
        userSerivce.create("c", 3);
        userSerivce.create("d", 4);
        userSerivce.create("e", 5);

        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userSerivce.getAllUsers().intValue());

        // 删除两个用户
        userSerivce.deleteByName("a");
        userSerivce.deleteByName("e");

        // 查数据库，应该有5个用户
        Assert.assertEquals(3, userSerivce.getAllUsers().intValue());

    }

    @Test
    public void redisTest() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void asynTest() throws Exception {
        //asynchronous.doRaskOne();
        //asynchronous.doRaskTwo();
        //asynchronous.doRaskThree();
        long start = System.currentTimeMillis();

        Future<String> task1 = asynchronous.doRaskOne();
        Future<String> task2 = asynchronous.doRaskTwo();
        Future<String> task3 = asynchronous.doRaskThree();

        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();
        System.out.println("total consumer time: " + (end - start));
    }

    @Test
    public void executorTask() throws Exception {
        asynchronous.doRaskOne();
        asynchronous.doRaskTwo();
        asynchronous.doRaskThree();

        Thread.currentThread().join();
    }
}
