package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzbcr extends FrameLayout implements zzbcm {
    private final zzbde zzefm;
    private final FrameLayout zzefn;
    private final zzabk zzefo;
    private final zzbdg zzefp;
    private final long zzefq;
    @Nullable
    private zzbcp zzefr;
    private boolean zzefs;
    private boolean zzeft;
    private boolean zzefu;
    private boolean zzefv;
    private long zzefw;
    private long zzefx;
    private String zzefy;
    private String[] zzefz;
    private Bitmap zzega;
    private ImageView zzegb;
    private boolean zzegc;

    public zzbcr(Context context, zzbde zzbde, int i, boolean z, zzabk zzabk, zzbdf zzbdf) {
        super(context);
        this.zzefm = zzbde;
        this.zzefo = zzabk;
        FrameLayout frameLayout = new FrameLayout(context);
        this.zzefn = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzbde.zzzr());
        zzbcp zza = zzbde.zzzr().zzbof.zza(context, zzbde, i, z, zzabk, zzbdf);
        this.zzefr = zza;
        if (zza != null) {
            frameLayout.addView(zza, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcme)).booleanValue()) {
                zzzf();
            }
        }
        this.zzegb = new ImageView(context);
        this.zzefq = ((Long) zzwe.zzpu().zzd(zzaat.zzcmi)).longValue();
        boolean booleanValue = ((Boolean) zzwe.zzpu().zzd(zzaat.zzcmg)).booleanValue();
        this.zzefv = booleanValue;
        if (zzabk != null) {
            zzabk.zzh("spinner_used", booleanValue ? "1" : "0");
        }
        this.zzefp = new zzbdg(this);
        zzbcp zzbcp = this.zzefr;
        if (zzbcp != null) {
            zzbcp.zza(this);
        }
        if (this.zzefr == null) {
            zzm("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public static void zza(zzbde zzbde, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("mimeTypes", map);
        zzbde.zza("onVideoEvent", hashMap);
    }

    public static void zzb(zzbde zzbde) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        zzbde.zza("onVideoEvent", hashMap);
    }

    private final boolean zzzh() {
        return this.zzegb.getParent() != null;
    }

    private final void zzzi() {
        if (this.zzefm.zzzq() != null && this.zzeft && !this.zzefu) {
            this.zzefm.zzzq().getWindow().clearFlags(128);
            this.zzeft = false;
        }
    }

    public final void destroy() {
        this.zzefp.pause();
        zzbcp zzbcp = this.zzefr;
        if (zzbcp != null) {
            zzbcp.stop();
        }
        zzzi();
    }

    @Override // java.lang.Object
    public final void finalize() throws Throwable {
        try {
            this.zzefp.pause();
            zzbcp zzbcp = this.zzefr;
            if (zzbcp != null) {
                zzdvw zzdvw = zzbbi.zzedy;
                zzbcp.getClass();
                zzdvw.execute(zzbcq.zza(zzbcp));
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void onPaused() {
        zzd(Tracker.Events.CREATIVE_PAUSE, new String[0]);
        zzzi();
        this.zzefs = false;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zzefp.resume();
        } else {
            this.zzefp.pause();
            this.zzefx = this.zzefw;
        }
        zzayh.zzeaj.post(new Runnable(this, z) { // from class: com.google.android.gms.internal.ads.zzbct
            private final zzbcr zzege;
            private final boolean zzegf;

            {
                this.zzege = r1;
                this.zzegf = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzege.zzau(this.zzegf);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbcm
    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zzefp.resume();
            z = true;
        } else {
            this.zzefp.pause();
            this.zzefx = this.zzefw;
            z = false;
        }
        zzayh.zzeaj.post(new zzbcu(this, z));
    }

    public final void pause() {
        zzbcp zzbcp = this.zzefr;
        if (zzbcp != null) {
            zzbcp.pause();
        }
    }

    public final void play() {
        zzbcp zzbcp = this.zzefr;
        if (zzbcp != null) {
            zzbcp.play();
        }
    }

    public final void seekTo(int i) {
        zzbcp zzbcp = this.zzefr;
        if (zzbcp != null) {
            zzbcp.seekTo(i);
        }
    }

    public final void setVolume(float f) {
        zzbcp zzbcp = this.zzefr;
        if (zzbcp != null) {
            zzbcp.zzefk.setVolume(f);
            zzbcp.zzyx();
        }
    }

    public final /* synthetic */ void zzau(boolean z) {
        zzd("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    public final void zzc(String str, String[] strArr) {
        this.zzefy = str;
        this.zzefz = strArr;
    }

    public final void zzd(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.zzefn.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzdl(int i) {
        this.zzefr.zzdl(i);
    }

    public final void zzdm(int i) {
        this.zzefr.zzdm(i);
    }

    public final void zzdn(int i) {
        this.zzefr.zzdn(i);
    }

    public final void zzdo(int i) {
        this.zzefr.zzdo(i);
    }

    public final void zzdp(int i) {
        this.zzefr.zzdp(i);
    }

    @TargetApi(14)
    public final void zze(MotionEvent motionEvent) {
        zzbcp zzbcp = this.zzefr;
        if (zzbcp != null) {
            zzbcp.dispatchTouchEvent(motionEvent);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zzez() {
        zzbcp zzbcp = this.zzefr;
        if (zzbcp != null && this.zzefx == 0) {
            zzd("canplaythrough", "duration", String.valueOf(((float) zzbcp.getDuration()) / 1000.0f), "videoWidth", String.valueOf(this.zzefr.getVideoWidth()), "videoHeight", String.valueOf(this.zzefr.getVideoHeight()));
        }
    }

    public final void zzhw() {
        if (this.zzefr != null) {
            if (!TextUtils.isEmpty(this.zzefy)) {
                this.zzefr.zzb(this.zzefy, this.zzefz);
            } else {
                zzd("no_src", new String[0]);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zzk(int i, int i2) {
        if (this.zzefv) {
            zzaai<Integer> zzaai = zzaat.zzcmh;
            int max = Math.max(i / ((Integer) zzwe.zzpu().zzd(zzaai)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzwe.zzpu().zzd(zzaai)).intValue(), 1);
            Bitmap bitmap = this.zzega;
            if (bitmap == null || bitmap.getWidth() != max || this.zzega.getHeight() != max2) {
                this.zzega = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.zzegc = false;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zzm(String str, @Nullable String str2) {
        zzd("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zzyy() {
        this.zzefp.resume();
        zzayh.zzeaj.post(new zzbcs(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zzyz() {
        if (this.zzefm.zzzq() != null && !this.zzeft) {
            boolean z = (this.zzefm.zzzq().getWindow().getAttributes().flags & 128) != 0;
            this.zzefu = z;
            if (!z) {
                this.zzefm.zzzq().getWindow().addFlags(128);
                this.zzeft = true;
            }
        }
        this.zzefs = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zzza() {
        zzd("ended", new String[0]);
        zzzi();
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zzzb() {
        if (this.zzegc && this.zzega != null && !zzzh()) {
            this.zzegb.setImageBitmap(this.zzega);
            this.zzegb.invalidate();
            this.zzefn.addView(this.zzegb, new FrameLayout.LayoutParams(-1, -1));
            this.zzefn.bringChildToFront(this.zzegb);
        }
        this.zzefp.pause();
        this.zzefx = this.zzefw;
        zzayh.zzeaj.post(new zzbcv(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zzzc() {
        if (this.zzefs && zzzh()) {
            this.zzefn.removeView(this.zzegb);
        }
        if (this.zzega != null) {
            long elapsedRealtime = zzp.zzkw().elapsedRealtime();
            if (this.zzefr.getBitmap(this.zzega) != null) {
                this.zzegc = true;
            }
            long elapsedRealtime2 = zzp.zzkw().elapsedRealtime() - elapsedRealtime;
            if (zzaxy.zzww()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(elapsedRealtime2);
                sb.append("ms");
                zzaxy.zzei(sb.toString());
            }
            if (elapsedRealtime2 > this.zzefq) {
                zzbbd.zzfe("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzefv = false;
                this.zzega = null;
                zzabk zzabk = this.zzefo;
                if (zzabk != null) {
                    zzabk.zzh("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    public final void zzzd() {
        zzbcp zzbcp = this.zzefr;
        if (zzbcp != null) {
            zzbcp.zzefk.setMuted(true);
            zzbcp.zzyx();
        }
    }

    public final void zzze() {
        zzbcp zzbcp = this.zzefr;
        if (zzbcp != null) {
            zzbcp.zzefk.setMuted(false);
            zzbcp.zzyx();
        }
    }

    @TargetApi(14)
    public final void zzzf() {
        zzbcp zzbcp = this.zzefr;
        if (zzbcp != null) {
            TextView textView = new TextView(zzbcp.getContext());
            String valueOf = String.valueOf(this.zzefr.zzyt());
            textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
            textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
            this.zzefn.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
            this.zzefn.bringChildToFront(textView);
        }
    }

    public final void zzzg() {
        zzbcp zzbcp = this.zzefr;
        if (zzbcp != null) {
            long currentPosition = (long) zzbcp.getCurrentPosition();
            if (this.zzefw != currentPosition && currentPosition > 0) {
                zzd("timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
                this.zzefw = currentPosition;
            }
        }
    }

    public static void zza(zzbde zzbde, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("error", str);
        zzbde.zza("onVideoEvent", hashMap);
    }

    /* access modifiers changed from: private */
    public final void zzd(String str, String... strArr) {
        HashMap k0 = a.k0("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                k0.put(str2, str3);
                str2 = null;
            }
        }
        this.zzefm.zza("onVideoEvent", k0);
    }

    public final void zza(float f, float f2) {
        zzbcp zzbcp = this.zzefr;
        if (zzbcp != null) {
            zzbcp.zza(f, f2);
        }
    }
}
