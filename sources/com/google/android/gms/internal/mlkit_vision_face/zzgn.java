package com.google.android.gms.internal.mlkit_vision_face;
/* JADX WARN: Init of enum zzb can be incorrect */
/* JADX WARN: Init of enum zzi can be incorrect */
public enum zzgn {
    VOID(Void.class, Void.class, null),
    INT(r1, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzez.class, zzez.class, zzez.zza),
    ENUM(r1, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzk;
    private final Class<?> zzl;
    private final Object zzm;

    /* access modifiers changed from: public */
    static {
        Class cls = Integer.TYPE;
    }

    private zzgn(Class cls, Class cls2, Object obj) {
        this.zzk = cls;
        this.zzl = cls2;
        this.zzm = obj;
    }

    public final Class<?> zza() {
        return this.zzl;
    }
}
