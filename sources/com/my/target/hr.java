package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
import com.my.target.hq;
import java.util.HashSet;
import java.util.Set;
@SuppressLint({"ViewConstructor"})
public class hr extends LinearLayout implements View.OnTouchListener, hq {
    @NonNull
    public final gc a;
    @NonNull
    public final TextView b;
    @NonNull
    public final TextView c;
    @NonNull
    public final Button d;
    @NonNull
    public final ho e;
    @NonNull
    public final Set<View> f = new HashSet();
    @Nullable
    public hq.a g;
    @Nullable
    public ImageData h;
    public boolean i;

    public hr(@NonNull Context context, @NonNull bu buVar, @NonNull ho hoVar) {
        super(context);
        setOrientation(1);
        this.e = hoVar;
        gc gcVar = new gc(context);
        this.a = gcVar;
        TextView textView = new TextView(context);
        this.b = textView;
        TextView textView2 = new TextView(context);
        this.c = textView2;
        Button button = new Button(context);
        this.d = button;
        button.setTransformationMethod(null);
        button.setSingleLine();
        button.setTextSize((float) hoVar.G(ho.oI));
        button.setEllipsize(TextUtils.TruncateAt.END);
        button.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i2 = ho.oE;
        layoutParams.leftMargin = hoVar.G(i2);
        layoutParams.rightMargin = hoVar.G(i2);
        int i3 = ho.oF;
        layoutParams.topMargin = hoVar.G(i3) * 2;
        layoutParams.gravity = 1;
        button.setLayoutParams(layoutParams);
        io.a(button, buVar.bu(), buVar.bv(), hoVar.G(ho.nP));
        button.setTextColor(buVar.bw());
        textView.setTextSize((float) hoVar.G(ho.oG));
        textView.setTextColor(buVar.getTitleColor());
        int i4 = ho.oD;
        textView.setPadding(hoVar.G(i4), 0, hoVar.G(i4), 0);
        textView.setTypeface(null, 1);
        textView.setLines(hoVar.G(ho.oj));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = hoVar.G(i3);
        textView.setLayoutParams(layoutParams2);
        textView2.setTextColor(buVar.getTextColor());
        textView2.setLines(hoVar.G(ho.ok));
        textView2.setTextSize((float) hoVar.G(ho.oH));
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setPadding(hoVar.G(i4), 0, hoVar.G(i4), 0);
        textView2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = hoVar.G(i3);
        layoutParams3.gravity = 1;
        textView2.setLayoutParams(layoutParams3);
        io.a(this, "card_view");
        io.a(textView, "card_title_text");
        io.a(textView2, "card_description_text");
        io.a(button, "card_cta_button");
        io.a(gcVar, "card_image");
        addView(gcVar);
        addView(textView);
        addView(textView2);
        addView(button);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setClickArea(@NonNull bq bqVar) {
        setOnTouchListener(this);
        this.a.setOnTouchListener(this);
        this.b.setOnTouchListener(this);
        this.c.setOnTouchListener(this);
        this.d.setOnTouchListener(this);
        this.f.clear();
        if (bqVar.dW) {
            this.i = true;
            return;
        }
        if (bqVar.dQ) {
            this.f.add(this.d);
        } else {
            this.d.setEnabled(false);
            this.f.remove(this.d);
        }
        if (bqVar.dV) {
            this.f.add(this);
        } else {
            this.f.remove(this);
        }
        if (bqVar.dK) {
            this.f.add(this.b);
        } else {
            this.f.remove(this.b);
        }
        if (bqVar.dL) {
            this.f.add(this.c);
        } else {
            this.f.remove(this.c);
        }
        if (bqVar.dN) {
            this.f.add(this.a);
        } else {
            this.f.remove(this.a);
        }
    }

    @Override // com.my.target.hq
    public View eu() {
        return this;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        this.a.measure(i2, i3);
        if (this.b.getVisibility() == 0) {
            this.b.measure(i2, i3);
        }
        if (this.c.getVisibility() == 0) {
            this.c.measure(i2, i3);
        }
        if (this.d.getVisibility() == 0) {
            this.d.measure(View.MeasureSpec.makeMeasureSpec(this.a.getMeasuredWidth() - (this.e.G(ho.oE) * 2), 1073741824), i3);
        }
        if (getMeasuredHeight() <= 0 || getMeasuredWidth() <= 0 || getMeasuredWidth() != size) {
            int measuredWidth = this.a.getMeasuredWidth();
            int measuredHeight = this.a.getMeasuredHeight();
            if (size > size2) {
                setMeasuredDimension(measuredWidth, measuredHeight);
                return;
            }
            int paddingTop = getPaddingTop() + getPaddingBottom() + 0;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                int paddingTop2 = childAt.getPaddingTop() + childAt.getMeasuredHeight() + paddingTop;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                paddingTop = childAt.getPaddingBottom() + paddingTop2 + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            setMeasuredDimension(measuredWidth, paddingTop);
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            boolean z = false;
            if (action == 1) {
                setBackgroundColor(0);
                this.d.setPressed(false);
                hq.a aVar = this.g;
                if (aVar != null) {
                    if (this.i || this.f.contains(view)) {
                        z = true;
                    }
                    aVar.x(z);
                }
            } else if (action == 3) {
                setBackgroundColor(0);
                this.d.setPressed(false);
            }
        } else if (this.i || this.f.contains(view)) {
            Button button = this.d;
            if (view == button) {
                button.setPressed(true);
            } else {
                setBackgroundColor(-13421773);
            }
        }
        return true;
    }

    @Override // com.my.target.hq
    public void setBanner(@Nullable cb cbVar) {
        if (cbVar != null) {
            ImageData image = cbVar.getImage();
            this.h = image;
            if (image != null) {
                this.a.setPlaceholderDimensions(image.getWidth(), this.h.getHeight());
                ia.a(this.h, this.a);
            }
            if (cbVar.isImageOnly()) {
                this.b.setVisibility(8);
                this.c.setVisibility(8);
                this.d.setVisibility(8);
            } else {
                this.b.setVisibility(0);
                this.c.setVisibility(0);
                this.d.setVisibility(0);
                this.b.setText(cbVar.getTitle());
                this.c.setText(cbVar.getDescription());
                this.d.setText(cbVar.getCtaText());
            }
            setClickArea(cbVar.getClickArea());
            return;
        }
        this.f.clear();
        ImageData imageData = this.h;
        if (imageData != null) {
            ia.b(imageData, this.a);
        }
        this.a.setPlaceholderDimensions(0, 0);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
    }

    @Override // com.my.target.hq
    public void setListener(@Nullable hq.a aVar) {
        this.g = aVar;
    }
}
