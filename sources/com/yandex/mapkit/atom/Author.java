package com.yandex.mapkit.atom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class Author implements Serializable {
    private String email;
    private String name;
    private String uri;

    public Author(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        if (str != null) {
            this.name = str;
            this.uri = str2;
            this.email = str3;
            return;
        }
        throw new IllegalArgumentException("Required field \"name\" cannot be null");
    }

    @Nullable
    public String getEmail() {
        return this.email;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    @Nullable
    public String getUri() {
        return this.uri;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.name = archive.add(this.name, false);
        this.uri = archive.add(this.uri, true);
        this.email = archive.add(this.email, true);
    }

    public Author() {
    }
}
