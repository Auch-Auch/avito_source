package com.yandex.runtime.internal.test_support;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class LiteTestStructure implements Serializable {
    private boolean b;
    private long interval;
    private String optionalText;
    private String text;
    private long timestamp;

    public LiteTestStructure(boolean z, @NonNull String str, @Nullable String str2, long j, long j2) {
        if (str != null) {
            this.b = z;
            this.text = str;
            this.optionalText = str2;
            this.interval = j;
            this.timestamp = j2;
            return;
        }
        throw new IllegalArgumentException("Required field \"text\" cannot be null");
    }

    public boolean getB() {
        return this.b;
    }

    public long getInterval() {
        return this.interval;
    }

    @Nullable
    public String getOptionalText() {
        return this.optionalText;
    }

    @NonNull
    public String getText() {
        return this.text;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.b = archive.add(this.b);
        this.text = archive.add(this.text, false);
        this.optionalText = archive.add(this.optionalText, true);
        this.interval = archive.add(this.interval);
        this.timestamp = archive.add(this.timestamp);
    }

    public LiteTestStructure() {
    }
}
