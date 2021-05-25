package com.yandex.metrica.impl.ob;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
public class p implements fg {
    public static final a.EnumC0340a a = a.EnumC0340a.UNKNOWN;
    @NonNull
    private final Context b;
    @Nullable
    private volatile a c;
    private final List<b> d = new ArrayList();
    private final BroadcastReceiver e = new BroadcastReceiver() { // from class: com.yandex.metrica.impl.ob.p.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a.EnumC0340a aVar;
            a aVar2 = p.this.c;
            if (aVar2 == null) {
                aVar = null;
            } else {
                aVar = aVar2.b;
            }
            a a3 = p.this.a(intent);
            p.this.c = a3;
            if (aVar != a3.b) {
                p.this.e();
            }
        }
    };

    public static class a {
        @Nullable
        public final Integer a;
        @NonNull
        public final EnumC0340a b;

        /* renamed from: com.yandex.metrica.impl.ob.p$a$a  reason: collision with other inner class name */
        public enum EnumC0340a {
            UNKNOWN(-1),
            NONE(0),
            USB(1),
            WIRELESS(2),
            AC(3);
            
            private final int f;

            private EnumC0340a(int i) {
                this.f = i;
            }

            public int a() {
                return this.f;
            }

            public static EnumC0340a a(Integer num) {
                if (num != null) {
                    EnumC0340a[] values = values();
                    for (int i = 0; i < 5; i++) {
                        EnumC0340a aVar = values[i];
                        if (aVar.a() == num.intValue()) {
                            return aVar;
                        }
                    }
                }
                return UNKNOWN;
            }
        }

        public a(@Nullable Integer num, @NonNull EnumC0340a aVar) {
            this.a = num;
            this.b = aVar;
        }
    }

    public interface b {
        void a(@NonNull a.EnumC0340a aVar);
    }

    public p(@NonNull Context context) {
        this.b = context;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void e() {
        a.EnumC0340a d2 = d();
        for (b bVar : this.d) {
            bVar.a(d2);
        }
    }

    private synchronized a f() {
        return a(this.b.registerReceiver(this.e, new IntentFilter("android.intent.action.BATTERY_CHANGED")));
    }

    private synchronized void g() {
        this.b.unregisterReceiver(this.e);
    }

    @Nullable
    public Integer c() {
        a aVar = this.c;
        if (aVar == null) {
            return null;
        }
        return aVar.a;
    }

    @NonNull
    public a.EnumC0340a d() {
        a aVar = this.c;
        return aVar == null ? a.EnumC0340a.UNKNOWN : aVar.b;
    }

    @Override // com.yandex.metrica.impl.ob.fg
    public void b() {
        this.c = null;
        g();
    }

    @NonNull
    private a.EnumC0340a c(@NonNull Intent intent) {
        int intExtra = intent.getIntExtra("plugged", -1);
        a.EnumC0340a aVar = a.EnumC0340a.NONE;
        if (intExtra == 1) {
            return a.EnumC0340a.AC;
        }
        if (intExtra == 2) {
            return a.EnumC0340a.USB;
        }
        if (intExtra != 4) {
            return aVar;
        }
        return a.EnumC0340a.WIRELESS;
    }

    public void a() {
        this.c = f();
    }

    public synchronized void b(@NonNull b bVar) {
        this.d.remove(bVar);
    }

    public synchronized void a(@NonNull b bVar) {
        this.d.add(bVar);
        bVar.a(d());
    }

    @Nullable
    private Integer b(@NonNull Intent intent) {
        int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra <= 0 || intExtra2 <= 0) {
            return null;
        }
        return Integer.valueOf((intExtra * 100) / intExtra2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NonNull
    private a a(@Nullable Intent intent) {
        a.EnumC0340a aVar;
        Integer num;
        a.EnumC0340a aVar2 = a;
        if (intent != null) {
            num = b(intent);
            aVar = c(intent);
        } else {
            num = null;
            aVar = aVar2;
        }
        return new a(num, aVar);
    }
}
