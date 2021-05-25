package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
public final class zzdps {
    private final Executor executor;
    private final Clock zzbpw;
    private final String zzbra;
    private final String zzciq;
    private final String zzdpz;
    private final zzeg zzflj;
    private final zzdli zzfsl;
    private final zzcud zzfuf;
    private final zzbbh zzhif;
    private final Context zzvr;

    public zzdps(Executor executor2, zzbbh zzbbh, zzcud zzcud, zzbbg zzbbg, String str, String str2, Context context, @Nullable zzdli zzdli, Clock clock, zzeg zzeg) {
        this.executor = executor2;
        this.zzhif = zzbbh;
        this.zzfuf = zzcud;
        this.zzbra = zzbbg.zzbra;
        this.zzdpz = str;
        this.zzciq = str2;
        this.zzvr = context;
        this.zzfsl = zzdli;
        this.zzbpw = clock;
        this.zzflj = zzeg;
    }

    private static String zzc(String str, String str2, @Nullable String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    @Nullable
    private static String zzgy(@Nullable String str) {
        return (TextUtils.isEmpty(str) || !zzbax.isEnabled()) ? str : "fakeForAdDebugLog";
    }

    public final void zza(zzdlj zzdlj, zzdkx zzdkx, List<String> list) {
        zza(zzdlj, zzdkx, false, "", "", list);
    }

    public final void zzes(String str) {
        this.executor.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzdpr
            private final String zzdft;
            private final zzdps zzhie;

            {
                this.zzhie = r1;
                this.zzdft = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhie.zzgz(this.zzdft);
            }
        });
    }

    public final /* synthetic */ void zzgz(String str) {
        this.zzhif.zzes(str);
    }

    public final void zzi(List<String> list) {
        for (String str : list) {
            zzes(str);
        }
    }

    public final void zza(zzdlj zzdlj, @Nullable zzdkx zzdkx, boolean z, String str, @Nullable String str2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String str3 = z ? "1" : "0";
        for (String str4 : list) {
            String zzc = zzc(zzc(zzc(str4, "@gw_adlocid@", zzdlj.zzhbp.zzfqn.zzhbv), "@gw_adnetrefresh@", str3), "@gw_sdkver@", this.zzbra);
            if (zzdkx != null) {
                zzc = zzawq.zzc(zzc(zzc(zzc(zzc, "@gw_qdata@", zzdkx.zzdiy), "@gw_adnetid@", zzdkx.zzagt), "@gw_allocid@", zzdkx.zzdjo), this.zzvr, zzdkx.zzdsu);
            }
            String zzc2 = zzc(zzc(zzc(zzc, "@gw_adnetstatus@", this.zzfuf.zzapv()), "@gw_seqnum@", this.zzdpz), "@gw_sessid@", this.zzciq);
            boolean z2 = ((Boolean) zzwe.zzpu().zzd(zzaat.zzcre)).booleanValue() && !TextUtils.isEmpty(str);
            boolean isEmpty = true ^ TextUtils.isEmpty(str2);
            if (z2 || isEmpty) {
                if (this.zzflj.zzb(Uri.parse(zzc2))) {
                    Uri.Builder buildUpon = Uri.parse(zzc2).buildUpon();
                    if (z2) {
                        buildUpon = buildUpon.appendQueryParameter("ms", str);
                    }
                    if (isEmpty) {
                        buildUpon = buildUpon.appendQueryParameter("attok", str2);
                    }
                    zzc2 = buildUpon.build().toString();
                }
            }
            arrayList.add(zzc2);
        }
        zzi(arrayList);
    }

    public final void zza(zzdlj zzdlj, zzdkx zzdkx, List<String> list, zzatj zzatj) {
        long currentTimeMillis = this.zzbpw.currentTimeMillis();
        try {
            String type = zzatj.getType();
            String num = Integer.toString(zzatj.getAmount());
            ArrayList arrayList = new ArrayList();
            zzdli zzdli = this.zzfsl;
            String str = "";
            String zzgy = zzdli == null ? str : zzgy(zzdli.zzdve);
            zzdli zzdli2 = this.zzfsl;
            if (zzdli2 != null) {
                str = zzgy(zzdli2.zzdvf);
            }
            for (String str2 : list) {
                arrayList.add(zzawq.zzc(zzc(zzc(zzc(zzc(zzc(zzc(str2, "@gw_rwd_userid@", Uri.encode(zzgy)), "@gw_rwd_custom_data@", Uri.encode(str)), "@gw_tmstmp@", Long.toString(currentTimeMillis)), "@gw_rwd_itm@", Uri.encode(type)), "@gw_rwd_amt@", num), "@gw_sdkver@", this.zzbra), this.zzvr, zzdkx.zzdsu));
            }
            zzi(arrayList);
        } catch (RemoteException unused) {
        }
    }
}
