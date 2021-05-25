package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.m;
public class j {

    /* renamed from: com.yandex.metrica.impl.ob.j$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            m.a.values();
            int[] iArr = new int[4];
            a = iArr;
            try {
                m.a aVar = m.a.ACTIVE;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = a;
                m.a aVar2 = m.a.WORKING_SET;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = a;
                m.a aVar3 = m.a.FREQUENT;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = a;
                m.a aVar4 = m.a.RARE;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @TargetApi(28)
    @Nullable
    private m.a b(int i) {
        if (i == 10) {
            return m.a.ACTIVE;
        }
        if (i == 20) {
            return m.a.WORKING_SET;
        }
        if (i == 30) {
            return m.a.FREQUENT;
        }
        if (i != 40) {
            return null;
        }
        return m.a.RARE;
    }

    @Nullable
    public m.a a(int i) {
        if (dl.a(28)) {
            return b(i);
        }
        return null;
    }

    @Nullable
    public String a(@Nullable m.a aVar) {
        if (aVar == null) {
            return null;
        }
        int i = AnonymousClass1.a[aVar.ordinal()];
        if (i == 1) {
            return "ACTIVE";
        }
        if (i == 2) {
            return "WORKING_SET";
        }
        if (i == 3) {
            return "FREQUENT";
        }
        if (i != 4) {
            return null;
        }
        return "RARE";
    }
}
