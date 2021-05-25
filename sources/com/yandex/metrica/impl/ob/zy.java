package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.widget.TextView;
import com.yandex.metrica.impl.ob.aam;
import java.util.List;
public class zy implements aae {
    @NonNull
    private final List<String> a;

    public zy(@NonNull List<String> list) {
        this.a = list;
    }

    public boolean a(@NonNull TextView textView) {
        for (String str : this.a) {
            CharSequence text = textView.getText();
            if (text != null && text.toString().matches(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.yandex.metrica.impl.ob.aaq
    @NonNull
    public aam.c a() {
        return aam.c.REGEXP_NOT_MATCHED;
    }
}
