package com.example.dp.ch3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by dp on 2018/9/29.
 */

public class PlaneView extends View {

    public float currentX;
    public float currentY;
    Bitmap plane, plane1, plane2;

    public  PlaneView(Context context){
        super(context);

        plane= BitmapFactory.decodeResource(context.getResources(),R.drawable.plane);
        plane1=imageScale(plane, 60,80);
        plane2=imageScale(plane, 60,80);

        setFocusable(true);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas );
        Paint p=new Paint();
        canvas.drawBitmap(plane, currentX, currentY, p);
        canvas.drawBitmap(plane1, currentX+260, currentY+40, p);
        canvas.drawBitmap(plane1, currentX-10, currentY+40, p);
    }

    /**
     * 调整图片大小
     *
     * @param bitmap
     *            源
     * @param dst_w
     *            输出宽度
     * @param dst_h
     *            输出高度
     * @return
     */
    public static Bitmap imageScale(Bitmap bitmap, int dst_w, int dst_h) {
        int src_w = bitmap.getWidth();
        int src_h = bitmap.getHeight();
        float scale_w = ((float) dst_w) / src_w;
        float scale_h = ((float) dst_h) / src_h;
        Matrix matrix = new Matrix();
        matrix.postScale(scale_w, scale_h);
        Bitmap dstbmp = Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix,
                true);
        return dstbmp;
    }

}
