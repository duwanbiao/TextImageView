package com.simple.text.imageView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.imagetext.R;

@SuppressLint("AppCompatCustomView")
public class TextImageView extends ImageView {
    int originWidthSize = 12;//初始设定值
    int widthSize = 12;//像素值
    float aspectRatio = 2f;//比值
    private Paint paint;
    String NumString = "0";

    public TextImageView(Context context) {
        this(context,null);
    }

    public TextImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TextImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public TextImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getMeasuredWidth()/NumString.toCharArray().length<=originWidthSize){
            widthSize = getMeasuredWidth()/NumString.toCharArray().length;
        }else {
            widthSize = originWidthSize;
        }
        int width = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(width, (int) (widthSize*aspectRatio));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        toText(canvas);
    }

    private void init(Context context, AttributeSet attrs){
        paint = new Paint();
        TypedArray types = context.obtainStyledAttributes(attrs, R.styleable.TextImageView);
        try {
            originWidthSize = types.getDimensionPixelSize(R.styleable.TextImageView_size, originWidthSize);
            aspectRatio = types.getFloat(R.styleable.TextImageView_aspectRatio,aspectRatio);
            NumString = types.getString(R.styleable.TextImageView_text)==null?NumString:types.getString(R.styleable.TextImageView_text);
        } finally {
            types.recycle();
        }
    }
    private void toText(Canvas canvas) {
        char[] charArray = NumString.toCharArray();
        int mLeftSize = 0;
        for (char num : charArray) {
            int mWithSize = widthSize;
            Bitmap bitmap = null;
            switch (String.valueOf(num)) {
                case "0":
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.num0);
                    break;
                case "1":
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.num1);
                    break;
                case "2":
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.num2);
                    break;
                case "3":
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.num3);
                    break;
                case "4":
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.num4);
                    break;
                case "5":
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.num5);
                    break;
                case "6":
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.num6);
                    break;
                case "7":
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.num7);
                    break;
                case "8":
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.num8);
                    break;
                case "9":
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.num9);
                    break;
                case "$":
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.symbol_us);
                    break;
                case ".":
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dian);
                    mWithSize = mWithSize / 2;
                    break;
            }
            if (bitmap != null) {
                bitmap = Bitmap.createScaledBitmap(bitmap, mWithSize, (int) (widthSize * aspectRatio), false);
                canvas.drawBitmap(bitmap, mLeftSize, 0, paint);
                bitmap.recycle();
                mLeftSize = mLeftSize + widthSize;
                if (mWithSize != widthSize) {
                    mLeftSize = mLeftSize - mWithSize;
                }
            }
        }
    }

    /**
     * 设置文本
     * @param text number
     */
    public void setText(String text){
        NumString = text;
        invalidate();
    }

    /**
     * 获取数字
     * @return 数字文本
     */
    public String getText(){
        return NumString;
    }

    /**
     * 设置字体大小
     * @param size 像素值
     */
    public void setSize(int size){
        originWidthSize = size;
        invalidate();
    }

    /**
     * 获取字体大小
     * @return 像素值
     */
    public int getSize(){
        return widthSize;
    }

    /**
     * 设置宽高比例
     * @param aspectRatio 高/宽
     */
    public void setAspectRatio(float aspectRatio){
        this.aspectRatio = aspectRatio;
        invalidate();
    }

    public float getAspectRatio(){
        return aspectRatio;
    }
}
