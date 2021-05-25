package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.CounterConfiguration;
public class cy {
    @NonNull
    private final String a;
    @NonNull
    private final Context b;
    @Nullable
    private final CounterConfiguration.a c;
    @NonNull
    private final da d;

    /* renamed from: com.yandex.metrica.impl.ob.cy$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            CounterConfiguration.a.values();
            int[] iArr = new int[6];
            a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public cy(@NonNull String str, @NonNull Context context, @NonNull CounterConfiguration.a aVar, @NonNull da daVar) {
        this.a = str;
        this.b = context;
        int i = AnonymousClass1.a[aVar.ordinal()];
        if (i == 1) {
            this.c = CounterConfiguration.a.SELF_DIAGNOSTIC_MAIN;
        } else if (i != 2) {
            this.c = null;
        } else {
            this.c = CounterConfiguration.a.SELF_DIAGNOSTIC_MANUAL;
        }
        this.d = daVar;
    }

    public void a(@NonNull aa aaVar) {
        if (this.c != null) {
            try {
                CounterConfiguration counterConfiguration = new CounterConfiguration(this.a);
                counterConfiguration.a(this.c);
                this.d.a(aaVar.a(new co(new eu(this.b, (ResultReceiver) null), counterConfiguration).b()));
            } catch (Throwable unused) {
            }
        }
    }
}
