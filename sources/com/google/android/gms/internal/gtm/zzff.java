package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import android.content.Context;
import android.os.RemoteException;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomMasterTable;
import com.avito.android.advert.item.AdvertDetailsPresenterKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcm;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ru.ok.android.sdk.Shared;
@VisibleForTesting
public final class zzff {
    private final String zzaec;
    private int zzaka;
    private final zzcm zzamx;
    private final zzcd zzanh;
    private final zznm zzaov;
    private final zzfl zzaow;
    private final zzok zzaox;
    private final zzok zzaoy;
    private final Set<String> zzaoz = new HashSet();
    private zzkz zzapa;
    private zzee zzapb;
    private final zzfj zzapc;
    private final Context zzrm;

    @VisibleForTesting
    public zzff(Context context, String str, zznm zznm, zznu zznu, zzcm zzcm, zzcd zzcd) {
        zzfl zzfl = new zzfl();
        this.zzaow = zzfl;
        zzok zzok = new zzok(new HashMap(50));
        this.zzaox = zzok;
        zzok zzok2 = new zzok(new HashMap(10));
        this.zzaoy = zzok2;
        zzfg zzfg = new zzfg(this);
        this.zzapc = zzfg;
        Preconditions.checkNotNull(zznm, "Internal Error: Container resource cannot be null");
        Preconditions.checkNotNull(zznu, "Internal Error: Runtime resource cannot be null");
        Preconditions.checkNotEmpty(str, "Internal Error: ContainerId cannot be empty");
        Preconditions.checkNotNull(zzcm);
        Preconditions.checkNotNull(zzcd);
        this.zzrm = context;
        this.zzaec = str;
        this.zzaov = zznm;
        this.zzamx = zzcm;
        this.zzanh = zzcd;
        zzfl.zza("1", new zzof(new zzhy()));
        zzfl.zza("12", new zzof(new zzhz()));
        zzfl.zza("18", new zzof(new zzia()));
        zzfl.zza("19", new zzof(new zzib()));
        zzfl.zza("20", new zzof(new zzic()));
        zzfl.zza("21", new zzof(new zzid()));
        zzfl.zza("23", new zzof(new zzie()));
        zzfl.zza("24", new zzof(new zzif()));
        zzfl.zza("27", new zzof(new zzig()));
        zzfl.zza("28", new zzof(new zzih()));
        zzfl.zza("29", new zzof(new zzii()));
        zzfl.zza("30", new zzof(new zzij()));
        zzfl.zza("32", new zzof(new zzik()));
        zzfl.zza("33", new zzof(new zzik()));
        zzfl.zza("34", new zzof(new zzil()));
        zzfl.zza("35", new zzof(new zzil()));
        zzfl.zza("39", new zzof(new zzim()));
        zzfl.zza("40", new zzof(new zzin()));
        zzfl.zza("0", new zzof(new zzjk()));
        zzfl.zza("10", new zzof(new zzjl()));
        zzfl.zza("25", new zzof(new zzjm()));
        zzfl.zza("26", new zzof(new zzjn()));
        zzfl.zza("37", new zzof(new zzjo()));
        zzfl.zza(ExifInterface.GPS_MEASUREMENT_2D, new zzof(new zzio()));
        zzfl.zza(ExifInterface.GPS_MEASUREMENT_3D, new zzof(new zzip()));
        zzfl.zza("4", new zzof(new zziq()));
        zzfl.zza("5", new zzof(new zzir()));
        zzfl.zza("6", new zzof(new zzis()));
        zzfl.zza("7", new zzof(new zzit()));
        zzfl.zza("8", new zzof(new zziu()));
        zzfl.zza(AdvertDetailsPresenterKt.AUTO_CATEGORY_ID, new zzof(new zzir()));
        zzfl.zza("13", new zzof(new zziv()));
        zzfl.zza("47", new zzof(new zziw()));
        zzfl.zza("15", new zzof(new zzix()));
        zzfl.zza("48", new zzof(new zziy(this)));
        zziz zziz = new zziz();
        zzfl.zza("16", new zzof(zziz));
        zzfl.zza("17", new zzof(zziz));
        zzfl.zza("22", new zzof(new zzjb()));
        zzfl.zza("45", new zzof(new zzjc()));
        zzfl.zza("46", new zzof(new zzjd()));
        zzfl.zza("36", new zzof(new zzje()));
        zzfl.zza("43", new zzof(new zzjf()));
        zzfl.zza("38", new zzof(new zzjg()));
        zzfl.zza("44", new zzof(new zzjh()));
        zzfl.zza("41", new zzof(new zzji()));
        zzfl.zza(RoomMasterTable.DEFAULT_ID, new zzof(new zzjj()));
        zza(zza.CONTAINS, new zzlw());
        zza(zza.ENDS_WITH, new zzlx());
        zza(zza.EQUALS, new zzly());
        zza(zza.GREATER_EQUALS, new zzlz());
        zza(zza.GREATER_THAN, new zzma());
        zza(zza.LESS_EQUALS, new zzmb());
        zza(zza.LESS_THAN, new zzmc());
        zza(zza.REGEX, new zzme());
        zza(zza.STARTS_WITH, new zzmf());
        zzok.zzc("advertiserId", new zzof(new zzkp(context)));
        zzok.zzc("advertiserTrackingEnabled", new zzof(new zzkq(context)));
        zzok.zzc("adwordsClickReferrer", new zzof(new zzkr(context, zzfg)));
        zzok.zzc("applicationId", new zzof(new zzks(context)));
        zzok.zzc("applicationName", new zzof(new zzkt(context)));
        zzok.zzc("applicationVersion", new zzof(new zzku(context)));
        zzok.zzc("applicationVersionName", new zzof(new zzkv(context)));
        zzok.zzc("arbitraryPixieMacro", new zzof(new zzkm(1, zzfl)));
        zzok.zzc("carrier", new zzof(new zzkw(context)));
        zzok.zzc("constant", new zzof(new zzje()));
        zzok.zzc("containerId", new zzof(new zzkx(new zzom(str))));
        zzok.zzc("containerVersion", new zzof(new zzkx(new zzom(zznm.getVersion()))));
        zzok.zzc("customMacro", new zzof(new zzkk(new zzfi(this, null))));
        zzok.zzc("deviceBrand", new zzof(new zzla()));
        zzok.zzc("deviceId", new zzof(new zzlb(context)));
        zzok.zzc("deviceModel", new zzof(new zzlc()));
        zzok.zzc("deviceName", new zzof(new zzld()));
        zzok.zzc("encode", new zzof(new zzle()));
        zzok.zzc("encrypt", new zzof(new zzlf()));
        zzok.zzc("event", new zzof(new zzky()));
        zzok.zzc("eventParameters", new zzof(new zzlg(zzfg)));
        zzok.zzc("version", new zzof(new zzlh()));
        zzok.zzc("hashcode", new zzof(new zzli()));
        zzok.zzc("installReferrer", new zzof(new zzlj(context)));
        zzok.zzc("join", new zzof(new zzlk()));
        zzok.zzc("language", new zzof(new zzll()));
        zzok.zzc("locale", new zzof(new zzlm()));
        zzok.zzc("adWordsUniqueId", new zzof(new zzlo(context)));
        zzok.zzc("osVersion", new zzof(new zzlp()));
        zzok.zzc(Shared.PARAM_PLATFORM, new zzof(new zzlq()));
        zzok.zzc("random", new zzof(new zzlr()));
        zzok.zzc("regexGroup", new zzof(new zzls()));
        zzok.zzc("resolution", new zzof(new zzlu(context)));
        zzok.zzc("runtimeVersion", new zzof(new zzlt()));
        zzok.zzc("sdkVersion", new zzof(new zzlv()));
        this.zzapa = new zzkz();
        zzok.zzc("currentTime", new zzof(this.zzapa));
        zzok.zzc("userProperty", new zzof(new zzln(context, zzfg)));
        zzok.zzc("arbitraryPixel", new zzof(new zzmi(zzec.zzp(context))));
        zzok.zzc("customTag", new zzof(new zzkk(new zzfh(this, null))));
        zzok.zzc("universalAnalytics", new zzof(new zzmj(context, zzfg)));
        zzok.zzc("queueRequest", new zzof(new zzmg(zzec.zzp(context))));
        zzok.zzc("sendMeasurement", new zzof(new zzmh(zzcm, zzfg)));
        zzok.zzc("arbitraryPixieTag", new zzof(new zzkm(0, zzfl)));
        zzok.zzc("suppressPassthrough", new zzof(new zzko(context, zzfg)));
        zzok2.zzc("decodeURI", new zzof(new zzkf()));
        zzok2.zzc("decodeURIComponent", new zzof(new zzkg()));
        zzok2.zzc("encodeURI", new zzof(new zzkh()));
        zzok2.zzc("encodeURIComponent", new zzof(new zzki()));
        zzok2.zzc("log", new zzof(new zzkn()));
        zzok2.zzc("isArray", new zzof(new zzkj()));
        for (zzgy zzgy : zznu.zzmb()) {
            zzgy.zza(this.zzaow);
            this.zzaow.zza(zzgy.getName(), new zzof(zzgy));
        }
        zzok zzok3 = new zzok(new HashMap(1));
        zzok3.zzc("mobile", this.zzaox);
        zzok3.zzc("common", this.zzaoy);
        this.zzaow.zza("gtmUtils", zzok3);
        zzok zzok4 = new zzok(new HashMap(this.zzaox.value()));
        zzok4.zzmi();
        zzok zzok5 = new zzok(new HashMap(this.zzaoy.value()));
        zzok5.zzmi();
        if (this.zzaow.has("main") && (this.zzaow.zzca("main") instanceof zzof)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzok3);
            zzoo.zza(this.zzaow, new zzol("main", arrayList));
        }
        this.zzaox.zzc("base", zzok4);
        this.zzaoy.zzc("base", zzok5);
        zzok3.zzmi();
        this.zzaox.zzmi();
        this.zzaoy.zzmi();
    }

    private final void zza(zza zza, zzgz zzgz) {
        this.zzaox.zzc(zzgw.zza(zza), new zzof(zzgz));
    }

    private final zzoa<?> zzby(String str) {
        this.zzaka++;
        String zzjg = zzjg();
        StringBuilder sb = new StringBuilder(a.q0(str, a.q0(zzjg, 31)));
        sb.append(zzjg);
        sb.append("Beginning to evaluate variable ");
        sb.append(str);
        zzev.zzab(sb.toString());
        if (!this.zzaoz.contains(str)) {
            this.zzaoz.add(str);
            zzno zzck = this.zzaov.zzck(str);
            if (zzck != null) {
                zzoa<?> zzi = zzi(zzh(zzck.zzlu()));
                String zzjg2 = zzjg();
                StringBuilder sb2 = new StringBuilder(a.q0(str, a.q0(zzjg2, 25)));
                sb2.append(zzjg2);
                sb2.append("Done evaluating variable ");
                sb2.append(str);
                zzev.zzab(sb2.toString());
                this.zzaka--;
                this.zzaoz.remove(str);
                return zzi;
            }
            this.zzaka--;
            this.zzaoz.remove(str);
            String zzjg3 = zzjg();
            throw new IllegalStateException(a.s2(a.q0(str, a.q0(zzjg3, 36)), zzjg3, "Attempting to resolve unknown macro ", str));
        }
        this.zzaka--;
        String obj = this.zzaoz.toString();
        throw new IllegalStateException(a.t2(a.q0(obj, a.q0(str, 77)), "Macro cycle detected.  Current macro reference: ", str, ". Previous macro references: ", obj));
    }

    private static String zzbz(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            zzev.zza("Escape URI: unsupported encoding", e);
            return str;
        }
    }

    private final zzol zzd(String str, Map<String, zzoa<?>> map) {
        try {
            return zzgw.zza(str, map, this.zzaow);
        } catch (RuntimeException e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + String.valueOf(str).length() + 30);
            sb.append("Incorrect keys for function ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzev.zzav(sb.toString());
            return null;
        }
    }

    private final Map<String, zzoa<?>> zzh(Map<String, zznx> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, zznx> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), zza(entry.getValue()));
        }
        return hashMap;
    }

    private final zzoa zzi(Map<String, zzoa<?>> map) {
        zzol zzol;
        if (map == null) {
            zzea.zza("executeFunctionCall: cannot access the function parameters.", this.zzrm);
            return zzog.zzaum;
        }
        zzoa<?> zzoa = map.get(zzb.FUNCTION.toString());
        if (!(zzoa instanceof zzom)) {
            zzea.zza("No function id in properties", this.zzrm);
            return zzog.zzaum;
        }
        String str = (String) ((zzom) zzoa).value();
        if (this.zzaow.has(str)) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, zzoa<?>> entry : map.entrySet()) {
                if (entry.getKey().startsWith("vtp_")) {
                    hashMap.put(entry.getKey().substring(4), entry.getValue());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new zzok(hashMap));
            zzol = new zzol(str, arrayList);
        } else {
            String zzcc = zzgw.zzcc(str);
            if (zzcc != null && this.zzaox.zzcn(zzcc)) {
                zzol = zzd(str, map);
            } else {
                zzea.zza(a.s2(a.q0(str, 30), "functionId '", str, "' is not supported"), this.zzrm);
                return zzog.zzaum;
            }
        }
        if (zzol == null) {
            zzea.zza("Internal error: failed to convert function to a valid statement", this.zzrm);
            return zzog.zzaum;
        }
        String valueOf = String.valueOf(zzol.zzmj());
        zzev.zzab(valueOf.length() != 0 ? "Executing: ".concat(valueOf) : new String("Executing: "));
        zzoa zza = zzoo.zza(this.zzaow, zzol);
        if (!(zza instanceof zzog)) {
            return zza;
        }
        zzog zzog = (zzog) zza;
        return zzog.zzmh() ? zzog.value() : zza;
    }

    private final String zzjg() {
        if (this.zzaka <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.zzaka));
        for (int i = 2; i < this.zzaka; i++) {
            sb.append(' ');
        }
        sb.append(": ");
        return sb.toString();
    }

    public final void dispatch() {
        zzec.zzp(this.zzrm).dispatch();
    }

    public final void zzb(zzee zzee) {
        boolean z;
        IllegalStateException e;
        zzoa<?> zzod;
        this.zzaow.zza("gtm.globals.eventName", new zzom(zzee.zzkf()));
        this.zzapa.zza(zzee);
        this.zzapb = zzee;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashMap hashMap = new HashMap();
        for (zznr zznr : this.zzaov.zzls()) {
            if (!zznr.zzly().isEmpty() || !zznr.zzlz().isEmpty()) {
                String valueOf = String.valueOf(zznr);
                StringBuilder sb = new StringBuilder(valueOf.length() + 19);
                sb.append("Evaluating trigger ");
                sb.append(valueOf);
                zzev.zzab(sb.toString());
                Iterator<zzno> it = zznr.zzlx().iterator();
                while (true) {
                    if (it.hasNext()) {
                        zzno next = it.next();
                        zzoa<?> zzoa = (zzoa) hashMap.get(next);
                        if (zzoa == null) {
                            zzoa = zza(next);
                            hashMap.put(next, zzoa);
                        }
                        zzod = zzog.zzaul;
                        if (zzoa != zzod) {
                            if (((Boolean) ((zzod) zzoa).value()).booleanValue()) {
                                zzod = new zzod(Boolean.FALSE);
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        Iterator<zzno> it2 = zznr.zzlw().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                zzod = new zzod(Boolean.TRUE);
                                break;
                            }
                            zzno next2 = it2.next();
                            zzoa<?> zzoa2 = (zzoa) hashMap.get(next2);
                            if (zzoa2 == null) {
                                zzoa2 = zza(next2);
                                hashMap.put(next2, zzoa2);
                            }
                            zzod = zzog.zzaul;
                            if (zzoa2 != zzod) {
                                if (!((Boolean) ((zzod) zzoa2).value()).booleanValue()) {
                                    zzod = new zzod(Boolean.FALSE);
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
                if (zzod == zzog.zzaul) {
                    String valueOf2 = String.valueOf(zznr);
                    zzea.zzb(a.r2(valueOf2.length() + 41, "Error encounted while evaluating trigger ", valueOf2), this.zzrm);
                    if (!zznr.zzlz().isEmpty()) {
                        String valueOf3 = String.valueOf(zznr.zzlz());
                        StringBuilder sb2 = new StringBuilder(valueOf3.length() + 15);
                        sb2.append("Blocking tags: ");
                        sb2.append(valueOf3);
                        zzev.zzab(sb2.toString());
                        hashSet2.addAll(zznr.zzlz());
                    }
                } else if (((Boolean) ((zzod) zzod).value()).booleanValue()) {
                    String valueOf4 = String.valueOf(zznr);
                    StringBuilder sb3 = new StringBuilder(valueOf4.length() + 19);
                    sb3.append("Trigger is firing: ");
                    sb3.append(valueOf4);
                    zzev.zzab(sb3.toString());
                    if (!zznr.zzly().isEmpty()) {
                        String valueOf5 = String.valueOf(zznr.zzly());
                        StringBuilder sb4 = new StringBuilder(valueOf5.length() + 34);
                        sb4.append("Adding tags to firing candidates: ");
                        sb4.append(valueOf5);
                        zzev.zzab(sb4.toString());
                        hashSet.addAll(zznr.zzly());
                    }
                    if (!zznr.zzlz().isEmpty()) {
                        String valueOf6 = String.valueOf(zznr.zzlz());
                        StringBuilder sb5 = new StringBuilder(valueOf6.length() + 24);
                        sb5.append("Blocking disabled tags: ");
                        sb5.append(valueOf6);
                        zzev.zzab(sb5.toString());
                        hashSet2.addAll(zznr.zzlz());
                    }
                }
            } else {
                String valueOf7 = String.valueOf(zznr);
                StringBuilder sb6 = new StringBuilder(valueOf7.length() + 64);
                sb6.append("Trigger is not being evaluated since it has no associated tags: ");
                sb6.append(valueOf7);
                zzev.zzab(sb6.toString());
            }
        }
        hashSet.removeAll(hashSet2);
        Iterator it3 = hashSet.iterator();
        boolean z2 = false;
        while (it3.hasNext()) {
            zzno zzno = (zzno) it3.next();
            this.zzaoz.clear();
            String valueOf8 = String.valueOf(zzno);
            StringBuilder sb7 = new StringBuilder(valueOf8.length() + 21);
            sb7.append("Executing firing tag ");
            sb7.append(valueOf8);
            zzev.zzab(sb7.toString());
            try {
                zzi(zzh(zzno.zzlu()));
                zznx zznx = zzno.zzlu().get(zzb.DISPATCH_ON_FIRE.toString());
                if (zznx != null && zznx.getType() == 8 && ((Boolean) zznx.getValue()).booleanValue()) {
                    try {
                        String valueOf9 = String.valueOf(zzno);
                        StringBuilder sb8 = new StringBuilder(valueOf9.length() + 36);
                        sb8.append("Tag configured to dispatch on fire: ");
                        sb8.append(valueOf9);
                        zzev.zzab(sb8.toString());
                        z2 = true;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        z = true;
                    }
                }
            } catch (IllegalStateException e3) {
                z = z2;
                e = e3;
                String valueOf10 = String.valueOf(zzno);
                zzea.zza(a.s2(valueOf10.length() + 19, "Error firing tag ", valueOf10, ": "), e, this.zzrm);
                z2 = z;
            }
        }
        this.zzaow.remove("gtm.globals.eventName");
        if (zzee.zzki()) {
            String zzkf = zzee.zzkf();
            StringBuilder sb9 = new StringBuilder(a.q0(zzkf, 35));
            sb9.append("Log passthrough event ");
            sb9.append(zzkf);
            sb9.append(" to Firebase.");
            zzev.zzab(sb9.toString());
            try {
                this.zzamx.logEventInternalNoInterceptor(zzee.zzkh(), zzee.zzkf(), zzee.zzkg(), zzee.currentTimeMillis());
            } catch (RemoteException e4) {
                zzea.zza("Error calling measurement proxy: ", e4, this.zzrm);
            }
        } else {
            String zzkf2 = zzee.zzkf();
            StringBuilder sb10 = new StringBuilder(a.q0(zzkf2, 63));
            sb10.append("Non-passthrough event ");
            sb10.append(zzkf2);
            sb10.append(" doesn't get logged to Firebase directly.");
            zzev.zzab(sb10.toString());
        }
        if (z2) {
            zzev.zzab("Dispatch called for dispatchOnFire tags.");
            dispatch();
        }
    }

    public final zzoa<?> zzbx(String str) {
        if (!this.zzaoz.contains(str)) {
            this.zzaka = 0;
            return zzby(str);
        }
        String obj = this.zzaoz.toString();
        throw new IllegalStateException(a.t2(a.q0(obj, a.q0(str, 77)), "Macro cycle detected.  Current macro reference: ", str, ". Previous macro references: ", obj));
    }

    private final zzoa<?> zza(zznx zznx) {
        switch (zznx.getType()) {
            case 1:
                try {
                    return new zzoe(Double.valueOf(Double.parseDouble((String) zznx.getValue())));
                } catch (NumberFormatException unused) {
                    return new zzom((String) zznx.getValue());
                }
            case 2:
                List<zznx> list = (List) zznx.getValue();
                ArrayList arrayList = new ArrayList(list.size());
                for (zznx zznx2 : list) {
                    arrayList.add(zza(zznx2));
                }
                return new zzoh(arrayList);
            case 3:
                Map map = (Map) zznx.getValue();
                HashMap hashMap = new HashMap(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    zzoa<?> zza = zza((zznx) entry.getKey());
                    hashMap.put(zzha.zzd(zza), zza((zznx) entry.getValue()));
                }
                return new zzok(hashMap);
            case 4:
                zzoa<?> zzby = zzby((String) zznx.getValue());
                if (!(zzby instanceof zzom) || zznx.zzmd().isEmpty()) {
                    return zzby;
                }
                String str = (String) ((zzom) zzby).value();
                for (Integer num : zznx.zzmd()) {
                    int intValue = num.intValue();
                    if (intValue != 12) {
                        StringBuilder sb = new StringBuilder(39);
                        sb.append("Unsupported Value Escaping: ");
                        sb.append(intValue);
                        zzev.zzav(sb.toString());
                    } else {
                        str = zzbz(str);
                    }
                }
                return new zzom(str);
            case 5:
                return new zzom((String) zznx.getValue());
            case 6:
                return new zzoe(Double.valueOf(((Integer) zznx.getValue()).doubleValue()));
            case 7:
                StringBuilder sb2 = new StringBuilder();
                for (zznx zznx3 : (List) zznx.getValue()) {
                    sb2.append(zzha.zzd(zza(zznx3)));
                }
                return new zzom(sb2.toString());
            case 8:
                return new zzod((Boolean) zznx.getValue());
            default:
                throw new IllegalStateException(a.o2(52, "Attempting to expand unknown Value type ", zznx.getType(), "."));
        }
    }

    @VisibleForTesting
    private final zzoa<?> zza(zzno zzno) {
        this.zzaoz.clear();
        try {
            zzoa<?> zzi = zzi(zzh(zzno.zzlu()));
            if (zzi instanceof zzod) {
                return zzi;
            }
            zzea.zza("Predicate must return a boolean value", this.zzrm);
            return new zzod(Boolean.FALSE);
        } catch (IllegalStateException unused) {
            zzev.zzav("Error evaluating predicate.");
            return zzog.zzaul;
        }
    }
}
