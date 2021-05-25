package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzaxk {
    private final Object lock = new Object();
    private zzbbg zzbpa;
    private final zzaxv zzdxp;
    private zzqn zzdxx;
    private final zzayd zzdxy;
    @Nullable
    private zzaba zzdxz;
    @Nullable
    private Boolean zzdya;
    private final AtomicInteger zzdyb;
    private final zzaxp zzdyc;
    private final Object zzdyd;
    @GuardedBy("grantedPermissionLock")
    private zzdvt<ArrayList<String>> zzdye;
    private Context zzvr;
    private boolean zzzh;

    public zzaxk() {
        zzayd zzayd = new zzayd();
        this.zzdxy = zzayd;
        this.zzdxp = new zzaxv(zzwe.zzpv(), zzayd);
        this.zzzh = false;
        this.zzdxz = null;
        this.zzdya = null;
        this.zzdyb = new AtomicInteger(0);
        this.zzdyc = new zzaxp(null);
        this.zzdyd = new Object();
    }

    @TargetApi(16)
    private static ArrayList<String> zzam(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(context.getApplicationInfo().packageName, 4096);
            if (packageInfo.requestedPermissions != null && packageInfo.requestedPermissionsFlags != null) {
                int i = 0;
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i >= strArr.length) {
                        break;
                    }
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(strArr[i]);
                    }
                    i++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    @Nullable
    public final Context getApplicationContext() {
        return this.zzvr;
    }

    @Nullable
    public final Resources getResources() {
        if (this.zzbpa.zzeds) {
            return this.zzvr.getResources();
        }
        try {
            zzbbc.zzbt(this.zzvr).getResources();
            return null;
        } catch (zzbbe e) {
            zzbbd.zzd("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final void zza(Boolean bool) {
        synchronized (this.lock) {
            this.zzdya = bool;
        }
    }

    public final void zzb(Throwable th, String str) {
        zzaro.zzc(this.zzvr, this.zzbpa).zza(th, str, zzact.zzdbn.get().floatValue());
    }

    @TargetApi(23)
    public final void zzd(Context context, zzbbg zzbbg) {
        synchronized (this.lock) {
            if (!this.zzzh) {
                this.zzvr = context.getApplicationContext();
                this.zzbpa = zzbbg;
                zzp.zzks().zza(this.zzdxp);
                zzaba zzaba = null;
                this.zzdxy.zza(this.zzvr, (String) null, true);
                zzaro.zzc(this.zzvr, this.zzbpa);
                this.zzdxx = new zzqn(context.getApplicationContext(), this.zzbpa);
                zzp.zzky();
                if (!zzach.zzczv.get().booleanValue()) {
                    zzaxy.zzei("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                } else {
                    zzaba = new zzaba();
                }
                this.zzdxz = zzaba;
                if (zzaba != null) {
                    zzbbm.zza(new zzaxm(this).zzwv(), "AppState.registerCsiReporter");
                }
                this.zzzh = true;
                zzwk();
            }
        }
        zzp.zzkp().zzs(context, zzbbg.zzbra);
    }

    @Nullable
    public final zzaba zzwd() {
        zzaba zzaba;
        synchronized (this.lock) {
            zzaba = this.zzdxz;
        }
        return zzaba;
    }

    public final Boolean zzwe() {
        Boolean bool;
        synchronized (this.lock) {
            bool = this.zzdya;
        }
        return bool;
    }

    public final void zzwf() {
        this.zzdyc.zzwf();
    }

    public final void zzwg() {
        this.zzdyb.incrementAndGet();
    }

    public final void zzwh() {
        this.zzdyb.decrementAndGet();
    }

    public final int zzwi() {
        return this.zzdyb.get();
    }

    public final zzaya zzwj() {
        zzayd zzayd;
        synchronized (this.lock) {
            zzayd = this.zzdxy;
        }
        return zzayd;
    }

    public final zzdvt<ArrayList<String>> zzwk() {
        if (PlatformVersion.isAtLeastJellyBean() && this.zzvr != null) {
            if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcqq)).booleanValue()) {
                synchronized (this.zzdyd) {
                    zzdvt<ArrayList<String>> zzdvt = this.zzdye;
                    if (zzdvt != null) {
                        return zzdvt;
                    }
                    zzdvt<ArrayList<String>> zze = zzbbi.zzedu.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzaxn
                        private final zzaxk zzdyn;

                        {
                            this.zzdyn = r1;
                        }

                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.zzdyn.zzwm();
                        }
                    });
                    this.zzdye = zze;
                    return zze;
                }
            }
        }
        return zzdvl.zzaf(new ArrayList());
    }

    public final zzaxv zzwl() {
        return this.zzdxp;
    }

    public final /* synthetic */ ArrayList zzwm() throws Exception {
        return zzam(zzatg.zzab(this.zzvr));
    }

    public final void zza(Throwable th, String str) {
        zzaro.zzc(this.zzvr, this.zzbpa).zza(th, str);
    }
}
