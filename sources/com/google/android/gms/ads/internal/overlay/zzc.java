package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaat;
import com.google.android.gms.internal.ads.zzagl;
import com.google.android.gms.internal.ads.zzagn;
import com.google.android.gms.internal.ads.zzaqg;
import com.google.android.gms.internal.ads.zzaqk;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzaym;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbg;
import com.google.android.gms.internal.ads.zzbfq;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhf;
import com.google.android.gms.internal.ads.zzbhj;
import com.google.android.gms.internal.ads.zzdsf;
import com.google.android.gms.internal.ads.zzto;
import com.google.android.gms.internal.ads.zzut;
import com.google.android.gms.internal.ads.zzwe;
import com.sumsub.sns.R2;
import java.util.Collections;
public class zzc extends zzaqk implements zzy {
    @VisibleForTesting
    private static final int zzdnn = Color.argb(0, 0, 0, 0);
    public final Activity zzaas;
    @VisibleForTesting
    private boolean zzbor = false;
    @VisibleForTesting
    public zzbfq zzdgc;
    @VisibleForTesting
    public AdOverlayInfoParcel zzdno;
    @VisibleForTesting
    private zzi zzdnp;
    @VisibleForTesting
    private zzq zzdnq;
    @VisibleForTesting
    private boolean zzdnr = false;
    @VisibleForTesting
    private FrameLayout zzdns;
    @VisibleForTesting
    private WebChromeClient.CustomViewCallback zzdnt;
    @VisibleForTesting
    private boolean zzdnu = false;
    @VisibleForTesting
    private zzj zzdnv;
    @VisibleForTesting
    private boolean zzdnw = false;
    @VisibleForTesting
    public int zzdnx = 0;
    private final Object zzdny = new Object();
    private Runnable zzdnz;
    private boolean zzdoa;
    private boolean zzdob;
    private boolean zzdoc = false;
    private boolean zzdod = false;
    private boolean zzdoe = true;

    public zzc(Activity activity) {
        this.zzaas = activity;
    }

    private final void zzai(boolean z) {
        int intValue = ((Integer) zzwe.zzpu().zzd(zzaat.zzctj)).intValue();
        zzp zzp = new zzp();
        zzp.size = 50;
        zzp.paddingLeft = z ? intValue : 0;
        zzp.paddingRight = z ? 0 : intValue;
        zzp.paddingTop = 0;
        zzp.paddingBottom = intValue;
        this.zzdnq = new zzq(this.zzaas, zzp, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.zzdno.zzdot);
        this.zzdnv.addView(this.zzdnq, layoutParams);
    }

    private final void zzaj(boolean z) throws zzg {
        if (!this.zzdob) {
            this.zzaas.requestWindowFeature(1);
        }
        Window window = this.zzaas.getWindow();
        if (window != null) {
            zzbfq zzbfq = this.zzdno.zzdgc;
            zzbhc zzabe = zzbfq != null ? zzbfq.zzabe() : null;
            boolean z2 = false;
            boolean z3 = zzabe != null && zzabe.zzabx();
            this.zzdnw = false;
            if (z3) {
                int i = this.zzdno.orientation;
                zzp.zzkr();
                if (i == 6) {
                    if (this.zzaas.getResources().getConfiguration().orientation == 1) {
                        z2 = true;
                    }
                    this.zzdnw = z2;
                } else {
                    int i2 = this.zzdno.orientation;
                    zzp.zzkr();
                    if (i2 == 7) {
                        if (this.zzaas.getResources().getConfiguration().orientation == 2) {
                            z2 = true;
                        }
                        this.zzdnw = z2;
                    }
                }
            }
            boolean z4 = this.zzdnw;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Delay onShow to next orientation change: ");
            sb.append(z4);
            zzbbd.zzef(sb.toString());
            setRequestedOrientation(this.zzdno.orientation);
            zzp.zzkr();
            window.setFlags(16777216, 16777216);
            zzbbd.zzef("Hardware acceleration on the AdActivity window enabled.");
            if (!this.zzbor) {
                this.zzdnv.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            } else {
                this.zzdnv.setBackgroundColor(zzdnn);
            }
            this.zzaas.setContentView(this.zzdnv);
            this.zzdob = true;
            if (z) {
                try {
                    zzp.zzkq();
                    Activity activity = this.zzaas;
                    zzbfq zzbfq2 = this.zzdno.zzdgc;
                    zzbhj zzabc = zzbfq2 != null ? zzbfq2.zzabc() : null;
                    zzbfq zzbfq3 = this.zzdno.zzdgc;
                    String zzabd = zzbfq3 != null ? zzbfq3.zzabd() : null;
                    AdOverlayInfoParcel adOverlayInfoParcel = this.zzdno;
                    zzbbg zzbbg = adOverlayInfoParcel.zzbpa;
                    zzbfq zzbfq4 = adOverlayInfoParcel.zzdgc;
                    zzbfq zza = zzbfy.zza(activity, zzabc, zzabd, true, z3, null, null, zzbbg, null, null, zzbfq4 != null ? zzbfq4.zzzr() : null, zzto.zzmy(), null, false);
                    this.zzdgc = zza;
                    zzbhc zzabe2 = zza.zzabe();
                    AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdno;
                    zzagl zzagl = adOverlayInfoParcel2.zzddv;
                    zzagn zzagn = adOverlayInfoParcel2.zzddw;
                    zzt zzt = adOverlayInfoParcel2.zzdov;
                    zzbfq zzbfq5 = adOverlayInfoParcel2.zzdgc;
                    zzabe2.zza(null, zzagl, null, zzagn, zzt, true, null, zzbfq5 != null ? zzbfq5.zzabe().zzabw() : null, null, null);
                    this.zzdgc.zzabe().zza(new zzbhf(this) { // from class: com.google.android.gms.ads.internal.overlay.zzf
                        private final zzc zzdoj;

                        {
                            this.zzdoj = r1;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbhf
                        public final void zzak(boolean z5) {
                            zzbfq zzbfq6 = this.zzdoj.zzdgc;
                            if (zzbfq6 != null) {
                                zzbfq6.zzuv();
                            }
                        }
                    });
                    AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzdno;
                    String str = adOverlayInfoParcel3.url;
                    if (str != null) {
                        this.zzdgc.loadUrl(str);
                    } else {
                        String str2 = adOverlayInfoParcel3.zzdou;
                        if (str2 != null) {
                            this.zzdgc.loadDataWithBaseURL(adOverlayInfoParcel3.zzdos, str2, "text/html", "UTF-8", null);
                        } else {
                            throw new zzg("No URL or HTML to display in ad overlay.");
                        }
                    }
                    zzbfq zzbfq6 = this.zzdno.zzdgc;
                    if (zzbfq6 != null) {
                        zzbfq6.zzb(this);
                    }
                } catch (Exception e) {
                    zzbbd.zzc("Error obtaining webview.", e);
                    throw new zzg("Could not obtain webview for the overlay.");
                }
            } else {
                zzbfq zzbfq7 = this.zzdno.zzdgc;
                this.zzdgc = zzbfq7;
                zzbfq7.zzbv(this.zzaas);
            }
            this.zzdgc.zza(this);
            zzbfq zzbfq8 = this.zzdno.zzdgc;
            if (zzbfq8 != null) {
                zzc(zzbfq8.zzabi(), this.zzdnv);
            }
            ViewParent parent = this.zzdgc.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.zzdgc.getView());
            }
            if (this.zzbor) {
                this.zzdgc.zzabq();
            }
            zzbfq zzbfq9 = this.zzdgc;
            Activity activity2 = this.zzaas;
            AdOverlayInfoParcel adOverlayInfoParcel4 = this.zzdno;
            zzbfq9.zza((ViewGroup) null, activity2, adOverlayInfoParcel4.zzdos, adOverlayInfoParcel4.zzdou);
            this.zzdnv.addView(this.zzdgc.getView(), -1, -1);
            if (!z && !this.zzdnw) {
                zzuv();
            }
            zzai(z3);
            if (this.zzdgc.zzabg()) {
                zza(z3, true);
                return;
            }
            return;
        }
        throw new zzg("Invalid activity, no window available.");
    }

    private static void zzc(@Nullable IObjectWrapper iObjectWrapper, @Nullable View view) {
        if (iObjectWrapper != null && view != null) {
            zzp.zzle().zza(iObjectWrapper, view);
        }
    }

    private final void zzus() {
        if (this.zzaas.isFinishing() && !this.zzdoc) {
            this.zzdoc = true;
            zzbfq zzbfq = this.zzdgc;
            if (zzbfq != null) {
                zzbfq.zzdu(this.zzdnx);
                synchronized (this.zzdny) {
                    if (!this.zzdoa && this.zzdgc.zzabm()) {
                        zze zze = new Runnable(this) { // from class: com.google.android.gms.ads.internal.overlay.zze
                            private final zzc zzdoj;

                            {
                                this.zzdoj = r1;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zzdoj.zzut();
                            }
                        };
                        this.zzdnz = zze;
                        zzayh.zzeaj.postDelayed(zze, ((Long) zzwe.zzpu().zzd(zzaat.zzcoj)).longValue());
                        return;
                    }
                }
            }
            zzut();
        }
    }

    private final void zzuv() {
        this.zzdgc.zzuv();
    }

    public final void close() {
        this.zzdnx = 2;
        this.zzaas.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onBackPressed() {
        this.zzdnx = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public void onCreate(Bundle bundle) {
        zzut zzut;
        this.zzaas.requestWindowFeature(1);
        this.zzdnu = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            AdOverlayInfoParcel zzc = AdOverlayInfoParcel.zzc(this.zzaas.getIntent());
            this.zzdno = zzc;
            if (zzc != null) {
                if (zzc.zzbpa.zzedr > 7500000) {
                    this.zzdnx = 3;
                }
                if (this.zzaas.getIntent() != null) {
                    this.zzdoe = this.zzaas.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
                }
                zzi zzi = this.zzdno.zzdoy;
                if (zzi != null) {
                    this.zzbor = zzi.zzbor;
                } else {
                    this.zzbor = false;
                }
                if (this.zzbor && zzi.zzbow != -1) {
                    new zzl(this).zzwv();
                }
                if (bundle == null) {
                    zzo zzo = this.zzdno.zzdor;
                    if (zzo != null && this.zzdoe) {
                        zzo.zzuj();
                    }
                    AdOverlayInfoParcel adOverlayInfoParcel = this.zzdno;
                    if (!(adOverlayInfoParcel.zzdow == 1 || (zzut = adOverlayInfoParcel.zzcgq) == null)) {
                        zzut.onAdClicked();
                    }
                }
                Activity activity = this.zzaas;
                AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdno;
                zzj zzj = new zzj(activity, adOverlayInfoParcel2.zzdox, adOverlayInfoParcel2.zzbpa.zzbra);
                this.zzdnv = zzj;
                zzj.setId(1000);
                zzp.zzkr().zzg(this.zzaas);
                AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzdno;
                int i = adOverlayInfoParcel3.zzdow;
                if (i == 1) {
                    zzaj(false);
                } else if (i == 2) {
                    this.zzdnp = new zzi(adOverlayInfoParcel3.zzdgc);
                    zzaj(false);
                } else if (i == 3) {
                    zzaj(true);
                } else {
                    throw new zzg("Could not determine ad overlay type.");
                }
            } else {
                throw new zzg("Could not get info for ad overlay.");
            }
        } catch (zzg e) {
            zzbbd.zzfe(e.getMessage());
            this.zzdnx = 3;
            this.zzaas.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onDestroy() {
        zzbfq zzbfq = this.zzdgc;
        if (zzbfq != null) {
            try {
                this.zzdnv.removeView(zzbfq.getView());
            } catch (NullPointerException unused) {
            }
        }
        zzus();
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onPause() {
        zzuo();
        zzo zzo = this.zzdno.zzdor;
        if (zzo != null) {
            zzo.onPause();
        }
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcth)).booleanValue() && this.zzdgc != null && (!this.zzaas.isFinishing() || this.zzdnp == null)) {
            zzp.zzkr();
            zzaym.zza(this.zzdgc);
        }
        zzus();
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onRestart() {
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onResume() {
        zzo zzo = this.zzdno.zzdor;
        if (zzo != null) {
            zzo.onResume();
        }
        zza(this.zzaas.getResources().getConfiguration());
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcth)).booleanValue()) {
            zzbfq zzbfq = this.zzdgc;
            if (zzbfq == null || zzbfq.isDestroyed()) {
                zzbbd.zzfe("The webview does not exist. Ignoring action.");
                return;
            }
            zzp.zzkr();
            zzaym.zzb(this.zzdgc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdnu);
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onStart() {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcth)).booleanValue()) {
            zzbfq zzbfq = this.zzdgc;
            if (zzbfq == null || zzbfq.isDestroyed()) {
                zzbbd.zzfe("The webview does not exist. Ignoring action.");
                return;
            }
            zzp.zzkr();
            zzaym.zzb(this.zzdgc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void onStop() {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcth)).booleanValue() && this.zzdgc != null && (!this.zzaas.isFinishing() || this.zzdnp == null)) {
            zzp.zzkr();
            zzaym.zza(this.zzdgc);
        }
        zzus();
    }

    public final void setRequestedOrientation(int i) {
        if (this.zzaas.getApplicationInfo().targetSdkVersion >= ((Integer) zzwe.zzpu().zzd(zzaat.zzcvl)).intValue()) {
            if (this.zzaas.getApplicationInfo().targetSdkVersion <= ((Integer) zzwe.zzpu().zzd(zzaat.zzcvm)).intValue()) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= ((Integer) zzwe.zzpu().zzd(zzaat.zzcvn)).intValue()) {
                    if (i2 <= ((Integer) zzwe.zzpu().zzd(zzaat.zzcvo)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzaas.setRequestedOrientation(i);
        } catch (Throwable th) {
            zzp.zzkt().zzb(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zza(boolean z, boolean z2) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzi zzi;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        zzi zzi2;
        boolean z3 = true;
        boolean z4 = ((Boolean) zzwe.zzpu().zzd(zzaat.zzcok)).booleanValue() && (adOverlayInfoParcel2 = this.zzdno) != null && (zzi2 = adOverlayInfoParcel2.zzdoy) != null && zzi2.zzboy;
        boolean z5 = ((Boolean) zzwe.zzpu().zzd(zzaat.zzcol)).booleanValue() && (adOverlayInfoParcel = this.zzdno) != null && (zzi = adOverlayInfoParcel.zzdoy) != null && zzi.zzboz;
        if (z && z2 && z4 && !z5) {
            new zzaqg(this.zzdgc, "useCustomClose").zzdx("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzq zzq = this.zzdnq;
        if (zzq != null) {
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            zzq.zzal(z3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void zzad(IObjectWrapper iObjectWrapper) {
        zza((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final void zzdo() {
        this.zzdob = true;
    }

    public final void zzuo() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdno;
        if (adOverlayInfoParcel != null && this.zzdnr) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.zzdns != null) {
            this.zzaas.setContentView(this.zzdnv);
            this.zzdob = true;
            this.zzdns.removeAllViews();
            this.zzdns = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzdnt;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzdnt = null;
        }
        this.zzdnr = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final void zzup() {
        this.zzdnx = 1;
        this.zzaas.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzaql
    public final boolean zzuq() {
        this.zzdnx = 0;
        zzbfq zzbfq = this.zzdgc;
        if (zzbfq == null) {
            return true;
        }
        boolean zzabl = zzbfq.zzabl();
        if (!zzabl) {
            this.zzdgc.zza("onbackblocked", Collections.emptyMap());
        }
        return zzabl;
    }

    public final void zzur() {
        this.zzdnv.removeView(this.zzdnq);
        zzai(true);
    }

    @VisibleForTesting
    public final void zzut() {
        zzbfq zzbfq;
        zzo zzo;
        if (!this.zzdod) {
            this.zzdod = true;
            zzbfq zzbfq2 = this.zzdgc;
            if (zzbfq2 != null) {
                this.zzdnv.removeView(zzbfq2.getView());
                zzi zzi = this.zzdnp;
                if (zzi != null) {
                    this.zzdgc.zzbv(zzi.zzvr);
                    this.zzdgc.zzax(false);
                    ViewGroup viewGroup = this.zzdnp.parent;
                    View view = this.zzdgc.getView();
                    zzi zzi2 = this.zzdnp;
                    viewGroup.addView(view, zzi2.index, zzi2.zzdok);
                    this.zzdnp = null;
                } else if (this.zzaas.getApplicationContext() != null) {
                    this.zzdgc.zzbv(this.zzaas.getApplicationContext());
                }
                this.zzdgc = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzdno;
            if (!(adOverlayInfoParcel == null || (zzo = adOverlayInfoParcel.zzdor) == null)) {
                zzo.zzui();
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdno;
            if (adOverlayInfoParcel2 != null && (zzbfq = adOverlayInfoParcel2.zzdgc) != null) {
                zzc(zzbfq.zzabi(), this.zzdno.zzdgc.getView());
            }
        }
    }

    public final void zzuu() {
        if (this.zzdnw) {
            this.zzdnw = false;
            zzuv();
        }
    }

    public final void zzuw() {
        this.zzdnv.zzdom = true;
    }

    public final void zzux() {
        synchronized (this.zzdny) {
            this.zzdoa = true;
            Runnable runnable = this.zzdnz;
            if (runnable != null) {
                zzdsf zzdsf = zzayh.zzeaj;
                zzdsf.removeCallbacks(runnable);
                zzdsf.post(this.zzdnz);
            }
        }
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.zzaas);
        this.zzdns = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzdns.addView(view, -1, -1);
        this.zzaas.setContentView(this.zzdns);
        this.zzdob = true;
        this.zzdnt = customViewCallback;
        this.zzdnr = true;
    }

    private final void zza(Configuration configuration) {
        zzi zzi;
        zzi zzi2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdno;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = (adOverlayInfoParcel == null || (zzi2 = adOverlayInfoParcel.zzdoy) == null || !zzi2.zzbos) ? false : true;
        boolean zza = zzp.zzkr().zza(this.zzaas, configuration);
        if ((!this.zzbor || z3) && !zza) {
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdno;
            if (!(adOverlayInfoParcel2 == null || (zzi = adOverlayInfoParcel2.zzdoy) == null || !zzi.zzbox)) {
                z2 = true;
            }
        } else {
            z = false;
        }
        Window window = this.zzaas.getWindow();
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcom)).booleanValue()) {
            View decorView = window.getDecorView();
            int i = 256;
            if (z) {
                i = R2.styleable.StateListDrawable_android_variablePadding;
                if (z2) {
                    i = 5894;
                }
            }
            decorView.setSystemUiVisibility(i);
        } else if (z) {
            window.addFlags(1024);
            window.clearFlags(2048);
            if (z2) {
                window.getDecorView().setSystemUiVisibility(4098);
            }
        } else {
            window.addFlags(2048);
            window.clearFlags(1024);
        }
    }
}
