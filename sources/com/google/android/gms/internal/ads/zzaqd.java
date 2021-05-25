package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
public final class zzaqd extends zzaqg implements zzahf<zzbfq> {
    private float density;
    private int maxHeight = -1;
    private int maxWidth = -1;
    private int rotation;
    private final WindowManager zzbrf;
    private final zzbfq zzdgc;
    private final zzaae zzdnf;
    private int zzdng = -1;
    private int zzdnh = -1;
    private int zzdni = -1;
    private int zzdnj = -1;
    private final Context zzvr;
    private DisplayMetrics zzxd;

    public zzaqd(zzbfq zzbfq, Context context, zzaae zzaae) {
        super(zzbfq);
        this.zzdgc = zzbfq;
        this.zzvr = context;
        this.zzdnf = zzaae;
        this.zzbrf = (WindowManager) context.getSystemService("window");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahf
    public final /* synthetic */ void zza(zzbfq zzbfq, Map map) {
        this.zzxd = new DisplayMetrics();
        Display defaultDisplay = this.zzbrf.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzxd);
        this.density = this.zzxd.density;
        this.rotation = defaultDisplay.getRotation();
        zzwe.zzpq();
        DisplayMetrics displayMetrics = this.zzxd;
        this.zzdng = zzbat.zzb(displayMetrics, displayMetrics.widthPixels);
        zzwe.zzpq();
        DisplayMetrics displayMetrics2 = this.zzxd;
        this.zzdnh = zzbat.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzzq = this.zzdgc.zzzq();
        if (zzzq == null || zzzq.getWindow() == null) {
            this.maxWidth = this.zzdng;
            this.maxHeight = this.zzdnh;
        } else {
            zzp.zzkp();
            int[] zzd = zzayh.zzd(zzzq);
            zzwe.zzpq();
            this.maxWidth = zzbat.zzb(this.zzxd, zzd[0]);
            zzwe.zzpq();
            this.maxHeight = zzbat.zzb(this.zzxd, zzd[1]);
        }
        if (this.zzdgc.zzabc().zzacx()) {
            this.zzdni = this.zzdng;
            this.zzdnj = this.zzdnh;
        } else {
            this.zzdgc.measure(0, 0);
        }
        zza(this.zzdng, this.zzdnh, this.maxWidth, this.maxHeight, this.density, this.rotation);
        this.zzdgc.zzb("onDeviceFeaturesReceived", new zzaqc(new zzaqe().zzae(this.zzdnf.zzqy()).zzad(this.zzdnf.zzqz()).zzaf(this.zzdnf.zzrb()).zzag(this.zzdnf.zzra()).zzah(true)).zzul());
        int[] iArr = new int[2];
        this.zzdgc.getLocationOnScreen(iArr);
        zzj(zzwe.zzpq().zzb(this.zzvr, iArr[0]), zzwe.zzpq().zzb(this.zzvr, iArr[1]));
        if (zzbbd.isLoggable(2)) {
            zzbbd.zzfd("Dispatching Ready Event.");
        }
        zzdy(this.zzdgc.zzzt().zzbra);
    }

    public final void zzj(int i, int i2) {
        int i3 = 0;
        if (this.zzvr instanceof Activity) {
            i3 = zzp.zzkp().zzf((Activity) this.zzvr)[0];
        }
        if (this.zzdgc.zzabc() == null || !this.zzdgc.zzabc().zzacx()) {
            int width = this.zzdgc.getWidth();
            int height = this.zzdgc.getHeight();
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcms)).booleanValue()) {
                if (width == 0 && this.zzdgc.zzabc() != null) {
                    width = this.zzdgc.zzabc().widthPixels;
                }
                if (height == 0 && this.zzdgc.zzabc() != null) {
                    height = this.zzdgc.zzabc().heightPixels;
                }
            }
            this.zzdni = zzwe.zzpq().zzb(this.zzvr, width);
            this.zzdnj = zzwe.zzpq().zzb(this.zzvr, height);
        }
        zzc(i, i2 - i3, this.zzdni, this.zzdnj);
        this.zzdgc.zzabe().zzi(i, i2);
    }
}
