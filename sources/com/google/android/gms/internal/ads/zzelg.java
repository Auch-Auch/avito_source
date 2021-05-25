package com.google.android.gms.internal.ads;
public abstract class zzelg {
    public static zzelg zzn(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzekz(cls.getSimpleName());
        }
        return new zzelb(cls.getSimpleName());
    }

    public abstract void zzik(String str);
}
