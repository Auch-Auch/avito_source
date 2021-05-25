package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.TimeUnit;
public final class zzbdh {
    private final zzbbg zzdpq;
    private final String zzdqg;
    @Nullable
    private final zzabk zzefo;
    private boolean zzefs;
    @Nullable
    private final zzabi zzeif;
    private final zzazp zzeig = new zzazq().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzye();
    private final long[] zzeih;
    private final String[] zzeii;
    private boolean zzeij = false;
    private boolean zzeik = false;
    private boolean zzeil = false;
    private boolean zzeim = false;
    private zzbcp zzein;
    private boolean zzeio;
    private boolean zzeip;
    private long zzeiq = -1;
    private final Context zzvr;

    public zzbdh(Context context, zzbbg zzbbg, String str, @Nullable zzabk zzabk, @Nullable zzabi zzabi) {
        this.zzvr = context;
        this.zzdpq = zzbbg;
        this.zzdqg = str;
        this.zzefo = zzabk;
        this.zzeif = zzabi;
        String str2 = (String) zzwe.zzpu().zzd(zzaat.zzcmc);
        if (str2 == null) {
            this.zzeii = new String[0];
            this.zzeih = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzeii = new String[split.length];
        this.zzeih = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzeih[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzbbd.zzd("Unable to parse frame hash target time number.", e);
                this.zzeih[i] = -1;
            }
        }
    }

    public final void onStop() {
        if (zzada.zzdcb.get().booleanValue() && !this.zzeio) {
            Bundle y1 = a.y1("type", "native-player-metrics");
            y1.putString("request", this.zzdqg);
            y1.putString(ScreenPublicConstsKt.CONTENT_TYPE_PLAYER, this.zzein.zzyt());
            for (zzazr zzazr : this.zzeig.zzyd()) {
                String valueOf = String.valueOf(zzazr.name);
                y1.putString(valueOf.length() != 0 ? "fps_c_".concat(valueOf) : new String("fps_c_"), Integer.toString(zzazr.count));
                String valueOf2 = String.valueOf(zzazr.name);
                y1.putString(valueOf2.length() != 0 ? "fps_p_".concat(valueOf2) : new String("fps_p_"), Double.toString(zzazr.zzebt));
            }
            int i = 0;
            while (true) {
                long[] jArr = this.zzeih;
                if (i < jArr.length) {
                    String str = this.zzeii[i];
                    if (str != null) {
                        String valueOf3 = String.valueOf(Long.valueOf(jArr[i]));
                        StringBuilder sb = new StringBuilder(valueOf3.length() + 3);
                        sb.append("fh_");
                        sb.append(valueOf3);
                        y1.putString(sb.toString(), str);
                    }
                    i++;
                } else {
                    zzp.zzkp().zza(this.zzvr, this.zzdpq.zzbra, "gmob-apps", y1, true);
                    this.zzeio = true;
                    return;
                }
            }
        }
    }

    public final void zzb(zzbcp zzbcp) {
        zzabb.zza(this.zzefo, this.zzeif, "vpc2");
        this.zzeij = true;
        zzabk zzabk = this.zzefo;
        if (zzabk != null) {
            zzabk.zzh("vpn", zzbcp.zzyt());
        }
        this.zzein = zzbcp;
    }

    public final void zzc(zzbcp zzbcp) {
        if (this.zzeil && !this.zzeim) {
            if (zzaxy.zzww() && !this.zzeim) {
                zzaxy.zzei("VideoMetricsMixin first frame");
            }
            zzabb.zza(this.zzefo, this.zzeif, "vff2");
            this.zzeim = true;
        }
        long nanoTime = zzp.zzkw().nanoTime();
        if (this.zzefs && this.zzeip && this.zzeiq != -1) {
            this.zzeig.zza(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzeiq)));
        }
        this.zzeip = this.zzefs;
        this.zzeiq = nanoTime;
        long longValue = ((Long) zzwe.zzpu().zzd(zzaat.zzcmd)).longValue();
        long currentPosition = (long) zzbcp.getCurrentPosition();
        int i = 0;
        while (true) {
            String[] strArr = this.zzeii;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] != null || longValue <= Math.abs(currentPosition - this.zzeih[i])) {
                i++;
            } else {
                String[] strArr2 = this.zzeii;
                int i2 = 8;
                Bitmap bitmap = zzbcp.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j2 |= (Color.green(pixel) + (Color.red(pixel) + Color.blue(pixel)) > 128 ? 1 : 0) << ((int) j);
                        i4++;
                        j--;
                        i2 = 8;
                    }
                    i3++;
                    i2 = 8;
                }
                strArr2[i] = String.format("%016X", Long.valueOf(j2));
                return;
            }
        }
    }

    public final void zzez() {
        if (this.zzeij && !this.zzeik) {
            zzabb.zza(this.zzefo, this.zzeif, "vfr2");
            this.zzeik = true;
        }
    }

    public final void zzzy() {
        this.zzefs = true;
        if (this.zzeik && !this.zzeil) {
            zzabb.zza(this.zzefo, this.zzeif, "vfp2");
            this.zzeil = true;
        }
    }

    public final void zzzz() {
        this.zzefs = false;
    }
}
