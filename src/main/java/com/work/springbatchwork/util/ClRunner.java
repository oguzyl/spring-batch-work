package com.work.springbatchwork.util;

import com.work.springbatchwork.config.TestClass;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Map;

@Component
public class ClRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext ctx = AppContextProvider.getApplicationContext();

        Map<String, DataSource> beansOfType = ctx.getBeansOfType(DataSource.class);

        for (String key : beansOfType.keySet()) {
            System.out.println(key);
        }


//        Map<String, DataSource> beans = ctx.getBeansOfType(DataSource.class);
//        String[] b = ctx.getBeanNamesForType(DataSource.class);
//        System.out.println("size : " + beans.size());
//
//        for (String s: b) {
//            System.out .println(b);
//        }
//
//        TestClass tc = ctx.getBean(TestClass.class);
//
//        System.out.println(tc.getDs().toString());



//        Map<String, Object> beans = ctx.getBeansOfType(Object.class);
//        for (Map.Entry<String, Object> entry: beans.entrySet()) {
//            System.out.println("Bean name: " + entry.getKey());
//            System.out.println("Bean type:  " + entry.getValue().getClass().getName());
//        }



    }
}
