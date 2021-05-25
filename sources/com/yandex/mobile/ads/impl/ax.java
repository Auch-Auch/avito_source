package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Pair;
import com.yandex.mobile.ads.impl.an;
import com.yandex.mobile.ads.impl.hv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public final class ax implements ay {
    @NonNull
    private final Context a;
    @NonNull
    private final b b = new b(Looper.getMainLooper());
    @NonNull
    private final ba c;
    @NonNull
    private final String d;
    @NonNull
    private final List<a> e;
    @NonNull
    private final cs f;
    @NonNull
    private final dg g;
    @Nullable
    private au h;
    private boolean i;
    private int j;
    private boolean k;
    private boolean l;

    @VisibleForTesting
    public static class a {
        public String a;
        public long b;
        public int c;
        public Long d;

        public a(String str, long j, int i) {
            this.a = str;
            this.b = j;
            this.c = i;
        }
    }

    @VisibleForTesting
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ax axVar;
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                ax axVar2 = (ax) ((WeakReference) pair.first).get();
                if (axVar2 != null) {
                    a aVar = (a) pair.second;
                    String unused = axVar2.d;
                    an a = axVar2.a(aVar);
                    axVar2.b(aVar, a);
                    if (ax.c(a)) {
                        axVar2.e.remove(aVar);
                        if (axVar2.e.isEmpty()) {
                            axVar2.a(a.c());
                            return;
                        }
                        return;
                    }
                    aVar.d = null;
                    axVar2.a();
                }
            } else if (i == 2 && (axVar = (ax) ((WeakReference) message.obj).get()) != null) {
                axVar.e.size();
                String unused2 = axVar.d;
                int size = axVar.e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    a aVar2 = (a) axVar.e.get(i2);
                    an a3 = axVar.a(aVar2);
                    if (ax.c(a3)) {
                        if (aVar2.d == null) {
                            aVar2.d = Long.valueOf(SystemClock.elapsedRealtime());
                        }
                        if (SystemClock.elapsedRealtime() - aVar2.d.longValue() >= aVar2.b) {
                            axVar.b.sendMessage(Message.obtain(axVar.b, 1, new Pair(new WeakReference(axVar), aVar2)));
                        }
                        axVar.b(a3.d());
                    } else {
                        aVar2.d = null;
                        axVar.a(a3);
                    }
                }
                if (axVar.d()) {
                    axVar.b.sendMessageDelayed(Message.obtain(axVar.b, 2, new WeakReference(axVar)), 200);
                }
            }
        }
    }

    public ax(@NonNull Context context, @NonNull fo foVar, @NonNull cs csVar, @NonNull ba baVar, @NonNull String str) {
        this.a = context;
        this.c = baVar;
        this.f = csVar;
        this.d = str;
        this.e = new ArrayList();
        this.g = new dg(context, foVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized boolean d() {
        return this.e.size() > 0;
    }

    @Override // com.yandex.mobile.ads.impl.ay
    public final synchronized void c() {
        this.e.size();
        b();
        hv.b bVar = hv.b.IMPRESSION_TRACKING_SUCCESS;
        ArrayList arrayList = new ArrayList();
        this.l = false;
        for (a aVar : this.e) {
            an a3 = a(aVar);
            a(aVar, a3);
            if (c(a3)) {
                arrayList.add(aVar);
                bVar = a3.c();
                b(a3.d());
            }
        }
        if (!arrayList.isEmpty()) {
            this.e.removeAll(arrayList);
            if (this.e.isEmpty()) {
                a(bVar);
            }
        }
        a();
    }

    @Override // com.yandex.mobile.ads.impl.ay
    public final synchronized void b() {
        this.b.removeMessages(2);
        this.b.removeMessages(1);
        for (a aVar : this.e) {
            aVar.d = null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.ay
    public final synchronized void a(@NonNull x xVar, @NonNull List<bo> list) {
        this.f.a(xVar);
        this.e.clear();
        this.j = 0;
        this.i = false;
        this.k = false;
        this.l = false;
        b();
        a(list);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void b(@NonNull a aVar, @NonNull an anVar) {
        if (c(anVar)) {
            this.g.a(aVar.a);
        } else {
            a(anVar);
        }
    }

    @VisibleForTesting
    public final synchronized void b(@NonNull hv.b bVar) {
        if (!this.k) {
            this.f.a(bVar);
            ij.a("Ad binding successful", new Object[0]);
            this.k = true;
        }
    }

    @VisibleForTesting
    private synchronized void a(List<bo> list) {
        for (bo boVar : list) {
            this.e.add(new a(boVar.b(), boVar.a(), boVar.c()));
        }
    }

    @Override // com.yandex.mobile.ads.impl.ay
    public final synchronized void a() {
        if (ah.a().a(this.a) && !id.a(this.e) && d() && !this.b.hasMessages(2)) {
            b bVar = this.b;
            bVar.sendMessage(Message.obtain(bVar, 2, new WeakReference(this)));
        }
    }

    /* access modifiers changed from: private */
    public static boolean c(@NonNull an anVar) {
        return anVar.b() == an.a.SUCCESS;
    }

    private synchronized void a(@NonNull a aVar, @NonNull an anVar) {
        b(aVar, anVar);
        if (!this.l && !c(anVar)) {
            this.f.b(anVar);
            this.l = true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NonNull
    private an a(@NonNull a aVar) {
        an a3 = this.c.a(aVar.c);
        a3.b().a();
        return a3;
    }

    @Override // com.yandex.mobile.ads.impl.ay
    public final synchronized void a(@NonNull Intent intent, boolean z) {
        String action = intent.getAction();
        char c2 = 65535;
        int hashCode = action.hashCode();
        if (hashCode != -2128145023) {
            if (hashCode != -1454123155) {
                if (hashCode == 823795052) {
                    if (action.equals("android.intent.action.USER_PRESENT")) {
                        c2 = 2;
                    }
                }
            } else if (action.equals("android.intent.action.SCREEN_ON")) {
                c2 = 1;
            }
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            c2 = 0;
        }
        if (c2 != 0) {
            if (c2 == 1 || c2 == 2) {
                if (z) {
                    a();
                }
            }
            return;
        }
        b();
    }

    @VisibleForTesting
    public final synchronized void a(hv.b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("failure_tracked", Boolean.valueOf(this.i));
        this.f.a(bVar, hashMap);
        au auVar = this.h;
        if (auVar != null) {
            auVar.a();
        }
    }

    @VisibleForTesting
    public final synchronized void a(an anVar) {
        int i2 = this.j + 1;
        this.j = i2;
        if (i2 == 20) {
            this.f.a(anVar);
            this.i = true;
        }
    }

    @Override // com.yandex.mobile.ads.impl.ay
    public final void a(@NonNull au auVar) {
        this.h = auVar;
    }
}
