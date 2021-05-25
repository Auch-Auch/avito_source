package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzduf implements FilenameFilter {
    private final Pattern zzhch;

    public zzduf(Pattern pattern) {
        this.zzhch = (Pattern) zzdsv.checkNotNull(pattern);
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(@NullableDecl File file, String str) {
        return this.zzhch.matcher(str).matches();
    }
}
