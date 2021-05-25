package com.google.android.gms.internal.ads;
/* JADX WARN: Init of enum zzilk can be incorrect */
/* JADX WARN: Init of enum zzill can be incorrect */
/* JADX WARN: Init of enum zzilm can be incorrect */
/* JADX WARN: Init of enum zziln can be incorrect */
/* JADX WARN: Init of enum zzilo can be incorrect */
/* JADX WARN: Init of enum zzilr can be incorrect */
/* JADX WARN: Init of enum zzils can be incorrect */
/* JADX WARN: Init of enum zzilu can be incorrect */
/* JADX WARN: Init of enum zzilw can be incorrect */
/* JADX WARN: Init of enum zzilx can be incorrect */
/* JADX WARN: Init of enum zzily can be incorrect */
/* JADX WARN: Init of enum zzilz can be incorrect */
public enum zzeke {
    DOUBLE(zzekh.DOUBLE, 1),
    FLOAT(zzekh.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzekh.BOOLEAN, 0),
    STRING(zzekh.STRING, 2) {
    },
    GROUP(r13, 3) {
    },
    MESSAGE(r13, 2) {
    },
    BYTES(zzekh.BYTE_STRING, 2) {
    },
    UINT32(r11, 0),
    ENUM(zzekh.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzekh zzima;
    private final int zzimb;

    /* access modifiers changed from: public */
    static {
        zzekh zzekh = zzekh.LONG;
        zzekh zzekh2 = zzekh.INT;
        zzekh zzekh3 = zzekh.MESSAGE;
    }

    private zzeke(zzekh zzekh, int i) {
        this.zzima = zzekh;
        this.zzimb = i;
    }

    public final zzekh zzbii() {
        return this.zzima;
    }

    public final int zzbij() {
        return this.zzimb;
    }

    /* access modifiers changed from: public */
    /* synthetic */ zzeke(zzekh zzekh, int i, zzekb zzekb) {
        this(zzekh, i);
    }
}
