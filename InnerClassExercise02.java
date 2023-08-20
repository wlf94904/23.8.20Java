package com.chapter101.innerclass;

public class InnerClassExercise02 {
    public static void main(String[] args){
        CellPhone cellPhone = new CellPhone();
        //1.传递的是实现了Bell接口的匿名内部类
        //2.重写了ring
        //3.Bell bell=new Bell(){
//      //              @Override
        //              public void ring(){
        //                  System.out.println("懒猪起床了“);
        //              }
        //          }
        cellPhone.alarmClock(new Bell(){
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });

        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });


    }
}
interface Bell{//接口
    void ring();//方法
}
class CellPhone{//类
    public void alarmClock(Bell bell){//形参是Bell接口类型
        System.out.println(bell.getClass());
        bell.ring();//动态绑定
    }
}
