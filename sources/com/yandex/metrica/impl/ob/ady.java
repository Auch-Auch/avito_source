package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;
public class ady implements adw<String> {
    private final Map<String, ?> a;

    public ady(@NonNull Map<String, ?> map) {
        this.a = map;
    }

    public adu a(@Nullable String str) {
        if (this.a.containsKey(str)) {
            return adu.a(this, String.format("Failed to activate AppMetrica with provided apiKey ApiKey %s has already been used by another reporter.", str));
        }
        return adu.a(this);
    }
}
