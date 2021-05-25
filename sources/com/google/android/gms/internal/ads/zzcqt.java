package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zztw;
import java.util.ArrayList;
public final class zzcqt {
    private static final SparseArray<zztw.zzo.zzb> zzgkn;
    private final zzbrz zzfqu;
    private final zzcqq zzghq;
    private final TelephonyManager zzgkk;
    private final zzcqk zzgkl;
    private zzug zzgkm;
    private final Context zzvr;

    static {
        SparseArray<zztw.zzo.zzb> sparseArray = new SparseArray<>();
        zzgkn = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zztw.zzo.zzb.CONNECTED);
        int ordinal = NetworkInfo.DetailedState.AUTHENTICATING.ordinal();
        zztw.zzo.zzb zzb = zztw.zzo.zzb.CONNECTING;
        sparseArray.put(ordinal, zzb);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzb);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzb);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zztw.zzo.zzb.DISCONNECTING);
        int ordinal2 = NetworkInfo.DetailedState.BLOCKED.ordinal();
        zztw.zzo.zzb zzb2 = zztw.zzo.zzb.DISCONNECTED;
        sparseArray.put(ordinal2, zzb2);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzb2);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzb2);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzb2);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzb2);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zztw.zzo.zzb.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzb);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzb);
    }

    public zzcqt(Context context, zzbrz zzbrz, zzcqq zzcqq, zzcqk zzcqk) {
        this.zzvr = context;
        this.zzfqu = zzbrz;
        this.zzghq = zzcqq;
        this.zzgkl = zzcqk;
        this.zzgkk = (TelephonyManager) context.getSystemService("phone");
    }

    /* access modifiers changed from: private */
    public final byte[] zza(boolean z, ArrayList<zztw.zzc.zza> arrayList, zztw.zzm zzm, zztw.zzo.zzb zzb) {
        boolean z2 = true;
        zztw.zzo.zza.C0207zza zzes = zztw.zzo.zza.zzoi().zze(arrayList).zzh(zzbl(zzp.zzkr().zzb(this.zzvr.getContentResolver()) != 0)).zzi(zzp.zzkr().zza(this.zzvr, this.zzgkk)).zzet(this.zzghq.zzapp()).zzeu(this.zzghq.zzapr()).zzcm(this.zzghq.getResponseCode()).zzb(zzb).zzb(zzm).zzj(this.zzgkm).zzf(zzbl(z)).zzes(zzp.zzkw().currentTimeMillis());
        if (zzp.zzkr().zza(this.zzvr.getContentResolver()) == 0) {
            z2 = false;
        }
        return ((zztw.zzo.zza) ((zzegp) zzes.zzg(zzbl(z2)).zzbfx())).toByteArray();
    }

    private static zzug zzbl(boolean z) {
        return z ? zzug.ENUM_TRUE : zzug.ENUM_FALSE;
    }

    /* access modifiers changed from: private */
    public final zztw.zzm zzk(Bundle bundle) {
        zztw.zzm.zzb zzb;
        zztw.zzm.zza zzoe = zztw.zzm.zzoe();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            this.zzgkm = zzug.ENUM_TRUE;
        } else {
            this.zzgkm = zzug.ENUM_FALSE;
            if (i == 0) {
                zzoe.zza(zztw.zzm.zzc.CELL);
            } else if (i != 1) {
                zzoe.zza(zztw.zzm.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zzoe.zza(zztw.zzm.zzc.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzb = zztw.zzm.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzb = zztw.zzm.zzb.THREE_G;
                    break;
                case 13:
                    zzb = zztw.zzm.zzb.LTE;
                    break;
                default:
                    zzb = zztw.zzm.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzoe.zza(zzb);
        }
        return (zztw.zzm) ((zzegp) zzoe.zzbfx());
    }

    /* access modifiers changed from: private */
    public static zztw.zzo.zzb zzl(Bundle bundle) {
        return zzgkn.get(zzdlu.zza(zzdlu.zza(bundle, "device"), "network").getInt("active_network_state", -1), zztw.zzo.zzb.UNSPECIFIED);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.google.android.gms.internal.ads.zztw.zzc.zza> zzm(android.os.Bundle r4) {
        /*
            java.lang.String r0 = "ad_types"
            java.lang.Object r4 = r4.get(r0)
            boolean r0 = r4 instanceof java.util.List
            if (r0 == 0) goto L_0x000d
            java.util.List r4 = (java.util.List) r4
            goto L_0x0017
        L_0x000d:
            boolean r0 = r4 instanceof java.lang.String[]
            if (r0 == 0) goto L_0x003d
            java.lang.String[] r4 = (java.lang.String[]) r4
            java.util.List r4 = java.util.Arrays.asList(r4)
        L_0x0017:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r4.size()
            r0.<init>(r1)
            java.util.Iterator r4 = r4.iterator()
        L_0x0024:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0038
            java.lang.Object r1 = r4.next()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0024
            java.lang.String r1 = (java.lang.String) r1
            r0.add(r1)
            goto L_0x0024
        L_0x0038:
            java.util.List r4 = java.util.Collections.unmodifiableList(r0)
            goto L_0x0041
        L_0x003d:
            java.util.List r4 = java.util.Collections.emptyList()
        L_0x0041:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x004a:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x00a2
            java.lang.Object r1 = r4.next()
            java.lang.String r1 = (java.lang.String) r1
            r1.hashCode()
            r2 = -1
            int r3 = r1.hashCode()
            switch(r3) {
                case -1396342996: goto L_0x0083;
                case -1052618729: goto L_0x0078;
                case -239580146: goto L_0x006d;
                case 604727084: goto L_0x0062;
                default: goto L_0x0061;
            }
        L_0x0061:
            goto L_0x008d
        L_0x0062:
            java.lang.String r3 = "interstitial"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x006b
            goto L_0x008d
        L_0x006b:
            r2 = 3
            goto L_0x008d
        L_0x006d:
            java.lang.String r3 = "rewarded"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0076
            goto L_0x008d
        L_0x0076:
            r2 = 2
            goto L_0x008d
        L_0x0078:
            java.lang.String r3 = "native"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0081
            goto L_0x008d
        L_0x0081:
            r2 = 1
            goto L_0x008d
        L_0x0083:
            java.lang.String r3 = "banner"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r2 = 0
        L_0x008d:
            switch(r2) {
                case 0: goto L_0x009c;
                case 1: goto L_0x0099;
                case 2: goto L_0x0096;
                case 3: goto L_0x0093;
                default: goto L_0x0090;
            }
        L_0x0090:
            com.google.android.gms.internal.ads.zztw$zzc$zza r1 = com.google.android.gms.internal.ads.zztw.zzc.zza.AD_FORMAT_TYPE_UNSPECIFIED
            goto L_0x009e
        L_0x0093:
            com.google.android.gms.internal.ads.zztw$zzc$zza r1 = com.google.android.gms.internal.ads.zztw.zzc.zza.INTERSTITIAL
            goto L_0x009e
        L_0x0096:
            com.google.android.gms.internal.ads.zztw$zzc$zza r1 = com.google.android.gms.internal.ads.zztw.zzc.zza.REWARD_BASED_VIDEO_AD
            goto L_0x009e
        L_0x0099:
            com.google.android.gms.internal.ads.zztw$zzc$zza r1 = com.google.android.gms.internal.ads.zztw.zzc.zza.NATIVE_APP_INSTALL
            goto L_0x009e
        L_0x009c:
            com.google.android.gms.internal.ads.zztw$zzc$zza r1 = com.google.android.gms.internal.ads.zztw.zzc.zza.BANNER
        L_0x009e:
            r0.add(r1)
            goto L_0x004a
        L_0x00a2:
            return r0
            switch-data {-1396342996->0x0083, -1052618729->0x0078, -239580146->0x006d, 604727084->0x0062, }
            switch-data {0->0x009c, 1->0x0099, 2->0x0096, 3->0x0093, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqt.zzm(android.os.Bundle):java.util.ArrayList");
    }

    public final void zzbk(boolean z) {
        zzdvl.zza(this.zzfqu.zzajc(), new zzcqw(this, z), zzbbi.zzedz);
    }
}
