package com.example.a478529_pppb2_tugas10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Bitmap mBitmap;
    private ImageView mImageView;
    private Rect mBounds = new Rect();
    private int mOffset = OFFSET;
    private static final int OFFSET = 120;
    private static final int MULTIPLIER = 100;

    private int mColorPink;
    private int mColorBlue;
    private int mColorGreen;
    private int mColorYellow;
    private int mColorChocolate;
    private int mColorWhite;

    private int mColorCherry;
    private int mColorIce;
    private int mColorCone;
    private int mColorBackground;
    private int mCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mColorPink = ResourcesCompat.getColor(getResources(), R.color.pink, null);
        mColorBlue = ResourcesCompat.getColor(getResources(), R.color.blue, null);
        mColorGreen = ResourcesCompat.getColor(getResources(), R.color.green, null);
        mColorYellow = ResourcesCompat.getColor(getResources(), R.color.yellow, null);
        mColorChocolate = ResourcesCompat.getColor(getResources(), R.color.chocolate, null);
        mColorWhite = ResourcesCompat.getColor(getResources(), R.color.white, null);

        mColorCherry = ResourcesCompat.getColor(getResources(), R.color.cherry, null);
        mColorIce = ResourcesCompat.getColor(getResources(), R.color.ice, null);
        mColorCone = ResourcesCompat.getColor(getResources(), R.color.cone, null);
        mColorBackground = ResourcesCompat.getColor(getResources(), R.color.background, null);

        mImageView = findViewById(R.id.image_view);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawSomething(v, mCount);
                mCount += 1;
            }
        });
    }

    public void drawSomething(View v, int count){
        int width = v.getWidth();
        int height = v.getHeight();
        int halfWidth = v.getWidth()/2;
        int halfHeight = v.getHeight()/2;
        float radius = (float) (Math.min(width/6, height/6));

        if(count == 0) {
            mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            mImageView.setImageBitmap(mBitmap);
            mCanvas = new Canvas(mBitmap);
        }

        else if(count == 1) {
            //Background
            mPaint.setColor(mColorBackground);
            Point k = new Point(halfWidth - 1000, halfHeight - 1000);
            Point l = new Point(halfWidth + 1000, halfHeight - 1000);
            Point m = new Point(halfWidth + 1000, halfHeight + 1000);
            Point n = new Point(halfWidth - 1000, halfHeight + 1000);

            Path bg = new Path();
            bg.setFillType(Path.FillType.EVEN_ODD);
            bg.lineTo(k.x, k.y);
            bg.lineTo(l.x, l.y);
            bg.lineTo(m.x, m.y);
            bg.lineTo(n.x, n.y);
            bg.lineTo(k.x, k.y);
            bg.close();

            mCanvas.drawPath(bg, mPaint);
        }

        else if(count == 2) {
            //Cone
            mPaint.setColor(mColorCone - MULTIPLIER * mOffset);
            Point a = new Point(halfWidth, halfHeight + 600);
            Point b = new Point(halfWidth + 200, halfHeight - 200);
            Point c = new Point(halfWidth - 200, halfHeight - 200);

            Path path = new Path();
            path.setFillType(Path.FillType.EVEN_ODD);
            path.lineTo(a.x, a.y);
            path.lineTo(b.x, b.y);
            path.lineTo(c.x, c.y);
            path.lineTo(a.x, a.y);
            path.close();

            mCanvas.drawPath(path, mPaint);
        }

        else if(count == 3) {
            //Ice Melt
            mPaint.setColor(mColorIce);
            mCanvas.drawCircle(halfWidth, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorIce);
            mCanvas.drawCircle(halfWidth + 90, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorIce);
            mCanvas.drawCircle(halfWidth - 90, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorIce);
            mCanvas.drawCircle(halfWidth + 180, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorIce);
            mCanvas.drawCircle(halfWidth - 180, halfHeight - 200, halfHeight / 16, mPaint);
        }

        else if(count == 4) {
            //Ice
            mPaint.setColor(mColorIce);
            mCanvas.drawCircle(halfWidth, halfHeight - 400, halfHeight / (8/2), mPaint);
        }

        else if(count == 5) {
            //Cherry
            mPaint.setColor(mColorCherry);
            mCanvas.drawCircle(halfWidth + 150, halfHeight - 580, halfHeight/13, mPaint);
            int x = halfWidth - mBounds.centerX();
            int y = halfHeight - mBounds.centerY();
        }

        //Pink
        else if(count == 6) {
            //Ice Melt
            mPaint.setColor(mColorPink);
            mCanvas.drawCircle(halfWidth, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorPink);
            mCanvas.drawCircle(halfWidth + 90, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorPink);
            mCanvas.drawCircle(halfWidth - 90, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorPink);
            mCanvas.drawCircle(halfWidth + 180, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorPink);
            mCanvas.drawCircle(halfWidth - 180, halfHeight - 200, halfHeight / 16, mPaint);

            //Ice
            mPaint.setColor(mColorPink);
            mCanvas.drawCircle(halfWidth, halfHeight - 400, halfHeight / (8/2), mPaint);

            //Cherry
            mPaint.setColor(mColorCherry);
            mCanvas.drawCircle(halfWidth + 150, halfHeight - 580, halfHeight/13, mPaint);
            int x = halfWidth - mBounds.centerX();
            int y = halfHeight - mBounds.centerY();
        }

        //Blue
        else if(count == 7) {
            //Ice Melt
            mPaint.setColor(mColorBlue);
            mCanvas.drawCircle(halfWidth, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorBlue);
            mCanvas.drawCircle(halfWidth + 90, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorBlue);
            mCanvas.drawCircle(halfWidth - 90, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorBlue);
            mCanvas.drawCircle(halfWidth + 180, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorBlue);
            mCanvas.drawCircle(halfWidth - 180, halfHeight - 200, halfHeight / 16, mPaint);

            //Ice
            mPaint.setColor(mColorBlue);
            mCanvas.drawCircle(halfWidth, halfHeight - 400, halfHeight / (8/2), mPaint);

            //Cherry
            mPaint.setColor(mColorCherry);
            mCanvas.drawCircle(halfWidth + 150, halfHeight - 580, halfHeight/13, mPaint);
            int x = halfWidth - mBounds.centerX();
            int y = halfHeight - mBounds.centerY();
        }

        //Green
        else if(count == 8) {
            //Ice Melt
            mPaint.setColor(mColorGreen);
            mCanvas.drawCircle(halfWidth, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorGreen);
            mCanvas.drawCircle(halfWidth + 90, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorGreen);
            mCanvas.drawCircle(halfWidth - 90, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorGreen);
            mCanvas.drawCircle(halfWidth + 180, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorGreen);
            mCanvas.drawCircle(halfWidth - 180, halfHeight - 200, halfHeight / 16, mPaint);

            //Ice
            mPaint.setColor(mColorGreen);
            mCanvas.drawCircle(halfWidth, halfHeight - 400, halfHeight / (8/2), mPaint);

            //Cherry
            mPaint.setColor(mColorCherry);
            mCanvas.drawCircle(halfWidth + 150, halfHeight - 580, halfHeight/13, mPaint);
            int x = halfWidth - mBounds.centerX();
            int y = halfHeight - mBounds.centerY();
        }

        //Yellow
        else if(count == 9) {
            //Ice Melt
            mPaint.setColor(mColorYellow);
            mCanvas.drawCircle(halfWidth, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorYellow);
            mCanvas.drawCircle(halfWidth + 90, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorYellow);
            mCanvas.drawCircle(halfWidth - 90, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorYellow);
            mCanvas.drawCircle(halfWidth + 180, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorYellow);
            mCanvas.drawCircle(halfWidth - 180, halfHeight - 200, halfHeight / 16, mPaint);

            //Ice
            mPaint.setColor(mColorYellow);
            mCanvas.drawCircle(halfWidth, halfHeight - 400, halfHeight / (8/2), mPaint);

            //Cherry
            mPaint.setColor(mColorCherry);
            mCanvas.drawCircle(halfWidth + 150, halfHeight - 580, halfHeight/13, mPaint);
            int x = halfWidth - mBounds.centerX();
            int y = halfHeight - mBounds.centerY();
        }

        //Chocolate
        else if(count % 2 == 0) {
            //Ice Melt
            mPaint.setColor(mColorChocolate);
            mCanvas.drawCircle(halfWidth, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorChocolate);
            mCanvas.drawCircle(halfWidth + 90, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorChocolate);
            mCanvas.drawCircle(halfWidth - 90, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorChocolate);
            mCanvas.drawCircle(halfWidth + 180, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorChocolate);
            mCanvas.drawCircle(halfWidth - 180, halfHeight - 200, halfHeight / 16, mPaint);

            //Ice
            mPaint.setColor(mColorChocolate);
            mCanvas.drawCircle(halfWidth, halfHeight - 400, halfHeight / (8/2), mPaint);

            //Cherry
            mPaint.setColor(mColorCherry);
            mCanvas.drawCircle(halfWidth + 150, halfHeight - 580, halfHeight/13, mPaint);
            int x = halfWidth - mBounds.centerX();
            int y = halfHeight - mBounds.centerY();
        }

        //White
        else if(count % 2 == 1) {
            //Ice Melt
            mPaint.setColor(mColorWhite);
            mCanvas.drawCircle(halfWidth, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorWhite);
            mCanvas.drawCircle(halfWidth + 90, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorWhite);
            mCanvas.drawCircle(halfWidth - 90, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorWhite);
            mCanvas.drawCircle(halfWidth + 180, halfHeight - 200, halfHeight / 16, mPaint);
            mPaint.setColor(mColorWhite);
            mCanvas.drawCircle(halfWidth - 180, halfHeight - 200, halfHeight / 16, mPaint);

            //Ice
            mPaint.setColor(mColorWhite);
            mCanvas.drawCircle(halfWidth, halfHeight - 400, halfHeight / (8/2), mPaint);

            //Cherry
            mPaint.setColor(mColorCherry);
            mCanvas.drawCircle(halfWidth + 150, halfHeight - 580, halfHeight/13, mPaint);
            int x = halfWidth - mBounds.centerX();
            int y = halfHeight - mBounds.centerY();
        }

        v.invalidate();
    }
}
