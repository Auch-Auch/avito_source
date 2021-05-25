package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
public class vt {
    private static final EnumSet<b> a;
    private static final EnumSet<b> b;
    private final Set<a> c;
    @Nullable
    private vu d;
    @Nullable
    private vu e;
    private boolean f;
    @NonNull
    private final mq g;
    private b h;

    /* renamed from: com.yandex.metrica.impl.ob.vt$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            b.values();
            int[] iArr = new int[5];
            a = iArr;
            try {
                b bVar = b.EMPTY;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = a;
                b bVar2 = b.RECEIVER;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = a;
                b bVar3 = b.WAIT_FOR_RECEIVER_ONLY;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = a;
                b bVar4 = b.HAS_FROM_PLAY_SERVICES;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = a;
                b bVar5 = b.HAS_FROM_RECEIVER_ONLY;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public interface a {
        boolean a(@NonNull vu vuVar, @NonNull bd bdVar);
    }

    public enum b {
        EMPTY,
        RECEIVER,
        WAIT_FOR_RECEIVER_ONLY,
        HAS_FROM_PLAY_SERVICES,
        HAS_FROM_RECEIVER_ONLY
    }

    static {
        b bVar = b.HAS_FROM_PLAY_SERVICES;
        b bVar2 = b.HAS_FROM_RECEIVER_ONLY;
        a = EnumSet.of(bVar, bVar2, b.RECEIVER);
        b = EnumSet.of(bVar, bVar2);
    }

    @WorkerThread
    public vt(@NonNull Context context) {
        this(new mq(lv.a(context).c()));
    }

    private b b(vu vuVar) {
        int i = AnonymousClass1.a[this.h.ordinal()];
        if (i == 1) {
            return vuVar == null ? b.WAIT_FOR_RECEIVER_ONLY : b.HAS_FROM_PLAY_SERVICES;
        }
        if (i != 2) {
            return this.h;
        }
        return vuVar == null ? b.HAS_FROM_RECEIVER_ONLY : b.HAS_FROM_PLAY_SERVICES;
    }

    private void c() {
        this.f = true;
        this.g.e().f().q();
    }

    public synchronized void a(@Nullable vu vuVar) {
        if (!b.contains(this.h)) {
            this.e = vuVar;
            this.g.a(vuVar).q();
            a(b(vuVar));
        }
    }

    @VisibleForTesting
    public vt(@NonNull mq mqVar) {
        this.c = new HashSet();
        this.h = b.EMPTY;
        this.g = mqVar;
        boolean d2 = mqVar.d();
        this.f = d2;
        if (!d2) {
            String b2 = mqVar.b();
            if (!TextUtils.isEmpty(b2)) {
                this.d = new vu(b2, 0, 0);
            }
            this.e = mqVar.c();
            this.h = b.values()[mqVar.d(0)];
        }
    }

    private void b() {
        int i = AnonymousClass1.a[this.h.ordinal()];
        if (i == 4) {
            a(this.e, bd.GPL);
        } else if (i == 5) {
            a(this.d, bd.BROADCAST);
        }
    }

    public synchronized void a(@Nullable String str) {
        if (!a.contains(this.h) && !TextUtils.isEmpty(str)) {
            this.d = new vu(str, 0, 0);
            this.g.a(str).q();
            a(a());
        }
    }

    public synchronized void a(@NonNull a aVar) {
        if (!this.f) {
            this.c.add(aVar);
            b();
        }
    }

    private b a() {
        int i = AnonymousClass1.a[this.h.ordinal()];
        if (i == 1) {
            return b.RECEIVER;
        }
        if (i != 3) {
            return this.h;
        }
        return b.HAS_FROM_RECEIVER_ONLY;
    }

    private void a(@NonNull b bVar) {
        if (bVar != this.h) {
            this.h = bVar;
            this.g.e(bVar.ordinal()).q();
            b();
        }
    }

    private synchronized void a(@Nullable vu vuVar, @NonNull bd bdVar) {
        if (vuVar != null) {
            if (!this.c.isEmpty() && !this.f) {
                boolean z = false;
                for (a aVar : this.c) {
                    if (aVar.a(vuVar, bdVar)) {
                        z = true;
                    }
                }
                if (z) {
                    c();
                    this.c.clear();
                }
            }
        }
    }
}
