package com.google.android.gms.internal.vision;

import java.lang.reflect.Type;
/* JADX WARN: Init of enum zzvg can be incorrect */
/* JADX WARN: Init of enum zzvh can be incorrect */
/* JADX WARN: Init of enum zzvi can be incorrect */
/* JADX WARN: Init of enum zzvj can be incorrect */
/* JADX WARN: Init of enum zzvk can be incorrect */
/* JADX WARN: Init of enum zzvl can be incorrect */
/* JADX WARN: Init of enum zzvm can be incorrect */
/* JADX WARN: Init of enum zzvn can be incorrect */
/* JADX WARN: Init of enum zzvo can be incorrect */
/* JADX WARN: Init of enum zzvp can be incorrect */
/* JADX WARN: Init of enum zzvq can be incorrect */
/* JADX WARN: Init of enum zzvr can be incorrect */
/* JADX WARN: Init of enum zzvs can be incorrect */
/* JADX WARN: Init of enum zzvt can be incorrect */
/* JADX WARN: Init of enum zzvu can be incorrect */
/* JADX WARN: Init of enum zzvv can be incorrect */
/* JADX WARN: Init of enum zzvw can be incorrect */
/* JADX WARN: Init of enum zzvx can be incorrect */
/* JADX WARN: Init of enum zzvy can be incorrect */
/* JADX WARN: Init of enum zzvz can be incorrect */
/* JADX WARN: Init of enum zzwa can be incorrect */
/* JADX WARN: Init of enum zzwb can be incorrect */
/* JADX WARN: Init of enum zzwc can be incorrect */
/* JADX WARN: Init of enum zzwd can be incorrect */
/* JADX WARN: Init of enum zzwe can be incorrect */
/* JADX WARN: Init of enum zzwf can be incorrect */
/* JADX WARN: Init of enum zzwg can be incorrect */
/* JADX WARN: Init of enum zzwh can be incorrect */
/* JADX WARN: Init of enum zzwi can be incorrect */
/* JADX WARN: Init of enum zzwj can be incorrect */
/* JADX WARN: Init of enum zzwk can be incorrect */
/* JADX WARN: Init of enum zzwl can be incorrect */
/* JADX WARN: Init of enum zzwm can be incorrect */
/* JADX WARN: Init of enum zzwn can be incorrect */
/* JADX WARN: Init of enum zzwo can be incorrect */
/* JADX WARN: Init of enum zzwp can be incorrect */
/* JADX WARN: Init of enum zzwq can be incorrect */
/* JADX WARN: Init of enum zzwr can be incorrect */
/* JADX WARN: Init of enum zzws can be incorrect */
/* JADX WARN: Init of enum zzwt can be incorrect */
/* JADX WARN: Init of enum zzwu can be incorrect */
/* JADX WARN: Init of enum zzwv can be incorrect */
/* JADX WARN: Init of enum zzww can be incorrect */
/* JADX WARN: Init of enum zzwx can be incorrect */
/* JADX WARN: Init of enum zzwy can be incorrect */
/* JADX WARN: Init of enum zzwz can be incorrect */
/* JADX WARN: Init of enum zzxa can be incorrect */
/* JADX WARN: Init of enum zzxb can be incorrect */
/* JADX WARN: Init of enum zzxc can be incorrect */
/* JADX WARN: Init of enum zzxd can be incorrect */
public enum zzhy {
    DOUBLE(0, r7, r8),
    FLOAT(1, r7, r9),
    INT64(2, r7, r10),
    UINT64(3, r7, r10),
    INT32(4, r7, r11),
    FIXED64(5, r7, r10),
    FIXED32(6, r7, r11),
    BOOL(7, r7, r12),
    STRING(8, r7, r13),
    MESSAGE(9, r7, r14),
    BYTES(10, r7, r15),
    UINT32(11, r7, r11),
    ENUM(12, r7, r16),
    SFIXED32(13, r7, r11),
    SFIXED64(14, r7, r10),
    SINT32(15, r7, r11),
    SINT64(16, r7, r10),
    GROUP(17, r7, r14),
    DOUBLE_LIST(18, r7, r8),
    FLOAT_LIST(19, r7, r9),
    INT64_LIST(20, r7, r10),
    UINT64_LIST(21, r7, r10),
    INT32_LIST(22, r7, r11),
    FIXED64_LIST(23, r7, r10),
    FIXED32_LIST(24, r7, r11),
    BOOL_LIST(25, r7, r12),
    STRING_LIST(26, r7, r13),
    MESSAGE_LIST(27, r7, r14),
    BYTES_LIST(28, r7, r15),
    UINT32_LIST(29, r7, r11),
    ENUM_LIST(30, r7, r16),
    SFIXED32_LIST(31, r7, r11),
    SFIXED64_LIST(32, r7, r10),
    SINT32_LIST(33, r7, r11),
    SINT64_LIST(34, r7, r10),
    DOUBLE_LIST_PACKED(35, r13, r8),
    FLOAT_LIST_PACKED(36, r13, r9),
    INT64_LIST_PACKED(37, r13, r10),
    UINT64_LIST_PACKED(38, r13, r10),
    INT32_LIST_PACKED(39, r13, r11),
    FIXED64_LIST_PACKED(40, r13, r10),
    FIXED32_LIST_PACKED(41, r13, r11),
    BOOL_LIST_PACKED(42, r13, r12),
    UINT32_LIST_PACKED(43, r13, r11),
    ENUM_LIST_PACKED(44, r13, r16),
    SFIXED32_LIST_PACKED(45, r13, r11),
    SFIXED64_LIST_PACKED(46, r13, r8),
    SINT32_LIST_PACKED(47, r13, zzip.INT),
    SINT64_LIST_PACKED(48, r13, r8),
    GROUP_LIST(49, r7, r14),
    MAP(50, zzia.MAP, zzip.VOID);
    
    private static final zzhy[] zzxj = new zzhy[51];
    private static final Type[] zzxk = new Type[0];
    private final int id;
    private final zzip zzxf;
    private final zzia zzxg;
    private final Class<?> zzxh;
    private final boolean zzxi;

    /* access modifiers changed from: public */
    static {
        zzia zzia = zzia.SCALAR;
        zzip zzip = zzip.DOUBLE;
        zzip zzip2 = zzip.FLOAT;
        zzip zzip3 = zzip.LONG;
        zzip zzip4 = zzip.INT;
        zzip zzip5 = zzip.BOOLEAN;
        zzip zzip6 = zzip.STRING;
        zzip zzip7 = zzip.MESSAGE;
        zzip zzip8 = zzip.BYTE_STRING;
        zzip zzip9 = zzip.ENUM;
        zzia zzia2 = zzia.VECTOR;
        zzia zzia3 = zzia.PACKED_VECTOR;
        zzip zzip10 = zzip.LONG;
        zzhy[] values = values();
        for (zzhy zzhy : values) {
            zzxj[zzhy.id] = zzhy;
        }
    }

    private zzhy(int i, zzia zzia, zzip zzip) {
        int i2;
        this.id = i;
        this.zzxg = zzia;
        this.zzxf = zzip;
        int i3 = zzhx.zzve[zzia.ordinal()];
        boolean z = true;
        if (i3 == 1) {
            this.zzxh = zzip.zzhq();
        } else if (i3 != 2) {
            this.zzxh = null;
        } else {
            this.zzxh = zzip.zzhq();
        }
        this.zzxi = (zzia != zzia.SCALAR || (i2 = zzhx.zzvf[zzip.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    public final int id() {
        return this.id;
    }
}
