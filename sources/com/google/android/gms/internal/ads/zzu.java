package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.text.TextUtils;
public final class zzu {
    private final String mName;
    private final String mValue;

    public zzu(String str, String str2) {
        this.mName = str;
        this.mValue = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzu.class == obj.getClass()) {
            zzu zzu = (zzu) obj;
            if (TextUtils.equals(this.mName, zzu.mName) && TextUtils.equals(this.mValue, zzu.mValue)) {
                return true;
            }
        }
        return false;
    }

    public final String getName() {
        return this.mName;
    }

    public final String getValue() {
        return this.mValue;
    }

    public final int hashCode() {
        return this.mValue.hashCode() + (this.mName.hashCode() * 31);
    }

    public final String toString() {
        String str = this.mName;
        String str2 = this.mValue;
        StringBuilder K = a.K(a.q0(str2, a.q0(str, 20)), "Header[name=", str, ",value=", str2);
        K.append("]");
        return K.toString();
    }
}
