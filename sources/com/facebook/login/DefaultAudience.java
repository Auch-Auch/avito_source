package com.facebook.login;

import com.facebook.internal.NativeProtocol;
public enum DefaultAudience {
    NONE(null),
    ONLY_ME(NativeProtocol.AUDIENCE_ME),
    FRIENDS("friends"),
    EVERYONE(NativeProtocol.AUDIENCE_EVERYONE);
    
    public final String a;

    /* access modifiers changed from: public */
    DefaultAudience(String str) {
        this.a = str;
    }

    public String getNativeProtocolAudience() {
        return this.a;
    }
}
