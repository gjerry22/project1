package com.jerry.maven;

import org.junit.Test;

/**
 * ClassName: HelloMavenTest
 * Package: com.jerry.maven
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/6
 */
public class HelloMavenTest {

    @Test
    public void testHelloMaven(){
        HelloMaven helloMaven = new HelloMaven();
        System.out.println(helloMaven.hello("Maven O(∩_∩)O"));
    }
}
