package com.google.android.gms.internal.mlkit_common;

import kotlin.text.Typography;
public enum zzef implements zzfv {
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
    
    private static final zzfu<zzef> zzq = new zzee();
    private final int zzr;

    private zzef(int i) {
        this.zzr = i;
    }

    public static zzfx zzb() {
        return zzeh.zza;
    }

    @Override // java.lang.Enum, java.lang.Object
    public final String toString() {
        return "<" + zzef.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzr + " name=" + name() + Typography.greater;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzfv
    public final int zza() {
        return this.zzr;
    }
}
