package com.example.zcucai.fragment_activity;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;

import com.example.zcucai.R;

public class MyCustomTextView extends AppCompatTextView {
    Context mContext;

    public MyCustomTextView(@NonNull Context context) {
        super(context);
        initView(context, null);

        this.setTextColor(Color.RED);
    }

    public MyCustomTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);

        this.setTextColor(Color.BLUE);
    }

    public MyCustomTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);

        this.setTextColor(Color.GREEN);
    }

    public void initView(Context context, AttributeSet attrs) {

        this.mContext = context;
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.MyCustomTextView, 0, 0);
        int mFont = typedArray.getInt(R.styleable.MyCustomTextView_mFont, 0);

        switch (mFont){
            case 1:
                setTypeface(ResourcesCompat.getFont(mContext, R.font.arabia));
                break;
            case 2:
                setTypeface(ResourcesCompat.getFont(mContext, R.font.architep));
                break;
            default:
                setTypeface(ResourcesCompat.getFont(mContext, R.font.aristoni));

        }
    }
}
