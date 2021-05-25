package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class ck extends by {
    @Nullable
    public String e;
    @Nullable
    public String f;
    public int g = 60;

    @NonNull
    public static ck newBanner() {
        return new ck();
    }

    @Nullable
    public String getMraidJs() {
        return this.f;
    }

    @Nullable
    public String getSource() {
        return this.e;
    }

    public int getTimeout() {
        return this.g;
    }

    public void setMraidJs(@Nullable String str) {
        this.f = str;
    }

    public void setSource(@Nullable String str) {
        this.e = str;
    }

    public void setTimeout(int i) {
        this.g = i;
    }
}
