package com.google.android.gms.internal.mlkit_vision_common;
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
public enum zzhn {
    DOUBLE(zzhu.DOUBLE, 1),
    FLOAT(zzhu.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzhu.BOOLEAN, 0),
    STRING(zzhu.STRING, 2) {
    },
    GROUP(r13, 3) {
    },
    MESSAGE(r13, 2) {
    },
    BYTES(zzhu.BYTE_STRING, 2) {
    },
    UINT32(r11, 0),
    ENUM(zzhu.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzhu zzs;
    private final int zzt;

    /* access modifiers changed from: public */
    static {
        zzhu zzhu = zzhu.LONG;
        zzhu zzhu2 = zzhu.INT;
        zzhu zzhu3 = zzhu.MESSAGE;
    }

    private zzhn(zzhu zzhu, int i) {
        this.zzs = zzhu;
        this.zzt = i;
    }

    public final zzhu zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* access modifiers changed from: public */
    /* synthetic */ zzhn(zzhu zzhu, int i, zzho zzho) {
        this(zzhu, i);
    }
}
