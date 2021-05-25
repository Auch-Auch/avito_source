package com.my.target;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
public final class cm {
    @NonNull
    public final String a;
    @NonNull
    public final String b;
    @NonNull
    public final String c;
    @NonNull
    public final cz d = cz.cx();
    @NonNull
    public final HashMap<String, String> e = new HashMap<>();
    @Nullable
    public String f;
    @Nullable
    public cn g;
    public int h = 10000;
    public float i = 0.0f;

    public cm(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @NonNull
    public static cm a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return new cm(str, str2, str3);
    }

    public void a(@Nullable cn cnVar) {
        this.g = cnVar;
    }

    public void b(@NonNull String str, @Nullable String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str2 == null) {
                this.e.remove(str);
            } else {
                this.e.put(str, str2);
            }
        }
    }

    @NonNull
    public String bM() {
        return this.c;
    }

    @NonNull
    public Map<String, String> bN() {
        return new HashMap(this.e);
    }

    public float bO() {
        return this.i;
    }

    @Nullable
    public cn bP() {
        return this.g;
    }

    @NonNull
    public String getName() {
        return this.a;
    }

    @Nullable
    public String getPayload() {
        return this.f;
    }

    @NonNull
    public String getPlacementId() {
        return this.b;
    }

    @NonNull
    public cz getStatHolder() {
        return this.d;
    }

    public int getTimeout() {
        return this.h;
    }

    public void i(float f2) {
        this.i = f2;
    }

    public void setTimeout(int i2) {
        this.h = i2;
    }

    public void u(@Nullable String str) {
        this.f = str;
    }
}
