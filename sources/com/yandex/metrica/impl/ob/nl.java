package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.gpllibrary.a;
import com.yandex.metrica.impl.ob.ve;
public class nl implements np<pw, ve.a.d.C0355a.b.C0358a> {

    /* renamed from: com.yandex.metrica.impl.ob.nl$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            a.b.values();
            int[] iArr = new int[4];
            a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @NonNull
    /* renamed from: a */
    public ve.a.d.C0355a.b.C0358a b(@NonNull pw pwVar) {
        ve.a.d.C0355a.b.C0358a aVar = new ve.a.d.C0355a.b.C0358a();
        aVar.b = pwVar.b;
        aVar.c = pwVar.c;
        aVar.d = a(pwVar.a);
        return aVar;
    }

    @NonNull
    public pw a(@NonNull ve.a.d.C0355a.b.C0358a aVar) {
        return new pw(a(aVar.d), aVar.b, aVar.c);
    }

    private int a(@NonNull a.b bVar) {
        int i = AnonymousClass1.a[bVar.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    return 0;
                }
            }
        }
        return i2;
    }

    @NonNull
    private a.b a(int i) {
        if (i == 1) {
            return a.b.PRIORITY_LOW_POWER;
        }
        if (i == 2) {
            return a.b.PRIORITY_BALANCED_POWER_ACCURACY;
        }
        if (i != 3) {
            return a.b.PRIORITY_NO_POWER;
        }
        return a.b.PRIORITY_HIGH_ACCURACY;
    }
}
