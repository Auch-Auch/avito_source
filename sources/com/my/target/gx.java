package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.my.target.nativeads.views.MediaAdView;
import java.util.Objects;
@SuppressLint({"ViewConstructor"})
public class gx extends RelativeLayout {
    public static final int g = io.fh();
    public static final int h = io.fh();
    @NonNull
    public final go a;
    @NonNull
    public final Button b;
    @NonNull
    public final ft c;
    @NonNull
    public final gp d;
    @NonNull
    public final io e;
    public final boolean f;

    public class a implements View.OnTouchListener {
        public final /* synthetic */ bq a;
        public final /* synthetic */ View.OnClickListener b;

        public a(bq bqVar, View.OnClickListener onClickListener) {
            this.a = bqVar;
            this.b = onClickListener;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!this.a.dR) {
                return true;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                gx.this.a.setBackgroundColor(-3806472);
            } else if (action == 1) {
                gx.this.a.setBackgroundColor(-1);
                this.b.onClick(view);
            } else if (action == 3) {
                gx.this.setBackgroundColor(-1);
            }
            return true;
        }
    }

    public gx(@NonNull Context context, @NonNull io ioVar, boolean z) {
        super(context);
        this.e = ioVar;
        this.f = z;
        gp gpVar = new gp(context, ioVar, z);
        this.d = gpVar;
        io.a(gpVar, "footer_layout");
        go goVar = new go(context, ioVar, z);
        this.a = goVar;
        io.a(goVar, "body_layout");
        Button button = new Button(context);
        this.b = button;
        io.a(button, "cta_button");
        ft ftVar = new ft(context);
        this.c = ftVar;
        io.a(ftVar, "age_bordering");
    }

    public void a(int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        float f2;
        Button button;
        int max = Math.max(i2, i) / 8;
        go goVar = this.a;
        goVar.e.setOrientation(1);
        goVar.e.setGravity(1);
        goVar.a.setGravity(1);
        goVar.a.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.leftMargin = goVar.i.L(8);
        layoutParams.rightMargin = goVar.i.L(8);
        goVar.a.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        goVar.b.setLayoutParams(layoutParams2);
        goVar.b.setLines(1);
        goVar.b.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        goVar.c.setGravity(1);
        goVar.c.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        TextView textView = goVar.c;
        if (z) {
            textView.setTextSize(2, 12.0f);
            goVar.c.setLines(2);
            goVar.c.setEllipsize(TextUtils.TruncateAt.END);
            layoutParams3.topMargin = 0;
            layoutParams3.leftMargin = goVar.i.L(4);
            i3 = goVar.i.L(4);
        } else {
            textView.setTextSize(2, 16.0f);
            layoutParams3.topMargin = goVar.i.L(8);
            layoutParams3.leftMargin = goVar.i.L(16);
            i3 = goVar.i.L(16);
        }
        layoutParams3.rightMargin = i3;
        layoutParams3.gravity = 1;
        goVar.c.setLayoutParams(layoutParams3);
        goVar.d.setOrientation(0);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 1;
        goVar.d.setLayoutParams(layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(goVar.i.L(73), goVar.i.L(12));
        layoutParams5.topMargin = goVar.i.L(4);
        layoutParams5.rightMargin = goVar.i.L(4);
        goVar.g.setLayoutParams(layoutParams5);
        goVar.h.setTextColor(-6710887);
        goVar.h.setTextSize(2, 14.0f);
        goVar.f.setTextColor(-6710887);
        goVar.f.setGravity(1);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 1;
        io ioVar = goVar.i;
        if (z) {
            layoutParams6.leftMargin = ioVar.L(4);
            i4 = goVar.i.L(4);
        } else {
            layoutParams6.leftMargin = ioVar.L(16);
            i4 = goVar.i.L(16);
        }
        layoutParams6.rightMargin = i4;
        layoutParams6.gravity = 1;
        goVar.f.setLayoutParams(layoutParams6);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams7.gravity = 17;
        goVar.addView(goVar.e, layoutParams7);
        goVar.e.addView(goVar.a);
        goVar.e.addView(goVar.b);
        goVar.e.addView(goVar.d);
        goVar.e.addView(goVar.c);
        goVar.e.addView(goVar.f);
        goVar.d.addView(goVar.g);
        goVar.d.addView(goVar.h);
        gp gpVar = this.d;
        Objects.requireNonNull(gpVar);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams8.addRule(12, -1);
        gpVar.a.setLayoutParams(layoutParams8);
        gpVar.b.setImageBitmap(fi.R(gpVar.getContext()));
        gpVar.a.addView(gpVar.b);
        gpVar.a.addView(gpVar.c);
        gpVar.addView(gpVar.a);
        View view = new View(getContext());
        view.setBackgroundColor(-5592406);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, 1));
        gp gpVar2 = this.d;
        int i13 = g;
        gpVar2.setId(i13);
        gp gpVar3 = this.d;
        Objects.requireNonNull(gpVar3);
        int i14 = max / 3;
        if (gpVar3.e) {
            i14 = max / 5;
        }
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, i14);
        int L = gpVar3.d.L(24);
        io ioVar2 = gpVar3.d;
        if (z) {
            i7 = ioVar2.L(4);
            i6 = gpVar3.d.L(24);
            i5 = gpVar3.d.L(8);
        } else {
            i7 = ioVar2.L(16);
            i6 = gpVar3.d.L(24);
            i5 = gpVar3.d.L(16);
        }
        layoutParams9.setMargins(L, i7, i6, i5);
        layoutParams9.addRule(15, -1);
        layoutParams9.addRule(20);
        gpVar3.c.setScaleType(ImageView.ScaleType.FIT_START);
        gpVar3.c.setLayoutParams(layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, i14);
        io ioVar3 = gpVar3.d;
        if (z) {
            i11 = ioVar3.L(8);
            i10 = gpVar3.d.L(4);
            i9 = gpVar3.d.L(8);
            i8 = gpVar3.d.L(8);
        } else {
            i11 = ioVar3.L(24);
            i10 = gpVar3.d.L(16);
            i9 = gpVar3.d.L(24);
            i8 = gpVar3.d.L(16);
        }
        layoutParams10.setMargins(i11, i10, i9, i8);
        layoutParams10.addRule(15, -1);
        layoutParams10.addRule(21);
        gpVar3.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
        gpVar3.b.setLayoutParams(layoutParams10);
        gpVar3.b.setOnClickListener(gpVar3.f);
        this.b.setPadding(this.e.L(15), 0, this.e.L(15), 0);
        this.b.setMinimumWidth(this.e.L(100));
        this.b.setTransformationMethod(null);
        this.b.setSingleLine();
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        this.c.e(1, -7829368);
        this.c.setPadding(this.e.L(2), 0, 0, 0);
        this.c.setTextColor(MediaAdView.COLOR_PLACEHOLDER_GRAY);
        this.c.setMaxEms(5);
        this.c.a(1, MediaAdView.COLOR_PLACEHOLDER_GRAY, this.e.L(3));
        this.c.setBackgroundColor(1711276032);
        go goVar2 = this.a;
        int i15 = h;
        goVar2.setId(i15);
        go goVar3 = this.a;
        io ioVar4 = this.e;
        if (z) {
            goVar3.setPadding(ioVar4.L(4), this.e.L(4), this.e.L(4), this.e.L(4));
        } else {
            goVar3.setPadding(ioVar4.L(16), this.e.L(16), this.e.L(16), this.e.L(16));
        }
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams11.addRule(2, i13);
        this.a.setLayoutParams(layoutParams11);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-2, -2);
        io ioVar5 = this.e;
        layoutParams12.setMargins(this.e.L(16), z ? ioVar5.L(8) : ioVar5.L(16), this.e.L(16), this.e.L(4));
        layoutParams12.addRule(21, -1);
        this.c.setLayoutParams(layoutParams12);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, this.f ? this.e.L(64) : this.e.L(52));
        layoutParams13.addRule(14, -1);
        layoutParams13.addRule(8, i15);
        int i16 = -this.e.L(52);
        layoutParams13.bottomMargin = z ? (int) (((double) i16) / 1.5d) : i16 / 2;
        this.b.setLayoutParams(layoutParams13);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(-1, max);
        layoutParams14.addRule(12, -1);
        this.d.setLayoutParams(layoutParams14);
        addView(this.a);
        addView(view);
        addView(this.c);
        addView(this.d);
        addView(this.b);
        setClickable(true);
        if (this.f) {
            button = this.b;
            f2 = 32.0f;
            i12 = 2;
        } else {
            i12 = 2;
            button = this.b;
            f2 = 22.0f;
        }
        button.setTextSize(i12, f2);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(@NonNull bq bqVar, @NonNull View.OnClickListener onClickListener) {
        boolean z;
        Button button;
        this.a.a(bqVar, onClickListener);
        if (bqVar.dW) {
            this.b.setOnClickListener(onClickListener);
            return;
        }
        if (bqVar.dQ) {
            this.b.setOnClickListener(onClickListener);
            button = this.b;
            z = true;
        } else {
            this.b.setOnClickListener(null);
            button = this.b;
            z = false;
        }
        button.setEnabled(z);
        this.c.setOnTouchListener(new a(bqVar, onClickListener));
    }

    public void setBanner(@NonNull ce ceVar) {
        this.a.setBanner(ceVar);
        this.b.setText(ceVar.getCtaText());
        this.d.setBackgroundColor(-39322);
        if (TextUtils.isEmpty(ceVar.getAgeRestrictions())) {
            this.c.setVisibility(8);
        } else {
            this.c.setText(ceVar.getAgeRestrictions());
        }
        io.a(this.b, -16733198, -16746839, this.e.L(2));
        this.b.setTextColor(-1);
    }
}
