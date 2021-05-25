package com.google.android.gms.common.internal;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
public final class AccountType {
    @RecentlyNonNull
    @KeepForSdk
    public static final String GOOGLE = "com.google";
    private static final String[] zza = {"com.google", "com.google.work", "cn.google"};

    private AccountType() {
    }
}
