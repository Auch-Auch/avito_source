package com.google.android.gms.internal.mlkit_vision_face;

import java.lang.reflect.Type;
/* JADX WARN: Init of enum zzc can be incorrect */
/* JADX WARN: Init of enum zzd can be incorrect */
/* JADX WARN: Init of enum zze can be incorrect */
/* JADX WARN: Init of enum zzf can be incorrect */
/* JADX WARN: Init of enum zzg can be incorrect */
/* JADX WARN: Init of enum zzh can be incorrect */
/* JADX WARN: Init of enum zzi can be incorrect */
/* JADX WARN: Init of enum zzj can be incorrect */
/* JADX WARN: Init of enum zzk can be incorrect */
/* JADX WARN: Init of enum zzl can be incorrect */
/* JADX WARN: Init of enum zzm can be incorrect */
/* JADX WARN: Init of enum zzn can be incorrect */
/* JADX WARN: Init of enum zzo can be incorrect */
/* JADX WARN: Init of enum zzp can be incorrect */
/* JADX WARN: Init of enum zzq can be incorrect */
/* JADX WARN: Init of enum zzr can be incorrect */
/* JADX WARN: Init of enum zzs can be incorrect */
/* JADX WARN: Init of enum zzt can be incorrect */
/* JADX WARN: Init of enum zzu can be incorrect */
/* JADX WARN: Init of enum zzv can be incorrect */
/* JADX WARN: Init of enum zzw can be incorrect */
/* JADX WARN: Init of enum zzx can be incorrect */
/* JADX WARN: Init of enum zzy can be incorrect */
/* JADX WARN: Init of enum zzz can be incorrect */
/* JADX WARN: Init of enum zzaa can be incorrect */
/* JADX WARN: Init of enum zzab can be incorrect */
/* JADX WARN: Init of enum zzac can be incorrect */
/* JADX WARN: Init of enum zzad can be incorrect */
/* JADX WARN: Init of enum zzae can be incorrect */
/* JADX WARN: Init of enum zzaf can be incorrect */
/* JADX WARN: Init of enum zzag can be incorrect */
/* JADX WARN: Init of enum zzah can be incorrect */
/* JADX WARN: Init of enum zzai can be incorrect */
/* JADX WARN: Init of enum zzaj can be incorrect */
/* JADX WARN: Init of enum zzak can be incorrect */
/* JADX WARN: Init of enum zza can be incorrect */
/* JADX WARN: Init of enum zzal can be incorrect */
/* JADX WARN: Init of enum zzam can be incorrect */
/* JADX WARN: Init of enum zzan can be incorrect */
/* JADX WARN: Init of enum zzao can be incorrect */
/* JADX WARN: Init of enum zzap can be incorrect */
/* JADX WARN: Init of enum zzaq can be incorrect */
/* JADX WARN: Init of enum zzar can be incorrect */
/* JADX WARN: Init of enum zzas can be incorrect */
/* JADX WARN: Init of enum zzat can be incorrect */
/* JADX WARN: Init of enum zzau can be incorrect */
/* JADX WARN: Init of enum zzav can be incorrect */
/* JADX WARN: Init of enum zzaw can be incorrect */
/* JADX WARN: Init of enum zzb can be incorrect */
/* JADX WARN: Init of enum zzax can be incorrect */
public enum zzga {
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
    SINT32_LIST_PACKED(47, r13, zzgn.INT),
    SINT64_LIST_PACKED(48, r13, r8),
    GROUP_LIST(49, r7, r14),
    MAP(50, zzgc.MAP, zzgn.VOID);
    
    private static final zzga[] zzbe = new zzga[51];
    private static final Type[] zzbf = new Type[0];
    private final zzgn zzaz;
    private final int zzba;
    private final zzgc zzbb;
    private final Class<?> zzbc;
    private final boolean zzbd;

    /* access modifiers changed from: public */
    static {
        zzgc zzgc = zzgc.SCALAR;
        zzgn zzgn = zzgn.DOUBLE;
        zzgn zzgn2 = zzgn.FLOAT;
        zzgn zzgn3 = zzgn.LONG;
        zzgn zzgn4 = zzgn.INT;
        zzgn zzgn5 = zzgn.BOOLEAN;
        zzgn zzgn6 = zzgn.STRING;
        zzgn zzgn7 = zzgn.MESSAGE;
        zzgn zzgn8 = zzgn.BYTE_STRING;
        zzgn zzgn9 = zzgn.ENUM;
        zzgc zzgc2 = zzgc.VECTOR;
        zzgc zzgc3 = zzgc.PACKED_VECTOR;
        zzgn zzgn10 = zzgn.LONG;
        zzga[] values = values();
        for (zzga zzga : values) {
            zzbe[zzga.zzba] = zzga;
        }
    }

    private zzga(int i, zzgc zzgc, zzgn zzgn) {
        int i2;
        this.zzba = i;
        this.zzbb = zzgc;
        this.zzaz = zzgn;
        int i3 = zzfz.zza[zzgc.ordinal()];
        boolean z = true;
        if (i3 == 1) {
            this.zzbc = zzgn.zza();
        } else if (i3 != 2) {
            this.zzbc = null;
        } else {
            this.zzbc = zzgn.zza();
        }
        this.zzbd = (zzgc != zzgc.SCALAR || (i2 = zzfz.zzb[zzgn.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    public final int zza() {
        return this.zzba;
    }
}
