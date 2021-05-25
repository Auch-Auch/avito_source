package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.am;
public final class ju {

    /* renamed from: com.yandex.mobile.ads.impl.ju$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            am.a.values();
            int[] iArr = new int[4];
            a = iArr;
            try {
                am.a aVar = am.a.FIXED;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = a;
                am.a aVar2 = am.a.STICKY;
                iArr2[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = a;
                am.a aVar3 = am.a.FLEXIBLE;
                iArr3[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = a;
                am.a aVar4 = am.a.SCREEN;
                iArr4[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static boolean a(@NonNull Context context, @Nullable am amVar) {
        return a(context, amVar, eg.c(context), eg.d(context));
    }

    public static boolean b(@NonNull Context context, @Nullable am amVar) {
        return a(context, amVar, eg.d(context), eg.c(context));
    }

    private static boolean a(@NonNull Context context, @Nullable am amVar, int i, int i2) {
        if (amVar != null) {
            int b = amVar.b(context);
            int a = amVar.a(context);
            if (b <= i && a <= i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(@NonNull Context context, @NonNull am amVar, @NonNull am amVar2) {
        int b = amVar2.b(context);
        int a = amVar2.a(context);
        int b2 = amVar.b(context);
        int a3 = amVar.a(context);
        int i = AnonymousClass1.a[amVar2.c().ordinal()];
        return (i == 1 ? !(b2 > b || b <= 0 || a3 > a) : !(i == 2 || i == 3 ? b2 > b || b <= 0 || (a3 > a && a != 0) : i != 4)) && a(context, amVar);
    }
}
