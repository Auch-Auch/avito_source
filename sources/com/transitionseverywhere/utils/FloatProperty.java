package com.transitionseverywhere.utils;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
@SuppressLint({"NewApi, Override"})
public abstract class FloatProperty<T> extends android.util.FloatProperty<T> {
    public FloatProperty() {
        super(null);
    }

    @Override // android.util.FloatProperty, android.util.Property
    @NonNull
    public Float get(@NonNull T t) {
        return Float.valueOf(0.0f);
    }
}
