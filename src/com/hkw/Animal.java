package com.hkw;

import java.util.ArrayList;
import java.util.List;

public class Animal implements Comparable<Animal>{
    private String kind;
    private String sex;
    private int age;
    private String name;

    public Animal() {
    }

    public Animal(String kind, String sex, int age, String name) {
        this.kind = kind;
        this.sex = sex;
        this.age = age;
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "该动物的相关信息:\n" +
                "种类——————" + kind +
                "\n性别——————" + sex +
                "\n年龄——————" + age +
                "\n姓名——————" + name;
    }


    @Override
    public int compareTo(Animal o) {
        return (o.age>this.age)?-1:1;
    }
}
