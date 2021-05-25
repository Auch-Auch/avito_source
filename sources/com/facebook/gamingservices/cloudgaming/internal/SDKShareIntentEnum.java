package com.facebook.gamingservices.cloudgaming.internal;

import androidx.annotation.Nullable;
public enum SDKShareIntentEnum {
    INVITE("INVITE"),
    REQUEST("REQUEST"),
    CHALLENGE("CHALLENGE"),
    SHARE("SHARE");
    
    public final String a;

    /* access modifiers changed from: public */
    SDKShareIntentEnum(String str) {
        this.a = str;
    }

    @Nullable
    public static SDKShareIntentEnum fromString(String str) {
        SDKShareIntentEnum[] values = values();
        for (int i = 0; i < 4; i++) {
            SDKShareIntentEnum sDKShareIntentEnum = values[i];
            if (sDKShareIntentEnum.toString().equals(str)) {
                return sDKShareIntentEnum;
            }
        }
        return null;
    }

    @Nullable
    public static String validate(String str) {
        SDKShareIntentEnum[] values = values();
        for (int i = 0; i < 4; i++) {
            if (values[i].toString().equals(str)) {
                return str;
            }
        }
        return null;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.a;
    }
}
