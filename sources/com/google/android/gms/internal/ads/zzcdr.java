package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
public final class zzcdr {
    private final Executor executor;
    private final zzadm zzdla;
    private final zzaya zzdza;
    private final Executor zzfmk;
    private final zzdln zzfqn;
    private final zzccv zzfvt;
    private final zzccz zzfwz;
    private final zzccu zzfxh;
    @Nullable
    private final zzcdz zzfzh;
    @Nullable
    private final zzceh zzfzi;

    public zzcdr(zzaya zzaya, zzdln zzdln, zzccz zzccz, zzccv zzccv, @Nullable zzcdz zzcdz, @Nullable zzceh zzceh, Executor executor2, Executor executor3, zzccu zzccu) {
        this.zzdza = zzaya;
        this.zzfqn = zzdln;
        this.zzdla = zzdln.zzdla;
        this.zzfwz = zzccz;
        this.zzfvt = zzccv;
        this.zzfzh = zzcdz;
        this.zzfzi = zzceh;
        this.zzfmk = executor2;
        this.executor = executor3;
        this.zzfxh = zzccu;
    }

    public final void zza(zzcep zzcep) {
        this.zzfmk.execute(new Runnable(this, zzcep) { // from class: com.google.android.gms.internal.ads.zzcdu
            private final zzcdr zzfzk;
            private final zzcep zzfzm;

            {
                this.zzfzk = r1;
                this.zzfzm = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfzk.zze(this.zzfzm);
            }
        });
    }

    public final /* synthetic */ void zzb(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.zzfvt.zzalr() == null) {
            return;
        }
        if (2 == this.zzfvt.zzaln() || 1 == this.zzfvt.zzaln()) {
            this.zzdza.zza(this.zzfqn.zzhbv, String.valueOf(this.zzfvt.zzaln()), z);
        } else if (6 == this.zzfvt.zzaln()) {
            this.zzdza.zza(this.zzfqn.zzhbv, ExifInterface.GPS_MEASUREMENT_2D, z);
            this.zzdza.zza(this.zzfqn.zzhbv, "1", z);
        }
    }

    public final void zzc(@Nullable zzcep zzcep) {
        if (zzcep != null && this.zzfzh != null && zzcep.zzams() != null && this.zzfwz.zzalz()) {
            try {
                zzcep.zzams().addView(this.zzfzh.zzamy());
            } catch (zzbgc e) {
                zzaxy.zza("web view can not be obtained", e);
            }
        }
    }

    public final void zzd(@Nullable zzcep zzcep) {
        if (zzcep != null) {
            Context context = zzcep.zzahq().getContext();
            if (zzbah.zza(this.zzfwz.zzfyh)) {
                if (!(context instanceof Activity)) {
                    zzbbd.zzef("Activity context is needed for policy validator.");
                } else if (this.zzfzi != null && zzcep.zzams() != null) {
                    try {
                        WindowManager windowManager = (WindowManager) context.getSystemService("window");
                        windowManager.addView(this.zzfzi.zza(zzcep.zzams(), windowManager), zzbah.zzyg());
                    } catch (zzbgc e) {
                        zzaxy.zza("web view can not be obtained", e);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00f5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zze(com.google.android.gms.internal.ads.zzcep r10) {
        /*
        // Method dump skipped, instructions count: 427
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdr.zze(com.google.android.gms.internal.ads.zzcep):void");
    }

    private static void zza(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    /* access modifiers changed from: private */
    public static boolean zza(zzcep zzcep, String[] strArr) {
        Map<String, WeakReference<View>> zzamp = zzcep.zzamp();
        if (zzamp == null) {
            return false;
        }
        for (String str : strArr) {
            if (zzamp.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean zza(@NonNull ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        View zzalr = this.zzfvt.zzalr();
        if (zzalr == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzalr.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzalr.getParent()).removeView(zzalr);
        }
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcru)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(zzalr, layoutParams);
        return true;
    }
}
