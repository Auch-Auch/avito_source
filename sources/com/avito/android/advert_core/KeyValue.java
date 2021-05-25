package com.avito.android.advert_core;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import com.avito.android.lib.design.R;
import com.avito.android.util.Contexts;
public class KeyValue extends LinearLayoutCompat {
    public TextView p;
    public TextView q;

    public KeyValue(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.p = (TextView) findViewById(R.id.key_view);
        this.q = (TextView) findViewById(R.id.value_view);
    }

    public void setText(String str) {
        this.q.setText(str);
        this.q.setTextColor(Contexts.getColorByAttr(getContext(), R.attr.black));
    }

    public void setTextAsLink(String str) {
        this.q.setText(str);
        this.q.setTextColor(ContextCompat.getColorStateList(getContext(), com.avito.android.ui_components.R.color.params_link));
    }

    public void setTextColors(int i, int i2) {
        this.p.setTextColor(i);
        this.q.setTextColor(i2);
    }

    public void setTitle(String str) {
        this.p.setText(str);
    }

    public void setUnlimitedHeight() {
        this.q.setMaxLines(Integer.MAX_VALUE);
    }

    public KeyValue(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KeyValue(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
