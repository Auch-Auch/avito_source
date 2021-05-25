package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
public class UserRecoverableException extends Exception {
    private final Intent zza;

    public UserRecoverableException(@RecentlyNonNull String str, @RecentlyNonNull Intent intent) {
        super(str);
        this.zza = intent;
    }

    @RecentlyNonNull
    public Intent getIntent() {
        return new Intent(this.zza);
    }
}
