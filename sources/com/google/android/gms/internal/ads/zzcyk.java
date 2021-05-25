package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbxj;
import com.google.android.gms.internal.ads.zzcyx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
public final class zzcyk extends zzawx {
    private static final List<String> zzgrl = new ArrayList(Arrays.asList("/aclk", "/pcs/click"));
    private static final List<String> zzgrm = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    private static final List<String> zzgrn = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion"));
    private static final List<String> zzgro = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    private zzbbg zzbop;
    private final ScheduledExecutorService zzflf;
    private zzeg zzflj;
    private Point zzfwd = new Point();
    private Point zzfwe = new Point();
    private final zzdvw zzgay;
    private zzdma<zzchc> zzgmr;
    private zzbii zzgrp;
    @Nullable
    private zzarn zzgrq;
    private Context zzvr;

    public zzcyk(zzbii zzbii, Context context, zzeg zzeg, zzbbg zzbbg, zzdma<zzchc> zzdma, zzdvw zzdvw, ScheduledExecutorService scheduledExecutorService) {
        this.zzgrp = zzbii;
        this.zzvr = context;
        this.zzflj = zzeg;
        this.zzbop = zzbbg;
        this.zzgmr = zzdma;
        this.zzgay = zzdvw;
        this.zzflf = scheduledExecutorService;
    }

    private final boolean zzaqo() {
        Map<String, WeakReference<View>> map;
        zzarn zzarn = this.zzgrq;
        return (zzarn == null || (map = zzarn.zzdpj) == null || map.isEmpty()) ? false : true;
    }

    public static /* synthetic */ Uri zzc(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zza(uri, "nas", str) : uri;
    }

    private final zzdvt<String> zzgr(String str) {
        zzchc[] zzchcArr = new zzchc[1];
        zzdvt zzb = zzdvl.zzb(this.zzgmr.zzasz(), new zzduv(this, zzchcArr, str) { // from class: com.google.android.gms.internal.ads.zzcyr
            private final String zzdin;
            private final zzcyk zzgri;
            private final zzchc[] zzgrr;

            {
                this.zzgri = r1;
                this.zzgrr = r2;
                this.zzdin = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgri.zza(this.zzgrr, this.zzdin, (zzchc) obj);
            }
        }, this.zzgay);
        zzb.addListener(new Runnable(this, zzchcArr) { // from class: com.google.android.gms.internal.ads.zzcyu
            private final zzcyk zzgri;
            private final zzchc[] zzgrr;

            {
                this.zzgri = r1;
                this.zzgrr = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgri.zza(this.zzgrr);
            }
        }, this.zzgay);
        return zzdvc.zzg(zzb).zza((long) ((Integer) zzwe.zzpu().zzd(zzaat.zzcxd)).intValue(), TimeUnit.MILLISECONDS, this.zzflf).zza(zzcyp.zzdwg, this.zzgay).zza(Exception.class, zzcys.zzdwg, this.zzgay);
    }

    @VisibleForTesting
    private static boolean zzk(@NonNull Uri uri) {
        return zza(uri, zzgrn, zzgro);
    }

    @Override // com.google.android.gms.internal.ads.zzawu
    public final void zza(IObjectWrapper iObjectWrapper, zzaxa zzaxa, zzawt zzawt) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.zzvr = context;
        String str = zzaxa.zzbuo;
        String str2 = zzaxa.zzbqx;
        zzvj zzvj = zzaxa.zzdxj;
        zzvc zzvc = zzaxa.zzdxk;
        zzcyh zzadx = this.zzgrp.zzadx();
        zzbsg.zza zzcd = new zzbsg.zza().zzcd(context);
        zzdlp zzdlp = new zzdlp();
        if (str == null) {
            str = "adUnitId";
        }
        zzdlp zzgt = zzdlp.zzgt(str);
        if (zzvc == null) {
            zzvc = new zzvf().zzph();
        }
        zzdlp zzh = zzgt.zzh(zzvc);
        if (zzvj == null) {
            zzvj = new zzvj();
        }
        zzdvl.zza(zzadx.zzf(zzcd.zza(zzh.zze(zzvj).zzasu()).zzajj()).zza(new zzcyx(new zzcyx.zza().zzgs(str2))).zzf(new zzbxj.zza().zzake()).zzagm().zzagl(), new zzcyt(this, zzawt), this.zzgrp.zzadj());
    }

    @Override // com.google.android.gms.internal.ads.zzawu
    public final void zzan(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcxc)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzarn zzarn = this.zzgrq;
            this.zzfwd = zzbah.zza(motionEvent, zzarn == null ? null : zzarn.zzaat);
            if (motionEvent.getAction() == 0) {
                this.zzfwe = this.zzfwd;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            Point point = this.zzfwd;
            obtain.setLocation((float) point.x, (float) point.y);
            this.zzflj.zza(obtain);
            obtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawu
    public final IObjectWrapper zzao(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzawu
    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzawu
    public final void zzb(List<Uri> list, IObjectWrapper iObjectWrapper, zzarc zzarc) {
        try {
            if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcxc)).booleanValue()) {
                zzarc.onError("The updating URL feature is not enabled.");
            } else if (list.size() != 1) {
                zzarc.onError("There should be only 1 click URL.");
            } else {
                Uri uri = list.get(0);
                if (!zza(uri, zzgrl, zzgrm)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    zzbbd.zzfe(sb.toString());
                    zzarc.onSuccess(list);
                    return;
                }
                zzdvt zze = this.zzgay.zze(new Callable(this, uri, iObjectWrapper) { // from class: com.google.android.gms.internal.ads.zzcyl
                    private final Uri zzeag;
                    private final zzcyk zzgri;
                    private final IObjectWrapper zzgrk;

                    {
                        this.zzgri = r1;
                        this.zzeag = r2;
                        this.zzgrk = r3;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zzgri.zzb(this.zzeag, this.zzgrk);
                    }
                });
                if (zzaqo()) {
                    zze = zzdvl.zzb(zze, new zzduv(this) { // from class: com.google.android.gms.internal.ads.zzcyo
                        private final zzcyk zzgri;

                        {
                            this.zzgri = r1;
                        }

                        @Override // com.google.android.gms.internal.ads.zzduv
                        public final zzdvt zzf(Object obj) {
                            return this.zzgri.zzl((Uri) obj);
                        }
                    }, this.zzgay);
                } else {
                    zzbbd.zzfd("Asset view map is empty.");
                }
                zzdvl.zza(zze, new zzcyv(this, zzarc), this.zzgrp.zzadj());
            }
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
        }
    }

    public final /* synthetic */ zzdvt zzl(Uri uri) throws Exception {
        return zzdvl.zzb(zzgr("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzdsl(this, uri) { // from class: com.google.android.gms.internal.ads.zzcyq
            private final Uri zzeag;
            private final zzcyk zzgri;

            {
                this.zzgri = r1;
                this.zzeag = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzdsl
            public final Object apply(Object obj) {
                return zzcyk.zzc(this.zzeag, (String) obj);
            }
        }, this.zzgay);
    }

    public final /* synthetic */ zzdvt zzb(ArrayList arrayList) throws Exception {
        return zzdvl.zzb(zzgr("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzdsl(this, arrayList) { // from class: com.google.android.gms.internal.ads.zzcyn
            private final zzcyk zzgri;
            private final List zzgrj;

            {
                this.zzgri = r1;
                this.zzgrj = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzdsl
            public final Object apply(Object obj) {
                return zzcyk.zza(this.zzgrj, (String) obj);
            }
        }, this.zzgay);
    }

    @Override // com.google.android.gms.internal.ads.zzawu
    public final void zza(zzarn zzarn) {
        this.zzgrq = zzarn;
        this.zzgmr.zzed(1);
    }

    @Override // com.google.android.gms.internal.ads.zzawu
    public final void zza(List<Uri> list, IObjectWrapper iObjectWrapper, zzarc zzarc) {
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcxc)).booleanValue()) {
            try {
                zzarc.onError("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                zzbbd.zzc("", e);
            }
        } else {
            zzdvt zze = this.zzgay.zze(new Callable(this, list, iObjectWrapper) { // from class: com.google.android.gms.internal.ads.zzcyj
                private final zzcyk zzgri;
                private final List zzgrj;
                private final IObjectWrapper zzgrk;

                {
                    this.zzgri = r1;
                    this.zzgrj = r2;
                    this.zzgrk = r3;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzgri.zza(this.zzgrj, this.zzgrk);
                }
            });
            if (zzaqo()) {
                zze = zzdvl.zzb(zze, new zzduv(this) { // from class: com.google.android.gms.internal.ads.zzcym
                    private final zzcyk zzgri;

                    {
                        this.zzgri = r1;
                    }

                    @Override // com.google.android.gms.internal.ads.zzduv
                    public final zzdvt zzf(Object obj) {
                        return this.zzgri.zzb((ArrayList) obj);
                    }
                }, this.zzgay);
            } else {
                zzbbd.zzfd("Asset view map is empty.");
            }
            zzdvl.zza(zze, new zzcyw(this, zzarc), this.zzgrp.zzadj());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final Uri zzb(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        try {
            uri = this.zzflj.zza(uri, this.zzvr, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
        } catch (zzef e) {
            zzbbd.zzd("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    private static boolean zza(@NonNull Uri uri, List<String> list, List<String> list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (!(host == null || path == null)) {
            for (String str : list) {
                if (path.contains(str)) {
                    for (String str2 : list2) {
                        if (host.endsWith(str2)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    private static Uri zza(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = indexOf + 1;
        StringBuilder sb = new StringBuilder(uri2.substring(0, i));
        a.n1(sb, str, "=", str2, "&");
        sb.append(uri2.substring(i));
        return Uri.parse(sb.toString());
    }

    public final /* synthetic */ void zza(zzchc[] zzchcArr) {
        if (zzchcArr[0] != null) {
            this.zzgmr.zzd(zzdvl.zzaf(zzchcArr[0]));
        }
    }

    public final /* synthetic */ zzdvt zza(zzchc[] zzchcArr, String str, zzchc zzchc) throws Exception {
        zzchcArr[0] = zzchc;
        Context context = this.zzvr;
        zzarn zzarn = this.zzgrq;
        Map<String, WeakReference<View>> map = zzarn.zzdpj;
        JSONObject zza = zzbah.zza(context, map, map, zzarn.zzaat);
        JSONObject zza2 = zzbah.zza(this.zzvr, this.zzgrq.zzaat);
        JSONObject zzt = zzbah.zzt(this.zzgrq.zzaat);
        JSONObject zzb = zzbah.zzb(this.zzvr, this.zzgrq.zzaat);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zza);
        jSONObject.put("ad_view_signal", zza2);
        jSONObject.put("scroll_view_signal", zzt);
        jSONObject.put("lock_screen_signal", zzb);
        if (str == "google.afma.nativeAds.getPublisherCustomRenderedClickSignals") {
            jSONObject.put("click_signal", zzbah.zza((String) null, this.zzvr, this.zzfwe, this.zzfwd));
        }
        return zzchc.zzc(str, jSONObject);
    }

    public static /* synthetic */ ArrayList zza(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzk(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zza(uri, "nas", str));
            }
        }
        return arrayList;
    }

    public final /* synthetic */ ArrayList zza(List list, IObjectWrapper iObjectWrapper) throws Exception {
        String zza = this.zzflj.zzca() != null ? this.zzflj.zzca().zza(this.zzvr, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null) : "";
        if (!TextUtils.isEmpty(zza)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (!zzk(uri)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    zzbbd.zzfe(sb.toString());
                    arrayList.add(uri);
                } else {
                    arrayList.add(zza(uri, "ms", zza));
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new Exception("Empty impression URLs result.");
        }
        throw new Exception("Failed to get view signals.");
    }
}
