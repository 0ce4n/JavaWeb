package com.demo;

import javax.validation.constraints.Min;

/**
 * Created by duhaiyang on 2018/2/4.
 */
public class girl {
    private String name;

    @Min(value = 18, message = "未成年少女禁止入内")
    private Integer age;

    private String cupsize;

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

    public String getCupsize() {
        return cupsize;
    }

    public void setCupsize(String cupsize) {
        this.cupsize = cupsize;
    }
}
