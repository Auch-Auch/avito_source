package com.google.android.gms.internal.gtm;

import java.lang.reflect.Type;
/* JADX WARN: Init of enum zzaxs can be incorrect */
/* JADX WARN: Init of enum zzaxt can be incorrect */
/* JADX WARN: Init of enum zzaxu can be incorrect */
/* JADX WARN: Init of enum zzaxv can be incorrect */
/* JADX WARN: Init of enum zzaxw can be incorrect */
/* JADX WARN: Init of enum zzaxx can be incorrect */
/* JADX WARN: Init of enum zzaxy can be incorrect */
/* JADX WARN: Init of enum zzaxz can be incorrect */
/* JADX WARN: Init of enum zzaya can be incorrect */
/* JADX WARN: Init of enum zzayb can be incorrect */
/* JADX WARN: Init of enum zzayc can be incorrect */
/* JADX WARN: Init of enum zzayd can be incorrect */
/* JADX WARN: Init of enum zzaye can be incorrect */
/* JADX WARN: Init of enum zzayf can be incorrect */
/* JADX WARN: Init of enum zzayg can be incorrect */
/* JADX WARN: Init of enum zzayh can be incorrect */
/* JADX WARN: Init of enum zzayi can be incorrect */
/* JADX WARN: Init of enum zzayj can be incorrect */
/* JADX WARN: Init of enum zzayk can be incorrect */
/* JADX WARN: Init of enum zzayl can be incorrect */
/* JADX WARN: Init of enum zzaym can be incorrect */
/* JADX WARN: Init of enum zzayn can be incorrect */
/* JADX WARN: Init of enum zzayo can be incorrect */
/* JADX WARN: Init of enum zzayp can be incorrect */
/* JADX WARN: Init of enum zzayq can be incorrect */
/* JADX WARN: Init of enum zzayr can be incorrect */
/* JADX WARN: Init of enum zzays can be incorrect */
/* JADX WARN: Init of enum zzayt can be incorrect */
/* JADX WARN: Init of enum zzayu can be incorrect */
/* JADX WARN: Init of enum zzayv can be incorrect */
/* JADX WARN: Init of enum zzayw can be incorrect */
/* JADX WARN: Init of enum zzayx can be incorrect */
/* JADX WARN: Init of enum zzayy can be incorrect */
/* JADX WARN: Init of enum zzayz can be incorrect */
/* JADX WARN: Init of enum zzaza can be incorrect */
/* JADX WARN: Init of enum zzazb can be incorrect */
/* JADX WARN: Init of enum zzazc can be incorrect */
/* JADX WARN: Init of enum zzazd can be incorrect */
/* JADX WARN: Init of enum zzaze can be incorrect */
/* JADX WARN: Init of enum zzazf can be incorrect */
/* JADX WARN: Init of enum zzazg can be incorrect */
/* JADX WARN: Init of enum zzazh can be incorrect */
/* JADX WARN: Init of enum zzazi can be incorrect */
/* JADX WARN: Init of enum zzazj can be incorrect */
/* JADX WARN: Init of enum zzazk can be incorrect */
/* JADX WARN: Init of enum zzazl can be incorrect */
/* JADX WARN: Init of enum zzazm can be incorrect */
/* JADX WARN: Init of enum zzazn can be incorrect */
/* JADX WARN: Init of enum zzazo can be incorrect */
/* JADX WARN: Init of enum zzazp can be incorrect */
public enum zzqw {
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
    SINT32_LIST_PACKED(47, r13, zzrm.INT),
    SINT64_LIST_PACKED(48, r13, r8),
    GROUP_LIST(49, r7, r14),
    MAP(50, zzqy.MAP, zzrm.VOID);
    
    private static final zzqw[] zzazv = new zzqw[51];
    private static final Type[] zzazw = new Type[0];
    private final int id;
    private final zzrm zzazr;
    private final zzqy zzazs;
    private final Class<?> zzazt;
    private final boolean zzazu;

    /* access modifiers changed from: public */
    static {
        zzqy zzqy = zzqy.SCALAR;
        zzrm zzrm = zzrm.DOUBLE;
        zzrm zzrm2 = zzrm.FLOAT;
        zzrm zzrm3 = zzrm.LONG;
        zzrm zzrm4 = zzrm.INT;
        zzrm zzrm5 = zzrm.BOOLEAN;
        zzrm zzrm6 = zzrm.STRING;
        zzrm zzrm7 = zzrm.MESSAGE;
        zzrm zzrm8 = zzrm.BYTE_STRING;
        zzrm zzrm9 = zzrm.ENUM;
        zzqy zzqy2 = zzqy.VECTOR;
        zzqy zzqy3 = zzqy.PACKED_VECTOR;
        zzrm zzrm10 = zzrm.LONG;
        zzqw[] values = values();
        for (zzqw zzqw : values) {
            zzazv[zzqw.id] = zzqw;
        }
    }

    private zzqw(int i, zzqy zzqy, zzrm zzrm) {
        int i2;
        this.id = i;
        this.zzazs = zzqy;
        this.zzazr = zzrm;
        int i3 = zzqx.zzazy[zzqy.ordinal()];
        boolean z = true;
        if (i3 == 1) {
            this.zzazt = zzrm.zzpx();
        } else if (i3 != 2) {
            this.zzazt = null;
        } else {
            this.zzazt = zzrm.zzpx();
        }
        this.zzazu = (zzqy != zzqy.SCALAR || (i2 = zzqx.zzazz[zzrm.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    public final int id() {
        return this.id;
    }
}
