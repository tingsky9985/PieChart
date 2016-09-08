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

    private int width,height;

    private Paint mPaint = new Paint();

    public PieChartView(Context context) {
        this(context,null);
    }

    public PieChartView(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
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

       // float currentStartAngle = mStartAngle;

        canvas.translate(width/2, height/2);

        RectF mRecf = new RectF();
    }
}
