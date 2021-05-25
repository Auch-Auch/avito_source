package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
public final class zzcco extends zzbpd {
    private final zzbbg zzbpa;
    private final zzeg zzenn;
    private final Executor zzfmk;
    private final zzcdg zzfod;
    private final zzavy zzfpr;
    private final zzcxh zzftk;
    private final zzccv zzfvt;
    private final zzcdd zzfwx;
    private final zzcdr zzfwy;
    private final zzccz zzfwz;
    private final zzeli<zzcgu> zzfxa;
    private final zzeli<zzcgs> zzfxb;
    private final zzeli<zzcgx> zzfxc;
    private final zzeli<zzcgo> zzfxd;
    private final zzeli<zzcgw> zzfxe;
    private zzcep zzfxf;
    private boolean zzfxg;
    private final zzccu zzfxh;
    private final Context zzvr;

    public zzcco(zzbpg zzbpg, Executor executor, zzccv zzccv, zzcdd zzcdd, zzcdr zzcdr, zzccz zzccz, zzcdg zzcdg, zzeli<zzcgu> zzeli, zzeli<zzcgs> zzeli2, zzeli<zzcgx> zzeli3, zzeli<zzcgo> zzeli4, zzeli<zzcgw> zzeli5, zzavy zzavy, zzeg zzeg, zzbbg zzbbg, Context context, zzccu zzccu, zzcxh zzcxh) {
        super(zzbpg);
        this.zzfmk = executor;
        this.zzfvt = zzccv;
        this.zzfwx = zzcdd;
        this.zzfwy = zzcdr;
        this.zzfwz = zzccz;
        this.zzfod = zzcdg;
        this.zzfxa = zzeli;
        this.zzfxb = zzeli2;
        this.zzfxc = zzeli3;
        this.zzfxd = zzeli4;
        this.zzfxe = zzeli5;
        this.zzfpr = zzavy;
        this.zzenn = zzeg;
        this.zzbpa = zzbbg;
        this.zzvr = context;
        this.zzfxh = zzccu;
        this.zzftk = zzcxh;
    }

    public static boolean zzz(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
    }

    public final synchronized void cancelUnconfirmedClick() {
        this.zzfwx.cancelUnconfirmedClick();
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final synchronized void destroy() {
        this.zzfmk.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzccp
            private final zzcco zzfww;

            {
                this.zzfww = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfww.zzall();
            }
        });
        super.destroy();
    }

    public final synchronized boolean isCustomClickGestureEnabled() {
        return this.zzfwx.isCustomClickGestureEnabled();
    }

    public final synchronized void recordCustomClickGesture() {
        zzcep zzcep = this.zzfxf;
        if (zzcep == null) {
            zzbbd.zzef("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.zzfmk.execute(new Runnable(this, zzcep instanceof zzcdq) { // from class: com.google.android.gms.internal.ads.zzccs
                private final boolean zzegf;
                private final zzcco zzfww;

                {
                    this.zzfww = r1;
                    this.zzegf = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzfww.zzbj(this.zzegf);
                }
            });
        }
    }

    public final synchronized void setClickConfirmingView(View view) {
        this.zzfwx.setClickConfirmingView(view);
    }

    public final synchronized void zza(zzcep zzcep) {
        zzdw zzca;
        this.zzfxf = zzcep;
        this.zzfwy.zza(zzcep);
        this.zzfwx.zza(zzcep.zzahq(), zzcep.zzamp(), zzcep.zzamq(), zzcep, zzcep);
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcqn)).booleanValue() && (zzca = this.zzenn.zzca()) != null) {
            zzca.zzb(zzcep.zzahq());
        }
        if (zzcep.zzamt() != null) {
            zzcep.zzamt().zza(this.zzfpr);
        }
    }

    public final void zzaa(View view) {
        IObjectWrapper zzalu = this.zzfvt.zzalu();
        boolean z = this.zzfvt.zzalt() != null;
        if (this.zzfwz.zzalj() && zzalu != null && z && view != null) {
            zzp.zzle().zza(zzalu, view);
        }
    }

    public final void zzab(View view) {
        IObjectWrapper zzalu = this.zzfvt.zzalu();
        if (this.zzfwz.zzalj() && zzalu != null && view != null) {
            zzp.zzle().zzb(zzalu, view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    @AnyThread
    public final void zzahw() {
        this.zzfmk.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzccn
            private final zzcco zzfww;

            {
                this.zzfww = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfww.zzalm();
            }
        });
        if (this.zzfvt.zzaln() != 7) {
            Executor executor = this.zzfmk;
            zzcdd zzcdd = this.zzfwx;
            zzcdd.getClass();
            executor.execute(zzccq.zza(zzcdd));
        }
        super.zzahw();
    }

    public final synchronized void zzalc() {
        if (!this.zzfxg) {
            this.zzfwx.zzalc();
        }
    }

    public final boolean zzali() {
        return this.zzfwz.zzama();
    }

    public final boolean zzalj() {
        return this.zzfwz.zzalj();
    }

    public final zzccu zzalk() {
        return this.zzfxh;
    }

    public final /* synthetic */ void zzall() {
        this.zzfwx.destroy();
        this.zzfvt.destroy();
    }

    public final /* synthetic */ void zzalm() {
        try {
            int zzaln = this.zzfvt.zzaln();
            if (zzaln != 1) {
                if (zzaln != 2) {
                    if (zzaln != 3) {
                        if (zzaln != 6) {
                            if (zzaln != 7) {
                                zzbbd.zzfc("Wrong native template id!");
                            } else if (this.zzfod.zzamg() != null) {
                                this.zzfod.zzamg().zza(this.zzfxd.get());
                            }
                        } else if (this.zzfod.zzame() != null) {
                            zzh("Google", true);
                            this.zzfod.zzame().zza(this.zzfxc.get());
                        }
                    } else if (this.zzfod.zzgd(this.zzfvt.getCustomTemplateId()) != null) {
                        if (this.zzfvt.zzals() != null) {
                            zzh("Google", true);
                        }
                        this.zzfod.zzgd(this.zzfvt.getCustomTemplateId()).zza(this.zzfxe.get());
                    }
                } else if (this.zzfod.zzamd() != null) {
                    zzh("Google", true);
                    this.zzfod.zzamd().zza(this.zzfxb.get());
                }
            } else if (this.zzfod.zzamc() != null) {
                zzh("Google", true);
                this.zzfod.zzamc().zza(this.zzfxa.get());
            }
        } catch (RemoteException e) {
            zzbbd.zzc("RemoteException when notifyAdLoad is called", e);
        }
    }

    public final synchronized void zzb(zzcep zzcep) {
        this.zzfwx.zza(zzcep.zzahq(), zzcep.zzamo());
        if (zzcep.zzams() != null) {
            zzcep.zzams().setClickable(false);
            zzcep.zzams().removeAllViews();
        }
        if (zzcep.zzamt() != null) {
            zzcep.zzamt().zzb(this.zzfpr);
        }
        this.zzfxf = null;
    }

    public final /* synthetic */ void zzbj(boolean z) {
        this.zzfwx.zza(this.zzfxf.zzahq(), this.zzfxf.zzamo(), this.zzfxf.zzamp(), z);
    }

    public final synchronized void zzfz(String str) {
        this.zzfwx.zzfz(str);
    }

    public final synchronized void zzg(Bundle bundle) {
        this.zzfwx.zzg(bundle);
    }

    public final synchronized void zzh(Bundle bundle) {
        this.zzfwx.zzh(bundle);
    }

    public final synchronized boolean zzi(Bundle bundle) {
        if (this.zzfxg) {
            return true;
        }
        boolean zzi = this.zzfwx.zzi(bundle);
        this.zzfxg = zzi;
        return zzi;
    }

    public final synchronized void zzsr() {
        this.zzfwx.zzsr();
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(java.lang.String r11, boolean r12) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzccz r0 = r10.zzfwz
            boolean r0 = r0.zzalj()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            com.google.android.gms.internal.ads.zzccv r0 = r10.zzfvt
            com.google.android.gms.internal.ads.zzbfq r0 = r0.zzalt()
            com.google.android.gms.internal.ads.zzccv r1 = r10.zzfvt
            com.google.android.gms.internal.ads.zzbfq r1 = r1.zzals()
            if (r0 != 0) goto L_0x001a
            if (r1 != 0) goto L_0x001a
            return
        L_0x001a:
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0020
            r4 = 1
            goto L_0x0021
        L_0x0020:
            r4 = 0
        L_0x0021:
            if (r1 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r2 = 0
        L_0x0025:
            r3 = 0
            if (r4 == 0) goto L_0x002a
        L_0x0028:
            r8 = r3
            goto L_0x0032
        L_0x002a:
            if (r2 == 0) goto L_0x0030
            java.lang.String r3 = "javascript"
            r0 = r1
            goto L_0x0028
        L_0x0030:
            r0 = r3
            r8 = r0
        L_0x0032:
            android.webkit.WebView r3 = r0.getWebView()
            if (r3 != 0) goto L_0x0039
            return
        L_0x0039:
            com.google.android.gms.internal.ads.zzaqi r3 = com.google.android.gms.ads.internal.zzp.zzle()
            android.content.Context r4 = r10.zzvr
            boolean r3 = r3.zzp(r4)
            if (r3 == 0) goto L_0x0095
            com.google.android.gms.internal.ads.zzbbg r3 = r10.zzbpa
            int r4 = r3.zzedq
            int r3 = r3.zzedr
            r5 = 23
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r6.append(r4)
            java.lang.String r4 = "."
            r6.append(r4)
            r6.append(r3)
            java.lang.String r4 = r6.toString()
            com.google.android.gms.internal.ads.zzaqi r3 = com.google.android.gms.ads.internal.zzp.zzle()
            android.webkit.WebView r5 = r0.getWebView()
            java.lang.String r6 = ""
            java.lang.String r7 = "javascript"
            r9 = r11
            com.google.android.gms.dynamic.IObjectWrapper r11 = r3.zza(r4, r5, r6, r7, r8, r9)
            if (r11 != 0) goto L_0x0075
            return
        L_0x0075:
            com.google.android.gms.internal.ads.zzccv r3 = r10.zzfvt
            r3.zzas(r11)
            r0.zzap(r11)
            if (r2 == 0) goto L_0x008c
            android.view.View r0 = r1.getView()
            if (r0 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzaqi r1 = com.google.android.gms.ads.internal.zzp.zzle()
            r1.zza(r11, r0)
        L_0x008c:
            if (r12 == 0) goto L_0x0095
            com.google.android.gms.internal.ads.zzaqi r12 = com.google.android.gms.ads.internal.zzp.zzle()
            r12.zzab(r11)
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcco.zzh(java.lang.String, boolean):void");
    }

    public final synchronized void zzb(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzfxg) {
            if (z) {
                this.zzfwy.zzd(this.zzfxf);
                this.zzfwx.zza(view, map, map2);
                this.zzfxg = true;
                return;
            }
            if (!z) {
                if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcrv)).booleanValue() && map != null) {
                    for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                        View view2 = entry.getValue().get();
                        if (view2 != null && zzz(view2)) {
                            this.zzfwy.zzd(this.zzfxf);
                            this.zzfwx.zza(view, map, map2);
                            this.zzfxg = true;
                            return;
                        }
                    }
                }
            }
        }
    }

    public final synchronized void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        this.zzfwy.zzc(this.zzfxf);
        this.zzfwx.zza(view, view2, map, map2, z);
    }

    public final synchronized void zza(View view, MotionEvent motionEvent, View view2) {
        this.zzfwx.zza(view, motionEvent, view2);
    }

    public final synchronized void zza(zzafr zzafr) {
        this.zzfwx.zza(zzafr);
    }

    public final synchronized void zza(@Nullable zzxv zzxv) {
        this.zzfwx.zza(zzxv);
    }

    public final synchronized void zza(zzxr zzxr) {
        this.zzfwx.zza(zzxr);
    }

    public final synchronized void zza(zzya zzya) {
        this.zzftk.zzb(zzya);
    }
}
