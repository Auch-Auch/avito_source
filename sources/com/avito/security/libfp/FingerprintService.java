package com.avito.security.libfp;

import android.content.Context;
import com.avito.security.libfp.Application;
import java.util.BitSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
public abstract class FingerprintService {
    public static BitSet a = new BitSet();

    public enum a {
        b(0),
        c(1),
        d(2);
        
        private final int a;

        private a(int i) {
            this.a = i;
        }

        public int a() {
            return this.a;
        }
    }

    static {
        Application.vk(Application.C0170Application.uFGzCfc());
    }

    public static void doProbe(@Nonnull Context context) {
        Application.C0170Application.C0171Application.nxpB(2022749723, null);
    }

    @Nonnull
    public static FingerprintService init(@Nonnull Context context) {
        Application.vk(context);
        Application.C0170Application.C0171Application.nxpB(-275466689, new Object[]{context});
        Object nxpB = Application.C0170Application.C0171Application.nxpB(87078675, new Object[]{1275967038});
        Object rfdkigAIy = Application.C0170Application.C0171Application.rfdkigAIy(-2064271847);
        Object[] objArr = new Object[2];
        objArr[1] = context;
        objArr[0] = rfdkigAIy;
        Application.C0170Application.C0171Application.ekypkbk(nxpB, 241022488, objArr);
        return (FingerprintService) nxpB;
    }

    public static void negativeDebugCheck(Object obj) {
        a.clear(a.c.a());
    }

    public static void negativeEmulatorCheck(Object obj) {
        a.clear(a.d.a());
    }

    public static void negativeRootCheck(Object obj) {
        a.clear(a.b.a());
    }

    public static void positiveDebugCheck(Object obj) {
        a.set(a.c.a());
    }

    public static void positiveEmulatorCheck(Object obj) {
        a.set(a.d.a());
    }

    public static void positiveRootCheck(Object obj) {
        a.set(a.b.a());
    }

    @Nullable
    public abstract String calculateFingerprint();
}
