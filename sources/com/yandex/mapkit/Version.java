package com.yandex.mapkit;

import androidx.annotation.NonNull;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class Version implements Serializable {
    private String str;

    public Version(@NonNull String str2) {
        if (str2 != null) {
            this.str = str2;
            return;
        }
        throw new IllegalArgumentException("Required field \"str\" cannot be null");
    }

    @NonNull
    public String getStr() {
        return this.str;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.str = archive.add(this.str, false);
    }

    public Version() {
    }
}
