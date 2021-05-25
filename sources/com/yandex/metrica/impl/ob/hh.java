package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.al;
import java.util.LinkedList;
public class hh extends hi<hu> {
    private final ie a;
    private final jd b;
    private final ia c;

    /* renamed from: com.yandex.metrica.impl.ob.hh$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            al.a.values();
            int[] iArr = new int[43];
            a = iArr;
            try {
                al.a aVar = al.a.EVENT_TYPE_START;
                iArr[34] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = a;
                al.a aVar2 = al.a.EVENT_TYPE_INIT;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = a;
                al.a aVar3 = al.a.EVENT_TYPE_UPDATE_FOREGROUND_TIME;
                iArr3[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public hh(fe feVar) {
        this.a = new ie(feVar);
        this.b = new jd(feVar);
        this.c = new ia(feVar);
    }

    @Override // com.yandex.metrica.impl.ob.hi
    public hf<hu> a(int i) {
        LinkedList linkedList = new LinkedList();
        int i2 = AnonymousClass1.a[al.a.a(i).ordinal()];
        if (i2 == 1) {
            linkedList.add(this.b);
            linkedList.add(this.a);
        } else if (i2 == 2) {
            linkedList.add(this.a);
        } else if (i2 == 3) {
            linkedList.add(this.c);
        }
        return new he(linkedList);
    }
}
