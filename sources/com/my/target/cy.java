package com.my.target;

import androidx.annotation.NonNull;
public class cy {
    @NonNull
    public final String a;
    @NonNull
    public final String b;
    public boolean c = true;

    public cy(@NonNull String str, @NonNull String str2) {
        this.a = str;
        this.b = str2;
    }

    @NonNull
    public static cy c(@NonNull String str, @NonNull String str2) {
        return new cy(str, str2);
    }

    public boolean cw() {
        return this.c;
    }

    @NonNull
    public String getType() {
        return this.a;
    }

    @NonNull
    public String getUrl() {
        return this.b;
    }

    public void w(boolean z) {
        this.c = z;
    }
}
