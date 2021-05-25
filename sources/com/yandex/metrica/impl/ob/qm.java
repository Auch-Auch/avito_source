package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.k;
public class qm {
    @NonNull
    public final ql a;
    @NonNull
    public final qu b;

    /* renamed from: com.yandex.metrica.impl.ob.qm$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            k.a.values();
            int[] iArr = new int[4];
            a = iArr;
            try {
                k.a aVar = k.a.VISIBLE;
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = a;
                k.a aVar2 = k.a.FOREGROUND;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = a;
                k.a aVar3 = k.a.BACKGROUND;
                iArr3[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum a {
        UNKNOWN("unknown"),
        FOREGROUND("fg"),
        BACKGROUND("bg"),
        VISIBLE("visible");
        
        private final String e;

        private a(String str) {
            this.e = str;
        }

        @NonNull
        public String a() {
            return this.e;
        }

        @Override // java.lang.Enum, java.lang.Object
        @NonNull
        public String toString() {
            return this.e;
        }

        @NonNull
        public static a a(@Nullable String str) {
            a aVar = UNKNOWN;
            a[] values = values();
            for (int i = 0; i < 4; i++) {
                a aVar2 = values[i];
                if (aVar2.e.equals(str)) {
                    aVar = aVar2;
                }
            }
            return aVar;
        }

        @NonNull
        public static a a(@Nullable k.a aVar) {
            a aVar2 = UNKNOWN;
            if (aVar == null) {
                return aVar2;
            }
            int i = AnonymousClass1.a[aVar.ordinal()];
            if (i == 1) {
                return VISIBLE;
            }
            if (i == 2) {
                return FOREGROUND;
            }
            if (i != 3) {
                return aVar2;
            }
            return BACKGROUND;
        }
    }

    public qm(@NonNull ql qlVar, @NonNull qu quVar) {
        this.a = qlVar;
        this.b = quVar;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("LocationCollectionConfig{arguments=");
        L.append(this.a);
        L.append(", preconditions=");
        L.append(this.b);
        L.append('}');
        return L.toString();
    }
}
