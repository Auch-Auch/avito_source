package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.profile.UserProfile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class wz implements ay {
    @NonNull
    private final List<ww> a;
    @Nullable
    private volatile ay b;
    @NonNull
    private final vj c;

    public wz() {
        this(vj.a());
    }

    public synchronized void a(@NonNull Context context) {
        this.b = this.c.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
        for (ww wwVar : this.a) {
            wwVar.a(this.b);
        }
        this.a.clear();
    }

    @Override // com.yandex.metrica.d
    public void b(@NonNull final String str, @Nullable final String str2) {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.2
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.b(str, str2);
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.ay
    public void e() {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.16
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.e();
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void pauseSession() {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.11
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.pauseSession();
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(@NonNull final String str, @Nullable final Throwable th) {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.7
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.reportError(str, th);
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(@NonNull final String str) {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.4
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.reportEvent(str);
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void reportRevenue(@NonNull final Revenue revenue) {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.14
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.reportRevenue(revenue);
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUnhandledException(@NonNull final Throwable th) {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.8
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.reportUnhandledException(th);
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUserProfile(@NonNull final UserProfile userProfile) {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.13
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.reportUserProfile(userProfile);
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void resumeSession() {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.9
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.resumeSession();
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void sendEventsBuffer() {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.3
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.sendEventsBuffer();
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void setStatisticsSending(final boolean z) {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.15
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.setStatisticsSending(z);
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void setUserProfileID(@Nullable final String str) {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.12
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.setUserProfileID(str);
            }
        });
    }

    @VisibleForTesting
    public wz(@NonNull vj vjVar) {
        this.a = new ArrayList();
        this.c = vjVar;
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(@NonNull final String str, @Nullable final String str2) {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.5
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.reportEvent(str, str2);
            }
        });
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(@NonNull final String str, @Nullable final Map<String, Object> map) {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.6
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.reportEvent(str, map);
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.ay
    public void a(@NonNull final ld ldVar) {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.1
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.a(ldVar);
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.ay
    public void a(@NonNull final ky kyVar) {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.10
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.a(kyVar);
            }
        });
    }

    @Override // com.yandex.metrica.d
    public void a(@Nullable final String str, @Nullable final String str2) {
        a(new ww() { // from class: com.yandex.metrica.impl.ob.wz.17
            @Override // com.yandex.metrica.impl.ob.ww
            public void a(@NonNull ay ayVar) {
                ayVar.a(str, str2);
            }
        });
    }

    private synchronized void a(@NonNull ww wwVar) {
        if (this.b == null) {
            this.a.add(wwVar);
        } else {
            wwVar.a(this.b);
        }
    }
}
