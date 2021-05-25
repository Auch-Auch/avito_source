package com.yandex.metrica.impl.ob;

import android.support.annotation.Nullable;
public class ug implements adw<String> {
    public adu a(@Nullable String str) {
        if (str == null) {
            return adu.a(this, "key is null");
        }
        if (str.startsWith("appmetrica")) {
            return adu.a(this, "key starts with appmetrica");
        }
        if (str.length() > 200) {
            return adu.a(this, "key length more then 200 characters");
        }
        return adu.a(this);
    }
}
