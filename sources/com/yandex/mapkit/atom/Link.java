package com.yandex.mapkit.atom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class Link implements Serializable {
    private String href;
    private String rel;
    private String type;

    public Link(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        if (str != null) {
            this.href = str;
            this.rel = str2;
            this.type = str3;
            return;
        }
        throw new IllegalArgumentException("Required field \"href\" cannot be null");
    }

    @NonNull
    public String getHref() {
        return this.href;
    }

    @Nullable
    public String getRel() {
        return this.rel;
    }

    @Nullable
    public String getType() {
        return this.type;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.href = archive.add(this.href, false);
        this.rel = archive.add(this.rel, true);
        this.type = archive.add(this.type, true);
    }

    public Link() {
    }
}
