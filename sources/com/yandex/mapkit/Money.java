package com.yandex.mapkit;

import androidx.annotation.NonNull;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class Money implements Serializable {
    private String currency;
    private String text;
    private double value;

    public Money(double d, @NonNull String str, @NonNull String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required field \"text\" cannot be null");
        } else if (str2 != null) {
            this.value = d;
            this.text = str;
            this.currency = str2;
        } else {
            throw new IllegalArgumentException("Required field \"currency\" cannot be null");
        }
    }

    @NonNull
    public String getCurrency() {
        return this.currency;
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
        this.currency = archive.add(this.currency, false);
    }

    public Money() {
    }
}
