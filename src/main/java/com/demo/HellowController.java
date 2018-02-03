package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by duhaiyang on 2018/2/3.
 */
@RestController
public class HellowController {
    @Value("${username}")
    private  String username;

    @Autowired
    private babyproperties baby;

   // @GetMapping(value = "/hello")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say(){
        Integer age = baby.getAge();
        String name = baby.getName();
        return "Hello spring boot!" + age + name;
    }

    @RequestMapping(value = {"/aaa","/bbb"}, method = RequestMethod.GET)
    public String doubleurl(){
        return "you win!";
    }

    //对应的url为/pathvalue/xxxx
    @RequestMapping(value = "/pathvalue/{pv}",method = RequestMethod.GET)
    public String pathvalue(@PathVariable("pv") String pv){
        return pv;
    }

    //对应的url为/requestvalue?name=xxxxx
    @RequestMapping(value = "/requestvalue",method = RequestMethod.GET)
    public Object requestvale(@RequestParam(value = "name", required = false,defaultValue = "duhaiyang") String name){
        return name;
    }
}
