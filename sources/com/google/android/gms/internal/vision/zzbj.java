package com.google.android.gms.internal.vision;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
public final class zzbj {
    @GuardedBy("PhenotypeConstants.class")
    private static final ArrayMap<String, Uri> zzgp = new ArrayMap<>();

    public static synchronized Uri getContentProviderUri(String str) {
        Uri uri;
        synchronized (zzbj.class) {
            ArrayMap<String, Uri> arrayMap = zzgp;
            uri = arrayMap.get(str);
            if (uri == null) {
                String valueOf = String.valueOf(Uri.encode(str));
                uri = Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
                arrayMap.put(str, uri);
            }
        }
        return uri;
    }
}
