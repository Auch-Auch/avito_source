package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanSettings;
import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.xi;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
@TargetApi(21)
public class ea {
    private static final Map<xi.b.d, Integer> a;

    /* renamed from: com.yandex.metrica.impl.ob.ea$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            xi.b.c.values();
            int[] iArr = new int[3];
            b = iArr;
            try {
                xi.b.c cVar = xi.b.c.ONE_AD;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = b;
                xi.b.c cVar2 = xi.b.c.FEW_AD;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            xi.b.a.values();
            int[] iArr3 = new int[3];
            a = iArr3;
            try {
                xi.b.a aVar = xi.b.a.MATCH_LOST;
                iArr3[2] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = a;
                xi.b.a aVar2 = xi.b.a.FIRST_MATCH;
                iArr4[1] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(xi.b.d.LOW_POWER, 0);
        hashMap.put(xi.b.d.BALANCED, 1);
        hashMap.put(xi.b.d.LOW_LATENCY, 2);
        a = Collections.unmodifiableMap(hashMap);
    }

    @NonNull
    public ScanSettings a(@NonNull xi.b bVar) {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        builder.setScanMode(a(bVar.d));
        builder.setReportDelay(bVar.e);
        if (dl.a(23)) {
            builder.setCallbackType(a(bVar.a));
            builder.setMatchMode(a(bVar.b));
            builder.setNumOfMatches(a(bVar.c));
        }
        return builder.build();
    }

    private int a(@NonNull xi.b.d dVar) {
        Integer num = a.get(dVar);
        if (num == null) {
            return 2;
        }
        return num.intValue();
    }

    @TargetApi(23)
    private int a(@NonNull xi.b.a aVar) {
        int i = AnonymousClass1.a[aVar.ordinal()];
        if (i != 1) {
            return i != 2 ? 1 : 2;
        }
        return 4;
    }

    @TargetApi(23)
    private int a(@NonNull xi.b.EnumC0364b bVar) {
        return xi.b.EnumC0364b.AGGRESSIVE.equals(bVar) ? 1 : 2;
    }

    @TargetApi(23)
    private int a(@NonNull xi.b.c cVar) {
        int i = AnonymousClass1.b[cVar.ordinal()];
        if (i != 1) {
            return i != 2 ? 3 : 2;
        }
        return 1;
    }
}
