package com.google.android.gms.internal.mlkit_common;
public enum zzja {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzep.zza),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzj;

    private zzja(Object obj) {
        this.zzj = obj;
    }
}
