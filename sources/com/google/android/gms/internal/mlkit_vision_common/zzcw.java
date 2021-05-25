package com.google.android.gms.internal.mlkit_vision_common;

import kotlin.text.Typography;
public enum zzcw implements zzel {
    UNRECOGNIZED(0),
    CODE_128(1),
    CODE_39(2),
    CODE_93(3),
    CODABAR(4),
    DATA_MATRIX(5),
    EAN_13(6),
    EAN_8(7),
    ITF(8),
    QR_CODE(9),
    UPC_A(10),
    UPC_E(11),
    PDF417(12),
    AZTEC(13),
    DATABAR(14),
    TEZ_CODE(16);
    
    private static final zzeo<zzcw> zzq = new zzcy();
    private final int zzr;

    private zzcw(int i) {
        this.zzr = i;
    }

    public static zzen zzb() {
        return zzcx.zza;
    }

    @Override // java.lang.Enum, java.lang.Object
    public final String toString() {
        return "<" + zzcw.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzr + " name=" + name() + Typography.greater;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
    public final int zza() {
        return this.zzr;
    }
}
