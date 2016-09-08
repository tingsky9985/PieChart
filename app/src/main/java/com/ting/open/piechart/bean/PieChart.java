package com.ting.open.piechart.bean;

/**
 * Created by lt on 2016/9/8.
 */

/**
 * 饼图需要的数据
 */
public class PieChart {

    //显示在界面上的内容
    private String name;//名称
    private float value;//数值
    private float percentage;//百分比

    //程序中需要的值
    private int color;//颜色
    private int angle;//角度

    public PieChart(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
}
