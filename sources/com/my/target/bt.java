package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public abstract class bt<T> {
    @Nullable
    public T a;
    public int height;
    @NonNull
    public final String url;
    public int width;

    public bt(@NonNull String str) {
        this.url = str;
    }

    @Nullable
    public T getData() {
        return this.a;
    }

    public int getHeight() {
        return this.height;
    }

    @NonNull
    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public void setData(@Nullable T t) {
        this.a = t;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
