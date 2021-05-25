package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.k;
import com.yandex.metrica.impl.ob.p;
import com.yandex.metrica.impl.ob.ve;
import java.util.ArrayList;
import java.util.Arrays;
public class nt implements np<qu, ve.a.d.b> {

    /* renamed from: com.yandex.metrica.impl.ob.nt$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            k.a.values();
            int[] iArr = new int[4];
            b = iArr;
            try {
                k.a aVar = k.a.BACKGROUND;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = b;
                k.a aVar2 = k.a.FOREGROUND;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = b;
                k.a aVar3 = k.a.VISIBLE;
                iArr3[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            p.a.EnumC0340a.values();
            int[] iArr4 = new int[5];
            a = iArr4;
            try {
                p.a.EnumC0340a aVar4 = p.a.EnumC0340a.AC;
                iArr4[4] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = a;
                p.a.EnumC0340a aVar5 = p.a.EnumC0340a.USB;
                iArr5[2] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = a;
                p.a.EnumC0340a aVar6 = p.a.EnumC0340a.WIRELESS;
                iArr6[3] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = a;
                p.a.EnumC0340a aVar7 = p.a.EnumC0340a.NONE;
                iArr7[1] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @NonNull
    private k.a b(int i) {
        if (i == 0) {
            return k.a.BACKGROUND;
        }
        if (i == 1) {
            return k.a.FOREGROUND;
        }
        if (i != 2) {
            return k.a.UNKNOWN;
        }
        return k.a.VISIBLE;
    }

    @NonNull
    /* renamed from: a */
    public ve.a.d.b b(@NonNull qu quVar) {
        ve.a.d.b bVar = new ve.a.d.b();
        bVar.b = new int[quVar.a.size()];
        int i = 0;
        int i2 = 0;
        for (p.a.EnumC0340a aVar : quVar.a) {
            bVar.b[i2] = a(aVar);
            i2++;
        }
        bVar.c = new int[quVar.b.size()];
        for (k.a aVar2 : quVar.b) {
            bVar.c[i] = a(aVar2);
            i++;
        }
        return bVar;
    }

    @NonNull
    public qu a(@NonNull ve.a.d.b bVar) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (bVar.b.length != 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = bVar.b;
                if (i2 >= iArr.length) {
                    break;
                }
                arrayList.add(a(iArr[i2]));
                i2++;
            }
        } else {
            arrayList.addAll(Arrays.asList(p.a.EnumC0340a.values()));
        }
        ArrayList arrayList2 = new ArrayList();
        if (bVar.c.length != 0) {
            while (true) {
                int[] iArr2 = bVar.c;
                if (i >= iArr2.length) {
                    break;
                }
                arrayList2.add(b(iArr2[i]));
                i++;
            }
        } else {
            arrayList2.addAll(Arrays.asList(k.a.values()));
        }
        return new qu(arrayList, arrayList2);
    }

    private int a(@NonNull p.a.EnumC0340a aVar) {
        int i = AnonymousClass1.a[aVar.ordinal()];
        if (i == 1) {
            return 3;
        }
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? 4 : 0;
        }
        return 2;
    }

    @NonNull
    private p.a.EnumC0340a a(int i) {
        if (i == 0) {
            return p.a.EnumC0340a.NONE;
        }
        if (i == 1) {
            return p.a.EnumC0340a.USB;
        }
        if (i == 2) {
            return p.a.EnumC0340a.WIRELESS;
        }
        if (i != 3) {
            return p.a.EnumC0340a.UNKNOWN;
        }
        return p.a.EnumC0340a.AC;
    }

    private int a(@NonNull k.a aVar) {
        int i = AnonymousClass1.b[aVar.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 3 : 2;
        }
        return 1;
    }
}
