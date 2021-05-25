package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
public final class zzdlt {
    private final Pattern zzhch;

    @VisibleForTesting
    public zzdlt() {
        Pattern pattern;
        try {
            pattern = Pattern.compile((String) zzwe.zzpu().zzd(zzaat.zzcxb));
        } catch (PatternSyntaxException unused) {
            pattern = null;
        }
        this.zzhch = pattern;
    }

    @Nullable
    public final String zzgu(@Nullable String str) {
        Pattern pattern = this.zzhch;
        if (!(pattern == null || str == null)) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group();
            }
        }
        return null;
    }
}
