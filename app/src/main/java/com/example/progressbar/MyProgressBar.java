package com.example.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyProgressBar extends View {

    private RectF whiteRect;
    private RectF progressRect;
    private RectF borderRect;
    private Paint whitePaint;
    private Paint progressPaint;
    private Paint borderPaint;
    private Paint textPaint;
    private Path triangle;

    private int progress;

    public void setProgress(int progress) {
        if(progress >= 0 && progress <= 100){
            this.progress = progress;
            invalidate();
        }
    }

    public MyProgressBar(Context context) {
        super(context);

        init(null);
    }

    public MyProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public MyProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    public MyProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }
    private void init(@Nullable AttributeSet set){
        whiteRect = new RectF();
        progressRect = new RectF();
        borderRect = new RectF();

        whitePaint = new Paint();
        whitePaint.setColor(Color.WHITE);

        progressPaint = new Paint();
        progressPaint.setColor(Color.parseColor("#000080"));
        progressPaint.setTextSize(30);
        progressPaint.setTextAlign(Paint.Align.CENTER);

        borderPaint = new Paint();
        borderPaint.setColor(Color.parseColor("#000080"));
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(4);
        borderPaint.setAntiAlias(true);

        textPaint = new Paint();
        textPaint.setTextSize(30);
        textPaint.setAntiAlias(true);

        triangle = new Path();

        progress = 0;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        float barWidth = (float) ((0.8-0.0288)*getWidth());

        //PROGRESS TEXT
        canvas.drawText(String.valueOf(progress) + "%", (float)(0.1*getWidth()+0.93*barWidth), (float)(0.5*getHeight() - (textPaint.descent() + textPaint.ascent()) / 2), textPaint);

        //DRAW SMALL TRIANGLE
        triangle.reset();
        triangle.moveTo((float) (0.1*getWidth() + barWidth*(progress*0.01 + 0.018)), (float) (0.485*getHeight() + 0.018*barWidth));
        triangle.lineTo((float) (0.1*getWidth() + barWidth*(progress*0.01 + 0.018)), (float) (0.515*getHeight() - 0.018*barWidth));
        triangle.lineTo((float) (0.1*getWidth() + barWidth*(progress*0.01 + 0.018) + 0.03*getHeight() - 0.036*barWidth), (float) (0.485*getHeight() + 0.018*barWidth));
        triangle.close();
        canvas.drawPath(triangle, progressPaint);

        //DRAW SLASH 1
        triangle.reset();
        triangle.moveTo((float) (0.1*getWidth() + barWidth*(progress*0.01 + 0.018) + 0.03*getHeight() - 0.0242*barWidth), (float) (0.485*getHeight() + 0.0178*barWidth));
        triangle.lineTo((float) (0.1*getWidth() + barWidth*(progress*0.01 + 0.018) + 0.0118*barWidth), (float) (0.515*getHeight() - 0.0178*barWidth));
        triangle.lineTo((float) (0.1*getWidth() + barWidth*(progress*0.01 + 0.018) + 0.0298*barWidth), (float) (0.515*getHeight() - 0.0178*barWidth));
        triangle.lineTo((float) (0.1*getWidth() + barWidth*(progress*0.01 + 0.018) + 0.03*getHeight() - 0.0062*barWidth), (float) (0.485*getHeight() + 0.0178*barWidth));
        triangle.close();
        canvas.drawPath(triangle, progressPaint);

        //DRAW SLASH 2
        triangle.reset();
        triangle.moveTo((float) (0.1*getWidth() + barWidth*(progress*0.01 + 0.018) + 0.03*getHeight() + 0.0062*barWidth), (float) (0.485*getHeight() + 0.0178*barWidth));
        triangle.lineTo((float) (0.1*getWidth() + barWidth*(progress*0.01 + 0.018) + 0.0416*barWidth), (float) (0.515*getHeight() - 0.0178*barWidth));
        triangle.lineTo((float) (0.1*getWidth() + barWidth*(progress*0.01 + 0.018) + 0.059*barWidth), (float) (0.515*getHeight() - 0.0178*barWidth));
        triangle.lineTo((float) (0.1*getWidth() + barWidth*(progress*0.01 + 0.018) + 0.03*getHeight() + 0.0242*barWidth), (float) (0.485*getHeight() + 0.0178*barWidth));
        triangle.close();
        canvas.drawPath(triangle, progressPaint);

        //DRAW WHITE RECT FOR HIDING ABOVE ELEMENTS
        whiteRect.bottom = (float) (0.515*getHeight() - 0.018*barWidth);
        whiteRect.left = (float) (0.1*getWidth() + 1.018*barWidth);
        whiteRect.top = (float) (0.485*getHeight() + 0.018*barWidth);
        whiteRect.right = (float) (0.1*getWidth() + barWidth*1.12);
        canvas.drawRect(whiteRect, whitePaint);

        //DRAW BORDER RECT
        borderRect.bottom = (float) (0.515*getHeight());
        borderRect.left = (float) (0.1*getWidth());
        borderRect.top = (float) (0.485*getHeight());
        borderRect.right = (float) (0.9*getWidth());
        canvas.drawRect(borderRect,borderPaint);

        //DRAW PROGRESS RECT
        progressRect.bottom = (float) (0.515*getHeight() - 0.018*barWidth);
        progressRect.left = (float) (0.1*getWidth() + 0.018*barWidth);
        progressRect.top = (float) (0.485*getHeight() + 0.018*barWidth);
        progressRect.right = (float) (0.1*getWidth() + barWidth*(progress*0.01 + 0.018));
        canvas.drawRect(progressRect, progressPaint);

    }
}
