package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
public interface Result {
    @RecentlyNonNull
    @KeepForSdk
    Status getStatus();
}
