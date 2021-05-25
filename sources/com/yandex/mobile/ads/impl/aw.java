package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
public final class aw implements ay {
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
    private final List<a> f;
    @NonNull
    private final cs g;
    @NonNull
    private final dg h;
    @Nullable
    private au i;
    private boolean j;
    private int k;
    private boolean l;
    private boolean m;

    @VisibleForTesting
    public static class a {
        public String a;
        public long b;
        public int c;

        public a(String str, long j, int i) {
            this.a = str;
            this.b = j;
            this.c = i;
        }
    }

    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            aw awVar;
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                aw awVar2 = (aw) ((WeakReference) pair.first).get();
                if (awVar2 != null) {
                    a aVar = (a) pair.second;
                    String unused = awVar2.d;
                    awVar2.e.remove(aVar);
                    an a = awVar2.a(aVar);
                    awVar2.b(aVar, a);
                    if (aw.c(a)) {
                        awVar2.f.remove(aVar);
                        if (awVar2.f.isEmpty()) {
                            awVar2.a(a.c());
                            return;
                        }
                        return;
                    }
                    awVar2.a();
                }
            } else if (i == 2 && (awVar = (aw) ((WeakReference) message.obj).get()) != null) {
                awVar.f.size();
                String unused2 = awVar.d;
                int size = awVar.f.size();
                for (int i2 = 0; i2 < size; i2++) {
                    a aVar2 = (a) awVar.f.get(i2);
                    if (!awVar.e.contains(aVar2)) {
                        an a3 = awVar.a(aVar2);
                        if (aw.c(a3)) {
                            awVar.b.sendMessageDelayed(Message.obtain(awVar.b, 1, new Pair(new WeakReference(awVar), aVar2)), aVar2.b);
                            awVar.e.add(aVar2);
                            awVar.b(a3.d());
                        } else {
                            awVar.a(a3);
                        }
                    }
                }
                if (awVar.d()) {
                    awVar.b.sendMessageDelayed(Message.obtain(awVar.b, 2, new WeakReference(awVar)), 300);
                }
            }
        }
    }

    public aw(@NonNull Context context, @NonNull fo foVar, @NonNull cs csVar, @NonNull ba baVar, @NonNull String str) {
        this.a = context;
        this.c = baVar;
        this.g = csVar;
        this.d = str;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.h = new dg(context, foVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized boolean d() {
        return this.f.size() > this.e.size();
    }

    @Override // com.yandex.mobile.ads.impl.ay
    public final synchronized void c() {
        this.f.size();
        b();
        hv.b bVar = hv.b.IMPRESSION_TRACKING_SUCCESS;
        ArrayList arrayList = new ArrayList();
        this.m = false;
        for (a aVar : this.f) {
            an a3 = a(aVar);
            a(aVar, a3);
            if (c(a3)) {
                arrayList.add(aVar);
                bVar = a3.c();
                b(a3.d());
            }
        }
        if (!arrayList.isEmpty()) {
            this.f.removeAll(arrayList);
            if (this.f.isEmpty()) {
                a(bVar);
            }
        }
        a();
    }

    @Override // com.yandex.mobile.ads.impl.ay
    public final synchronized void b() {
        this.b.removeMessages(2);
        this.b.removeMessages(1);
        this.e.clear();
    }

    @Override // com.yandex.mobile.ads.impl.ay
    public final synchronized void a(@NonNull x xVar, @NonNull List<bo> list) {
        this.g.a(xVar);
        this.f.clear();
        this.k = 0;
        this.j = false;
        this.l = false;
        this.m = false;
        b();
        a(list);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void b(@NonNull a aVar, @NonNull an anVar) {
        if (c(anVar)) {
            this.h.a(aVar.a);
        } else {
            a(anVar);
        }
    }

    @VisibleForTesting
    public final synchronized void b(@NonNull hv.b bVar) {
        if (!this.l) {
            this.g.a(bVar);
            ij.a("Ad binding successful", new Object[0]);
            this.l = true;
        }
    }

    @VisibleForTesting
    private synchronized void a(List<bo> list) {
        for (bo boVar : list) {
            this.f.add(new a(boVar.b(), boVar.a(), boVar.c()));
        }
    }

    @Override // com.yandex.mobile.ads.impl.ay
    public final synchronized void a() {
        if (ah.a().a(this.a) && !id.a(this.f) && d()) {
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
        if (!this.m && !c(anVar)) {
            this.g.b(anVar);
            this.m = true;
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
        hashMap.put("failure_tracked", Boolean.valueOf(this.j));
        this.g.a(bVar, hashMap);
        au auVar = this.i;
        if (auVar != null) {
            auVar.a();
        }
    }

    @VisibleForTesting
    public final synchronized void a(an anVar) {
        int i2 = this.k + 1;
        this.k = i2;
        if (i2 == 20) {
            this.g.a(anVar);
            this.j = true;
        }
    }

    @Override // com.yandex.mobile.ads.impl.ay
    public final void a(@NonNull au auVar) {
        this.i = auVar;
    }
}
