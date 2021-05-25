package com.yandex.metrica.impl.ob;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.abc;
public class jx implements jw {
    public mo a;
    private final String b;
    private abc.a c;

    public jx(mo moVar, String str) {
        this.a = moVar;
        this.b = str;
        abc.a aVar = new abc.a();
        try {
            String c2 = this.a.c(str);
            if (!TextUtils.isEmpty(c2)) {
                aVar = new abc.a(c2);
            }
        } catch (Throwable unused) {
        }
        this.c = aVar;
    }

    @Override // com.yandex.metrica.impl.ob.jw
    public jx a(long j) {
        a("SESSION_COUNTER_ID", Long.valueOf(j));
        return this;
    }

    @Nullable
    public Long b() {
        return this.c.d("SESSION_ID");
    }

    @Nullable
    public Long c() {
        return this.c.d("SESSION_INIT_TIME");
    }

    public jx d(long j) {
        a("SESSION_ID", Long.valueOf(j));
        return this;
    }

    public jx e(long j) {
        a("SESSION_INIT_TIME", Long.valueOf(j));
        return this;
    }

    @Nullable
    public Long f() {
        return this.c.d("SESSION_LAST_EVENT_OFFSET");
    }

    @Nullable
    public Boolean g() {
        return this.c.e("SESSION_IS_ALIVE_REPORT_NEEDED");
    }

    public void h() {
        this.a.a(this.b, this.c.toString());
        this.a.q();
    }

    public boolean i() {
        return this.c.length() > 0;
    }

    @Override // com.yandex.metrica.impl.ob.jw
    public jx a(boolean z) {
        a("SESSION_IS_ALIVE_REPORT_NEEDED", Boolean.valueOf(z));
        return this;
    }

    @Override // com.yandex.metrica.impl.ob.jw
    public jx b(long j) {
        a("SESSION_SLEEP_START", Long.valueOf(j));
        return this;
    }

    @Override // com.yandex.metrica.impl.ob.jw
    public jx c(long j) {
        a("SESSION_LAST_EVENT_OFFSET", Long.valueOf(j));
        return this;
    }

    @Nullable
    public Long d() {
        return this.c.d("SESSION_COUNTER_ID");
    }

    @Nullable
    public Long e() {
        return this.c.d("SESSION_SLEEP_START");
    }

    private void a(String str, Object obj) {
        try {
            this.c.put(str, obj);
        } catch (Throwable unused) {
        }
    }

    @Override // com.yandex.metrica.impl.ob.jw
    public void a() {
        this.c = new abc.a();
        h();
    }
}
