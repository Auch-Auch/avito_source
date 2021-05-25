package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.m;
import com.yandex.metrica.impl.ob.uz;
public class nf implements nh<m, uz.a.C0347a> {

    /* renamed from: com.yandex.metrica.impl.ob.nf$1  reason: invalid class name */
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

    @NonNull
    /* renamed from: a */
    public uz.a.C0347a b(@NonNull m mVar) {
        uz.a.C0347a aVar = new uz.a.C0347a();
        m.a aVar2 = mVar.a;
        if (aVar2 != null) {
            int i = AnonymousClass1.a[aVar2.ordinal()];
            if (i == 1) {
                aVar.b = 1;
            } else if (i == 2) {
                aVar.b = 2;
            } else if (i == 3) {
                aVar.b = 3;
            } else if (i == 4) {
                aVar.b = 4;
            }
        }
        Boolean bool = mVar.b;
        if (bool != null) {
            if (bool.booleanValue()) {
                aVar.c = 1;
            } else {
                aVar.c = 0;
            }
        }
        return aVar;
    }

    @NonNull
    public m a(@NonNull uz.a.C0347a aVar) {
        m.a aVar2;
        int i = aVar.b;
        Boolean bool = null;
        if (i == 1) {
            aVar2 = m.a.ACTIVE;
        } else if (i == 2) {
            aVar2 = m.a.WORKING_SET;
        } else if (i == 3) {
            aVar2 = m.a.FREQUENT;
        } else if (i != 4) {
            aVar2 = null;
        } else {
            aVar2 = m.a.RARE;
        }
        int i2 = aVar.c;
        if (i2 == 0) {
            bool = Boolean.FALSE;
        } else if (i2 == 1) {
            bool = Boolean.TRUE;
        }
        return new m(aVar2, bool);
    }
}
