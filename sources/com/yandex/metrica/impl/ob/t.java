package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.al;
import java.util.HashMap;
public class t extends aa {
    private HashMap<a, Integer> f;
    private adn<String> g;
    private adn<String> h;
    private adn<byte[]> i;
    private adn<String> j;
    private adn<String> k;

    public enum a {
        NAME,
        VALUE,
        USER_INFO
    }

    @VisibleForTesting
    public t(@NonNull abl abl) {
        this.f = new HashMap<>();
        b(abl);
    }

    private void b(@NonNull abl abl) {
        this.g = new adl(1000, "event name", abl);
        this.h = new adk(245760, "event value", abl);
        this.i = new add(245760, "event value bytes", abl);
        this.j = new adl(200, "user profile id", abl);
        this.k = new adl(10000, "UserInfo", abl);
    }

    private String f(String str) {
        String a3 = this.g.a(str);
        a(str, a3, a.NAME);
        return a3;
    }

    private String g(String str) {
        String a3 = this.h.a(str);
        a(str, a3, a.VALUE);
        return a3;
    }

    private void u() {
        this.e = 0;
        for (Integer num : this.f.values()) {
            this.e = num.intValue() + this.e;
        }
    }

    public t a(@NonNull HashMap<a, Integer> hashMap) {
        this.f = hashMap;
        return this;
    }

    @Override // com.yandex.metrica.impl.ob.aa
    public aa c(String str) {
        return super.c(g(str));
    }

    @Override // com.yandex.metrica.impl.ob.aa
    @NonNull
    public aa d(@Nullable String str) {
        return super.d(this.j.a(str));
    }

    public static aa c() {
        return new aa().a(al.a.EVENT_TYPE_SEND_USER_PROFILE.a());
    }

    @NonNull
    public HashMap<a, Integer> a() {
        return this.f;
    }

    private void a(String str, String str2, a aVar) {
        if (adg.a(str, str2)) {
            this.f.put(aVar, Integer.valueOf(dh.c(str).length - dh.c(str2).length));
        } else {
            this.f.remove(aVar);
        }
        u();
    }

    public t(String str, int i2, @NonNull abl abl) {
        this("", str, i2, abl);
    }

    public t(String str, String str2, int i2, @NonNull abl abl) {
        this(str, str2, i2, 0, abl);
    }

    public t(String str, String str2, int i2, int i3, @NonNull abl abl) {
        this.f = new HashMap<>();
        b(abl);
        this.b = g(str);
        this.a = f(str2);
        this.c = i2;
        this.d = i3;
    }

    private byte[] b(byte[] bArr) {
        byte[] a3 = this.i.a(bArr);
        a(bArr, a3, a.VALUE);
        return a3;
    }

    @Override // com.yandex.metrica.impl.ob.aa
    public aa b(String str) {
        return super.b(f(str));
    }

    private void a(byte[] bArr, byte[] bArr2, a aVar) {
        if (bArr.length != bArr2.length) {
            this.f.put(aVar, Integer.valueOf(bArr.length - bArr2.length));
        } else {
            this.f.remove(aVar);
        }
        u();
    }

    public static aa b() {
        return new aa().a(al.a.EVENT_TYPE_APP_ENVIRONMENT_CLEARED.a());
    }

    public t(byte[] bArr, String str, int i2, @NonNull abl abl) {
        this.f = new HashMap<>();
        b(abl);
        a(bArr);
        this.a = f(str);
        this.c = i2;
    }

    @Override // com.yandex.metrica.impl.ob.aa
    public aa a(String str) {
        String a3 = this.k.a(str);
        a(str, a3, a.USER_INFO);
        return super.a(a3);
    }

    @Override // com.yandex.metrica.impl.ob.aa
    public final aa a(@Nullable byte[] bArr) {
        return super.a(b(bArr));
    }

    public static aa a(String str, String str2) {
        return new aa().a(al.a.EVENT_TYPE_APP_ENVIRONMENT_UPDATED.a()).b(str, str2);
    }

    @NonNull
    public static aa a(@Nullable String str, @NonNull abl abl) {
        return new t(abl).a(al.a.EVENT_TYPE_SET_USER_PROFILE_ID.a()).d(str);
    }

    @NonNull
    public static aa a(@NonNull abl abl) {
        return new t(abl).a(al.a.EVENT_TYPE_SEND_REVENUE_EVENT.a());
    }
}
