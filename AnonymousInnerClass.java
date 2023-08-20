package com.chapter101.innerclass;
/*
演示匿名内部类的使用
 */

public class AnonymousInnerClass {
    public static void main(String[] args){
        Outer04 outer04 = new Outer04();
        outer04.method();

    }
}

class Outer04{//外部类
    private int n1=10;//属性
    public void method(){//方法
        //基于接口的匿名内部类
        //1.需求：想使用IA接口，并创建对象
        //2.传统方法是写一个类，实现该接口，并创建对象
        //3.新需求：Tiger/Dog这个类只使用1次，后面再不使用
        //4.可以使用匿名内部类来简化开发
        //5.tiger的编译类型？编译类型看等号的左边，就是接口IA的类型
        //6.tiger的运行类型？匿名内部类XXX=Outer04$1
        /*
        底层会分配类名Outer04$1
        class xxx implements IA(){
             @Override
            public void cry() {
                System.out.println("老虎叫唤...");
            }
        }
         */
        //7.jdk底层在创建匿名内部类Outer04$1，立即就创建了Outer04$1实例，并且把地址
        //返回给tiger
        //8.匿名内部类使用一次就不能再使用，tiger是个对象，可以反复调用
//        IA tiger = new Tiger();
//        tiger.cry();
        IA tiger=new IA(){
            @Override
            public void cry() {
                System.out.println("老虎叫唤...");
            }
        };
        System.out.println("tiger的运行类型="+tiger.getClass());
        tiger.cry();
        tiger.cry();
        tiger.cry();
        //演示基于类的匿名内部类
        //分析
        //1.father的编译类型：Father
        //2.father的运行类型：Outer04$2(带大括号是这个），Father(不带大括号是这个）
        //3.底层会创建匿名内部类
        /*
            class Outer04$2 extends Father{
                 @Override
                public void test() {
                    System.out.println("匿名内部类重写了test类");
                }
            }
         */
        //4.同时也直接返回了 匿名内部类Outer04$2的对象
        //5.注意("jack")参数列表会传递给构造器
        Father father=new Father("jack"){

            @Override
            public void test() {
                System.out.println("匿名内部类重写了test类");
            }
        };
        System.out.println("father对象的运行类型="+father.getClass());//Outer04$2
        father.test();
        //基于抽象类的匿名内部类
        Animal animal=new Animal(){
            @Override
            void eat() {
                System.out.println("小狗吃骨头");

            }
        };
        animal.eat();


    }
}

interface IA{//接口
    public void cry();
}

//class Tiger implements IA{
//
//    @Override
//    public void cry() {
//        System.out.println("老虎叫唤...");
//    }
//}
//
//class Dog implements IA{
//    @Override
//    public void cry() {
//        System.out.println("小狗汪汪...");
//
//    }
//}

class Father{//类
    public Father(String name){//构造器，下面的super（）可删去
        System.out.println("接收到的name="+name);
    }
    public void test(){//方法

    }

}

abstract class Animal{//抽象类
    abstract void eat();

}
