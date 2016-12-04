package applock.widget.lockpattern;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import applock.anderson.com.applock.R;
import applock.widget.lockpattern.Utils.ImageUtils;

/**
 * Created by Xiamin on 2016/12/3.
 */
public class LockPatternView extends View {
    private static final String TAG = "LockPatternView";

    private Point[][] mPoints = new Point[3][3];
    private boolean isInit;

    private float mWidth;
    private float mHeight;
    private Paint mPaint;

    private Bitmap mBitmapNormal;
    private Bitmap mBitmapPressed;
    private Bitmap mBitmapError;
    private int mBitmapR;
    private Bitmap mBitmapLinePressed;
    private Bitmap mBitmapLineError;

    public LockPatternView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LockPatternView(Context context) {
        super(context);
    }

    public LockPatternView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (!isInit) {
            initPoints();
        }
        pointToCanvas(canvas);
    }

    private void initPoints() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mHeight = getHeight();
        mWidth = getWidth();

        Log.i(TAG, "getHeight = " + mHeight + " getWidth = " + mWidth);
        Log.i(TAG, "getX = " + getX() + " getY = " + getY());

        //初始化点的坐标 以及偏移量
        float x = 0;
        float y = 0;
        float lenth = mHeight / 4;
        mPoints[0][0] = new Point(x + lenth, y + lenth);
        mPoints[0][1] = new Point(x + lenth * 2, y + lenth);
        mPoints[0][2] = new Point(x + lenth * 3, y + lenth);
        mPoints[1][0] = new Point(x + lenth, y + lenth * 2);
        mPoints[1][1] = new Point(x + lenth * 2, y + lenth * 2);
        mPoints[1][2] = new Point(x + lenth * 3, y + lenth * 2);
        mPoints[2][0] = new Point(x + lenth, y + lenth * 3);
        mPoints[2][1] = new Point(x + lenth * 2, y + lenth * 3);
        mPoints[2][2] = new Point(x + lenth * 3, y + lenth * 3);

        /*初始化图标资源*/
        mBitmapR = (int)(lenth * 0.43);
        mBitmapNormal = ImageUtils.getBitmap(getResources(), R.drawable.lock_normal, mBitmapR, mBitmapR);
        mBitmapPressed = ImageUtils.getBitmap(getResources(), R.drawable.lock_pressed, mBitmapR, mBitmapR);
        mBitmapError = ImageUtils.getBitmap(getResources(), R.drawable.lock_error, mBitmapR, mBitmapR);
//        mBitmapNormal = BitmapFactory.decodeResource(getResources(), R.drawable.lock_normal);
//        mBitmapPressed = BitmapFactory.decodeResource(getResources(), R.drawable.lock_pressed);
//        mBitmapError = BitmapFactory.decodeResource(getResources(), R.drawable.lock_error);

    }

    /**
     * 点绘制到画布上
     *
     * @param canvas 画布
     */
    private void pointToCanvas(Canvas canvas) {
        Bitmap bitmap = null;
        for (int i = 0; i < mPoints.length; i++) {
            for (int j = 0; j < mPoints[i].length; j++) {

                Point point = mPoints[i][j];
                Log.i(TAG, "pointX = " + point.getX() + " pointY = " + point.getY());
                switch (point.getState()) {
                    case Point.STATE_NORMAL:
                        bitmap = mBitmapNormal;
                        break;
                    case Point.STATE_PRESSED:
                        bitmap = mBitmapPressed;
                        break;
                    case Point.STATE_ERROR:
                        bitmap = mBitmapError;
                        break;
                }
                if(bitmap != null) {
                    canvas.drawBitmap(mBitmapNormal,point.getX() - mBitmapR ,point.getY()- mBitmapR,mPaint);
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }

        return super.onTouchEvent(event);
    }
}
