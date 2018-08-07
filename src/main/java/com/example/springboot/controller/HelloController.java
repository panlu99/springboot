/**
 * FileName: HelloController
 * Author: panlu02
 * Date: 2018/7/2 下午5:45
 * Description: HelloController
 **/
package com.example.springboot.controller;

import com.example.springboot.error.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误...");
    }
}
