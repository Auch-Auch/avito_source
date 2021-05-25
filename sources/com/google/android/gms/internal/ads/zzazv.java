package com.google.android.gms.internal.ads;
public final class zzazv implements zzai {
    private final /* synthetic */ String zzeca;
    private final /* synthetic */ zzazw zzecb;

    public zzazv(zzazt zzazt, String str, zzazw zzazw) {
        this.zzeca = str;
        this.zzecb = zzazw;
    }

    @Override // com.google.android.gms.internal.ads.zzai
    public final void zzc(zzao zzao) {
        String str = this.zzeca;
        String exc = zzao.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(exc).length() + String.valueOf(str).length() + 21);
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(exc);
        zzbbd.zzfe(sb.toString());
        this.zzecb.zzb(null);
    }
}
