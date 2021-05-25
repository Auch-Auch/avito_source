package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;
@ParametersAreNonnullByDefault
@TargetApi(14)
public final class zzrk extends Thread {
    private final Object lock;
    private boolean started;
    private final int zzbsb;
    private final int zzbsd;
    private final boolean zzbse;
    private boolean zzbtb;
    private boolean zzbtc;
    private final zzrd zzbtd;
    private final int zzbte;
    private final int zzbtf;
    private final int zzbtg;
    private final int zzbth;
    private final int zzbti;
    private final int zzbtj;
    private final String zzbtk;
    private final boolean zzbtl;
    private final boolean zzbtm;

    public zzrk() {
        this(new zzrd());
    }

    @VisibleForTesting
    private final zzro zza(@Nullable View view, zzre zzre) {
        boolean z;
        if (view == null) {
            return new zzro(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzro(this, 0, 0);
            }
            zzre.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new zzro(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzbfq)) {
            WebView webView = (WebView) view;
            if (!PlatformVersion.isAtLeastKitKat()) {
                z = false;
            } else {
                zzre.zzmc();
                webView.post(new zzrm(this, zzre, webView, globalVisibleRect));
                z = true;
            }
            if (z) {
                return new zzro(this, 0, 1);
            }
            return new zzro(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zzro(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zzro zza = zza(viewGroup.getChildAt(i3), zzre);
                i += zza.zzbtt;
                i2 += zza.zzbtu;
            }
            return new zzro(this, i, i2);
        }
    }

    @VisibleForTesting
    private static boolean zzmh() {
        boolean z;
        try {
            Context context = zzp.zzks().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null) {
                return false;
            }
            if (keyguardManager == null) {
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return false;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    if (powerManager == null) {
                        z = false;
                    } else {
                        z = powerManager.isScreenOn();
                    }
                    if (z) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            zzp.zzkt().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    private final void zzmj() {
        synchronized (this.lock) {
            this.zzbtb = true;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(true);
            zzbbd.zzef(sb.toString());
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                if (zzmh()) {
                    Activity activity = zzp.zzks().getActivity();
                    if (activity == null) {
                        zzbbd.zzef("ContentFetchThread: no activity. Sleeping.");
                        zzmj();
                    } else {
                        View view = null;
                        try {
                            if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                                view = activity.getWindow().getDecorView().findViewById(16908290);
                            }
                        } catch (Exception e) {
                            zzp.zzkt().zza(e, "ContentFetchTask.extractContent");
                            zzbbd.zzef("Failed getting root view of activity. Content not extracted.");
                        }
                        if (view != null) {
                            view.post(new zzrj(this, view));
                        }
                    }
                } else {
                    zzbbd.zzef("ContentFetchTask: sleeping");
                    zzmj();
                }
                Thread.sleep((long) (this.zzbte * 1000));
            } catch (InterruptedException e2) {
                zzbbd.zzc("Error in ContentFetchTask", e2);
            } catch (Exception e3) {
                zzbbd.zzc("Error in ContentFetchTask", e3);
                zzp.zzkt().zza(e3, "ContentFetchTask.run");
            }
            synchronized (this.lock) {
                while (this.zzbtb) {
                    try {
                        zzbbd.zzef("ContentFetchTask: waiting");
                        this.lock.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    public final void wakeup() {
        synchronized (this.lock) {
            this.zzbtb = false;
            this.lock.notifyAll();
            zzbbd.zzef("ContentFetchThread: wakeup");
        }
    }

    @VisibleForTesting
    public final void zzj(View view) {
        try {
            zzre zzre = new zzre(this.zzbsb, this.zzbtf, this.zzbsd, this.zzbtg, this.zzbth, this.zzbti, this.zzbtj, this.zzbse);
            Context context = zzp.zzks().getContext();
            if (context != null && !TextUtils.isEmpty(this.zzbtk)) {
                String str = (String) view.getTag(context.getResources().getIdentifier((String) zzwe.zzpu().zzd(zzaat.zzcmw), "id", context.getPackageName()));
                if (str != null && str.equals(this.zzbtk)) {
                    return;
                }
            }
            zzro zza = zza(view, zzre);
            zzre.zzme();
            if (zza.zzbtt != 0 || zza.zzbtu != 0) {
                if (zza.zzbtu != 0 || zzre.zzmf() != 0) {
                    if (zza.zzbtu != 0 || !this.zzbtd.zza(zzre)) {
                        this.zzbtd.zzc(zzre);
                    }
                }
            }
        } catch (Exception e) {
            zzbbd.zzc("Exception in fetchContentOnUIThread", e);
            zzp.zzkt().zza(e, "ContentFetchTask.fetchContent");
        }
    }

    public final void zzmg() {
        synchronized (this.lock) {
            if (this.started) {
                zzbbd.zzef("Content hash thread already started, quiting...");
                return;
            }
            this.started = true;
            start();
        }
    }

    public final zzre zzmi() {
        return this.zzbtd.zzo(this.zzbtm);
    }

    public final boolean zzmk() {
        return this.zzbtb;
    }

    @VisibleForTesting
    private zzrk(zzrd zzrd) {
        this.started = false;
        this.zzbtb = false;
        this.zzbtc = false;
        this.zzbtd = zzrd;
        this.lock = new Object();
        this.zzbsb = zzaci.zzczz.get().intValue();
        this.zzbtf = zzaci.zzczw.get().intValue();
        this.zzbsd = zzaci.zzdaa.get().intValue();
        this.zzbtg = zzaci.zzczy.get().intValue();
        this.zzbth = ((Integer) zzwe.zzpu().zzd(zzaat.zzcmt)).intValue();
        this.zzbti = ((Integer) zzwe.zzpu().zzd(zzaat.zzcmu)).intValue();
        this.zzbtj = ((Integer) zzwe.zzpu().zzd(zzaat.zzcmv)).intValue();
        this.zzbte = zzaci.zzdab.get().intValue();
        this.zzbtk = (String) zzwe.zzpu().zzd(zzaat.zzcmx);
        this.zzbtl = ((Boolean) zzwe.zzpu().zzd(zzaat.zzcmy)).booleanValue();
        this.zzbse = ((Boolean) zzwe.zzpu().zzd(zzaat.zzcmz)).booleanValue();
        this.zzbtm = ((Boolean) zzwe.zzpu().zzd(zzaat.zzcna)).booleanValue();
        setName("ContentFetchTask");
    }

    @VisibleForTesting
    public final void zza(zzre zzre, WebView webView, String str, boolean z) {
        zzre.zzmb();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (this.zzbtl || TextUtils.isEmpty(webView.getTitle())) {
                    zzre.zza(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzre.zza(sb.toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (zzre.zzlw()) {
                this.zzbtd.zzb(zzre);
            }
        } catch (JSONException unused) {
            zzbbd.zzef("Json string may be malformed.");
        } catch (Throwable th) {
            zzbbd.zzb("Failed to get webview content.", th);
            zzp.zzkt().zza(th, "ContentFetchTask.processWebViewContent");
        }
    }
}
