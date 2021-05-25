package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
public final class zzaj extends zzae<Boolean> {
    public zzaj(zzao zzao, String str, Boolean bool) {
        super(zzao, str, bool, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final Boolean zza(SharedPreferences sharedPreferences) {
        try {
            return Boolean.valueOf(sharedPreferences.getBoolean(this.zzds, false));
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(this.zzds);
            if (valueOf.length() != 0) {
                "Invalid boolean value in SharedPreferences for ".concat(valueOf);
                return null;
            }
            new String("Invalid boolean value in SharedPreferences for ");
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.clearcut.zzae
    public final /* synthetic */ Boolean zzb(String str) {
        if (zzy.zzcr.matcher(str).matches()) {
            return Boolean.TRUE;
        }
        if (zzy.zzcs.matcher(str).matches()) {
            return Boolean.FALSE;
        }
        String.valueOf(this.zzds).length();
        String.valueOf(str).length();
        return null;
    }
}
