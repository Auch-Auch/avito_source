package com.google.android.gms.internal.measurement;
public enum zzlo {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzgt.zza),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzj;

    private zzlo(Object obj) {
        this.zzj = obj;
    }
}
