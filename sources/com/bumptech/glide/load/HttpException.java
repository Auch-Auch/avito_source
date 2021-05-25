package com.bumptech.glide.load;

import a2.b.a.a.a;
import androidx.annotation.Nullable;
import java.io.IOException;
public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    public final int a;

    public HttpException(int i) {
        this(a.M2("Http request failed with status code: ", i), i);
    }

    public int getStatusCode() {
        return this.a;
    }

    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i) {
        this(str, i, null);
    }

    public HttpException(String str, int i, @Nullable Throwable th) {
        super(str, th);
        this.a = i;
    }
}
