/**
 * FileName: component
 * Author: panlu02
 * Date: 2018/6/27 下午5:21
 * Description: component
 **/
package com.example.springboot.domin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ComponentPO {

    //@Value("${com.example.name}")
    private String name;

    //@Value("${com.example.title}")
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
