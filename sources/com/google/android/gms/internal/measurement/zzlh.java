package com.google.android.gms.internal.measurement;
/* JADX WARN: Init of enum zzc can be incorrect */
/* JADX WARN: Init of enum zzd can be incorrect */
/* JADX WARN: Init of enum zze can be incorrect */
/* JADX WARN: Init of enum zzf can be incorrect */
/* JADX WARN: Init of enum zzg can be incorrect */
/* JADX WARN: Init of enum zzj can be incorrect */
/* JADX WARN: Init of enum zzk can be incorrect */
/* JADX WARN: Init of enum zzm can be incorrect */
/* JADX WARN: Init of enum zzo can be incorrect */
/* JADX WARN: Init of enum zzp can be incorrect */
/* JADX WARN: Init of enum zzq can be incorrect */
/* JADX WARN: Init of enum zzr can be incorrect */
public enum zzlh {
    DOUBLE(zzlo.DOUBLE, 1),
    FLOAT(zzlo.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzlo.BOOLEAN, 0),
    STRING(zzlo.STRING, 2) {
    },
    GROUP(r13, 3) {
    },
    MESSAGE(r13, 2) {
    },
    BYTES(zzlo.BYTE_STRING, 2) {
    },
    UINT32(r11, 0),
    ENUM(zzlo.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzlo zzs;
    private final int zzt;

    /* access modifiers changed from: public */
    static {
        zzlo zzlo = zzlo.LONG;
        zzlo zzlo2 = zzlo.INT;
        zzlo zzlo3 = zzlo.MESSAGE;
    }

    private zzlh(zzlo zzlo, int i) {
        this.zzs = zzlo;
        this.zzt = i;
    }

    public final zzlo zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* access modifiers changed from: public */
    /* synthetic */ zzlh(zzlo zzlo, int i, zzli zzli) {
        this(zzlo, i);
    }
}
