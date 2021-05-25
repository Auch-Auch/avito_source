package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
public class il {
    public static int a = (1 | a);

    public static class a implements Runnable {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ij.ad(this.a).setFlags(il.a);
        }
    }

    static {
        boolean z;
        if (id.eF()) {
            a |= 2;
        }
        try {
            Class.forName("com.unity3d.player.UnityPlayerActivity");
        } catch (Throwable unused) {
            z = false;
        }
        z = true;
        if (z) {
        }
    }

    public static void Q(boolean z) {
        a = z ? a | 16 : a & -17;
    }

    public static void R(boolean z) {
        a = z ? a | 32 : a & -33;
    }

    public static void ae(@NonNull Context context) {
        af.b(new a(context));
    }

    public static int bp() {
        return a;
    }

    public static void fa() {
        a |= 4;
    }

    public static void fb() {
        a |= 8;
    }

    public static void fc() {
        a |= 64;
    }

    public static void fd() {
        a |= 128;
    }

    public static void fe() {
        a &= -3;
    }
}
