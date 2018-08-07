/**
 * FileName: MyException
 * Author: panlu02
 * Date: 2018/7/2 下午5:44
 * Description: MyException
 **/
package com.example.springboot.error;

public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
