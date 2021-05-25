package com.google.android.gms.internal.ads;
/* JADX WARN: Init of enum zzigq can be incorrect */
/* JADX WARN: Init of enum zzigx can be incorrect */
public enum zzehb {
    VOID(Void.class, Void.class, null),
    INT(r1, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzeff.class, zzeff.class, zzeff.zzibd),
    ENUM(r1, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzigz;
    private final Class<?> zziha;
    private final Object zzihb;

    /* access modifiers changed from: public */
    static {
        Class cls = Integer.TYPE;
    }

    private zzehb(Class cls, Class cls2, Object obj) {
        this.zzigz = cls;
        this.zziha = cls2;
        this.zzihb = obj;
    }

    public final Class<?> zzbgk() {
        return this.zziha;
    }
}
