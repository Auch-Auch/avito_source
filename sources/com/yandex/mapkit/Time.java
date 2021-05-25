package com.yandex.mapkit;

import androidx.annotation.NonNull;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class Time implements Serializable {
    private String text;
    private int tzOffset;
    private long value;

    public Time(long j, int i, @NonNull String str) {
        if (str != null) {
            this.value = j;
            this.tzOffset = i;
            this.text = str;
            return;
        }
        throw new IllegalArgumentException("Required field \"text\" cannot be null");
    }

    @NonNull
    public String getText() {
        return this.text;
    }

    public int getTzOffset() {
        return this.tzOffset;
    }

    public long getValue() {
        return this.value;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.value = archive.add(this.value);
        this.tzOffset = archive.add(this.tzOffset);
        this.text = archive.add(this.text, false);
    }

    public Time() {
    }
}
