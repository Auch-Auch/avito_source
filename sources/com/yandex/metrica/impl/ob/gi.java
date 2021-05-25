package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.CounterConfiguration;
public class gi {

    /* renamed from: com.yandex.metrica.impl.ob.gi$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            CounterConfiguration.a.values();
            int[] iArr = new int[6];
            a = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[4] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[5] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[1] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[2] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @NonNull
    public gh a(@NonNull ge geVar) {
        switch (AnonymousClass1.a[geVar.e().ordinal()]) {
            case 1:
                return new go();
            case 2:
                return new gm();
            case 3:
                return new gt();
            case 4:
                return new gu();
            case 5:
                return new gq();
            case 6:
                return new gd();
            default:
                return new gm();
        }
    }
}
