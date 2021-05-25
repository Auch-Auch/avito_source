package com.my.target.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class MyTargetPrivacy {
    @Nullable
    public static Boolean a;
    @Nullable
    public static Boolean b;
    @Nullable
    public static Boolean c;
    public static boolean d;
    @Nullable
    public final Boolean ccpaUserConsent;
    @Nullable
    public final Boolean iabUserConsent;
    public final boolean userAgeRestricted;
    @Nullable
    public final Boolean userConsent;

    public MyTargetPrivacy(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, boolean z) {
        this.userConsent = bool;
        this.ccpaUserConsent = bool2;
        this.iabUserConsent = bool3;
        this.userAgeRestricted = z;
    }

    @NonNull
    public static MyTargetPrivacy currentPrivacy() {
        return new MyTargetPrivacy(a, b, c, d);
    }

    public static void setCcpaUserConsent(boolean z) {
        b = Boolean.valueOf(z);
    }

    public static void setIabUserConsent(boolean z) {
        c = Boolean.valueOf(z);
    }

    public static void setUserAgeRestricted(boolean z) {
        d = z;
    }

    public static void setUserConsent(boolean z) {
        a = Boolean.valueOf(z);
    }

    public boolean isConsent() {
        Boolean bool = Boolean.FALSE;
        return !bool.equals(this.userConsent) && !bool.equals(this.ccpaUserConsent) && !bool.equals(this.iabUserConsent);
    }
}
