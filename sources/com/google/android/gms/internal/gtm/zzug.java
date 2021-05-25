package com.google.android.gms.internal.gtm;
/* JADX WARN: Init of enum zzbfr can be incorrect */
/* JADX WARN: Init of enum zzbfs can be incorrect */
/* JADX WARN: Init of enum zzbft can be incorrect */
/* JADX WARN: Init of enum zzbfu can be incorrect */
/* JADX WARN: Init of enum zzbfv can be incorrect */
/* JADX WARN: Init of enum zzbfy can be incorrect */
/* JADX WARN: Init of enum zzbfz can be incorrect */
/* JADX WARN: Init of enum zzbgb can be incorrect */
/* JADX WARN: Init of enum zzbgd can be incorrect */
/* JADX WARN: Init of enum zzbge can be incorrect */
/* JADX WARN: Init of enum zzbgf can be incorrect */
/* JADX WARN: Init of enum zzbgg can be incorrect */
public enum zzug {
    DOUBLE(zzul.DOUBLE, 1),
    FLOAT(zzul.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzul.BOOLEAN, 0),
    STRING(zzul.STRING, 2) {
    },
    GROUP(r13, 3) {
    },
    MESSAGE(r13, 2) {
    },
    BYTES(zzul.BYTE_STRING, 2) {
    },
    UINT32(r11, 0),
    ENUM(zzul.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzul zzbgh;
    private final int zzbgi;

    /* access modifiers changed from: public */
    static {
        zzul zzul = zzul.LONG;
        zzul zzul2 = zzul.INT;
        zzul zzul3 = zzul.MESSAGE;
    }

    private zzug(zzul zzul, int i) {
        this.zzbgh = zzul;
        this.zzbgi = i;
    }

    public final zzul zzrs() {
        return this.zzbgh;
    }

    public final int zzrt() {
        return this.zzbgi;
    }

    /* access modifiers changed from: public */
    /* synthetic */ zzug(zzul zzul, int i, zzuf zzuf) {
        this(zzul, i);
    }
}
