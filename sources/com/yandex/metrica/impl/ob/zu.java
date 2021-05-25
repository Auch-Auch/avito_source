package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.DigitalClock;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextClock;
import android.widget.TextView;
import com.yandex.metrica.impl.ob.aam;
import java.util.HashSet;
import java.util.Set;
public class zu implements aae {
    private final Set<Class> a;

    public zu() {
        HashSet hashSet = new HashSet();
        this.a = hashSet;
        hashSet.add(EditText.class);
        hashSet.add(Chronometer.class);
        hashSet.add(DigitalClock.class);
        hashSet.add(TextClock.class);
        hashSet.add(RadioButton.class);
        hashSet.add(CheckBox.class);
    }

    public boolean a(@NonNull TextView textView) {
        for (Class cls : this.a) {
            if (cls.isInstance(textView)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.yandex.metrica.impl.ob.aaq
    @NonNull
    public aam.c a() {
        return aam.c.IRRELEVANT_CLASS;
    }
}
