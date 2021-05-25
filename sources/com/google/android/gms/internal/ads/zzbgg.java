package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.avito.android.search.map.view.PanelStateKt;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zztq;
import com.google.android.gms.internal.ads.zztw;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;
@VisibleForTesting
@ParametersAreNonnullByDefault
public final class zzbgg extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzbfq {
    private int maxHeight = -1;
    private int maxWidth = -1;
    @GuardedBy("this")
    private String zzacx;
    private final zzbbg zzbpa;
    private final WindowManager zzbrf;
    private int zzdng = -1;
    private int zzdnh = -1;
    @GuardedBy("this")
    private boolean zzdot;
    @GuardedBy("this")
    private String zzdqg = "";
    @GuardedBy("this")
    private Boolean zzdya;
    private zzabi zzeif;
    private final zzto zzelx;
    private final zzbhg zzenm;
    @Nullable
    private final zzeg zzenn;
    @Nullable
    private final zzabt zzeno;
    private final zzk zzenp;
    private final zzb zzenq;
    private final float zzenr;
    @Nullable
    private final zzsq zzens;
    private final boolean zzent;
    private boolean zzenu = false;
    private boolean zzenv = false;
    private zzbft zzenw;
    @GuardedBy("this")
    private zzc zzenx;
    @GuardedBy("this")
    private IObjectWrapper zzeny;
    @GuardedBy("this")
    private zzbhj zzenz;
    @GuardedBy("this")
    private boolean zzeoa;
    @GuardedBy("this")
    private boolean zzeob;
    @GuardedBy("this")
    private boolean zzeoc;
    @GuardedBy("this")
    private int zzeod;
    @GuardedBy("this")
    private boolean zzeoe = true;
    @GuardedBy("this")
    private boolean zzeof = false;
    @GuardedBy("this")
    private zzbgk zzeog;
    @GuardedBy("this")
    private boolean zzeoh;
    @GuardedBy("this")
    private boolean zzeoi;
    @GuardedBy("this")
    private zzadk zzeoj;
    @GuardedBy("this")
    private zzadf zzeok;
    @GuardedBy("this")
    private zzsc zzeol;
    @GuardedBy("this")
    private int zzeom;
    @GuardedBy("this")
    private int zzeon;
    private zzabi zzeoo;
    private zzabi zzeop;
    private zzabh zzeoq;
    private WeakReference<View.OnClickListener> zzeor;
    @GuardedBy("this")
    private zzc zzeos;
    @GuardedBy("this")
    private boolean zzeot;
    private zzbaq zzeou;
    private Map<String, zzbev> zzeov;
    private final DisplayMetrics zzxd;

    @VisibleForTesting
    private zzbgg(zzbhg zzbhg, zzbhj zzbhj, String str, boolean z, boolean z2, @Nullable zzeg zzeg, @Nullable zzabt zzabt, zzbbg zzbbg, zzabk zzabk, zzk zzk, zzb zzb, zzto zzto, zzsq zzsq, boolean z3) {
        super(zzbhg);
        this.zzenm = zzbhg;
        this.zzenz = zzbhj;
        this.zzacx = str;
        this.zzeob = z;
        this.zzeod = -1;
        this.zzenn = zzeg;
        this.zzeno = zzabt;
        this.zzbpa = zzbbg;
        this.zzenp = zzk;
        this.zzenq = zzb;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.zzbrf = windowManager;
        zzp.zzkp();
        DisplayMetrics zza = zzayh.zza(windowManager);
        this.zzxd = zza;
        this.zzenr = zza.density;
        this.zzelx = zzto;
        this.zzens = zzsq;
        this.zzent = z3;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzbbd.zzc("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setMixedContentMode(2);
        zzp.zzkp().zza(zzbhg, zzbbg.zzbra, settings);
        zzp.zzkr().zza(getContext(), settings);
        setDownloadListener(this);
        zzacn();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(zzbgp.zzc(this), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.zzeou = new zzbaq(this.zzenm.zzzq(), this, this, null);
        zzacr();
        zzabh zzabh = new zzabh(new zzabk(true, "make_wv", this.zzacx));
        this.zzeoq = zzabh;
        zzabh.zzrm().zzc(zzabk);
        zzabi zzb2 = zzabb.zzb(this.zzeoq.zzrm());
        this.zzeif = zzb2;
        this.zzeoq.zza("native:view_create", zzb2);
        this.zzeop = null;
        this.zzeoo = null;
        zzp.zzkr().zzbf(zzbhg);
        zzp.zzkt().zzwg();
    }

    private final boolean zzack() {
        int i;
        int i2;
        boolean z = false;
        if (!this.zzenw.zzabx() && !this.zzenw.zzaby()) {
            return false;
        }
        zzwe.zzpq();
        DisplayMetrics displayMetrics = this.zzxd;
        int zzb = zzbat.zzb(displayMetrics, displayMetrics.widthPixels);
        zzwe.zzpq();
        DisplayMetrics displayMetrics2 = this.zzxd;
        int zzb2 = zzbat.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzzq = this.zzenm.zzzq();
        if (zzzq == null || zzzq.getWindow() == null) {
            i2 = zzb;
            i = zzb2;
        } else {
            zzp.zzkp();
            int[] zzd = zzayh.zzd(zzzq);
            zzwe.zzpq();
            int zzb3 = zzbat.zzb(this.zzxd, zzd[0]);
            zzwe.zzpq();
            i = zzbat.zzb(this.zzxd, zzd[1]);
            i2 = zzb3;
        }
        int i3 = this.zzdng;
        if (i3 == zzb && this.zzdnh == zzb2 && this.maxWidth == i2 && this.maxHeight == i) {
            return false;
        }
        if (!(i3 == zzb && this.zzdnh == zzb2)) {
            z = true;
        }
        this.zzdng = zzb;
        this.zzdnh = zzb2;
        this.maxWidth = i2;
        this.maxHeight = i;
        new zzaqg(this).zza(zzb, zzb2, i2, i, this.zzxd.density, this.zzbrf.getDefaultDisplay().getRotation());
        return z;
    }

    private final synchronized void zzacl() {
        Boolean zzwe = zzp.zzkt().zzwe();
        this.zzdya = zzwe;
        if (zzwe == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zza(Boolean.TRUE);
            } catch (IllegalStateException unused) {
                zza(Boolean.FALSE);
            }
        }
    }

    private final void zzacm() {
        zzabb.zza(this.zzeoq.zzrm(), this.zzeif, "aeh2");
    }

    private final synchronized void zzacn() {
        if (!this.zzeob) {
            if (!this.zzenz.zzacx()) {
                zzbbd.zzef("Enabling hardware acceleration on an AdView.");
                zzacp();
                return;
            }
        }
        zzbbd.zzef("Enabling hardware acceleration on an overlay.");
        zzacp();
    }

    private final synchronized void zzaco() {
        if (!this.zzeoc) {
            zzp.zzkr();
            setLayerType(1, null);
        }
        this.zzeoc = true;
    }

    private final synchronized void zzacp() {
        if (this.zzeoc) {
            zzp.zzkr();
            setLayerType(0, null);
        }
        this.zzeoc = false;
    }

    private final synchronized void zzacq() {
        Map<String, zzbev> map = this.zzeov;
        if (map != null) {
            for (zzbev zzbev : map.values()) {
                zzbev.release();
            }
        }
        this.zzeov = null;
    }

    private final void zzacr() {
        zzabk zzrm;
        zzabh zzabh = this.zzeoq;
        if (zzabh != null && (zzrm = zzabh.zzrm()) != null && zzp.zzkt().zzwd() != null) {
            zzp.zzkt().zzwd().zza(zzrm);
        }
    }

    public static zzbgg zzb(Context context, zzbhj zzbhj, String str, boolean z, boolean z2, @Nullable zzeg zzeg, @Nullable zzabt zzabt, zzbbg zzbbg, zzabk zzabk, zzk zzk, zzb zzb, zzto zzto, zzsq zzsq, boolean z3) {
        return new zzbgg(new zzbhg(context), zzbhj, str, z, z2, zzeg, zzabt, zzbbg, zzabk, zzk, zzb, zzto, zzsq, z3);
    }

    private final void zzbd(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", hashMap);
    }

    private final synchronized void zzfr(String str) {
        if (!isDestroyed()) {
            loadUrl(str);
        } else {
            zzbbd.zzfe("#004 The webview is destroyed. Ignoring action.");
        }
    }

    private final synchronized void zzfs(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e) {
            zzp.zzkt().zza(e, "AdWebViewImpl.loadUrlUnsafe");
            zzbbd.zzd("Could not call loadUrl. ", e);
        }
    }

    private final void zzft(String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            if (zzwe() == null) {
                zzacl();
            }
            if (zzwe().booleanValue()) {
                zza(str, (ValueCallback<String>) null);
                return;
            }
            String valueOf = String.valueOf(str);
            zzfr(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        String valueOf2 = String.valueOf(str);
        zzfr(valueOf2.length() != 0 ? "javascript:".concat(valueOf2) : new String("javascript:"));
    }

    @VisibleForTesting
    private final synchronized Boolean zzwe() {
        return this.zzdya;
    }

    private final synchronized void zzwh() {
        if (!this.zzeot) {
            this.zzeot = true;
            zzp.zzkt().zzwh();
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbfq
    public final synchronized void destroy() {
        zzacr();
        this.zzeou.zzyj();
        zzc zzc = this.zzenx;
        if (zzc != null) {
            zzc.close();
            this.zzenx.onDestroy();
            this.zzenx = null;
        }
        this.zzeny = null;
        this.zzenw.reset();
        if (!this.zzeoa) {
            zzp.zzll();
            zzbes.zzc(this);
            zzacq();
            this.zzeoa = true;
            zzaxy.zzei("Initiating WebView self destruct sequence in 3...");
            zzaxy.zzei("Loading blank page in WebView, 2...");
            zzfs("about:blank");
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public final synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (isDestroyed()) {
            zzbbd.zzfg("#004 The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    @Override // java.lang.Object
    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.zzeoa) {
                    this.zzenw.reset();
                    zzp.zzll();
                    zzbes.zzc(this);
                    zzacq();
                    zzwh();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbde
    public final synchronized String getRequestId() {
        return this.zzdqg;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq, com.google.android.gms.internal.ads.zzbhd
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized boolean isDestroyed() {
        return this.zzeoa;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbfq
    public final synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzbbd.zzfe("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbfq
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzbbd.zzfe("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbfq
    public final synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            try {
                super.loadUrl(str);
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                zzp.zzkt().zza(e, "AdWebViewImpl.loadUrl");
                zzbbd.zzd("Could not call loadUrl. ", e);
            }
        } else {
            zzbbd.zzfe("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, android.view.View, android.view.ViewGroup
    public final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.zzeou.onAttachedToWindow();
        }
        boolean z = this.zzeoh;
        zzbft zzbft = this.zzenw;
        if (zzbft != null && zzbft.zzaby()) {
            if (!this.zzeoi) {
                this.zzenw.zzaca();
                this.zzenw.zzacb();
                this.zzeoi = true;
            }
            zzack();
            z = true;
        }
        zzbd(z);
    }

    @Override // android.view.View, android.view.ViewGroup
    public final void onDetachedFromWindow() {
        zzbft zzbft;
        synchronized (this) {
            if (!isDestroyed()) {
                this.zzeou.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzeoi && (zzbft = this.zzenw) != null && zzbft.zzaby() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzenw.zzaca();
                this.zzenw.zzacb();
                this.zzeoi = false;
            }
        }
        zzbd(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzp.zzkp();
            zzayh.zza(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str4).length() + String.valueOf(str).length() + 51);
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzbbd.zzef(sb.toString());
        }
    }

    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (Build.VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zzack = zzack();
        zzc zzaba = zzaba();
        if (zzaba != null && zzack) {
            zzaba.zzuu();
        }
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @SuppressLint({"DrawAllocation"})
    public final synchronized void onMeasure(int i, int i2) {
        int i3;
        if (isDestroyed()) {
            setMeasuredDimension(0, 0);
        } else if (isInEditMode() || this.zzeob || this.zzenz.zzacy()) {
            super.onMeasure(i, i2);
        } else if (this.zzenz.zzada()) {
            super.onMeasure(i, i2);
        } else if (this.zzenz.zzacz()) {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcru)).booleanValue()) {
                super.onMeasure(i, i2);
                return;
            }
            zzbgk zzzo = zzzo();
            float aspectRatio = zzzo != null ? zzzo.getAspectRatio() : 0.0f;
            if (aspectRatio == 0.0f) {
                super.onMeasure(i, i2);
                return;
            }
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int i4 = (int) (((float) size2) * aspectRatio);
            int i5 = (int) (((float) size) / aspectRatio);
            if (size2 == 0 && i5 != 0) {
                i4 = (int) (((float) i5) * aspectRatio);
                size2 = i5;
            } else if (size == 0 && i4 != 0) {
                i5 = (int) (((float) i4) / aspectRatio);
                size = i4;
            }
            setMeasuredDimension(Math.min(i4, size), Math.min(i5, size2));
        } else if (this.zzenz.isFluid()) {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcrx)).booleanValue() || !PlatformVersion.isAtLeastJellyBeanMR1()) {
                super.onMeasure(i, i2);
                return;
            }
            zza("/contentHeight", new zzbgi(this));
            zzft("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
            float f = this.zzxd.density;
            int size3 = View.MeasureSpec.getSize(i);
            int i6 = this.zzeon;
            if (i6 != -1) {
                i3 = (int) (((float) i6) * f);
            } else {
                i3 = View.MeasureSpec.getSize(i2);
            }
            setMeasuredDimension(size3, i3);
        } else if (this.zzenz.zzacx()) {
            DisplayMetrics displayMetrics = this.zzxd;
            setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            int mode = View.MeasureSpec.getMode(i);
            int size4 = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size5 = View.MeasureSpec.getSize(i2);
            int i7 = Integer.MAX_VALUE;
            int i8 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size4 : Integer.MAX_VALUE;
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i7 = size5;
            }
            zzbhj zzbhj = this.zzenz;
            boolean z = zzbhj.widthPixels > i8 || zzbhj.heightPixels > i7;
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcuh)).booleanValue()) {
                zzbhj zzbhj2 = this.zzenz;
                float f2 = this.zzenr;
                boolean z2 = ((float) zzbhj2.widthPixels) / f2 <= ((float) i8) / f2 && ((float) zzbhj2.heightPixels) / f2 <= ((float) i7) / f2;
                if (z) {
                    z = z2;
                }
            }
            if (z) {
                zzbhj zzbhj3 = this.zzenz;
                float f3 = this.zzenr;
                StringBuilder sb = new StringBuilder(103);
                sb.append("Not enough space to show ad. Needs ");
                sb.append((int) (((float) zzbhj3.widthPixels) / f3));
                sb.append("x");
                sb.append((int) (((float) zzbhj3.heightPixels) / f3));
                sb.append(" dp, but only has ");
                sb.append((int) (((float) size4) / f3));
                sb.append("x");
                sb.append((int) (((float) size5) / f3));
                sb.append(" dp.");
                zzbbd.zzfe(sb.toString());
                if (getVisibility() != 8) {
                    setVisibility(4);
                }
                setMeasuredDimension(0, 0);
                if (!this.zzenu) {
                    this.zzelx.zza(zztq.zza.zzb.BANNER_SIZE_INVALID);
                    this.zzenu = true;
                }
            } else {
                if (getVisibility() != 8) {
                    setVisibility(0);
                }
                if (!this.zzenv) {
                    this.zzelx.zza(zztq.zza.zzb.BANNER_SIZE_VALID);
                    this.zzenv = true;
                }
                zzbhj zzbhj4 = this.zzenz;
                setMeasuredDimension(zzbhj4.widthPixels, zzbhj4.heightPixels);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbfq
    public final void onPause() {
        if (!isDestroyed()) {
            try {
                super.onPause();
            } catch (Exception e) {
                zzbbd.zzc("Could not pause webview.", e);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbfq
    public final void onResume() {
        if (!isDestroyed()) {
            try {
                super.onResume();
            } catch (Exception e) {
                zzbbd.zzc("Could not resume webview.", e);
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzenw.zzaby() || this.zzenw.zzabz()) {
            zzeg zzeg = this.zzenn;
            if (zzeg != null) {
                zzeg.zza(motionEvent);
            }
            zzabt zzabt = this.zzeno;
            if (zzabt != null) {
                zzabt.zza(motionEvent);
            }
        } else {
            synchronized (this) {
                zzadk zzadk = this.zzeoj;
                if (zzadk != null) {
                    zzadk.zzc(motionEvent);
                }
            }
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbfq
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzeor = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized void setRequestedOrientation(int i) {
        this.zzeod = i;
        zzc zzc = this.zzenx;
        if (zzc != null) {
            zzc.setRequestedOrientation(i);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbfq
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzbft) {
            this.zzenw = (zzbft) webViewClient;
        }
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Exception e) {
                zzbbd.zzc("Could not stop loading webview.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final void zza(String str, Map<String, ?> map) {
        try {
            zzb(str, zzp.zzkp().zzj(map));
        } catch (JSONException unused) {
            zzbbd.zzfe("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zzaax() {
        zzacm();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbpa.zzbra);
        zza("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zzaay() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzp.zzku().zzqe()));
        hashMap.put("app_volume", String.valueOf(zzp.zzku().zzqd()));
        hashMap.put("device_volume", String.valueOf(zzayz.zzbh(getContext())));
        zza("volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final Context zzaaz() {
        return this.zzenm.zzaaz();
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized zzc zzaba() {
        return this.zzenx;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized zzc zzabb() {
        return this.zzeos;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq, com.google.android.gms.internal.ads.zzbgy
    public final synchronized zzbhj zzabc() {
        return this.zzenz;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized String zzabd() {
        return this.zzacx;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final /* synthetic */ zzbhc zzabe() {
        return this.zzenw;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final WebViewClient zzabf() {
        return this.zzenw;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized boolean zzabg() {
        return this.zzdot;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq, com.google.android.gms.internal.ads.zzbhb
    public final zzeg zzabh() {
        return this.zzenn;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized IObjectWrapper zzabi() {
        return this.zzeny;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq, com.google.android.gms.internal.ads.zzbgs
    public final synchronized boolean zzabj() {
        return this.zzeob;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized void zzabk() {
        zzaxy.zzei("Destroying WebView!");
        zzwh();
        zzayh.zzeaj.post(new zzbgl(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized boolean zzabl() {
        return this.zzeoe;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized boolean zzabm() {
        return this.zzeom > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zzabn() {
        this.zzeou.zzyi();
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zzabo() {
        if (this.zzeop == null) {
            zzabi zzb = zzabb.zzb(this.zzeoq.zzrm());
            this.zzeop = zzb;
            this.zzeoq.zza("native:view_load", zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized zzadk zzabp() {
        return this.zzeoj;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zzabq() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zzabr() {
        zzaxy.zzei("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized zzsc zzabs() {
        return this.zzeol;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final boolean zzabt() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final zzsq zzabu() {
        return this.zzens;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final boolean zzabv() {
        return ((Boolean) zzwe.zzpu().zzd(zzaat.zzcwc)).booleanValue() && this.zzens != null && this.zzent;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized void zzal(boolean z) {
        zzc zzc = this.zzenx;
        if (zzc != null) {
            zzc.zza(this.zzenw.zzabx(), z);
        } else {
            this.zzdot = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized void zzap(IObjectWrapper iObjectWrapper) {
        this.zzeny = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbde
    public final void zzav(boolean z) {
        this.zzenw.zzav(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized void zzax(boolean z) {
        boolean z2 = z != this.zzeob;
        this.zzeob = z;
        zzacn();
        if (z2) {
            if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcmr)).booleanValue() || !this.zzenz.zzacx()) {
                new zzaqg(this).zzdz(z ? PanelStateKt.PANEL_EXPANDED : "default");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized void zzay(boolean z) {
        this.zzeoe = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized void zzaz(boolean z) {
        zzc zzc;
        int i = this.zzeom + (z ? 1 : -1);
        this.zzeom = i;
        if (i <= 0 && (zzc = this.zzenx) != null) {
            zzc.zzux();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zzba(boolean z) {
        this.zzenw.zzba(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zzbv(Context context) {
        this.zzenm.setBaseContext(context);
        this.zzeou.zzh(this.zzenm.zzzq());
    }

    @Override // com.google.android.gms.internal.ads.zzbgw
    public final void zzc(boolean z, int i) {
        this.zzenw.zzc(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    public final void zzdc(String str) {
        zzft(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zzdu(int i) {
        if (i == 0) {
            zzabb.zza(this.zzeoq.zzrm(), this.zzeif, "aebb2");
        }
        zzacm();
        if (this.zzeoq.zzrm() != null) {
            this.zzeoq.zzrm().zzh("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzbpa.zzbra);
        zza("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbde
    public final synchronized zzbev zzfj(String str) {
        Map<String, zzbev> map = this.zzeov;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // com.google.android.gms.ads.internal.zzk
    public final synchronized void zzkl() {
        this.zzeof = true;
        zzk zzk = this.zzenp;
        if (zzk != null) {
            zzk.zzkl();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzk
    public final synchronized void zzkm() {
        this.zzeof = false;
        zzk zzk = this.zzenp;
        if (zzk != null) {
            zzk.zzkm();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zzuv() {
        if (this.zzeoo == null) {
            zzabb.zza(this.zzeoq.zzrm(), this.zzeif, "aes2");
            zzabi zzb = zzabb.zzb(this.zzeoq.zzrm());
            this.zzeoo = zzb;
            this.zzeoq.zza("native:view_show", zzb);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbpa.zzbra);
        zza("onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbde
    public final void zzuw() {
        zzc zzaba = zzaba();
        if (zzaba != null) {
            zzaba.zzuw();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbde
    public final zzbcx zzzn() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq, com.google.android.gms.internal.ads.zzbde
    public final synchronized zzbgk zzzo() {
        return this.zzeog;
    }

    @Override // com.google.android.gms.internal.ads.zzbde
    public final zzabi zzzp() {
        return this.zzeif;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq, com.google.android.gms.internal.ads.zzbde, com.google.android.gms.internal.ads.zzbgt
    public final Activity zzzq() {
        return this.zzenm.zzzq();
    }

    @Override // com.google.android.gms.internal.ads.zzbfq, com.google.android.gms.internal.ads.zzbde
    public final zzb zzzr() {
        return this.zzenq;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq, com.google.android.gms.internal.ads.zzbde
    public final zzabh zzzs() {
        return this.zzeoq;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq, com.google.android.gms.internal.ads.zzbde, com.google.android.gms.internal.ads.zzbha
    public final zzbbg zzzt() {
        return this.zzbpa;
    }

    @Override // com.google.android.gms.internal.ads.zzbde
    public final int zzzu() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbde
    public final int zzzv() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbde
    public final synchronized void zzzw() {
        zzadf zzadf = this.zzeok;
        if (zzadf != null) {
            zzadf.zzsc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized void zzb(String str, String str2, @Nullable String str3) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, zzbgz.zzf(str2, zzbgz.zzact()), "text/html", "UTF-8", str3);
        } else {
            zzbbd.zzfe("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @TargetApi(19)
    private final synchronized void zza(String str, ValueCallback<String> valueCallback) {
        if (!isDestroyed()) {
            evaluateJavascript(str, null);
        } else {
            zzbbd.zzfe("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @VisibleForTesting
    private final void zza(Boolean bool) {
        synchronized (this) {
            this.zzdya = bool;
        }
        zzp.zzkt().zza(bool);
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        StringBuilder W = a.W("(window.AFMA_ReceiveMessage || function() {})('", str, "'", ",", jSONObject.toString());
        W.append(");");
        String valueOf = String.valueOf(W.toString());
        zzbbd.zzef(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzft(W.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    public final void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        zzft(a.t2(a.q0(jSONObject2, a.q0(str, 3)), str, "(", jSONObject2, ");"));
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized void zzb(zzc zzc) {
        this.zzeos = zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zzb(String str, zzahf<? super zzbfq> zzahf) {
        zzbft zzbft = this.zzenw;
        if (zzbft != null) {
            zzbft.zzb(str, zzahf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbde
    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("success", z ? "1" : "0");
        hashMap.put("duration", Long.toString(j));
        zza("onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final boolean zzb(boolean z, int i) {
        destroy();
        this.zzelx.zza(new zztn(z, i) { // from class: com.google.android.gms.internal.ads.zzbgj
            private final int zzeax;
            private final boolean zzeoy;

            {
                this.zzeoy = r1;
                this.zzeax = r2;
            }

            @Override // com.google.android.gms.internal.ads.zztn
            public final void zza(zztw.zzi.zza zza) {
                zzbgg.zza(this.zzeoy, this.zzeax, zza);
            }
        });
        this.zzelx.zza(zztq.zza.zzb.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized void zza(zzc zzc) {
        this.zzenx = zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized void zza(zzbhj zzbhj) {
        this.zzenz = zzbhj;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzbfq, com.google.android.gms.internal.ads.zzbde
    public final synchronized void zza(String str, zzbev zzbev) {
        if (this.zzeov == null) {
            this.zzeov = new HashMap();
        }
        this.zzeov.put(str, zzbev);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized void zza(zzadf zzadf) {
        this.zzeok = zzadf;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized void zza(zzsc zzsc) {
        this.zzeol = zzsc;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final synchronized void zza(zzadk zzadk) {
        this.zzeoj = zzadk;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq, com.google.android.gms.internal.ads.zzbde
    public final synchronized void zza(zzbgk zzbgk) {
        if (this.zzeog != null) {
            zzbbd.zzfc("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzeog = zzbgk;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgw
    public final void zza(zzd zzd) {
        this.zzenw.zza(zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbgw
    public final void zza(boolean z, int i, String str) {
        this.zzenw.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgw
    public final void zza(boolean z, int i, String str, String str2) {
        this.zzenw.zza(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zza(zzqr zzqr) {
        boolean z;
        synchronized (this) {
            z = zzqr.zzbrk;
            this.zzeoh = z;
        }
        zzbd(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zza(String str, zzahf<? super zzbfq> zzahf) {
        zzbft zzbft = this.zzenw;
        if (zzbft != null) {
            zzbft.zza(str, zzahf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zza(String str, Predicate<zzahf<? super zzbfq>> predicate) {
        zzbft zzbft = this.zzenw;
        if (zzbft != null) {
            zzbft.zza(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zza(ViewGroup viewGroup, Activity activity, String str, String str2) {
        if (!zzabv()) {
            zzaxy.zzei("AR ad is not enabled or the ad from the server is not an AR ad.");
            return;
        }
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        zzaxy.zzei("Initializing ArWebView object.");
        this.zzens.zza(activity, this);
        this.zzens.zzc(str, str2);
        if (viewGroup != null) {
            viewGroup.addView(this.zzens.getView());
        } else {
            zzbbd.zzfc("The FrameLayout object cannot be null.");
        }
    }

    public static final /* synthetic */ void zza(boolean z, int i, zztw.zzi.zza zza) {
        zztw.zzae.zza zzpd = zztw.zzae.zzpd();
        if (zzpd.zzpc() != z) {
            zzpd.zzx(z);
        }
        zza.zza((zztw.zzae) ((zzegp) zzpd.zzcy(i).zzbfx()));
    }
}
