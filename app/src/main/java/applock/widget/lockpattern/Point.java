package applock.widget.lockpattern;

/**
 * Created by Xiamin on 2016/12/3.
 */
public class Point {
    public static final int STATE_NORMAL = 0;
    public static final int STATE_PRESSED = 1;
    public static final int STATE_ERROR = 2;

    private float mX;
    private float mY;
    private int mIndex;
    private int mState;

    public Point(float x, float y) {
        this.mX = x;
        this.mY = y;
    }

    /**
     * 求两点之间距离
     *
     * @param a
     * @param b
     * @return
     */
    public static double getDistance(Point a, Point b) {
        return Math.sqrt(Math.pow(Math.abs(a.getX() - b.getX()), 2)
                + Math.pow(Math.abs(a.getY() - b.getY()), 2));
    }

    /**
     * 返回是否在范围内的布尔值
     * @param pointX
     * @param pointY
     * @param r
     * @param moveX
     * @param moveY
     * @return
     */
    public static boolean isWith(float pointX, float pointY, float r, float moveX, float moveY) {
        return Math.sqrt((pointX - moveX) * (pointX - moveX) +
                (pointY - moveY) * (pointY - moveY)) < r;
    }

    public boolean isWith(float r, float moveX, float moveY) {
        return Math.sqrt((mX - moveX) * (mX - moveX) +
                (mY - moveY) * (mY - moveY)) < r;
    }


    /*********************
     * get and set
     ***************************************/
    public float getX() {
        return mX;
    }

    public void setX(float mX) {
        this.mX = mX;
    }

    public float getY() {
        return mY;
    }

    public void setY(float mY) {
        this.mY = mY;
    }

    public int getIndex() {
        return mIndex;
    }

    public void setIndex(int mIndex) {
        this.mIndex = mIndex;
    }

    public int getState() {
        return mState;
    }

    public void setState(int mState) {
        this.mState = mState;
    }
}
