package com.luohao.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.luohao.springboot.R.R;
import com.luohao.springboot.bean.Person;
import com.luohao.springboot.utils.RUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Controller
public class RedisController {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    Person person;


    /**
     * String类型
     * @return value
     */
    @ResponseBody
    @GetMapping(value = "redisTypeString",name = "redis String类型")
    public R<Object> RedisTypeString(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());  //重新设置key的序列化方式，默认为jdk序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());  //重新设置value的序列化方式，默认为jdk序列化
        ValueOperations<Object, Object> string = redisTemplate.opsForValue();
        string.set("String2","value");
        Object value = string.get("String2");
        return RUtils.success(value);
    }

    /**
     * List类型
     * @return value
     */
    @ResponseBody
    @GetMapping(value = "redisTypeList",name = "redis List类型")
    public R<Object> RedisTypeList(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());  //重新设置key的序列化方式，默认为jdk序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());  //重新设置value的序列化方式，默认为jdk序列化
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        List<Object> value = list.range("list", 0, -1);
        return RUtils.success(value);
    }

    /**
     * Hash类型
     * @return value
     */
    @ResponseBody
    @GetMapping("redisTypeHash")
    public R<Object> RedisTypeHash(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());  //重新设置key的序列化方式，默认为jdk序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());  //重新设置value的序列化方式，默认为jdk序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());    //重新设置Hash类型key的序列化方式，默认为jdk序列化
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());   //重新设置Hash类型的value的序列化方式，默认为jdk序列化
        HashOperations<Object, Object, Object> hash = redisTemplate.opsForHash();
        Object value = hash.get("hash", "field1");
        return RUtils.success(value);
    }

    /**
     * Set类型
     * @return value
     */
    @ResponseBody
    @GetMapping("redisTypeSet")
    public R<Object> RedisTypeSet(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());  //重新设置key的序列化方式，默认为jdk序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());  //重新设置value的序列化方式，默认为jdk序列化
        SetOperations<Object, Object> set = redisTemplate.opsForSet();
        Set<Object> value = set.members("set");
        return RUtils.success(value);
    }

    /**
     * Zset类型
     * @return value
     */
    @ResponseBody
    @GetMapping("redisTypeZSet")
    public R<Object> RedisTypeZSet(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());  //重新设置key的序列化方式，默认为jdk序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());  //重新设置value的序列化方式，默认为jdk序列化
        ZSetOperations<Object, Object> zset = redisTemplate.opsForZSet();
        Set<Object> value = zset.range("zset",0,-1);
        return RUtils.success(value);
    }

    /**
     * HyperLoglog类型
     * @return Long
     */
    @ResponseBody
    @GetMapping("redisTypeHyperLogLog")
    public R<Object> RedisTypeHyperLogLog(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());  //重新设置key的序列化方式，默认为jdk序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());  //重新设置value的序列化方式，默认为jdk序列化
        HyperLogLogOperations<Object, Object> hyperLogLog = redisTemplate.opsForHyperLogLog();
        Long value = hyperLogLog.size("HyperLoglog");
        return RUtils.success(value);
    }

    /**
     * JavaBean存取
     * @return javaBean
     */
    @ResponseBody
    @GetMapping("redisTypeJavaBean")
    public R<Object> RedisTypeJavaBean(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());  //重新设置key的序列化方式，默认为jdk序列化
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));  //重新设置value的序列化方式，默认为jdk序列化,这里value是java对象，所以使用Jackson2JsonRedisSerializer
        ValueOperations<Object, Object> JavaBean = redisTemplate.opsForValue();
        JavaBean.set("Person",person);
        Object value = JavaBean.get("Person");
        System.out.println(value);
        return RUtils.success(value);
  }


}
