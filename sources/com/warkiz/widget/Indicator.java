package com.warkiz.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
public class Indicator {
    public final int a;
    public int[] b = new int[2];
    public ArrowView c;
    public TextView d;
    public PopupWindow e;
    public LinearLayout f;
    public int g;
    public int h;
    public Context i;
    public int j;
    public IndicatorSeekBar k;
    public View l;
    public View m;
    public View n;
    public float o;
    public int p;

    public Indicator(Context context, IndicatorSeekBar indicatorSeekBar, int i2, int i3, int i4, int i5, View view, View view2) {
        this.i = context;
        this.k = indicatorSeekBar;
        this.h = i2;
        this.j = i3;
        this.m = view;
        this.n = view2;
        this.o = (float) i4;
        this.p = i5;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.a = windowManager != null ? windowManager.getDefaultDisplay().getWidth() : 0;
        this.g = SizeUtils.dp2px(this.i, 2.0f);
        c();
    }

    public final void a(float f2) {
        int i2 = this.j;
        if (i2 != 4 && i2 != 1) {
            this.k.getLocationOnScreen(this.b);
            int i3 = this.b[0];
            if (((float) i3) + f2 < ((float) (this.e.getContentView().getMeasuredWidth() / 2))) {
                e(this.c, -((int) (((float) ((this.e.getContentView().getMeasuredWidth() / 2) - i3)) - f2)), -1, -1, -1);
            } else if (((float) (this.a - i3)) - f2 < ((float) (this.e.getContentView().getMeasuredWidth() / 2))) {
                e(this.c, (int) (((float) (this.e.getContentView().getMeasuredWidth() / 2)) - (((float) (this.a - i3)) - f2)), -1, -1, -1);
            } else {
                e(this.c, 0, 0, 0, 0);
            }
        }
    }

    @NonNull
    public final GradientDrawable b() {
        GradientDrawable gradientDrawable;
        if (this.j == 2) {
            gradientDrawable = (GradientDrawable) this.i.getResources().getDrawable(R.drawable.isb_indicator_rounded_corners);
        } else {
            gradientDrawable = (GradientDrawable) this.i.getResources().getDrawable(R.drawable.isb_indicator_square_corners);
        }
        gradientDrawable.setColor(this.h);
        return gradientDrawable;
    }

    public final void c() {
        View findViewById;
        int i2 = this.j;
        if (i2 == 4) {
            View view = this.m;
            if (view != null) {
                this.l = view;
                int identifier = this.i.getResources().getIdentifier("isb_progress", "id", this.i.getApplicationContext().getPackageName());
                if (identifier > 0 && (findViewById = this.l.findViewById(identifier)) != null) {
                    if (findViewById instanceof TextView) {
                        TextView textView = (TextView) findViewById;
                        this.d = textView;
                        textView.setText(this.k.getIndicatorTextString());
                        this.d.setTextSize((float) SizeUtils.px2sp(this.i, this.o));
                        this.d.setTextColor(this.p);
                        return;
                    }
                    throw new ClassCastException("the view identified by isb_progress in indicator custom layout can not be cast to TextView");
                }
                return;
            }
            throw new IllegalArgumentException("the attr：indicator_custom_layout must be set while you set the indicator type to CUSTOM.");
        } else if (i2 == 1) {
            CircleBubbleView circleBubbleView = new CircleBubbleView(this.i, this.o, this.p, this.h, "1000");
            this.l = circleBubbleView;
            circleBubbleView.setProgress(this.k.getIndicatorTextString());
        } else {
            View inflate = View.inflate(this.i, R.layout.isb_indicator, null);
            this.l = inflate;
            this.f = (LinearLayout) inflate.findViewById(R.id.indicator_container);
            ArrowView arrowView = (ArrowView) this.l.findViewById(R.id.indicator_arrow);
            this.c = arrowView;
            arrowView.setColor(this.h);
            TextView textView2 = (TextView) this.l.findViewById(R.id.isb_progress);
            this.d = textView2;
            textView2.setText(this.k.getIndicatorTextString());
            this.d.setTextSize((float) SizeUtils.px2sp(this.i, this.o));
            this.d.setTextColor(this.p);
            this.f.setBackground(b());
            if (this.n != null) {
                int identifier2 = this.i.getResources().getIdentifier("isb_progress", "id", this.i.getApplicationContext().getPackageName());
                View view2 = this.n;
                if (identifier2 > 0) {
                    View findViewById2 = view2.findViewById(identifier2);
                    if (findViewById2 == null || !(findViewById2 instanceof TextView)) {
                        setTopContentView(view2);
                    } else {
                        setTopContentView(view2, (TextView) findViewById2);
                    }
                } else {
                    setTopContentView(view2);
                }
            }
        }
    }

    public void d() {
        String indicatorTextString = this.k.getIndicatorTextString();
        View view = this.l;
        if (view instanceof CircleBubbleView) {
            ((CircleBubbleView) view).setProgress(indicatorTextString);
            return;
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(indicatorTextString);
        }
    }

    public final void e(View view, int i2, int i3, int i4, int i5) {
        if (view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (i2 == -1) {
                i2 = marginLayoutParams.leftMargin;
            }
            if (i3 == -1) {
                i3 = marginLayoutParams.topMargin;
            }
            if (i4 == -1) {
                i4 = marginLayoutParams.rightMargin;
            }
            if (i5 == -1) {
                i5 = marginLayoutParams.bottomMargin;
            }
            marginLayoutParams.setMargins(i2, i3, i4, i5);
            view.requestLayout();
        }
    }

    public View getContentView() {
        return this.l;
    }

    public View getTopContentView() {
        return this.f;
    }

    public void setContentView(@NonNull View view) {
        this.j = 4;
        this.m = view;
        c();
    }

    public void setTopContentView(@NonNull View view) {
        setTopContentView(view, null);
    }

    public void setTopContentView(@NonNull View view, @Nullable TextView textView) {
        this.d = textView;
        this.f.removeAllViews();
        view.setBackground(b());
        this.f.addView(view);
    }

    public void setContentView(@NonNull View view, TextView textView) {
        this.d = textView;
        this.j = 4;
        this.m = view;
        c();
    }
}
