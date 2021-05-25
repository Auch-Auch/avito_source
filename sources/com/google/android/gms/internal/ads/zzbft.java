package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zztq;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
@VisibleForTesting
@ParametersAreNonnullByDefault
public class zzbft extends WebViewClient implements zzbhc {
    private final Object lock;
    @GuardedBy("lock")
    private boolean zzbrb;
    private zzut zzcgq;
    private zzagl zzddv;
    private zzagn zzddw;
    private zza zzder;
    private zzapw zzdes;
    private zzo zzdor;
    private zzt zzdov;
    private boolean zzdsu;
    public zzbfq zzelw;
    @Nullable
    private final zzto zzelx;
    private final HashMap<String, List<zzahf<? super zzbfq>>> zzely;
    private zzbhf zzelz;
    private zzbhe zzema;
    private zzbhh zzemb;
    private boolean zzemc;
    @GuardedBy("lock")
    private boolean zzemd;
    @GuardedBy("lock")
    private boolean zzeme;
    @GuardedBy("lock")
    private boolean zzemf;
    private final zzaqd zzemg;
    @Nullable
    public zzavu zzemh;
    private boolean zzemi;
    private boolean zzemj;
    private int zzemk;
    private View.OnAttachStateChangeListener zzeml;

    public zzbft(zzbfq zzbfq, zzto zzto, boolean z) {
        this(zzbfq, zzto, z, new zzaqd(zzbfq, zzbfq.zzaaz(), new zzaae(zzbfq.getContext())), null);
    }

    private final void zzacc() {
        if (this.zzeml != null) {
            this.zzelw.getView().removeOnAttachStateChangeListener(this.zzeml);
        }
    }

    private final void zzach() {
        zzbhf zzbhf = this.zzelz;
        if (zzbhf != null && ((this.zzemi && this.zzemk <= 0) || this.zzemj)) {
            zzbhf.zzak(!this.zzemj);
            this.zzelz = null;
        }
        this.zzelw.zzabo();
    }

    private static WebResourceResponse zzaci() {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcnr)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zze(String str, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    openConnection.addRequestProperty(entry.getKey(), entry.getValue());
                }
                if (openConnection instanceof HttpURLConnection) {
                    httpURLConnection = (HttpURLConnection) openConnection;
                    zzp.zzkp().zza(this.zzelw.getContext(), this.zzelw.zzzt().zzbra, false, httpURLConnection);
                    zzbax zzbax = new zzbax();
                    zzbax.zza(httpURLConnection, (byte[]) null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzbax.zza(httpURLConnection, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        break;
                    }
                    String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                    if (headerField == null) {
                        throw new IOException("Missing Location header in redirect");
                    } else if (headerField.startsWith("tel:")) {
                        return null;
                    } else {
                        URL url2 = new URL(url, headerField);
                        String protocol = url2.getProtocol();
                        if (protocol == null) {
                            zzbbd.zzfe("Protocol is null");
                            return zzaci();
                        } else if (protocol.equals(UriUtil.HTTP_SCHEME) || protocol.equals("https")) {
                            zzbbd.zzef(headerField.length() != 0 ? "Redirecting to ".concat(headerField) : new String("Redirecting to "));
                            httpURLConnection.disconnect();
                            url = url2;
                        } else {
                            zzbbd.zzfe(protocol.length() != 0 ? "Unsupported scheme: ".concat(protocol) : new String("Unsupported scheme: "));
                            return zzaci();
                        }
                    }
                } else {
                    throw new IOException("Invalid protocol.");
                }
            } else {
                throw new IOException("Too many redirects (20)");
            }
        }
        zzp.zzkp();
        return zzayh.zzd(httpURLConnection);
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzaxy.zzei(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.lock) {
            if (this.zzelw.isDestroyed()) {
                zzaxy.zzei("Blank page loaded, 1...");
                this.zzelw.zzabk();
                return;
            }
        }
        this.zzemi = true;
        zzbhe zzbhe = this.zzema;
        if (zzbhe != null) {
            zzbhe.zztf();
            this.zzema = null;
        }
        zzach();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzsq zzabu = this.zzelw.zzabu();
        if (zzabu != null && webView == zzabu.getWebView()) {
            zzabu.onPageStarted(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzelw.zzb(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    public final void reset() {
        zzavu zzavu = this.zzemh;
        if (zzavu != null) {
            zzavu.zzvq();
            this.zzemh = null;
        }
        zzacc();
        synchronized (this.lock) {
            this.zzely.clear();
            this.zzcgq = null;
            this.zzdor = null;
            this.zzelz = null;
            this.zzema = null;
            this.zzddv = null;
            this.zzddw = null;
            this.zzemc = false;
            this.zzbrb = false;
            this.zzemd = false;
            this.zzemf = false;
            this.zzdov = null;
            this.zzemb = null;
            zzapw zzapw = this.zzdes;
            if (zzapw != null) {
                zzapw.zzac(true);
                this.zzdes = null;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzd(str, Collections.emptyMap());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzaxy.zzei(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if (!"gmsg".equalsIgnoreCase(parse.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            if (this.zzemc && webView == this.zzelw.getWebView()) {
                String scheme = parse.getScheme();
                if (UriUtil.HTTP_SCHEME.equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    zzut zzut = this.zzcgq;
                    if (zzut != null) {
                        zzut.onAdClicked();
                        zzavu zzavu = this.zzemh;
                        if (zzavu != null) {
                            zzavu.zzea(str);
                        }
                        this.zzcgq = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzelw.getWebView().willNotDraw()) {
                try {
                    zzeg zzabh = this.zzelw.zzabh();
                    if (zzabh != null && zzabh.zzb(parse)) {
                        parse = zzabh.zza(parse, this.zzelw.getContext(), this.zzelw.getView(), this.zzelw.zzzq());
                    }
                } catch (zzef unused) {
                    String valueOf2 = String.valueOf(str);
                    zzbbd.zzfe(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                }
                zza zza = this.zzder;
                if (zza == null || zza.zzjx()) {
                    zza(new zzd("android.intent.action.VIEW", parse.toString(), null, null, null, null, null));
                } else {
                    this.zzder.zzbo(str);
                }
            } else {
                String valueOf3 = String.valueOf(str);
                zzbbd.zzfe(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
            }
        } else {
            zzh(parse);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zza(int i, int i2, boolean z) {
        this.zzemg.zzj(i, i2);
        zzapw zzapw = this.zzdes;
        if (zzapw != null) {
            zzapw.zza(i, i2, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final zza zzabw() {
        return this.zzder;
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final boolean zzabx() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzbrb;
        }
        return z;
    }

    public final boolean zzaby() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzemd;
        }
        return z;
    }

    public final boolean zzabz() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzeme;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzaca() {
        synchronized (this.lock) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzacb() {
        synchronized (this.lock) {
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zzacd() {
        zzavu zzavu = this.zzemh;
        if (zzavu != null) {
            WebView webView = this.zzelw.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                zza(webView, zzavu, 10);
                return;
            }
            zzacc();
            this.zzeml = new zzbfx(this, zzavu);
            this.zzelw.getView().addOnAttachStateChangeListener(this.zzeml);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zzace() {
        synchronized (this.lock) {
            this.zzemf = true;
        }
        this.zzemk++;
        zzach();
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zzacf() {
        this.zzemk--;
        zzach();
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zzacg() {
        zzto zzto = this.zzelx;
        if (zzto != null) {
            zzto.zza(zztq.zza.zzb.DELAY_PAGE_LOAD_CANCELLED_AD);
        }
        this.zzemj = true;
        zzach();
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcuw)).booleanValue()) {
            this.zzelw.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final zzavu zzacj() {
        return this.zzemh;
    }

    public final void zzav(boolean z) {
        this.zzemc = z;
    }

    public final void zzb(String str, zzahf<? super zzbfq> zzahf) {
        synchronized (this.lock) {
            List<zzahf<? super zzbfq>> list = this.zzely.get(str);
            if (list != null) {
                list.remove(zzahf);
            }
        }
    }

    public final void zzba(boolean z) {
        this.zzdsu = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zzbb(boolean z) {
        synchronized (this.lock) {
            this.zzemd = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zzbc(boolean z) {
        synchronized (this.lock) {
            this.zzeme = z;
        }
    }

    public final void zzc(boolean z, int i) {
        zzut zzut = (!this.zzelw.zzabj() || this.zzelw.zzabc().zzacx()) ? this.zzcgq : null;
        zzo zzo = this.zzdor;
        zzt zzt = this.zzdov;
        zzbfq zzbfq = this.zzelw;
        zza(new AdOverlayInfoParcel(zzut, zzo, zzt, zzbfq, z, i, zzbfq.zzzt()));
    }

    @Nullable
    public final WebResourceResponse zzd(String str, Map<String, String> map) {
        zzsv zza;
        try {
            String zzc = zzawq.zzc(str, this.zzelw.getContext(), this.zzdsu);
            if (!zzc.equals(str)) {
                return zze(zzc, map);
            }
            zzta zzbw = zzta.zzbw(str);
            if (zzbw != null && (zza = zzp.zzkv().zza(zzbw)) != null && zza.zzmu()) {
                return new WebResourceResponse("", "", zza.zzmv());
            }
            if (!zzbax.isEnabled() || !zzacj.zzdad.get().booleanValue()) {
                return null;
            }
            return zze(str, map);
        } catch (Exception | NoClassDefFoundError e) {
            zzp.zzkt().zza(e, "AdWebViewClient.interceptRequest");
            return zzaci();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zzh(Uri uri) {
        String path = uri.getPath();
        List<zzahf<? super zzbfq>> list = this.zzely.get(path);
        if (list != null) {
            if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcus)).booleanValue()) {
                zzp.zzkp();
                zza(zzayh.zzj(uri), list, path);
                return;
            }
            zzdvl.zza(zzp.zzkp().zzi(uri), new zzbfw(this, list, path), zzbbi.zzedz);
            return;
        }
        String valueOf = String.valueOf(uri);
        StringBuilder sb = new StringBuilder(valueOf.length() + 32);
        sb.append("No GMSG handler found for GMSG: ");
        sb.append(valueOf);
        zzaxy.zzei(sb.toString());
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcwx)).booleanValue() && zzp.zzkt().zzwd() != null) {
            zzbbi.zzedu.execute(new Runnable(path) { // from class: com.google.android.gms.internal.ads.zzbfv
                private final String zzdgb;

                {
                    this.zzdgb = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzp.zzkt().zzwd().zzcv(this.zzdgb.substring(1));
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zzi(int i, int i2) {
        zzapw zzapw = this.zzdes;
        if (zzapw != null) {
            zzapw.zzi(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zzur() {
        synchronized (this.lock) {
            this.zzemc = false;
            this.zzbrb = true;
            zzbbi.zzedy.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbfs
                private final zzbft zzelv;

                {
                    this.zzelv = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbft zzbft = this.zzelv;
                    zzbft.zzelw.zzabn();
                    zzc zzaba = zzbft.zzelw.zzaba();
                    if (zzaba != null) {
                        zzaba.zzur();
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zza(zzut zzut, zzagl zzagl, zzo zzo, zzagn zzagn, zzt zzt, boolean z, @Nullable zzahi zzahi, zza zza, zzaqf zzaqf, @Nullable zzavu zzavu) {
        if (zza == null) {
            zza = new zza(this.zzelw.getContext(), zzavu, null);
        }
        this.zzdes = new zzapw(this.zzelw, zzaqf);
        this.zzemh = zzavu;
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcoc)).booleanValue()) {
            zza("/adMetadata", new zzagm(zzagl));
        }
        zza("/appEvent", new zzago(zzagn));
        zza("/backButton", zzagp.zzdeh);
        zza("/refresh", zzagp.zzdei);
        zza("/canOpenApp", zzagp.zzddy);
        zza("/canOpenURLs", zzagp.zzddx);
        zza("/canOpenIntents", zzagp.zzddz);
        zza("/click", zzagp.zzdea);
        zza("/close", zzagp.zzdeb);
        zza("/customClose", zzagp.zzdec);
        zza("/instrument", zzagp.zzdel);
        zza("/delayPageLoaded", zzagp.zzden);
        zza("/delayPageClosed", zzagp.zzdeo);
        zza("/getLocationInfo", zzagp.zzdep);
        zza("/httpTrack", zzagp.zzded);
        zza("/log", zzagp.zzdee);
        zza("/mraid", new zzahk(zza, this.zzdes, zzaqf));
        zza("/mraidLoaded", this.zzemg);
        zza("/open", new zzahj(zza, this.zzdes));
        zza("/precache", new zzbfa());
        zza("/touch", zzagp.zzdeg);
        zza("/video", zzagp.zzdej);
        zza("/videoMeta", zzagp.zzdek);
        if (zzp.zzln().zzac(this.zzelw.getContext())) {
            zza("/logScionEvent", new zzahh(this.zzelw.getContext()));
        }
        this.zzcgq = zzut;
        this.zzdor = zzo;
        this.zzddv = zzagl;
        this.zzddw = zzagn;
        this.zzdov = zzt;
        this.zzder = zza;
        this.zzemc = z;
    }

    @VisibleForTesting
    private zzbft(zzbfq zzbfq, zzto zzto, boolean z, zzaqd zzaqd, zzapw zzapw) {
        this.zzely = new HashMap<>();
        this.lock = new Object();
        this.zzemc = false;
        this.zzelx = zzto;
        this.zzelw = zzbfq;
        this.zzbrb = z;
        this.zzemg = zzaqd;
        this.zzdes = null;
    }

    /* access modifiers changed from: private */
    public final void zza(View view, zzavu zzavu, int i) {
        if (zzavu.zzvo() && i > 0) {
            zzavu.zzl(view);
            if (zzavu.zzvo()) {
                zzayh.zzeaj.postDelayed(new zzbfu(this, view, zzavu, i), 100);
            }
        }
    }

    public final void zza(zzd zzd) {
        zzo zzo;
        boolean zzabj = this.zzelw.zzabj();
        zzut zzut = (!zzabj || this.zzelw.zzabc().zzacx()) ? this.zzcgq : null;
        if (zzabj) {
            zzo = null;
        } else {
            zzo = this.zzdor;
        }
        zza(new AdOverlayInfoParcel(zzd, zzut, zzo, this.zzdov, this.zzelw.zzzt()));
    }

    public final void zza(boolean z, int i, String str) {
        zzbfz zzbfz;
        boolean zzabj = this.zzelw.zzabj();
        zzut zzut = (!zzabj || this.zzelw.zzabc().zzacx()) ? this.zzcgq : null;
        if (zzabj) {
            zzbfz = null;
        } else {
            zzbfz = new zzbfz(this.zzelw, this.zzdor);
        }
        zzagl zzagl = this.zzddv;
        zzagn zzagn = this.zzddw;
        zzt zzt = this.zzdov;
        zzbfq zzbfq = this.zzelw;
        zza(new AdOverlayInfoParcel(zzut, zzbfz, zzagl, zzagn, zzt, zzbfq, z, i, str, zzbfq.zzzt()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzbfz zzbfz;
        boolean zzabj = this.zzelw.zzabj();
        zzut zzut = (!zzabj || this.zzelw.zzabc().zzacx()) ? this.zzcgq : null;
        if (zzabj) {
            zzbfz = null;
        } else {
            zzbfz = new zzbfz(this.zzelw, this.zzdor);
        }
        zzagl zzagl = this.zzddv;
        zzagn zzagn = this.zzddw;
        zzt zzt = this.zzdov;
        zzbfq zzbfq = this.zzelw;
        zza(new AdOverlayInfoParcel(zzut, zzbfz, zzagl, zzagn, zzt, zzbfq, z, i, str, str2, zzbfq.zzzt()));
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzd zzd;
        zzapw zzapw = this.zzdes;
        boolean zzuk = zzapw != null ? zzapw.zzuk() : false;
        zzp.zzko();
        zzn.zza(this.zzelw.getContext(), adOverlayInfoParcel, !zzuk);
        zzavu zzavu = this.zzemh;
        if (zzavu != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && (zzd = adOverlayInfoParcel.zzdoq) != null) {
                str = zzd.url;
            }
            zzavu.zzea(str);
        }
    }

    public final void zza(String str, zzahf<? super zzbfq> zzahf) {
        synchronized (this.lock) {
            List<zzahf<? super zzbfq>> list = this.zzely.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                this.zzely.put(str, list);
            }
            list.add(zzahf);
        }
    }

    public final void zza(String str, Predicate<zzahf<? super zzbfq>> predicate) {
        synchronized (this.lock) {
            List<zzahf<? super zzbfq>> list = this.zzely.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzahf<? super zzbfq> zzahf : list) {
                    if (predicate.apply(zzahf)) {
                        arrayList.add(zzahf);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zza(zzbhf zzbhf) {
        this.zzelz = zzbhf;
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zza(zzbhe zzbhe) {
        this.zzema = zzbhe;
    }

    /* access modifiers changed from: private */
    public final void zza(Map<String, String> map, List<zzahf<? super zzbfq>> list, String str) {
        if (zzbbd.isLoggable(2)) {
            String valueOf = String.valueOf(str);
            zzaxy.zzei(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + String.valueOf(str2).length() + 4);
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                zzaxy.zzei(sb.toString());
            }
        }
        for (zzahf<? super zzbfq> zzahf : list) {
            zzahf.zza(this.zzelw, map);
        }
    }
}
