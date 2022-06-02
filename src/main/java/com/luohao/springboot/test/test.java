package com.luohao.springboot.test;


import com.luohao.springboot.R.R;
import com.luohao.springboot.R.Renum;
import com.luohao.springboot.utils.RUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

    /**IOC
     * 即控制反转
     * 传统java程序中，一个类想要调用另外一个类的方法或者属性，需要使用new关键字，而在spring中，使用xml配置，注解，配置类等方式（如：@Component注解）对java对象进行定义，
     * spring启动时，Ioc容器会根据这些对象定义，自动创建对象并且管理起来，当我们需要这些对象时，直接在ioc容器中获取就行了，由之前的主动创建变为了被动的获取
     */


    /** bean的生命周期
     * 1.bean的实例化
     * 2.bean的属性注入
     * 3.bean的初始化
     * 4.bean的调用
     * 5.bean的销毁
     */

    /**依赖注入的方式
     * 1.构造器方法
     * 2.setter方法
     * 3.静态工厂
     * 4.实例工厂
     */

    /**自动装配的方式
     * 基于xml的方式：
     * 1.no
     * 2.default
     * 3.byName
     * 4.byType
     * 5.构造器
     *
     * 基于注解的方式：
     * 1.@Autowired  默认按照bean的类型进行装配，可以搭配@Qualifier使用，按照bean的名字进行装配
     * 2.@Resource(name="bean") 按照bean的名字进行装配
     * 3.@Resource(type=bean.class)  按照bean的类型进行装配
     */


    /**AOP
     * 1.AOP即面向切面编程
     * 2.AOP通过横向的抽取，把应用中一些非业务通用功能抽取出来进行单独维护，并且通过声明的方式，例如配置文件，注解等方式定义这些功能要以何种方式作用在哪些应用中，而不是在业务中直接调用
     * 3.简单说就是那些与业务无关，却为业务模块所同调用的逻辑或责任封装起来，便于减少系统的重复代码，降低模块之间的耦合度，并有利于未来的可操作性和可维护性。
     */


    /**spring aop的两种动态代理方式
     * 1.jdk动态代理：springAop默认的代理方式，只有目标方法实现了某个接口才能使用jdk动态代理
     * 2.CGLIB动态代理：当目标方法没有实现接口时，就会使用cglib动态代理
     */
    public static void main(String[] args) {
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
//        System.out.println(System.currentTimeMillis());
//        try {
//            Date parse = simpleDateFormat.parse("2020-12-02");
//            String format = simpleDateFormat.format(parse);
//            System.out.println(parse);
//            System.out.println(format);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


//        String id="200s";
//        Pattern matches = Pattern.compile("[0-9]");
//        Matcher matcher = matches.matcher(id);
//        String ID="";
//        while (matcher.find()){
//            ID+=matcher.group();
//        }
//        System.out.println(ID);

        String msg = RUtils.getmsg(Renum.class, -1);
        System.out.println(msg);
    }
}
