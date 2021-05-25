package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
public final class oe extends LinearLayout {
    @NonNull
    private final dv a;
    @NonNull
    private od b;
    @NonNull
    private TextView c;
    private final View.OnClickListener d;

    public oe(@NonNull Context context) {
        super(context);
        AnonymousClass1 r0 = new View.OnClickListener() { // from class: com.yandex.mobile.ads.impl.oe.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z = !oe.this.b.isSelected();
                oe.this.b.setSelected(z);
                oe.this.c.setVisibility(z ? 0 : 8);
            }
        };
        this.d = r0;
        dv dvVar = new dv();
        this.a = dvVar;
        setOrientation(0);
        int a3 = dv.a(context, 4.0f);
        setPadding(a3, a3, a3, a3);
        od odVar = new od(context, dvVar);
        this.b = odVar;
        odVar.setOnClickListener(r0);
        addView(this.b);
        this.c = new TextView(context);
        int a4 = dv.a(context, 3.0f);
        this.c.setPadding(a4, a4, a4, a4);
        int a5 = dv.a(context, 2.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setStroke(a5, SupportMenu.CATEGORY_MASK);
        this.c.setBackgroundDrawable(gradientDrawable);
        addView(this.c);
        int a6 = dv.a(context, 2.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.setMargins(a6, 0, a6, a6);
        this.c.setLayoutParams(layoutParams);
        this.c.setVisibility(8);
    }

    public final void setDescription(@NonNull String str) {
        this.c.setText(str);
    }
}
