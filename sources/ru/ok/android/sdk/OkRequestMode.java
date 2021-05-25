package ru.ok.android.sdk;

import java.util.EnumSet;
public enum OkRequestMode {
    SIGNED,
    UNSIGNED,
    SDK_SESSION,
    NO_PLATFORM_REPORTING;
    
    public static final EnumSet<OkRequestMode> DEFAULT;

    /* access modifiers changed from: public */
    static {
        OkRequestMode okRequestMode;
        DEFAULT = EnumSet.of(okRequestMode);
    }
}
