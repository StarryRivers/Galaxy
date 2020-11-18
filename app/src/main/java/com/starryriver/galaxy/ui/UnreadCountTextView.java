package com.starryriver.galaxy.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.starryriver.galaxy.R;
import com.starryriver.galaxy.utils.Screen;

/**
 * Copyright  : qinjingsheng@foxmail.com
 * Project    : Galaxy
 * Package    : com.starryriver.galaxy.ui
 *
 * @author : StarryRivers
 * @date : 2020/11/14 16:56
 * Desc       : unread message count TextView
 **/
public class UnreadCountTextView extends AppCompatTextView {

    private Paint mPaint;
    private int mNormalSize = Screen.getPxByDp(18.4f);

    public UnreadCountTextView(@NonNull Context context) {
        super(context);
        init();
    }

    public UnreadCountTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public UnreadCountTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        // 初始化画笔
        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(R.color.unread_red_point));
        setTextColor(Color.WHITE);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 13.6f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = mNormalSize;
        int height = mNormalSize;
        if (getText().length() > 1) {
            width = mNormalSize + Screen.getPxByDp((getText().length() - 1) * 10);
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (getText().length() == 0) {
            // 没有字符，就在本View中心画一个小圆点
            int l = (getMeasuredWidth() - Screen.getPxByDp(10)) / 2;
            int r = getMeasuredWidth() - l;
            canvas.drawOval(new RectF(l, l, r, r), mPaint);
        } else if (getText().length() == 1) {
            canvas.drawOval(new RectF(0, 0, mNormalSize, mNormalSize), mPaint);
        } else if (getText().length() > 1) {
            canvas.drawRoundRect(new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight()), getMeasuredHeight() / 2, getMeasuredHeight() / 2, mPaint);
        }
        super.onDraw(canvas);
    }
}
