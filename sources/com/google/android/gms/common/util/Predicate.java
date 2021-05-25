package com.google.android.gms.common.util;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
public interface Predicate<T> {
    @RecentlyNonNull
    @KeepForSdk
    boolean apply(@RecentlyNonNull T t);
}
