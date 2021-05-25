package com.yandex.runtime.internal.test_support;

import androidx.annotation.Nullable;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public final class OptionsTestStructure implements Serializable {
    private Boolean b;
    private Long interval;
    private String text;
    private Long timestamp;

    public OptionsTestStructure(@Nullable Boolean bool, @Nullable String str, @Nullable Long l, @Nullable Long l2) {
        this.b = bool;
        this.text = str;
        this.interval = l;
        this.timestamp = l2;
    }

    @Nullable
    public Boolean getB() {
        return this.b;
    }

    @Nullable
    public Long getInterval() {
        return this.interval;
    }

    @Nullable
    public String getText() {
        return this.text;
    }

    @Nullable
    public Long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.b = archive.add(this.b, true);
        this.text = archive.add(this.text, true);
        this.interval = archive.add(this.interval, true);
        this.timestamp = archive.add(this.timestamp, true);
    }

    public OptionsTestStructure setB(@Nullable Boolean bool) {
        this.b = bool;
        return this;
    }

    public OptionsTestStructure setInterval(@Nullable Long l) {
        this.interval = l;
        return this;
    }

    public OptionsTestStructure setText(@Nullable String str) {
        this.text = str;
        return this;
    }

    public OptionsTestStructure setTimestamp(@Nullable Long l) {
        this.timestamp = l;
        return this;
    }

    public OptionsTestStructure() {
    }
}
