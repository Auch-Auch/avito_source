package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.al;
import java.util.ArrayList;
public class hd extends hi<hk> {
    private final io a;

    /* renamed from: com.yandex.metrica.impl.ob.hd$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            al.a.values();
            int[] iArr = new int[43];
            a = iArr;
            try {
                al.a aVar = al.a.EVENT_TYPE_REFERRER_RECEIVED_FROM_BROADCAST;
                iArr[21] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = a;
                al.a aVar2 = al.a.EVENT_TYPE_STARTUP;
                iArr2[14] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = a;
                al.a aVar3 = al.a.EVENT_TYPE_REFERRER_OBTAINED_FROM_SERVICES;
                iArr3[23] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = a;
                al.a aVar4 = al.a.EVENT_TYPE_UPDATE_PRE_ACTIVATION_CONFIG;
                iArr4[40] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public hd(ey eyVar) {
        this.a = new io(eyVar);
    }

    @Override // com.yandex.metrica.impl.ob.hi
    public hf<hk> a(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = AnonymousClass1.a[al.a.a(i).ordinal()];
        if (i2 == 1) {
            arrayList.add(this.a.a());
        } else if (i2 == 2) {
            arrayList.add(this.a.b());
        } else if (i2 == 3) {
            arrayList.add(this.a.c());
        } else if (i2 == 4) {
            arrayList.add(this.a.d());
        }
        return new he(arrayList);
    }
}
