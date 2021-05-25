package com.google.android.gms.internal.ads;

import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzcfj {
    private final Executor executor;
    private final zzbbg zzbpa;
    private final zzadm zzdla;
    private final zzto zzelx;
    private final zzeg zzenn;
    private final ScheduledExecutorService zzflf;
    private final zzcfe zzgbl;
    private final zzb zzgbm;
    private final zzcga zzgbn;
    private final Context zzvr;

    public zzcfj(Context context, zzcfe zzcfe, zzeg zzeg, zzbbg zzbbg, zzb zzb, zzto zzto, Executor executor2, zzdln zzdln, zzcga zzcga, ScheduledExecutorService scheduledExecutorService) {
        this.zzvr = context;
        this.zzgbl = zzcfe;
        this.zzenn = zzeg;
        this.zzbpa = zzbbg;
        this.zzgbm = zzb;
        this.zzelx = zzto;
        this.executor = executor2;
        this.zzdla = zzdln.zzdla;
        this.zzgbn = zzcga;
        this.zzflf = scheduledExecutorService;
    }

    private final zzdvt<List<zzadi>> zza(@Nullable JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzdvl.zzaf(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zza(jSONArray.optJSONObject(i), z));
        }
        return zzdvl.zzb(zzdvl.zzi(arrayList), zzcfm.zzdwg, this.executor);
    }

    private static Integer zzf(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt(g.a), jSONObject2.getInt(AuthSource.BOOKING_ORDER)));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static List<zzzc> zzj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(Tracker.Events.CREATIVE_MUTE);
        if (optJSONObject == null) {
            return Collections.emptyList();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzzc zzl = zzl(optJSONArray.optJSONObject(i));
            if (zzl != null) {
                arrayList.add(zzl);
            }
        }
        return arrayList;
    }

    @Nullable
    public static zzzc zzk(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject(Tracker.Events.CREATIVE_MUTE);
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzl(optJSONObject);
    }

    @Nullable
    private static zzzc zzl(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzzc(optString, optString2);
    }

    public final /* synthetic */ zzdvt zzb(String str, Object obj) throws Exception {
        zzp.zzkq();
        zzbfq zza = zzbfy.zza(this.zzvr, zzbhj.zzacu(), "native-omid", false, false, this.zzenn, null, this.zzbpa, null, null, this.zzgbm, this.zzelx, null, false);
        zzbbr zzl = zzbbr.zzl(zza);
        zza.zzabe().zza(new zzbhf(zzl) { // from class: com.google.android.gms.internal.ads.zzcfr
            private final zzbbr zzenh;

            {
                this.zzenh = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbhf
            public final void zzak(boolean z) {
                this.zzenh.zzys();
            }
        });
        zza.loadData(str, "text/html", "UTF-8");
        return zzl;
    }

    public final zzdvt<zzadi> zzc(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONObject(str), this.zzdla.zzdcs);
    }

    public final zzdvt<List<zzadi>> zzd(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        zzadm zzadm = this.zzdla;
        return zza(optJSONArray, zzadm.zzdcs, zzadm.zzbnl);
    }

    public final zzdvt<zzadd> zze(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzdvl.zzaf(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zza(optJSONObject.optBoolean("require"), zzdvl.zzb(zza(optJSONArray, false, true), new zzdsl(this, optJSONObject) { // from class: com.google.android.gms.internal.ads.zzcfo
            private final JSONObject zzfmf;
            private final zzcfj zzgbr;

            {
                this.zzgbr = r1;
                this.zzfmf = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzdsl
            public final Object apply(Object obj) {
                return this.zzgbr.zza(this.zzfmf, (List) obj);
            }
        }, this.executor), (Object) null);
    }

    public final zzdvt<zzbfq> zzm(JSONObject jSONObject) {
        JSONObject zza = zzbab.zza(jSONObject, "html_containers", "instream");
        if (zza == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("video");
            if (optJSONObject == null) {
                return zzdvl.zzaf(null);
            }
            if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
                zzbbd.zzfe("Required field 'vast_xml' is missing");
                return zzdvl.zzaf(null);
            }
            return zza(zzdvl.zza(this.zzgbn.zzn(optJSONObject), (long) ((Integer) zzwe.zzpu().zzd(zzaat.zzcrn)).intValue(), TimeUnit.SECONDS, this.zzflf), (Object) null);
        }
        zzdvt<zzbfq> zzo = this.zzgbn.zzo(zza.optString("base_url"), zza.optString("html"));
        return zzdvl.zzb(zzo, new zzduv(zzo) { // from class: com.google.android.gms.internal.ads.zzcfq
            private final zzdvt zzgbt;

            {
                this.zzgbt = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                zzdvt zzdvt = this.zzgbt;
                zzbfq zzbfq = (zzbfq) obj;
                if (zzbfq != null && zzbfq.zzzo() != null) {
                    return zzdvt;
                }
                throw new zzcuh(zzdmd.zzhco, "Retrieve video view in instream ad response failed.");
            }
        }, zzbbi.zzedz);
    }

    private final zzdvt<zzadi> zza(@Nullable JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzdvl.zzaf(null);
        }
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return zzdvl.zzaf(null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, -1);
        int optInt2 = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, -1);
        if (z) {
            return zzdvl.zzaf(new zzadi(null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zza(jSONObject.optBoolean("require"), zzdvl.zzb(this.zzgbl.zza(optString, optDouble, optBoolean), new zzdsl(optString, optDouble, optInt, optInt2) { // from class: com.google.android.gms.internal.ads.zzcfl
            private final String zzdgb;
            private final int zzeay;
            private final int zzeaz;
            private final double zzgbq;

            {
                this.zzdgb = r1;
                this.zzgbq = r2;
                this.zzeay = r4;
                this.zzeaz = r5;
            }

            @Override // com.google.android.gms.internal.ads.zzdsl
            public final Object apply(Object obj) {
                String str = this.zzdgb;
                return new zzadi(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.zzgbq, this.zzeay, this.zzeaz);
            }
        }, this.executor), (Object) null);
    }

    private static <T> zzdvt<T> zza(zzdvt<T> zzdvt, T t) {
        return zzdvl.zzb(zzdvt, Exception.class, new zzduv(null) { // from class: com.google.android.gms.internal.ads.zzcfp
            private final Object zzgbs;

            {
                this.zzgbs = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                Object obj2 = this.zzgbs;
                zzaxy.zza("Error during loading assets.", (Exception) obj);
                return zzdvl.zzaf(obj2);
            }
        }, zzbbi.zzedz);
    }

    private static <T> zzdvt<T> zza(boolean z, zzdvt<T> zzdvt, T t) {
        if (z) {
            return zzdvl.zzb(zzdvt, new zzduv(zzdvt) { // from class: com.google.android.gms.internal.ads.zzcfs
                private final zzdvt zzgbt;

                {
                    this.zzgbt = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzduv
                public final zzdvt zzf(Object obj) {
                    zzdvt zzdvt2 = this.zzgbt;
                    if (obj != null) {
                        return zzdvt2;
                    }
                    return zzdvl.immediateFailedFuture(new zzcuh(zzdmd.zzhco, "Retrieve required value in native ad response failed."));
                }
            }, zzbbi.zzedz);
        }
        return zza(zzdvt, (Object) null);
    }

    public final /* synthetic */ zzadd zza(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer zzf = zzf(jSONObject, "bg_color");
        Integer zzf2 = zzf(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        return new zzadd(optString, list, zzf, zzf2, num, optInt3 + optInt2, this.zzdla.zzbnm, optBoolean);
    }
}
