package com.my.target;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class fp extends RelativeLayout {
    @NonNull
    public final TextView a;
    @NonNull
    public final View b;
    @Nullable
    public String c;
    @Nullable
    public a d;

    public interface a {
        void p();
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = fp.this.d;
            if (aVar != null) {
                aVar.p();
            }
        }
    }

    public fp(@NonNull Context context) {
        super(context);
        TextView textView = new TextView(context);
        this.a = textView;
        textView.setTextColor(-1);
        textView.setTypeface(null, 1);
        textView.setTextSize(2, 20.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = (int) TypedValue.applyDimension(1, 8.0f, getContext().getResources().getDisplayMetrics());
        layoutParams.addRule(15);
        layoutParams.addRule(1, 256);
        addView(textView, layoutParams);
        setBackgroundColor(-7829368);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) (context.getResources().getDisplayMetrics().density + 0.5f));
        layoutParams2.addRule(12);
        View view = new View(context);
        this.b = view;
        view.setBackgroundColor(-10066330);
        addView(view, layoutParams2);
        fx fxVar = new fx(context);
        fxVar.a(fg.O(context), false);
        fxVar.setId(256);
        fxVar.setOnClickListener(new b());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = (int) TypedValue.applyDimension(1, 5.0f, getContext().getResources().getDisplayMetrics());
        layoutParams3.addRule(15);
        layoutParams3.addRule(9);
        fxVar.setLayoutParams(layoutParams3);
        addView(fxVar);
    }

    @Nullable
    public String getTitle() {
        return this.c;
    }

    public void setMainColor(int i) {
        setBackgroundColor(i);
    }

    public void setOnCloseClickListener(@Nullable a aVar) {
        this.d = aVar;
    }

    public void setStripeColor(int i) {
        this.b.setBackgroundColor(i);
    }

    public void setTitle(@Nullable String str) {
        this.c = str;
        this.a.setText(str);
    }

    public void setTitleColor(int i) {
        this.a.setTextColor(i);
    }
}
