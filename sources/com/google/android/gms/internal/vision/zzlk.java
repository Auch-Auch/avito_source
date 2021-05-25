package com.google.android.gms.internal.vision;
/* JADX WARN: Init of enum zzadh can be incorrect */
/* JADX WARN: Init of enum zzadi can be incorrect */
/* JADX WARN: Init of enum zzadj can be incorrect */
/* JADX WARN: Init of enum zzadk can be incorrect */
/* JADX WARN: Init of enum zzadl can be incorrect */
/* JADX WARN: Init of enum zzado can be incorrect */
/* JADX WARN: Init of enum zzadp can be incorrect */
/* JADX WARN: Init of enum zzadr can be incorrect */
/* JADX WARN: Init of enum zzadt can be incorrect */
/* JADX WARN: Init of enum zzadu can be incorrect */
/* JADX WARN: Init of enum zzadv can be incorrect */
/* JADX WARN: Init of enum zzadw can be incorrect */
public enum zzlk {
    DOUBLE(zzlr.DOUBLE, 1),
    FLOAT(zzlr.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzlr.BOOLEAN, 0),
    STRING(zzlr.STRING, 2) {
    },
    GROUP(r13, 3) {
    },
    MESSAGE(r13, 2) {
    },
    BYTES(zzlr.BYTE_STRING, 2) {
    },
    UINT32(r11, 0),
    ENUM(zzlr.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzlr zzadx;
    private final int zzady;

    /* access modifiers changed from: public */
    static {
        zzlr zzlr = zzlr.LONG;
        zzlr zzlr2 = zzlr.INT;
        zzlr zzlr3 = zzlr.MESSAGE;
    }

    private zzlk(zzlr zzlr, int i) {
        this.zzadx = zzlr;
        this.zzady = i;
    }

    public final zzlr zzjk() {
        return this.zzadx;
    }

    public final int zzjl() {
        return this.zzady;
    }

    /* access modifiers changed from: public */
    /* synthetic */ zzlk(zzlr zzlr, int i, zzll zzll) {
        this(zzlr, i);
    }
}
