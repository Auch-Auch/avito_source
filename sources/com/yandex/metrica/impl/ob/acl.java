package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public enum acl {
    NONE(0),
    EXTERNALLY_ENCRYPTED_EVENT_CRYPTER(1),
    AES_VALUE_ENCRYPTION(2);
    
    private final int d;

    private acl(int i) {
        this.d = i;
    }

    public int a() {
        return this.d;
    }

    @NonNull
    public static acl a(@Nullable Integer num) {
        if (num != null) {
            acl[] values = values();
            for (int i = 0; i < 3; i++) {
                acl acl = values[i];
                if (acl.a() == num.intValue()) {
                    return acl;
                }
            }
        }
        return NONE;
    }
}
