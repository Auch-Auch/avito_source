package com.my.target;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.StateSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
public class fm extends LinearLayout {
    @NonNull
    public final TextView a;
    @NonNull
    public final gc b;

    public fm(Context context) {
        super(context);
        TextView textView = new TextView(context);
        this.a = textView;
        gc gcVar = new gc(context);
        this.b = gcVar;
        io af = io.af(context);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1157627904, -1157627904});
        gradientDrawable.setStroke(af.o(1.0f), -1157627904);
        gradientDrawable.setCornerRadius((float) af.o(10.0f));
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1157627904, -1157627904});
        gradientDrawable2.setStroke(af.o(1.0f), -1157627904);
        gradientDrawable2.setCornerRadius((float) af.o(10.0f));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, gradientDrawable);
        int L = af.L(6);
        int L2 = af.L(12);
        textView.setTextColor(-1);
        textView.setTextSize(18.0f);
        textView.setMaxLines(5);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        int c = io.c(32, context);
        setPadding(L2, L, L2, L);
        setBackgroundDrawable(stateListDrawable);
        setGravity(16);
        setOrientation(0);
        io.a(gcVar, "ctc_icon");
        addView(gcVar, c, c);
        io.a(textView, "ctc_text");
        addView(textView, new LinearLayout.LayoutParams(-2, -2));
    }

    public void a(@Nullable String str, @Nullable ImageData imageData) {
        this.a.setText(str);
        this.b.setImageData(imageData);
        ((LinearLayout.LayoutParams) this.a.getLayoutParams()).leftMargin = imageData == null ? 0 : io.c(4, getContext()) * 2;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
