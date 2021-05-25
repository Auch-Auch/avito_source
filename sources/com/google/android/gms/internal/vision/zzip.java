package com.google.android.gms.internal.vision;
/* JADX WARN: Init of enum zzyz can be incorrect */
/* JADX WARN: Init of enum zzzg can be incorrect */
public enum zzip {
    VOID(Void.class, Void.class, null),
    INT(r1, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzgs.class, zzgs.class, zzgs.zztt),
    ENUM(r1, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzzi;
    private final Class<?> zzzj;
    private final Object zzzk;

    /* access modifiers changed from: public */
    static {
        Class cls = Integer.TYPE;
    }

    private zzip(Class cls, Class cls2, Object obj) {
        this.zzzi = cls;
        this.zzzj = cls2;
        this.zzzk = obj;
    }

    public final Class<?> zzhq() {
        return this.zzzj;
    }
}
