package com.example.facedetection;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;


import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Boxes extends View {

    Rect rect;

    float scaleX=1;
    float scaleY=1;

    int i_height;
    int i_width;

    int v_height;
    int v_width;

    Paint paint =new Paint(Paint.ANTI_ALIAS_FLAG);

    //Constructors
    public Boxes(Context context) {
        super(context);
        paint.setStyle(Paint.Style.STROKE);
    }

    public Boxes(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.STROKE);

    }

    public Boxes(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint.setStyle(Paint.Style.STROKE);

    }

    //Setters & Getters
    public void setBox(Rect rect){
        setScaler();
        this.rect=scaleBox(rect);
        invalidate();
    }


    public Rect getRect(){
        return rect;
    }


    //Clear
    public void clear(){
        rect=null;
        invalidate();
    }




    //Scaler


    public void setImgSize(int i_height,int i_width){
        this.i_height=i_height;
        this.i_width=i_width;
    }

    public void setViewSize(int v_height, int v_width){
        this.v_height=v_height;
        this.v_width=v_width;
    }

    private void setScaler(){
        scaleY = (float)v_height / (float)i_width;
        scaleX = (float)v_width / (float)i_height;
    }

    private float translateX(float x){
       return x*scaleX;
    }
    private float translateY(float y){
        return y*scaleY;
    }

    private Rect scaleBox(Rect box){
        return new Rect((int) (box.left*scaleX),(int)(box.top*scaleY),(int) (box.right*scaleX),(int)(box.bottom*scaleY));
    }



    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        paint.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));

        if(rect!=null){
            canvas.drawRect(rect,paint);
        }

    }



}
