package com.chapter101.innerclass;

public class AnonymousInnerClassDetail {
    public static void main(String[] args){
        Outer05 outer05 = new Outer05();
        outer05.f1();
        System.out.println("main Outer05 hashcode="+outer05);

    }
}

class Outer05{
    private int n1=99;
    public void f1(){
        //创建一个基于类的匿名内部类
        //不能添加访问修饰符，因为它的地位就是一个局部变量
        //作用域：仅仅在定义它的方法或代码块中 Outer05$1
        Person p=new Person(){
            private int n1=88;
            @Override
            public void Hi() {
                System.out.println("匿名内部类重写了Hi方法 n1="+n1+"外部类的n1="+Outer05.this.n1);
                System.out.println("Outer05.this hashcode="+Outer05.this);
            }
        };
        p.Hi();//动态绑定，运行类型是Outer05$1
        //也可以直接调用,匿名内部类本质也是返回对象
        //class 匿名内部类 extends Person{}
//        new Person(){
//            @Override
//            public void Hi() {
//                //可以直接访问外部类的所有成员，包括私有的
//                System.out.println("匿名内部类重写了Hi方法哈哈哈");
//            }
//
//            @Override
//            public void ok(String str) {
//                super.ok(str);
//            }
//        }.ok("jack");
    }
}

class Person{//类
    public void Hi(){
        System.out.println("Person hi()");
    }
    public void ok(String str){
        System.out.println("Person ok()"+str);
    }

}
//抽象类/接口...
