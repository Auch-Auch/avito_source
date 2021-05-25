package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
public interface LifecycleFragment {
    @KeepForSdk
    void addCallback(@RecentlyNonNull String str, @RecentlyNonNull LifecycleCallback lifecycleCallback);

    @RecentlyNullable
    @KeepForSdk
    <T extends LifecycleCallback> T getCallbackOrNull(@RecentlyNonNull String str, @RecentlyNonNull Class<T> cls);

    @RecentlyNonNull
    @KeepForSdk
    Activity getLifecycleActivity();

    @RecentlyNonNull
    @KeepForSdk
    boolean isCreated();

    @RecentlyNonNull
    @KeepForSdk
    boolean isStarted();

    @KeepForSdk
    void startActivityForResult(@RecentlyNonNull Intent intent, @RecentlyNonNull int i);
}
