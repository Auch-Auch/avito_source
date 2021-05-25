package com.google.android.gms.internal.mlkit_common;
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
public enum zzix {
    DOUBLE(zzja.DOUBLE, 1),
    FLOAT(zzja.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzja.BOOLEAN, 0),
    STRING(zzja.STRING, 2) {
    },
    GROUP(r13, 3) {
    },
    MESSAGE(r13, 2) {
    },
    BYTES(zzja.BYTE_STRING, 2) {
    },
    UINT32(r11, 0),
    ENUM(zzja.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzja zzs;
    private final int zzt;

    /* access modifiers changed from: public */
    static {
        zzja zzja = zzja.LONG;
        zzja zzja2 = zzja.INT;
        zzja zzja3 = zzja.MESSAGE;
    }

    private zzix(zzja zzja, int i) {
        this.zzs = zzja;
        this.zzt = i;
    }

    public final zzja zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* access modifiers changed from: public */
    /* synthetic */ zzix(zzja zzja, int i, zziu zziu) {
        this(zzja, i);
    }
}
