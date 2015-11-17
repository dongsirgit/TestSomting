/**
 *Copyright (c) 1997, 2015,BEST WONDER CO.,LTD. All rights reserved.
 */

package com.ldm;

import java.util.Observable;
import java.util.Observer;

/**
  * @ClassName: TestOb
  * @Description: TODO
  * @author Administrator
  * @date 2015年11月3日 下午3:26:51
  */
class House extends Observable {   
    private float price;   
  
    public void setPrice(float price) {   
        this.setChanged();// 设置变化点  
        this.notifyObservers(price);// 通知所有观察者价格改变  
        this.price = price;   
    }   
  
    public float getPrice() {   
        return this.price;   
    }   
  
    public House(float price) {   
        this.price = price;   
    }   
  
    public String toString() {   
        return "房子价格为: " + this.price;   
    }   
}   
  
class HousePriceObserver implements Observer {   
    private String name;   
  
    public HousePriceObserver(String name) {   
        super();   
        this.name = name;   
    }   
  
    @Override  
    public void update(Observable o, Object arg) {// 只要改变了 observable 对象就调用此方法  
        if (arg instanceof Float) {   
            System.out.println(this.name + "观察的价格更改为:"  
                    + ((Float) arg).floatValue());   
        }   
  
    }   
  
}   
  
public class TestOb {   
    public static void main(String[] args) {   
        House h = new House(1000000);   
        HousePriceObserver hpo1 = new HousePriceObserver("购房者A");   
        HousePriceObserver hpo2 = new HousePriceObserver("购房者B");   
        HousePriceObserver hpo3 = new HousePriceObserver("购房者C");   
        HousePriceObserver hpo4 = new HousePriceObserver("购房者D");   
        h.addObserver(hpo1);// 给房子注册观察者   
        h.addObserver(hpo2);// 给房子注册观察者   
        h.addObserver(hpo3);// 给房子注册观察者   
        h.addObserver(hpo4);// 给房子注册观察者   
        System.out.println("初始价格:"+h);// 输出房子价格   
        // 修改房子价格，会触发update(Observable o, Object arg)方法通知购房者新的房价信息  
        h.setPrice(123423);//   
        System.out.println("更新价格:"+h);// 再次输出房子价格   
    }   
} 