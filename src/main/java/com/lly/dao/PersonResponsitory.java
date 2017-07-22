package com.lly.dao;

import com.lly.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * person数据访问接口
 * Created by dana on 2017/7/22.
 */
public interface PersonResponsitory extends JpaRepository<Person,Long> {
    //根据方法名查询
    List<Person> findByAddress(String address);

    //根据方法名查询
    Person findByNameAndAddress(String name,String address);

    //使用query查询。绑定定义的参数
    @Query("select p from Person p where p.name= :name and p.address=:address")
    Person withNameAndAddressQuery(@Param("name")String name,@Param("address")String address);

    //使用namedQuery查新。我们在实体中定义的
    Person withNameAndAddressNameQuery(String name,String address);
}
