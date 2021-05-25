package com.yandex.runtime.i18n;

import androidx.annotation.NonNull;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class CanonicalUnit implements Serializable {
    private String unit;
    private double value;

    public CanonicalUnit(@NonNull String str, double d) {
        if (str != null) {
            this.unit = str;
            this.value = d;
            return;
        }
        throw new IllegalArgumentException("Required field \"unit\" cannot be null");
    }

    @NonNull
    public String getUnit() {
        return this.unit;
    }

    public double getValue() {
        return this.value;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.unit = archive.add(this.unit, false);
        this.value = archive.add(this.value);
    }

    public CanonicalUnit() {
    }
}
