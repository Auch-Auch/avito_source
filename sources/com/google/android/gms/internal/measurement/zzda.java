package com.google.android.gms.internal.measurement;
public final class zzda extends zzcw<Boolean> {
    public zzda(zzdf zzdf, String str, Boolean bool, boolean z) {
        super(zzdf, str, bool, z, null);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzcw
    public final /* synthetic */ Boolean zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzcf.zzb.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (zzcf.zzc.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String zzb = super.zzb();
        String valueOf = String.valueOf(obj);
        String.valueOf(zzb).length();
        valueOf.length();
        return null;
    }
}
