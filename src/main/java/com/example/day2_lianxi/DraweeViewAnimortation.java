package com.example.day2_lianxi;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Retention(RetentionPolicy.RUNTIME)
@interface DraweeViewAnimortation {
    String name();
}
