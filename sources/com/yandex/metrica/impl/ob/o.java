package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.impl.ob.al;
import com.yandex.metrica.impl.ob.uy;
import com.yandex.metrica.profile.UserProfile;
import com.yandex.metrica.profile.UserProfileUpdate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
public abstract class o implements ay {
    private static final Collection<Integer> f = new HashSet(Arrays.asList(14, 15));
    private static final adw<uy.a> g = new adw<uy.a>() { // from class: com.yandex.metrica.impl.ob.o.1
        public adu a(@NonNull uy.a aVar) {
            if (dl.a((Object[]) aVar.b)) {
                return adu.a(this, "attributes list is empty");
            }
            return adu.a(this);
        }
    };
    private static final adw<Revenue> h = new aea();
    public final Context a;
    public final co b;
    @NonNull
    public abl c;
    @NonNull
    public abb d;
    public final cs e;
    private bf i;
    @NonNull
    private final am j;

    public o(Context context, cs csVar, @NonNull co coVar, @NonNull am amVar) {
        this.a = context.getApplicationContext();
        this.e = csVar;
        this.b = coVar;
        this.j = amVar;
        abl a3 = abd.a(coVar.h().e());
        this.c = a3;
        coVar.a(new adj(a3, "Crash Environment"));
        this.c = abd.a(coVar.h().e());
        this.d = abd.b(coVar.h().e());
        if (aau.a(coVar.h().j())) {
            this.c.a();
            this.d.a();
        }
    }

    private void e(String str) {
        if (this.c.c()) {
            this.c.a("Event received: " + d(str));
        }
    }

    private void f(@Nullable String str, @Nullable String str2) {
        if (this.c.c()) {
            StringBuilder sb = new StringBuilder("Statbox event received ");
            sb.append(" with name: ");
            sb.append(d(str));
            sb.append(" with value: ");
            String d2 = d(str2);
            if (d2.length() > 100) {
                sb.append(d2.substring(0, 100));
                sb.append("...");
            } else {
                sb.append(d2);
            }
            this.c.a(sb.toString());
        }
    }

    private void g() {
        if (this.c.c()) {
            this.c.a("User profile received");
        }
    }

    public void a(xx xxVar) {
        this.b.b(xxVar);
    }

    public void a_() {
        this.e.a(this.b);
    }

    public void b(Map<String, String> map) {
        if (!dl.a((Map) map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                d(entry.getKey(), entry.getValue());
            }
        }
    }

    public void c(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.b.a(str, str2);
        } else if (this.c.c()) {
            this.c.b("Invalid Error Environment (key,value) pair: (%s,%s).", str, str2);
        }
    }

    public void d(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.e.a(str, str2, this.b);
        } else if (this.c.c()) {
            this.c.b("Invalid App Environment (key,value) pair: (%s,%s).", str, str2);
        }
    }

    @Override // com.yandex.metrica.IReporter
    public void pauseSession() {
        if (this.c.c()) {
            this.c.a("Pause session");
        }
        b((String) null);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(@NonNull String str, @Nullable Throwable th) {
        this.e.a(str, a(th), this.b);
        if (this.c.c()) {
            this.c.a("Error received: %s", d(str));
        }
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(@NonNull String str) {
        if (this.c.c()) {
            e(str);
        }
        a(al.c(str, this.c));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportRevenue(@NonNull Revenue revenue) {
        a(revenue);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUnhandledException(@NonNull Throwable th) {
        b(new ld(th, null, null, this.j.a(), this.j.b()));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUserProfile(@NonNull UserProfile userProfile) {
        a(userProfile);
    }

    @Override // com.yandex.metrica.IReporter
    public void resumeSession() {
        a((String) null);
        if (this.c.c()) {
            this.c.a("Resume session");
        }
    }

    @Override // com.yandex.metrica.IReporter
    public void sendEventsBuffer() {
        this.e.a(al.a(al.a.EVENT_TYPE_PURGE_BUFFER, this.c), this.b);
    }

    @Override // com.yandex.metrica.IReporter
    public void setStatisticsSending(boolean z) {
        this.b.h().h(z);
    }

    @Override // com.yandex.metrica.IReporter
    public void setUserProfileID(@Nullable String str) {
        this.e.b(str, this.b);
        if (this.c.c()) {
            this.c.a("Set user profile ID: " + d(str));
        }
    }

    public void a(bf bfVar) {
        this.i = bfVar;
    }

    public void a(Map<String, String> map) {
        if (!dl.a((Map) map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                c(entry.getKey(), entry.getValue());
            }
        }
    }

    public void b() {
        this.e.b(this.b);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(@NonNull String str, String str2) {
        if (this.c.c()) {
            e(str, str2);
        }
        a(al.a(str, str2, this.c));
    }

    private void e(String str, String str2) {
        if (this.c.c()) {
            this.c.a("Event received: " + d(str) + ". With value: " + d(str2));
        }
    }

    public void b(String str) {
        if (!this.b.a()) {
            this.e.b(this);
            this.i.a();
            this.b.c();
            this.e.a(al.e(str, this.c), this.b);
        }
    }

    public boolean c() {
        boolean z = !f();
        if (z) {
            this.e.a(al.e("", this.c), this.b);
        }
        return z;
    }

    public co d() {
        return this.b;
    }

    public void a(String str) {
        this.e.a(this);
        this.i.b();
        this.e.a(al.d(str, this.c), this.b);
        a(this.b.d());
    }

    @NonNull
    public String d(@Nullable String str) {
        if (str == null) {
            return "<null>";
        }
        return str.isEmpty() ? "<empty>" : str;
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(@NonNull String str, @Nullable Map<String, Object> map) {
        String str2;
        Map<String, Object> b2 = dl.b(map);
        this.e.a(al.c(str, this.c), d(), b2);
        if (this.c.c()) {
            if (b2 == null) {
                str2 = null;
            } else {
                str2 = b2.toString();
            }
            e(str, str2);
        }
    }

    public void c(@Nullable String str) {
        f(str);
    }

    private void c(@NonNull ld ldVar) {
        if (this.c.c()) {
            this.c.a("Unhandled exception received: " + ldVar.toString());
        }
    }

    @Override // com.yandex.metrica.d
    public void b(@NonNull String str, @Nullable String str2) {
        a(al.a(str, str2));
    }

    private void b(@NonNull ld ldVar) {
        this.e.a(ldVar, this.b);
        c(ldVar);
    }

    @Override // com.yandex.metrica.impl.ob.ay
    public void e() {
        this.e.a(aa.a(this.a), this.b);
    }

    private void a(boolean z) {
        if (z) {
            this.e.a(al.a(al.a.EVENT_TYPE_PURGE_BUFFER, this.c), this.b);
        }
    }

    private void b(@NonNull Revenue revenue) {
        if (this.c.c()) {
            StringBuilder sb = new StringBuilder("Revenue received ");
            sb.append("for productID: ");
            sb.append(d(revenue.productID));
            sb.append(" of quantity: ");
            Integer num = revenue.quantity;
            if (num != null) {
                sb.append(num);
            } else {
                sb.append("<null>");
            }
            sb.append(" with price: ");
            sb.append(revenue.price);
            sb.append(" ");
            sb.append(revenue.currency);
            this.c.a(sb.toString());
        }
    }

    private void f(String str) {
        this.e.a(ax.b(str), this.b);
        if (this.c.c()) {
            this.c.a("Error received: native");
        }
    }

    public void a(int i2, String str, String str2, Map<String, String> map) {
        HashMap hashMap;
        if (!a(i2)) {
            if (map == null) {
                hashMap = null;
            } else {
                hashMap = new HashMap(map);
            }
            a(al.a(i2, str, str2, hashMap, this.c));
        }
    }

    private boolean a(int i2) {
        return !f.contains(Integer.valueOf(i2)) && i2 >= 1 && i2 <= 99;
    }

    @NonNull
    private ld a(@Nullable Throwable th) {
        StackTraceElement[] stackTraceElementArr;
        Throwable th2;
        List list = null;
        if (th == null) {
            stackTraceElementArr = null;
            th2 = null;
        } else if (th instanceof ks) {
            stackTraceElementArr = th.getStackTrace();
            th2 = null;
        } else {
            th2 = th;
            stackTraceElementArr = null;
        }
        if (stackTraceElementArr != null) {
            list = Arrays.asList(stackTraceElementArr);
        }
        return new ld(th2, null, list, this.j.a(), this.j.b());
    }

    public boolean f() {
        return this.b.a();
    }

    @Override // com.yandex.metrica.d
    public void a(@Nullable String str, @Nullable String str2) {
        a(al.b(str, str2, this.c));
        f(str, str2);
    }

    private void a(aa aaVar) {
        this.e.a(aaVar, this.b);
    }

    @Override // com.yandex.metrica.impl.ob.ay
    public void a(@NonNull ld ldVar) {
        b(ldVar);
    }

    private void a(@NonNull Revenue revenue) {
        adu a3 = h.a(revenue);
        if (a3.a()) {
            this.e.a(new cv(revenue, this.c), this.b);
            b(revenue);
        } else if (this.c.c()) {
            abl abl = this.c;
            StringBuilder L = a.L("Passed revenue is not valid. Reason: ");
            L.append(a3.b());
            abl.b(L.toString());
        }
    }

    private void a(@NonNull UserProfile userProfile) {
        uq uqVar = new uq();
        for (UserProfileUpdate<? extends ur> userProfileUpdate : userProfile.getUserProfileUpdates()) {
            ur userProfileUpdatePatcher = userProfileUpdate.getUserProfileUpdatePatcher();
            userProfileUpdatePatcher.a(this.c);
            userProfileUpdatePatcher.a(uqVar);
        }
        uy.a c2 = uqVar.c();
        adu a3 = g.a(c2);
        if (a3.a()) {
            this.e.a(c2, this.b);
            g();
        } else if (this.c.c()) {
            abl abl = this.c;
            StringBuilder L = a.L("UserInfo wasn't sent because ");
            L.append(a3.b());
            abl.b(L.toString());
        }
    }

    @Override // com.yandex.metrica.impl.ob.ay
    public void a(@NonNull ky kyVar) {
        this.e.a(new kz(kyVar, this.j.a(), this.j.b()), this.b);
    }
}
