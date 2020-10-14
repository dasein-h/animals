package com.hkw;

import java.util.*;

public class main {

    private boolean flag;
    private ArrayList<Animal> animals = new ArrayList<>();


    public static void main(String[] args) {
        new main().init();
    }

    public void show() {
        HashMap<String, Integer> kindAndNum = new HashMap<>();
        for (Animal animal : animals) {
            String kind = animal.getKind();
            if (kindAndNum.containsKey(kind)) {
                kindAndNum.put(kind, kindAndNum.get(kind) + 1);
            } else {
                kindAndNum.put(kind, 1);
            }
        }

        for (String n : kindAndNum.keySet()) {
            System.out.println(n + " ： " + kindAndNum.get(n));
        }
    }

    public void init() {
        Scanner scanner = new Scanner(System.in);
        int i = 100, a = 0;
        animals.add(new Animal("老虎", "公", 11, "小老虎"));
        animals.add(new Animal("老虎", "母", 41, "母老虎"));
        animals.add(new Animal("狮子", "母", 7, "小狮子"));
        System.out.println("\n——————————这是一个动物园——————————");


        while (i > 0) {
            System.out.println("目前动物园内有以下动物：");
            show();
            System.out.println("请输入序号进行操作：");
            System.out.println("1.添加动物   2.击杀动物   3.修改动物信息   4.查询动物信息   5.动物按年龄从小到大排序   6.退出");
            try{
                a = scanner.nextInt();
            }catch (Exception e){
                System.out.println("请输入数字......");
                break;
            }
            switch (a) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    modify();
                    break;
                case 4:
                    query();
                    break;
                case 5:
                    sort();
                    break;
                case 6:
                    i = -1;
                    break;
            }
        }
    }

    public void add() {
        Animal animal = new Animal();
        Scanner scanner = new Scanner(System.in);
        System.out.println("——————————1.添加动物——————————");
        System.out.println("请输入动物种类：");
        animal.setKind(scanner.next());
        System.out.println("请输入动物性别：");
        animal.setSex(scanner.next());
        try {
            System.out.println("请输入动物年龄：");
            animal.setAge(scanner.nextInt());
        } catch (Exception e) {
            System.out.println("输入有误，年龄请输入数字，请重新添加该动物");
            return;
        }
        System.out.println("请输入动物姓名：");
        animal.setName(scanner.next());

        animals.add(animal);

    }

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        flag = false;
        System.out.println("——————————2.杀死动物——————————");
        System.out.println("请输入想要杀死动物的姓名：");
        String name = scanner.next();
        System.out.println("击杀中......");
        for (Animal animal : animals) {
            if (name.equals(animal.getName())) {
                animals.remove(animal);
                System.out.println("击杀成功");
                break;
            }
        }
        if (flag) {
            System.out.println("抱歉，没有该动物存在");
        }
    }

    public void modify() {
        System.out.println("——————————3.修改动物——————————");
        flag = false;
        String change = null;
        int changeInt = 0;
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入想要修改动物的姓名：");
        String name = scanner.next();
        System.out.println("查询中......");
        for (Animal animal : animals) {
            if (name.equals(animal.getName())) {
                System.out.println("该动物存在，请选择需要修改的内容：（输入数字）");
                System.out.println("1.品种   2.性别   3.年龄   4.姓名");
                try {
                    i = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("请正确输入数字，请重新选择修改");
                    break;
                }
                System.out.println("请输入修改的内容");
                if (i != 3) {
                    change = scanner.next();
                } else {
                    changeInt = scanner.nextInt();
                }

                switch (i) {
                    case 1:
                        animal.setKind(change);
                        break;

                    case 2:
                        animal.setSex(change);
                        break;

                    case 3:
                        animal.setAge(changeInt);
                        break;

                    case 4:
                        animal.setName(change);
                }
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("抱歉，没有该动物存在");
        }
    }

    public void query() {
        Scanner scanner = new Scanner(System.in);
        flag = false;
        System.out.println("——————————4.查询动物信息——————————");
        System.out.println("下面是所有动物的姓名：");
        for (Animal animal : animals) {
            System.out.println(animal.getName() + "—————" + animal.getKind());
        }
        System.out.println("请输入姓名查询动物具体信息：");
        String name = scanner.next();
        for (Animal animal : animals) {
            if (name.equals(animal.getName()) || name == animal.getName()) {
                System.out.println(animal);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("查无此动物");
        }
    }

    public void sort() {
        System.out.println("——————————5.年龄从小到大排序——————————");
        Collections.sort(animals);
        for (Animal animal : animals) {
            System.out.println(animal.getName() + "——————" + animal.getAge());
        }
    }
}
