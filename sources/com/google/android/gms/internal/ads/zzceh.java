package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.messaging.Constants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
public final class zzceh {
    private final zzchc zzfzs;
    private final zzcih zzfzy;
    private ViewTreeObserver.OnScrollChangedListener zzgab = null;

    public zzceh(zzcih zzcih, zzchc zzchc) {
        this.zzfzy = zzcih;
        this.zzfzs = zzchc;
    }

    public final View zza(@NonNull View view, @NonNull WindowManager windowManager) throws zzbgc {
        zzbfq zza = this.zzfzy.zza(zzvj.zzpi(), false);
        zza.getView().setVisibility(4);
        zza.getView().setContentDescription("policy_validator");
        zza.zza("/sendMessageToSdk", new zzahf(this) { // from class: com.google.android.gms.internal.ads.zzcek
            private final zzceh zzgae;

            {
                this.zzgae = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzahf
            public final void zza(Object obj, Map map) {
                this.zzgae.zze((zzbfq) obj, map);
            }
        });
        zza.zza("/hideValidatorOverlay", new zzahf(this, windowManager, view) { // from class: com.google.android.gms.internal.ads.zzcej
            private final zzceh zzgae;
            private final WindowManager zzgaf;
            private final View zzgag;

            {
                this.zzgae = r1;
                this.zzgaf = r2;
                this.zzgag = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzahf
            public final void zza(Object obj, Map map) {
                this.zzgae.zza(this.zzgaf, this.zzgag, (zzbfq) obj, map);
            }
        });
        zza.zza("/open", new zzahj(null, null));
        this.zzfzs.zza(new WeakReference(zza), "/loadNativeAdPolicyViolations", new zzahf(this, view, windowManager) { // from class: com.google.android.gms.internal.ads.zzcem
            private final zzceh zzgae;
            private final View zzgah;
            private final WindowManager zzgai;

            {
                this.zzgae = r1;
                this.zzgah = r2;
                this.zzgai = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzahf
            public final void zza(Object obj, Map map) {
                this.zzgae.zza(this.zzgah, this.zzgai, (zzbfq) obj, map);
            }
        });
        this.zzfzs.zza(new WeakReference(zza), "/showValidatorOverlay", zzcel.zzdeq);
        return zza.getView();
    }

    public final /* synthetic */ void zzb(Map map, boolean z) {
        HashMap k0 = a.k0(Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, "validatorHtmlLoaded");
        k0.put("id", (String) map.get("id"));
        this.zzfzs.zza("sendMessageToNativeJs", k0);
    }

    public final /* synthetic */ void zze(zzbfq zzbfq, Map map) {
        this.zzfzs.zza("sendMessageToNativeJs", map);
    }

    private static int zza(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        zzwe.zzpq();
        return zzbat.zzc(context, i);
    }

    public final /* synthetic */ void zza(View view, WindowManager windowManager, zzbfq zzbfq, Map map) {
        int i;
        zzbfq.zzabe().zza(new zzbhf(this, map) { // from class: com.google.android.gms.internal.ads.zzcen
            private final Map zzedp;
            private final zzceh zzgae;

            {
                this.zzgae = r1;
                this.zzedp = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzbhf
            public final void zzak(boolean z) {
                this.zzgae.zzb(this.zzedp, z);
            }
        });
        if (map != null) {
            Context context = view.getContext();
            int zza = zza(context, (String) map.get("validator_width"), ((Integer) zzwe.zzpu().zzd(zzaat.zzcxl)).intValue());
            int zza2 = zza(context, (String) map.get("validator_height"), ((Integer) zzwe.zzpu().zzd(zzaat.zzcxm)).intValue());
            int zza3 = zza(context, (String) map.get("validator_x"), 0);
            int zza4 = zza(context, (String) map.get("validator_y"), 0);
            zzbfq.zza(zzbhj.zzq(zza, zza2));
            try {
                zzbfq.getWebView().getSettings().setUseWideViewPort(((Boolean) zzwe.zzpu().zzd(zzaat.zzcxn)).booleanValue());
                zzbfq.getWebView().getSettings().setLoadWithOverviewMode(((Boolean) zzwe.zzpu().zzd(zzaat.zzcxo)).booleanValue());
            } catch (NullPointerException unused) {
            }
            WindowManager.LayoutParams zzyg = zzbah.zzyg();
            zzyg.x = zza3;
            zzyg.y = zza4;
            windowManager.updateViewLayout(zzbfq.getView(), zzyg);
            String str = (String) map.get("orientation");
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                if ("1".equals(str) || ExifInterface.GPS_MEASUREMENT_2D.equals(str)) {
                    i = rect.bottom;
                } else {
                    i = rect.top;
                }
                this.zzgab = new ViewTreeObserver.OnScrollChangedListener(view, zzbfq, str, zzyg, i - zza4, windowManager) { // from class: com.google.android.gms.internal.ads.zzceo
                    private final String zzdin;
                    private final View zzgaj;
                    private final zzbfq zzgak;
                    private final WindowManager.LayoutParams zzgal;
                    private final int zzgam;
                    private final WindowManager zzgan;

                    {
                        this.zzgaj = r1;
                        this.zzgak = r2;
                        this.zzdin = r3;
                        this.zzgal = r4;
                        this.zzgam = r5;
                        this.zzgan = r6;
                    }

                    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                    public final void onScrollChanged() {
                        View view2 = this.zzgaj;
                        zzbfq zzbfq2 = this.zzgak;
                        String str2 = this.zzdin;
                        WindowManager.LayoutParams layoutParams = this.zzgal;
                        int i2 = this.zzgam;
                        WindowManager windowManager2 = this.zzgan;
                        Rect rect2 = new Rect();
                        if (view2.getGlobalVisibleRect(rect2) && zzbfq2.getView().getWindowToken() != null) {
                            if ("1".equals(str2) || ExifInterface.GPS_MEASUREMENT_2D.equals(str2)) {
                                layoutParams.y = rect2.bottom - i2;
                            } else {
                                layoutParams.y = rect2.top - i2;
                            }
                            windowManager2.updateViewLayout(zzbfq2.getView(), layoutParams);
                        }
                    }
                };
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnScrollChangedListener(this.zzgab);
                }
            }
            String str2 = (String) map.get("overlay_url");
            if (!TextUtils.isEmpty(str2)) {
                zzbfq.loadUrl(str2);
            }
        }
    }

    public final /* synthetic */ void zza(WindowManager windowManager, View view, zzbfq zzbfq, Map map) {
        zzbbd.zzef("Hide native ad policy validator overlay.");
        zzbfq.getView().setVisibility(8);
        if (zzbfq.getView().getWindowToken() != null) {
            windowManager.removeView(zzbfq.getView());
        }
        zzbfq.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzgab != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.zzgab);
        }
    }
}
