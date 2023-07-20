package com.jerry.explore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * ClassName: OnStudyTest
 * Package: com.hello.test
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/8
 */
class OnStudyTest {

    @BeforeEach
    void setUp() {
        System.out.println("before test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after test");
    }

    @Test
    void func1() {
        new OnStudy().func1(2);
    }

    @Test
    void func2() {
        OnStudy.func2(2);
    }
}