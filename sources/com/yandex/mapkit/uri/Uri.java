package com.yandex.mapkit.uri;

import androidx.annotation.NonNull;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class Uri implements Serializable {
    private String value;

    public Uri(@NonNull String str) {
        if (str != null) {
            this.value = str;
            return;
        }
        throw new IllegalArgumentException("Required field \"value\" cannot be null");
    }

    @NonNull
    public String getValue() {
        return this.value;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.value = archive.add(this.value, false);
    }

    public Uri() {
    }
}
