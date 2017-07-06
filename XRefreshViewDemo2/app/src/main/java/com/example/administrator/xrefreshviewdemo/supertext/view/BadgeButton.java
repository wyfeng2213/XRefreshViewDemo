package com.example.administrator.xrefreshviewdemo.supertext.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;

import deadline.statebutton.StateButton;

/**
 * Description:
 * Date：2017/07/04 16:34
 * Author: wangyong
 */

public class BadgeButton extends StateButton {

    private BadgeDrawable mBadgeDrawable;

    public BadgeButton(Context context) {
        this(context, null);
    }

    public BadgeButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BadgeButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs, ezy.library.badgebutton.R.styleable.BadgeButton);
        String badgeText = a.getString(ezy.library.badgebutton.R.styleable.BadgeButton_btnBadgeText);
        int badgeColor = a.getColor(ezy.library.badgebutton.R.styleable.BadgeButton_btnBadgeColor, 0xffFF4081);
        int badgeHeight = a.getDimensionPixelSize(ezy.library.badgebutton.R.styleable.BadgeButton_btnBadgeHeight, (int) (getResources().getDisplayMetrics().density * 12));
        boolean badgeVisible = a.getBoolean(ezy.library.badgebutton.R.styleable.BadgeButton_btnBadgeVisible, false);
        a.recycle();


        mBadgeDrawable = new BadgeDrawable(badgeHeight, badgeColor);
        mBadgeDrawable.setVisible(badgeVisible);
        mBadgeDrawable.setText(badgeText);

        setIcon(getCompoundDrawables()[1]);

    }

    public BadgeButton setIcon(Drawable drawable) {
        if (drawable != null && drawable.getBounds().isEmpty()) {
            drawable.setBounds(0, 0, drawable.getIntrinsicHeight(), drawable.getIntrinsicHeight());
        }
        Drawable[] cds = getCompoundDrawables();
        setCompoundDrawables(cds[0], drawable, cds[2], cds[3]);
        return this;
    }

    @Override
    public void setText(CharSequence text, BufferType type) {

        super.setText(text, type);
    }

    public BadgeButton setBadgeText(String text) {
        mBadgeDrawable.setText(text);
        return this;
    }

    public BadgeButton setBadgeVisible(boolean visible) {
        mBadgeDrawable.setVisible(visible);
        return this;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        if (getCompoundDrawables()[1] != null) {
            mBadgeDrawable.layout((width + getCompoundDrawables()[1].getIntrinsicWidth()) / 2, getPaddingTop(), width);
        } else {
            mBadgeDrawable.layout((width + (int) getLayout().getLineWidth(0)) / 2, getPaddingTop(), width);
        }

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        mBadgeDrawable.draw(canvas);
    }

    private static class BadgeDrawable extends GradientDrawable {
        private String mText;
        private boolean mIsVisible;
        private TextPaint mPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);

        private int mHeight = 0;

        public BadgeDrawable(int height, int color) {

            setColor(color);

            mPaint.setColor(0xffffffff);
            mPaint.setTextAlign(Paint.Align.CENTER);
            mPaint.setTextSize(height * 0.8f);

            mHeight = height;
        }

        void layout(int x, int y, int max) {
            Rect rect = getBounds();
            rect.offsetTo(Math.min(x - rect.width() / 2, max - rect.width() - (int) (0.2f * mHeight)), Math.max(0, y - rect.height() / 2));
            setBounds(rect);
        }

        void resize(int w, int h) {
            Rect rect = getBounds();
            setBounds(rect.left, rect.top, rect.left + w, rect.top + h);
            invalidateSelf();
        }

        public void setText(String text) {
            mText = text;
            if (TextUtils.isEmpty(mText)) {
                int size = (int) (mHeight * 0.65);
                resize(size, size);
            } else {
                int width = (int) (mPaint.measureText(mText) + 0.4 * mHeight);
                resize(Math.max(width, mHeight), mHeight);
            }
        }

        public void setVisible(boolean visible) {
            if (mIsVisible != visible) {
                invalidateSelf();
            }
            mIsVisible = visible;
        }

        @Override
        protected void onBoundsChange(Rect bounds) {
            super.onBoundsChange(bounds);
            setCornerRadius(getBounds().height() / 2f);
        }

        @Override
        public void draw(Canvas canvas) {
            if (!mIsVisible) {
                return;
            }
            super.draw(canvas);
            if (TextUtils.isEmpty(mText)) {
                return;
            }
            canvas.drawText(mText, getBounds().exactCenterX(), getBounds().exactCenterY() - (mPaint.descent() + mPaint.ascent()) / 2, mPaint);
        }
    }
}
