package com.luohao.springboot.controller;

import com.luohao.springboot.R.R;
import com.luohao.springboot.utils.RUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

@RestController            //@RestController相当于@Controller和@ResponBody。但是如果有方法用于返回html路径就不适合了
public class SqlTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;


    @RequestMapping("sqltest")
    public R<Object> sqltest1() throws SQLException {
        System.out.println("默认数据源为：" + dataSource.getClass());
        System.out.println("数据库连接实例：" + dataSource.getConnection());
        String sql="select addr from table1 where name='zhangsan' limit 1";
        String data = jdbcTemplate.queryForObject(sql, String.class);
        return RUtils.success(data);
    }
}
