package com.lly.web;

import com.lly.dao.PersonResponsitory;
import com.lly.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 数据接口
 * Created by dana on 2017/7/22.
 */
@RestController
public class PersonController {
    @Autowired
    private PersonResponsitory personResponsitory;

    @RequestMapping("/save")
    public Person save(String name,String address,Integer age){
        Person save = personResponsitory.save(new Person(null, name, age, address));
        return save;
    }

    /**
     * 测试findByAddress
     * @param address address
     * @return list
     */
    @RequestMapping("/q1")
    public List<Person> q1(String address){
        return personResponsitory.findByAddress(address);
    }

    /**
     * 测试 findByNameAndAddress
     */
    @RequestMapping("/q2")
    public Person q2(String name,String address){
        return personResponsitory.findByNameAndAddress(name,address);
    }

    /**
     * 测试withNameAndAddressQuery
     */
    @RequestMapping("/q3")
    public Person q3(String name,String address){
        return personResponsitory.withNameAndAddressQuery(name,address);
    }

    /**
     * 测试withNameAndAddressNameQuery
     */
    @RequestMapping("/q4")
    public Person q4(String name,String address){
        return personResponsitory.withNameAndAddressNameQuery(name,address);
    }

    /**
     * 测试排序
     */
    @RequestMapping("/sort")
    public List<Person> sort(){
        return personResponsitory.findAll(new Sort(Sort.Direction.ASC,"age"));
    }
    /**
     * 测试分页
     */
    @RequestMapping("/page")
    public Page<Person>  page(){
        Page<Person> page = personResponsitory.findAll(new PageRequest(1, 2));
        return page;
    }
}
