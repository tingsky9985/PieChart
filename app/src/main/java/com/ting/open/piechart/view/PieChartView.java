package com.ting.open.piechart.view;

/**
 * Created by lt on 2016/9/8.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.ting.open.piechart.bean.PieChart;

import java.util.ArrayList;

/**
 * 自定义view的思路
 * 1.构造函数，初始化
 * 2.onMeasure
 * 3.onSizeChanged
 * 4.onLayout
 * 5.onDraw
 * invalidate
 * 6.提供接口
 */
public class PieChartView extends View {

    private int width, height;
    private float mStartAngle;

    // 颜色表 (注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    private ArrayList<PieChart> mDatas;

    private Paint mPaint = new Paint();

    public PieChartView(Context context) {
        this(context, null);
    }

    public PieChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initPaint();
    }

    /**
     * 初始化paint
     */
    private void initPaint() {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mDatas == null) return;

        float currentStartAngle = mStartAngle; //当前初始角度
        canvas.translate(width / 2, height / 2);  //将画布坐标原点移动到画布中心
        float r = (float) (Math.min(width, height) / 2 * 0.8); //圆饼半径
        RectF mRecf = new RectF(-r, -r, r, r);//饼形图区域

        for (int i = 0; i < mDatas.size(); i++) {
            PieChart data = mDatas.get(i);
            mPaint.setColor(data.getColor());
            canvas.drawArc(mRecf, currentStartAngle, data.getAngle(), false, mPaint);
            currentStartAngle += data.getAngle();
        }

    }

    //设置起始角度
    public void setStartAngle(int startAngle){
        this.mStartAngle = startAngle;
        invalidate();
    }


    //设置数据
    public void setData(ArrayList<PieChart> datas){
        this.mDatas = datas;
        initData(mDatas);
        invalidate();
    }

    private void initData(ArrayList<PieChart> mDatas) {
        float sumValue = 0;
        for(int i = 0; i < mDatas.size(); i ++){
            PieChart chart = mDatas.get(i);
            sumValue += chart.getValue();
            int j = i % mColors.length;
            chart.setColor(mColors[j]);
        }

        float sumAngle = 0;
        for(int j = 0;j < mDatas.size(); j++){
            PieChart chart = mDatas.get(j);
            float percentage = chart.getValue() / sumValue;//设置百分比
            float angle = percentage * 360; //对应的角度

            chart.setPercentage(percentage);
            chart.setAngle(angle);

            sumAngle += angle;
        }

    }
}
