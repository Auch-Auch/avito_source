package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Result;
public class Response<T extends Result> {
    private T zza;

    public Response() {
    }

    @NonNull
    public T getResult() {
        return this.zza;
    }

    public void setResult(@RecentlyNonNull T t) {
        this.zza = t;
    }

    public Response(@RecentlyNonNull T t) {
        this.zza = t;
    }
}
