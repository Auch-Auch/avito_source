package com.my.target;

import androidx.annotation.NonNull;
public class cw extends da {
    public boolean g;

    public cw(@NonNull String str, @NonNull String str2) {
        super(str, str2);
    }

    @NonNull
    public static cw I(@NonNull String str) {
        return new cw("ovvStat", str);
    }

    public boolean ct() {
        return this.g;
    }

    public void v(boolean z) {
        this.g = z;
    }
}
