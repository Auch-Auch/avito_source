package com.facebook.share.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.common.R;
@Deprecated
public class LikeBoxCountView extends FrameLayout {
    public TextView a;
    public LikeBoxCountViewCaretPosition b = LikeBoxCountViewCaretPosition.LEFT;
    public float c;
    public float d;
    public float e;
    public Paint f;
    public int g;
    public int h;

    public enum LikeBoxCountViewCaretPosition {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    @Deprecated
    public LikeBoxCountView(Context context) {
        super(context);
        setWillNotDraw(false);
        Resources resources = getResources();
        int i = R.dimen.com_facebook_likeboxcountview_caret_height;
        this.c = resources.getDimension(i);
        this.d = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_width);
        this.e = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_radius);
        Paint paint = new Paint();
        this.f = paint;
        paint.setColor(getResources().getColor(R.color.com_facebook_likeboxcountview_border_color));
        this.f.setStrokeWidth(getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_width));
        this.f.setStyle(Paint.Style.STROKE);
        this.a = new TextView(context);
        this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.a.setGravity(17);
        this.a.setTextSize(0, getResources().getDimension(R.dimen.com_facebook_likeboxcountview_text_size));
        this.a.setTextColor(getResources().getColor(R.color.com_facebook_likeboxcountview_text_color));
        this.g = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_text_padding);
        this.h = getResources().getDimensionPixelSize(i);
        addView(this.a);
        setCaretPosition(this.b);
    }

    public final void a(int i, int i2, int i3, int i4) {
        TextView textView = this.a;
        int i5 = this.g;
        textView.setPadding(i + i5, i2 + i5, i3 + i5, i5 + i4);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int ordinal = this.b.ordinal();
        if (ordinal == 0) {
            paddingLeft = (int) (((float) paddingLeft) + this.c);
        } else if (ordinal == 1) {
            paddingTop = (int) (((float) paddingTop) + this.c);
        } else if (ordinal == 2) {
            width = (int) (((float) width) - this.c);
        } else if (ordinal == 3) {
            height = (int) (((float) height) - this.c);
        }
        float f2 = (float) paddingLeft;
        float f3 = (float) paddingTop;
        float f4 = (float) width;
        float f5 = (float) height;
        Path path = new Path();
        float f6 = this.e * 2.0f;
        float f7 = f2 + f6;
        float f8 = f3 + f6;
        path.addArc(new RectF(f2, f3, f7, f8), -180.0f, 90.0f);
        if (this.b == LikeBoxCountViewCaretPosition.TOP) {
            float f9 = f4 - f2;
            path.lineTo(((f9 - this.d) / 2.0f) + f2, f3);
            path.lineTo((f9 / 2.0f) + f2, f3 - this.c);
            path.lineTo(((f9 + this.d) / 2.0f) + f2, f3);
        }
        path.lineTo(f4 - this.e, f3);
        float f10 = f4 - f6;
        path.addArc(new RectF(f10, f3, f4, f8), -90.0f, 90.0f);
        if (this.b == LikeBoxCountViewCaretPosition.RIGHT) {
            float f11 = f5 - f3;
            path.lineTo(f4, ((f11 - this.d) / 2.0f) + f3);
            path.lineTo(this.c + f4, (f11 / 2.0f) + f3);
            path.lineTo(f4, ((f11 + this.d) / 2.0f) + f3);
        }
        path.lineTo(f4, f5 - this.e);
        float f12 = f5 - f6;
        path.addArc(new RectF(f10, f12, f4, f5), 0.0f, 90.0f);
        if (this.b == LikeBoxCountViewCaretPosition.BOTTOM) {
            float f13 = f4 - f2;
            path.lineTo(((this.d + f13) / 2.0f) + f2, f5);
            path.lineTo((f13 / 2.0f) + f2, this.c + f5);
            path.lineTo(((f13 - this.d) / 2.0f) + f2, f5);
        }
        path.lineTo(this.e + f2, f5);
        path.addArc(new RectF(f2, f12, f7, f5), 90.0f, 90.0f);
        if (this.b == LikeBoxCountViewCaretPosition.LEFT) {
            float f14 = f5 - f3;
            path.lineTo(f2, ((this.d + f14) / 2.0f) + f3);
            path.lineTo(f2 - this.c, (f14 / 2.0f) + f3);
            path.lineTo(f2, ((f14 - this.d) / 2.0f) + f3);
        }
        path.lineTo(f2, f3 + this.e);
        canvas.drawPath(path, this.f);
    }

    @Deprecated
    public void setCaretPosition(LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition) {
        this.b = likeBoxCountViewCaretPosition;
        int ordinal = likeBoxCountViewCaretPosition.ordinal();
        if (ordinal == 0) {
            a(this.h, 0, 0, 0);
        } else if (ordinal == 1) {
            a(0, this.h, 0, 0);
        } else if (ordinal == 2) {
            a(0, 0, this.h, 0);
        } else if (ordinal == 3) {
            a(0, 0, 0, this.h);
        }
    }

    @Deprecated
    public void setText(String str) {
        this.a.setText(str);
    }
}
