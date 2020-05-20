package com.will.springbootredis;

/**
 * @Description person类
 * @Author willfu
 * @Date 2020/5/20 9:12 上午
 * @Version 1.0
 */
public class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
