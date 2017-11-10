package eu.jonbo.zcalendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jonas on 2017-11-10.
 */

public class PanelHeader extends ViewGroup {

    private TextView mLeftLeftView;
    private TextView mLeftView;
    private TextView mCenterView;
    private TextView mRightView;
    private TextView mRightRightView;

    private int mLastPositionOffset = -1;

    public PanelHeader(Context context, AttributeSet attrs) {
        super(context, attrs);

        mLeftLeftView = new TextView(context);
        mLeftView = new TextView(context);
        mCenterView = new TextView(context);
        mRightView = new TextView(context);
        mRightRightView = new TextView(context);

        addView(mLeftLeftView);
        addView(mLeftView);
        addView(mCenterView);
        addView(mRightView);
        addView(mRightRightView);

        int[] attributes = new int[] {
                android.R.attr.textSize,
                android.R.attr.textColor
        };

        TypedArray a = context.obtainStyledAttributes(attrs, attributes);

        final int textSize = a.getDimensionPixelSize(0, 0);
        if (textSize != 0) {
            mLeftLeftView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            mLeftView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            mCenterView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            mRightView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            mRightRightView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        }

        if (a.hasValue(1)) {
            int textColor = a.getColor(1, 0);
            mLeftLeftView.setTextColor(textColor);
            mLeftView.setTextColor(textColor);
            mCenterView.setTextColor(textColor);
            mRightView.setTextColor(textColor);
            mRightRightView.setTextColor(textColor);
        }

        mLeftLeftView.setSingleLine();
        mLeftView.setSingleLine();
        mCenterView.setSingleLine();
        mRightView.setSingleLine();
        mRightRightView.setSingleLine();

        mLeftLeftView.setEllipsize(android.text.TextUtils.TruncateAt.END);
        mLeftView.setEllipsize(android.text.TextUtils.TruncateAt.END);
        mCenterView.setEllipsize(android.text.TextUtils.TruncateAt.END);
        mRightView.setEllipsize(android.text.TextUtils.TruncateAt.END);
        mRightRightView.setEllipsize(android.text.TextUtils.TruncateAt.END);

        a.recycle();
    }

    public void setText(String PreviousPrevious, String Previous, String Current, String Next, String NextNext) {
        mLeftLeftView.setText(PreviousPrevious);
        mLeftView.setText(Previous);
        mCenterView.setText(Current);
        mRightView.setText(Next);
        mRightRightView.setText(NextNext);
    }

    void updateTextPositions(int positionOffset) {
        if (mLastPositionOffset == positionOffset) {
            //return;
        }

        int screenWidth = getWidth();

        int cwidth = mCenterView.getMeasuredWidth();
        int cleft = (screenWidth - positionOffset - cwidth )/2;
        int cright = cleft + cwidth;
        mCenterView.layout(cleft, 0, cright, mCenterView.getMeasuredHeight());

        int lwidth = mLeftView.getMeasuredWidth();
        int lleft = -(positionOffset + lwidth)/2;
        int lright = lleft + mLeftView.getMeasuredWidth();
        mLeftView.layout(lleft, 0, Math.min(lright, cleft), mLeftView.getMeasuredHeight());

        int llwidth = mLeftLeftView.getMeasuredWidth();
        int llleft = (screenWidth - positionOffset - llwidth )/2 - screenWidth;
        int llright = llleft + llwidth;
        mLeftLeftView.layout(llleft, 0, Math.min(llright, lleft), mLeftLeftView.getMeasuredHeight());

        int rwidth = mRightView.getMeasuredWidth();
        int rright = getWidth() - (positionOffset- rwidth)/2;
        int rleft = rright - mRightView.getMeasuredWidth();;
        mRightView.layout(Math.max(rleft, cright), 0, rright, mRightView.getMeasuredHeight());

        int rrwidth = mRightRightView.getMeasuredWidth();
        int rrleft = (screenWidth - positionOffset - rrwidth )/2 + screenWidth;
        int rrright = rrleft + rrwidth;
        mRightRightView.layout(Math.max(rrleft, rright), 0, rrright, mRightRightView.getMeasuredHeight());

        mLastPositionOffset = positionOffset;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        updateTextPositions(0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int childWidthSpec = MeasureSpec.makeMeasureSpec((int) (widthSize * 0.8f), MeasureSpec.AT_MOST);
        int childHeightSpec = MeasureSpec.makeMeasureSpec(heightSize, MeasureSpec.AT_MOST);

        mLeftLeftView.measure(childWidthSpec, childHeightSpec);
        mLeftView.measure(childWidthSpec, childHeightSpec);
        mCenterView.measure(childWidthSpec, childHeightSpec);
        mRightView.measure(childWidthSpec, childHeightSpec);
        mRightRightView.measure(childWidthSpec, childHeightSpec);

        int textHeight = mCenterView.getMeasuredHeight();
        int padding = getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(widthSize, textHeight + padding);
    }
}

