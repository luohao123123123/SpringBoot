package com.luohao.springboot.config;

import com.luohao.springboot.annotation.IdFormatter;
import com.luohao.springboot.bean.Student;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义mvc的内置类型转换器，数据格式化，自定义注解格式化数据
 *
 * Spring MVC 框架的 Formatter 与 Converter 一样，也是一个可以将一种数据类型转换成另一种数据类型的接口。不同的是，Formatter 的源数据类型必须是 String 类型，
 * 而 Converter 的源数据类型是任意数据类型。
 * 在 Web 应用中由 HTTP 发送的请求数据到控制器中都是以 String 类型获取，因此在 Web 应用中选择 Formatter 比选择 Converter 更加合理。
 */
@Configuration
public class MyFormatterConfig implements WebMvcConfigurer {

    final SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");

//    @Autowired
//    Student student;   //MyConverterConfig是一个配置类，相当于也是一个javaBean，那么在MyConverterConfig中调用Student这个javaBean，会造成循环自引用

    @Override
    public void addFormatters(FormatterRegistry registry) {
        /**
         * 自定义内置类型转换器
         * 前端输入id，name，addr字符串，这个转换器转换为Student实体
         * String：传入的类型
         * Student：转换后的类型
         */
        registry.addConverter(new Converter<String, Student>() {

            @Override
            public Student convert(String source) {
                Student student=new Student();
                String[] dataSplit = source.split(",");
                if(dataSplit.length==3) {
                    student.setId(Integer.parseInt(dataSplit[0]));
                    student.setName(dataSplit[1]);
                    student.setAddr(dataSplit[2]);
                }
                else {
                    try {
                        throw new Exception("转换器错误，请输入正确格式");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return  student;
            }
        });


        /**
         * 自定义数据格式化
         * 输入：1653881848937
         * 输出：2022-05-30
         */
        registry.addFormatter(new Formatter<Date>() {

            //parse 方法的功能是利用指定的 Locale 将一个 String 类型转换成目标类型。
            @Override
            public Date parse(String text, Locale locale) throws ParseException {
//                System.out.println("输入数据格式："+text);
//                System.out.println("输出数据格式："+simpleDateFormat.parse(text));
                return simpleDateFormat.parse(text);
            }

            //print 方法用于返回目标对象的字符串表示。
            @Override
            public String print(Date object, Locale locale) {
                System.out.println(simpleDateFormat.format(object));
                return simpleDateFormat.format(object);
            }
        });

        /**
         * 自定义注解格式化
         * 确保所有javaBean的Id都为int类型
         */
        registry.addFormatterForFieldAnnotation(new AnnotationFormatterFactory<IdFormatter>() {
            @Override
            public Set<Class<?>> getFieldTypes() {
                Set<Class<?>> types = new HashSet<Class<?>>() ;
                types.add(Integer.class) ;
                return types;
            }

            @Override
            public Printer<Integer> getPrinter(com.luohao.springboot.annotation.IdFormatter annotation, Class<?> fieldType) {
                return new IdFormatter();
            }

            @Override
            public Parser<Integer> getParser(com.luohao.springboot.annotation.IdFormatter annotation, Class<?> fieldType) {
                return new IdFormatter();
            }


            class IdFormatter implements Formatter<Integer>{

               @Override
               public Integer parse(String text, Locale locale) throws ParseException {
                   Pattern pattern = Pattern.compile("[0-9]");
                   Matcher matcher = pattern.matcher(text);
                   StringBuilder ID= new StringBuilder();
                   while (matcher.find()){
                       ID.append(matcher.group());
                   }

                   if(ID.length()>0){
                       return Integer.parseInt(ID.toString());
                   }
                   else {
                       return -1;
                   }


               }

               @Override
               public String print(Integer object, Locale locale) {
                   return object.toString();
               }
           }
        });






        WebMvcConfigurer.super.addFormatters(registry);
    }
}
