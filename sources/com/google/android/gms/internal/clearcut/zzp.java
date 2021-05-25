package com.google.android.gms.internal.clearcut;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.clearcut.zzgw;
import com.google.android.gms.phenotype.Phenotype;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
public final class zzp implements ClearcutLogger.zza {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final zzao zzaq;
    private static final zzao zzar = new zzao(Phenotype.getContentProviderUri("com.google.android.gms.clearcut.public")).zzc("gms:playlog:service:sampling_").zzd("LogSampling__");
    private static final ConcurrentHashMap<String, zzae<zzgw.zza>> zzas = new ConcurrentHashMap<>();
    private static final HashMap<String, zzae<String>> zzat = new HashMap<>();
    @VisibleForTesting
    private static Boolean zzau = null;
    @VisibleForTesting
    private static Long zzav = null;
    @VisibleForTesting
    private static final zzae<Boolean> zzaw;
    private final Context zzh;

    static {
        zzao zzd = new zzao(Phenotype.getContentProviderUri("com.google.android.gms.clearcut.public")).zzc("gms:playlog:service:samplingrules_").zzd("LogSamplingRules__");
        zzaq = zzd;
        zzaw = zzd.zzc("enable_log_sampling_rules", false);
    }

    public zzp(Context context) {
        this.zzh = context;
        if (context != null) {
            zzae.maybeInit(context);
        }
    }

    @VisibleForTesting
    private static long zza(String str, long j) {
        if (str == null || str.isEmpty()) {
            return zzk.zza(ByteBuffer.allocate(8).putLong(j).array());
        }
        byte[] bytes = str.getBytes(UTF_8);
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 8);
        allocate.put(bytes);
        allocate.putLong(j);
        return zzk.zza(allocate.array());
    }

    @VisibleForTesting
    private static zzgw.zza.zzb zza(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(44);
        int i = 0;
        if (indexOf >= 0) {
            i = indexOf + 1;
            str2 = str.substring(0, indexOf);
        } else {
            str2 = "";
        }
        int indexOf2 = str.indexOf(47, i);
        if (indexOf2 <= 0) {
            if (str.length() != 0) {
                "Failed to parse the rule: ".concat(str);
            } else {
                new String("Failed to parse the rule: ");
            }
            return null;
        }
        try {
            long parseLong = Long.parseLong(str.substring(i, indexOf2));
            long parseLong2 = Long.parseLong(str.substring(indexOf2 + 1));
            if (parseLong < 0 || parseLong2 < 0) {
                return null;
            }
            return (zzgw.zza.zzb) zzgw.zza.zzb.zzfz().zzn(str2).zzr(parseLong).zzs(parseLong2).zzbh();
        } catch (NumberFormatException unused) {
            if (str.length() != 0) {
                "parseLong() failed while parsing: ".concat(str);
            } else {
                new String("parseLong() failed while parsing: ");
            }
            return null;
        }
    }

    @VisibleForTesting
    private static boolean zzb(long j, long j2, long j3) {
        if (j2 < 0 || j3 <= 0) {
            return true;
        }
        if (j < 0) {
            j = ((j & Long.MAX_VALUE) % j3) + (Long.MAX_VALUE % j3) + 1;
        }
        return j % j3 < j2;
    }

    private static boolean zzc(Context context) {
        if (zzau == null) {
            zzau = Boolean.valueOf(Wrappers.packageManager(context).checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return zzau.booleanValue();
    }

    @VisibleForTesting
    private static long zzd(Context context) {
        if (zzav == null) {
            long j = 0;
            if (context == null) {
                return 0;
            }
            if (zzc(context)) {
                j = zzy.getLong(context.getContentResolver(), "android_id", 0);
            }
            zzav = Long.valueOf(j);
        }
        return zzav.longValue();
    }

    @Override // com.google.android.gms.clearcut.ClearcutLogger.zza
    public final boolean zza(zze zze) {
        List<zzgw.zza.zzb> list;
        zzae<zzgw.zza> putIfAbsent;
        zzr zzr = zze.zzag;
        String str = zzr.zzj;
        int i = zzr.zzk;
        zzha zzha = zze.zzaa;
        int i2 = zzha != null ? zzha.zzbji : 0;
        String str2 = null;
        if (!zzaw.get().booleanValue()) {
            if (str == null || str.isEmpty()) {
                str = i >= 0 ? String.valueOf(i) : null;
            }
            if (str == null) {
                return true;
            }
            Context context = this.zzh;
            if (context != null && zzc(context)) {
                HashMap<String, zzae<String>> hashMap = zzat;
                zzae<String> zzae = hashMap.get(str);
                if (zzae == null) {
                    zzae = zzar.zza(str, null);
                    hashMap.put(str, zzae);
                }
                str2 = zzae.get();
            }
            zzgw.zza.zzb zza = zza(str2);
            if (zza != null) {
                return zzb(zza(zza.zzfw(), zzd(this.zzh)), zza.zzfx(), zza.zzfy());
            }
            return true;
        }
        if (str == null || str.isEmpty()) {
            str = i >= 0 ? String.valueOf(i) : null;
        }
        if (str == null) {
            return true;
        }
        if (this.zzh == null) {
            list = Collections.emptyList();
        } else {
            ConcurrentHashMap<String, zzae<zzgw.zza>> concurrentHashMap = zzas;
            zzae<zzgw.zza> zzae2 = concurrentHashMap.get(str);
            if (zzae2 == null && (putIfAbsent = concurrentHashMap.putIfAbsent(str, (zzae2 = zzaq.zza(str, zzgw.zza.zzft(), zzq.zzax)))) != null) {
                zzae2 = putIfAbsent;
            }
            list = zzae2.get().zzfs();
        }
        for (zzgw.zza.zzb zzb : list) {
            if (!zzb.zzfv() || zzb.getEventCode() == 0 || zzb.getEventCode() == i2) {
                if (!zzb(zza(zzb.zzfw(), zzd(this.zzh)), zzb.zzfx(), zzb.zzfy())) {
                    return false;
                }
            }
        }
        return true;
    }
}
