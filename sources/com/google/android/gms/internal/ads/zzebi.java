package com.google.android.gms.internal.ads;

import kotlin.text.Typography;
public enum zzebi implements zzegu {
    UNKNOWN_CURVE(0),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    CURVE25519(5),
    UNRECOGNIZED(-1);
    
    private static final zzegt<zzebi> zzes = new zzebk();
    private final int value;

    private zzebi(int i) {
        this.value = i;
    }

    public static zzebi zzfb(int i) {
        if (i == 0) {
            return UNKNOWN_CURVE;
        }
        if (i == 2) {
            return NIST_P256;
        }
        if (i == 3) {
            return NIST_P384;
        }
        if (i == 4) {
            return NIST_P521;
        }
        if (i != 5) {
            return null;
        }
        return CURVE25519;
    }

    @Override // java.lang.Enum, java.lang.Object
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(zzebi.class.getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != UNRECOGNIZED) {
            sb.append(" number=");
            sb.append(zzv());
        }
        sb.append(" name=");
        sb.append(name());
        sb.append(Typography.greater);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzegu
    public final int zzv() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
