package com.yandex.mapkit;

import androidx.annotation.NonNull;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class LocalizedValue implements Serializable {
    private String text;
    private double value;

    public LocalizedValue(double d, @NonNull String str) {
        if (str != null) {
            this.value = d;
            this.text = str;
            return;
        }
        throw new IllegalArgumentException("Required field \"text\" cannot be null");
    }

    @NonNull
    public String getText() {
        return this.text;
    }

    public double getValue() {
        return this.value;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.value = archive.add(this.value);
        this.text = archive.add(this.text, false);
    }

    public LocalizedValue() {
    }
}
