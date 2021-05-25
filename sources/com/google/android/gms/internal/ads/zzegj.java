package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;
/* JADX WARN: Init of enum zzicx can be incorrect */
/* JADX WARN: Init of enum zzicy can be incorrect */
/* JADX WARN: Init of enum zzicz can be incorrect */
/* JADX WARN: Init of enum zzida can be incorrect */
/* JADX WARN: Init of enum zzidb can be incorrect */
/* JADX WARN: Init of enum zzidc can be incorrect */
/* JADX WARN: Init of enum zzidd can be incorrect */
/* JADX WARN: Init of enum zzide can be incorrect */
/* JADX WARN: Init of enum zzidf can be incorrect */
/* JADX WARN: Init of enum zzidg can be incorrect */
/* JADX WARN: Init of enum zzidh can be incorrect */
/* JADX WARN: Init of enum zzidi can be incorrect */
/* JADX WARN: Init of enum zzidj can be incorrect */
/* JADX WARN: Init of enum zzidk can be incorrect */
/* JADX WARN: Init of enum zzidl can be incorrect */
/* JADX WARN: Init of enum zzidm can be incorrect */
/* JADX WARN: Init of enum zzidn can be incorrect */
/* JADX WARN: Init of enum zzido can be incorrect */
/* JADX WARN: Init of enum zzidp can be incorrect */
/* JADX WARN: Init of enum zzidq can be incorrect */
/* JADX WARN: Init of enum zzidr can be incorrect */
/* JADX WARN: Init of enum zzids can be incorrect */
/* JADX WARN: Init of enum zzidt can be incorrect */
/* JADX WARN: Init of enum zzidu can be incorrect */
/* JADX WARN: Init of enum zzidv can be incorrect */
/* JADX WARN: Init of enum zzidw can be incorrect */
/* JADX WARN: Init of enum zzidx can be incorrect */
/* JADX WARN: Init of enum zzidy can be incorrect */
/* JADX WARN: Init of enum zzidz can be incorrect */
/* JADX WARN: Init of enum zziea can be incorrect */
/* JADX WARN: Init of enum zzieb can be incorrect */
/* JADX WARN: Init of enum zziec can be incorrect */
/* JADX WARN: Init of enum zzied can be incorrect */
/* JADX WARN: Init of enum zziee can be incorrect */
/* JADX WARN: Init of enum zzief can be incorrect */
/* JADX WARN: Init of enum zzieg can be incorrect */
/* JADX WARN: Init of enum zzieh can be incorrect */
/* JADX WARN: Init of enum zziei can be incorrect */
/* JADX WARN: Init of enum zziej can be incorrect */
/* JADX WARN: Init of enum zziek can be incorrect */
/* JADX WARN: Init of enum zziel can be incorrect */
/* JADX WARN: Init of enum zziem can be incorrect */
/* JADX WARN: Init of enum zzien can be incorrect */
/* JADX WARN: Init of enum zzieo can be incorrect */
/* JADX WARN: Init of enum zziep can be incorrect */
/* JADX WARN: Init of enum zzieq can be incorrect */
/* JADX WARN: Init of enum zzier can be incorrect */
/* JADX WARN: Init of enum zzies can be incorrect */
/* JADX WARN: Init of enum zziet can be incorrect */
/* JADX WARN: Init of enum zzieu can be incorrect */
public enum zzegj {
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
    SINT32_LIST_PACKED(47, r13, zzehb.INT),
    SINT64_LIST_PACKED(48, r13, r8),
    GROUP_LIST(49, r7, r14),
    MAP(50, zzegl.MAP, zzehb.VOID);
    
    private static final zzegj[] zzifa = new zzegj[51];
    private static final Type[] zzifb = new Type[0];
    private final int id;
    private final zzehb zziew;
    private final zzegl zziex;
    private final Class<?> zziey;
    private final boolean zziez;

    /* access modifiers changed from: public */
    static {
        zzegl zzegl = zzegl.SCALAR;
        zzehb zzehb = zzehb.DOUBLE;
        zzehb zzehb2 = zzehb.FLOAT;
        zzehb zzehb3 = zzehb.LONG;
        zzehb zzehb4 = zzehb.INT;
        zzehb zzehb5 = zzehb.BOOLEAN;
        zzehb zzehb6 = zzehb.STRING;
        zzehb zzehb7 = zzehb.MESSAGE;
        zzehb zzehb8 = zzehb.BYTE_STRING;
        zzehb zzehb9 = zzehb.ENUM;
        zzegl zzegl2 = zzegl.VECTOR;
        zzegl zzegl3 = zzegl.PACKED_VECTOR;
        zzehb zzehb10 = zzehb.LONG;
        zzegj[] values = values();
        for (zzegj zzegj : values) {
            zzifa[zzegj.id] = zzegj;
        }
    }

    private zzegj(int i, zzegl zzegl, zzehb zzehb) {
        int i2;
        this.id = i;
        this.zziex = zzegl;
        this.zziew = zzehb;
        int i3 = zzegm.zzifj[zzegl.ordinal()];
        boolean z = true;
        if (i3 == 1) {
            this.zziey = zzehb.zzbgk();
        } else if (i3 != 2) {
            this.zziey = null;
        } else {
            this.zziey = zzehb.zzbgk();
        }
        this.zziez = (zzegl != zzegl.SCALAR || (i2 = zzegm.zzifk[zzehb.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    public final int id() {
        return this.id;
    }
}
