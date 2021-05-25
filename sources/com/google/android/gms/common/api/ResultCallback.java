package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Result;
public interface ResultCallback<R extends Result> {
    void onResult(@RecentlyNonNull R r);
}
