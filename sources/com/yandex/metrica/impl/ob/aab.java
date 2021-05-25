package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.widget.TextView;
import com.yandex.metrica.impl.ob.aam;
public class aab implements aae {
    private final int a;

    public aab(int i) {
        this.a = i;
    }

    public boolean a(@NonNull TextView textView) {
        CharSequence text = textView.getText();
        return text != null && text.length() > this.a;
    }

    @Override // com.yandex.metrica.impl.ob.aaq
    @NonNull
    public aam.c a() {
        return aam.c.TEXT_TOO_LONG;
    }
}
