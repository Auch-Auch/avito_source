package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;
public final class zzapw extends zzaqg {
    private static final Set<String> zzdmi = CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private int height = -1;
    private final Object lock = new Object();
    private int width = -1;
    private zzaqf zzdet;
    private final zzbfq zzdgc;
    private final Activity zzdly;
    private String zzdmj = "top-right";
    private boolean zzdmk = true;
    private int zzdml = 0;
    private int zzdmm = 0;
    private int zzdmn = 0;
    private int zzdmo = 0;
    private zzbhj zzdmp;
    private ImageView zzdmq;
    private LinearLayout zzdmr;
    private PopupWindow zzdms;
    private RelativeLayout zzdmt;
    private ViewGroup zzdmu;

    public zzapw(zzbfq zzbfq, zzaqf zzaqf) {
        super(zzbfq, "resize");
        this.zzdgc = zzbfq;
        this.zzdly = zzbfq.zzzq();
        this.zzdet = zzaqf;
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.lock) {
            this.zzdml = i;
            this.zzdmm = i2;
            PopupWindow popupWindow = this.zzdms;
        }
    }

    public final void zzac(boolean z) {
        synchronized (this.lock) {
            PopupWindow popupWindow = this.zzdms;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.zzdmt.removeView(this.zzdgc.getView());
                ViewGroup viewGroup = this.zzdmu;
                if (viewGroup != null) {
                    viewGroup.removeView(this.zzdmq);
                    this.zzdmu.addView(this.zzdgc.getView());
                    this.zzdgc.zza(this.zzdmp);
                }
                if (z) {
                    zzdz("default");
                    zzaqf zzaqf = this.zzdet;
                    if (zzaqf != null) {
                        zzaqf.zzum();
                    }
                }
                this.zzdms = null;
                this.zzdmt = null;
                this.zzdmu = null;
                this.zzdmr = null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0298  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(java.util.Map<java.lang.String, java.lang.String> r17) {
        /*
        // Method dump skipped, instructions count: 1250
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapw.zzg(java.util.Map):void");
    }

    public final void zzi(int i, int i2) {
        this.zzdml = i;
        this.zzdmm = i2;
    }

    public final boolean zzuk() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdms != null;
        }
        return z;
    }
}
