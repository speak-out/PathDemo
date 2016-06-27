package administrator.example.com.pathdemo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by yuer on 2016/6/24.
 */


public class PathViewDemo1 extends View {
    private int mWidth;
    private int mHeight;
    private Path path;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;
    private float mAnimatorValue;
    private int defaultDuration = 2000;

    public PathViewDemo1(Context context) {
        this(context, null);
    }

    public PathViewDemo1(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth / 2, mHeight / 2);
        Path mPath = new Path();
        RectF mRectF = new RectF(0,0,200,200);
        mPath.addOval(mRectF, Path.Direction.CW);
//        mPath.addCircle(0, 0, 100, Path.Direction.CW);
        mPaint.setColor(Color.GRAY);
        canvas.drawPath(mPath,mPaint);
        mPaint.setColor(Color.GREEN);
        PathMeasure mPathMeasure = new PathMeasure(mPath, false);
        float stop = mPathMeasure.getLength() * mAnimatorValue;
        float start = (float) (stop - ((0.5 - Math.abs(mAnimatorValue - 0.5)) * 300f));
        Path dest = new Path();
        mPathMeasure.getSegment(start, stop, dest, true);
        canvas.drawPath(dest, mPaint);
    }

    private void initView(Context context) {
//        mValueAnimator = new ValueAnimator();
        mValueAnimator = ValueAnimator.ofFloat(0f, 1f).setDuration(defaultDuration);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(15);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mAnimatorValue = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        mValueAnimator.setRepeatMode(ValueAnimator.RESTART);
        mValueAnimator.setRepeatCount(100);
        mValueAnimator.setInterpolator(new LinearInterpolator());
        mValueAnimator.start();

    }
}
