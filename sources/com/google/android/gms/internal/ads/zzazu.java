package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzazu extends zzbh {
    private final /* synthetic */ byte[] zzebx;
    private final /* synthetic */ Map zzeby;
    private final /* synthetic */ zzbax zzebz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzazu(zzazt zzazt, int i, String str, zzal zzal, zzai zzai, byte[] bArr, Map map, zzbax zzbax) {
        super(i, str, zzal, zzai);
        this.zzebx = bArr;
        this.zzeby = map;
        this.zzebz = zzbax;
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public final Map<String, String> getHeaders() throws zzl {
        Map<String, String> map = this.zzeby;
        return map == null ? super.getHeaders() : map;
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public final byte[] zzg() throws zzl {
        byte[] bArr = this.zzebx;
        return bArr == null ? super.zzg() : bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    /* renamed from: zzj */
    public final void zza(String str) {
        this.zzebz.zzez(str);
        super.zza(str);
    }
}
