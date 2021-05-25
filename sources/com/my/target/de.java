package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public abstract class de<T> {
    @Nullable
    public String c;
    public boolean dx;
    public boolean eW;
    @Nullable
    public T eX;
    public int responseCode = -1;

    @Nullable
    public abstract T c(@NonNull String str, @NonNull Context context);

    public boolean cI() {
        return this.eW;
    }

    @Nullable
    public T cJ() {
        return this.eX;
    }

    @Nullable
    public String cK() {
        return this.c;
    }

    @Nullable
    public final T f(@NonNull String str, @NonNull Context context) {
        this.eW = true;
        this.dx = false;
        this.responseCode = -1;
        this.eX = null;
        this.c = null;
        return c(str, context);
    }
}
