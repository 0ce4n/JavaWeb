package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by duhaiyang on 2018/2/3.
 */
@RestController
@RequestMapping(value = "/index")
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

    //表单验证
    @PostMapping(value = "/addgirl")
    public Object addgril(@Valid girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return girl;
    }

}
