package com.my.target;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.views.StarsRatingView;
import java.util.HashMap;
@SuppressLint({"ViewConstructor"})
public class go extends FrameLayout implements View.OnTouchListener {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull
    public final TextView c;
    @NonNull
    public final LinearLayout d;
    @NonNull
    public final LinearLayout e;
    @NonNull
    public final TextView f;
    @NonNull
    public final StarsRatingView g;
    @NonNull
    public final TextView h;
    @NonNull
    public final io i;
    public final boolean j;
    @NonNull
    public final HashMap<View, Boolean> k = new HashMap<>();
    @Nullable
    public String l;
    @Nullable
    public View.OnClickListener m;

    public go(@NonNull Context context, @NonNull io ioVar, boolean z) {
        super(context);
        TextView textView = new TextView(context);
        this.a = textView;
        this.b = new TextView(context);
        TextView textView2 = new TextView(context);
        this.c = textView2;
        this.d = new LinearLayout(context);
        TextView textView3 = new TextView(context);
        this.f = textView3;
        StarsRatingView starsRatingView = new StarsRatingView(context);
        this.g = starsRatingView;
        TextView textView4 = new TextView(context);
        this.h = textView4;
        this.e = new LinearLayout(context);
        io.a(textView, "title_text");
        io.a(textView2, "description_text");
        io.a(textView3, "disclaimer_text");
        io.a(starsRatingView, "stars_view");
        io.a(textView4, "votes_text");
        this.i = ioVar;
        this.j = z;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(@NonNull bq bqVar, @NonNull View.OnClickListener onClickListener) {
        HashMap<View, Boolean> hashMap;
        boolean z;
        TextView textView;
        if (bqVar.dW) {
            setOnClickListener(onClickListener);
            io.a(this, -1, -3806472);
            return;
        }
        this.m = onClickListener;
        this.a.setOnTouchListener(this);
        this.b.setOnTouchListener(this);
        this.c.setOnTouchListener(this);
        this.g.setOnTouchListener(this);
        this.h.setOnTouchListener(this);
        setOnTouchListener(this);
        this.k.put(this.a, Boolean.valueOf(bqVar.dK));
        if ("store".equals(this.l)) {
            hashMap = this.k;
            textView = this.b;
            z = bqVar.dU;
        } else {
            hashMap = this.k;
            textView = this.b;
            z = bqVar.dT;
        }
        hashMap.put(textView, Boolean.valueOf(z));
        this.k.put(this.c, Boolean.valueOf(bqVar.dL));
        this.k.put(this.g, Boolean.valueOf(bqVar.dO));
        this.k.put(this.h, Boolean.valueOf(bqVar.dP));
        this.k.put(this, Boolean.valueOf(bqVar.dV));
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.k.containsKey(view)) {
            return false;
        }
        if (!this.k.get(view).booleanValue()) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            setBackgroundColor(-3806472);
        } else if (action == 1) {
            setBackgroundColor(-1);
            View.OnClickListener onClickListener = this.m;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        } else if (action == 3) {
            setBackgroundColor(-1);
        }
        return true;
    }

    public void setBanner(@NonNull ce ceVar) {
        int i2;
        TextView textView;
        float f2;
        this.l = ceVar.getNavigationType();
        this.a.setText(ceVar.getTitle());
        this.c.setText(ceVar.getDescription());
        this.g.setRating(ceVar.getRating());
        this.h.setText(String.valueOf(ceVar.getVotes()));
        if ("store".equals(ceVar.getNavigationType())) {
            io.a(this.b, "category_text");
            String category = ceVar.getCategory();
            String subCategory = ceVar.getSubCategory();
            String str = "";
            if (!TextUtils.isEmpty(category)) {
                str = a.c3(str, category);
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(subCategory)) {
                str = a.c3(str, ", ");
            }
            if (!TextUtils.isEmpty(subCategory)) {
                str = a.c3(str, subCategory);
            }
            if (!TextUtils.isEmpty(str)) {
                this.b.setText(str);
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(8);
            }
            this.d.setVisibility(0);
            this.d.setGravity(16);
            if (ceVar.getRating() > 0.0f) {
                this.g.setVisibility(0);
                if (ceVar.getVotes() > 0) {
                    this.h.setVisibility(0);
                    textView = this.b;
                    i2 = -3355444;
                }
            } else {
                this.g.setVisibility(8);
            }
            this.h.setVisibility(8);
            textView = this.b;
            i2 = -3355444;
        } else {
            io.a(this.b, "domain_text");
            this.d.setVisibility(8);
            this.b.setText(ceVar.getDomain());
            this.d.setVisibility(8);
            textView = this.b;
            i2 = -16733198;
        }
        textView.setTextColor(i2);
        if (TextUtils.isEmpty(ceVar.getDisclaimer())) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
            this.f.setText(ceVar.getDisclaimer());
        }
        if (this.j) {
            this.a.setTextSize(2, 32.0f);
            this.c.setTextSize(2, 24.0f);
            f2 = 18.0f;
            this.f.setTextSize(2, 18.0f);
        } else {
            this.a.setTextSize(2, 20.0f);
            f2 = 16.0f;
            this.c.setTextSize(2, 16.0f);
            this.f.setTextSize(2, 14.0f);
        }
        this.b.setTextSize(2, f2);
    }
}
