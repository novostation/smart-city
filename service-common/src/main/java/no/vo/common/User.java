package no.vo.common;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String list() {
        List<User> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(new User(i,"name"+i));
        }
       return JSON.toJSONString(list);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
