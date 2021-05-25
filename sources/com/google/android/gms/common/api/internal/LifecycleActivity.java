package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
@KeepForSdk
public class LifecycleActivity {
    private final Object zza;

    public LifecycleActivity(@RecentlyNonNull Activity activity) {
        this.zza = Preconditions.checkNotNull(activity, "Activity must not be null");
    }

    @NonNull
    @KeepForSdk
    public Activity asActivity() {
        return (Activity) this.zza;
    }

    @NonNull
    @KeepForSdk
    public FragmentActivity asFragmentActivity() {
        return (FragmentActivity) this.zza;
    }

    @NonNull
    @KeepForSdk
    public Object asObject() {
        return this.zza;
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean isChimera() {
        return false;
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean isSupport() {
        return this.zza instanceof FragmentActivity;
    }

    @RecentlyNonNull
    public final boolean zza() {
        return this.zza instanceof Activity;
    }

    @KeepForSdk
    public LifecycleActivity(@RecentlyNonNull ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }
}
