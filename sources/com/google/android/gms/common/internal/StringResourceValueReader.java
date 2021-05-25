package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.avito.android.util.preferences.db_preferences.Types;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
public class StringResourceValueReader {
    private final Resources zza;
    private final String zzb;

    public StringResourceValueReader(@RecentlyNonNull Context context) {
        Preconditions.checkNotNull(context);
        Resources resources = context.getResources();
        this.zza = resources;
        this.zzb = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    @RecentlyNullable
    @KeepForSdk
    public String getString(@RecentlyNonNull String str) {
        int identifier = this.zza.getIdentifier(str, Types.STRING, this.zzb);
        if (identifier == 0) {
            return null;
        }
        return this.zza.getString(identifier);
    }
}
