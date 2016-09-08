package com.ting.open.piechart;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by lt on 2016/9/8.
 */

/**
 * 思路：
 * 1.由不同的扇形组成
 *   创建画笔和画布
 *   drawArc(l,t,r,b,startAngle,sweepAngle,usecenter,paint);
 * 2.主要数据：
 *   名称，百分比，对应的角度，颜色值，数据值
 * 3.提供接口
 *
 */

public class MainActivty extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
