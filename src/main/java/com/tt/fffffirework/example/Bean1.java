package com.tt.fffffirework.example;

import com.tt.fffffirework.annotations.Aop;

public class Bean1 implements sou{

    private String string;

    public Bean1() {
    }

    public Bean1(String string) {
        this.string = string;
    }

    @Override
    @Aop("com.tt.fffffirework.example.AopTest.around")
    public void sou(){
        System.out.println("bean1" +string);
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
