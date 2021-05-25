package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.annotation.WorkerThread;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.f;
import com.yandex.metrica.g;
import com.yandex.metrica.profile.UserProfile;
import java.util.List;
import java.util.Map;
public class vi implements ay {
    @NonNull
    private final vl a;
    @NonNull
    private final vq b;
    @NonNull
    private final act c;
    @NonNull
    private final Context d;
    @NonNull
    private final vn e;
    @NonNull
    private final f f;
    @NonNull
    private final g g;

    public vi(@NonNull act act, @NonNull Context context, @NonNull String str) {
        this(act, context, str, new vl());
    }

    @Override // com.yandex.metrica.d
    public void b(@NonNull final String str, @Nullable final String str2) {
        this.b.b(str, str2);
        this.g.c(str, str2);
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.2
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().b(str, str2);
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.ay
    public void e() {
        this.g.d();
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.17
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().e();
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void pauseSession() {
        this.b.pauseSession();
        this.g.c();
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.10
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().pauseSession();
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(@NonNull final String str, @Nullable Throwable th) {
        this.b.reportError(str, th);
        final Throwable a3 = this.g.a(str, th);
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.6
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().reportError(str, a3);
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(@NonNull final String str) {
        this.b.reportEvent(str);
        this.g.a(str);
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.3
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().reportEvent(str);
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void reportRevenue(@NonNull final Revenue revenue) {
        this.b.reportRevenue(revenue);
        this.g.a(revenue);
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.13
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().reportRevenue(revenue);
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUnhandledException(@NonNull final Throwable th) {
        this.b.reportUnhandledException(th);
        this.g.a(th);
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.7
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().reportUnhandledException(th);
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUserProfile(@NonNull final UserProfile userProfile) {
        this.b.reportUserProfile(userProfile);
        this.g.a(userProfile);
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.12
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().reportUserProfile(userProfile);
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void resumeSession() {
        this.b.resumeSession();
        this.g.b();
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.8
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().resumeSession();
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void sendEventsBuffer() {
        this.b.sendEventsBuffer();
        this.g.a();
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.18
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().sendEventsBuffer();
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void setStatisticsSending(final boolean z) {
        this.b.setStatisticsSending(z);
        this.g.a(z);
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.14
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().setStatisticsSending(z);
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void setUserProfileID(@Nullable final String str) {
        this.b.setUserProfileID(str);
        this.g.b(str);
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.11
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().setUserProfileID(str);
            }
        });
    }

    private vi(@NonNull act act, @NonNull Context context, @NonNull String str, @NonNull vl vlVar) {
        this(act, context, new vq(), vlVar, new vn(), new g(vlVar), f.a(str).b());
    }

    @WorkerThread
    @NonNull
    public final ay a() {
        return this.a.a(this.d).b(this.f);
    }

    @Override // com.yandex.metrica.impl.ob.ay
    public void a(@NonNull final ld ldVar) {
        this.g.a(ldVar);
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.1
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().a(ldVar);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @WorkerThread
    private void b(@NonNull f fVar) {
        this.a.a(this.d).a(fVar);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(@NonNull final String str, @Nullable final String str2) {
        this.b.reportEvent(str, str2);
        this.g.b(str, str2);
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.4
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().reportEvent(str, str2);
            }
        });
    }

    @VisibleForTesting
    public vi(@NonNull act act, @NonNull Context context, @NonNull vq vqVar, @NonNull vl vlVar, @NonNull vn vnVar, @NonNull g gVar, @NonNull f fVar) {
        this.c = act;
        this.d = context;
        this.b = vqVar;
        this.a = vlVar;
        this.e = vnVar;
        this.g = gVar;
        this.f = fVar;
    }

    @Override // com.yandex.metrica.impl.ob.ay
    public void a(@NonNull final ky kyVar) {
        this.g.a(kyVar);
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.9
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().a(kyVar);
            }
        });
    }

    @Override // com.yandex.metrica.d
    public void a(@Nullable final String str, @Nullable final String str2) {
        this.b.a(str, str2);
        this.g.a(str, str2);
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.19
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().a(str, str2);
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(@NonNull final String str, @Nullable Map<String, Object> map) {
        this.b.reportEvent(str, map);
        this.g.a(str, map);
        final List c2 = dl.c(map);
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.5
            @Override // java.lang.Runnable
            public void run() {
                vi.this.a().reportEvent(str, dl.a(c2));
            }
        });
    }

    public void a(@NonNull String str) {
        final f b2 = f.a(str).b();
        this.g.a(b2);
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.15
            @Override // java.lang.Runnable
            public void run() {
                vi.this.b(b2);
            }
        });
    }

    public void a(@NonNull f fVar) {
        final f a3 = this.e.a(fVar);
        this.g.a(a3);
        this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vi.16
            @Override // java.lang.Runnable
            public void run() {
                vi.this.b(a3);
            }
        });
    }
}
