package com.yandex.metrica;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.YandexMetricaConfig;
import com.yandex.metrica.impl.ob.dl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
public class j extends YandexMetricaConfig {
    @Nullable
    public final String a;
    @Nullable
    public final Map<String, String> b;
    @Nullable
    public final String c;
    @Nullable
    public final List<String> d;
    @Nullable
    public final Integer e;
    @Nullable
    public final Integer f;
    @Nullable
    public final Integer g;
    @Nullable
    public final Map<String, String> h;
    @Nullable
    public final Map<String, String> i;
    @Nullable
    public final Boolean j;
    @Nullable
    public final Boolean k;
    @Nullable
    public final Boolean l;
    @Nullable
    public final e m;
    @Nullable
    public final c n;

    public static final class a {
        @Nullable
        public String a;
        @NonNull
        public YandexMetricaConfig.Builder b;
        @Nullable
        public String c;
        @Nullable
        public List<String> d;
        @Nullable
        public Integer e;
        @Nullable
        public Map<String, String> f;
        @Nullable
        public Integer g;
        @Nullable
        public Integer h;
        @NonNull
        public LinkedHashMap<String, String> i = new LinkedHashMap<>();
        @NonNull
        public LinkedHashMap<String, String> j = new LinkedHashMap<>();
        @Nullable
        public Boolean k;
        @Nullable
        public Boolean l;
        @Nullable
        public e m;
        @Nullable
        public Boolean n;
        @Nullable
        public c o;

        public a(@NonNull String str) {
            this.b = YandexMetricaConfig.newConfigBuilder(str);
        }

        @NonNull
        public a a(@NonNull String str) {
            this.b.withAppVersion(str);
            return this;
        }

        @NonNull
        public a b(@Nullable String str) {
            this.a = str;
            return this;
        }

        @NonNull
        public a c(boolean z) {
            this.n = Boolean.valueOf(z);
            return this;
        }

        @NonNull
        public a d(boolean z) {
            this.b.withLocationTracking(z);
            return this;
        }

        @NonNull
        public a e(boolean z) {
            this.b.withInstalledAppCollecting(z);
            return this;
        }

        @NonNull
        public a f(boolean z) {
            this.b.withStatisticsSending(z);
            return this;
        }

        @NonNull
        public a g(boolean z) {
            this.b.handleFirstActivationAsUpdate(z);
            return this;
        }

        @NonNull
        public a h(boolean z) {
            this.l = Boolean.valueOf(z);
            return this;
        }

        @NonNull
        public a a(int i2) {
            this.b.withSessionTimeout(i2);
            return this;
        }

        @NonNull
        public a b(boolean z) {
            this.b.withNativeCrashReporting(z);
            return this;
        }

        @NonNull
        public a c(@Nullable String str) {
            this.c = str;
            return this;
        }

        @NonNull
        public a d(int i2) {
            this.g = Integer.valueOf(i2);
            return this;
        }

        @NonNull
        public a e(int i2) {
            this.b.withMaxReportsInDatabaseCount(i2);
            return this;
        }

        @NonNull
        public a a(boolean z) {
            this.b.withCrashReporting(z);
            return this;
        }

        @NonNull
        public a b(int i2) {
            if (i2 >= 0) {
                this.e = Integer.valueOf(i2);
                return this;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid %1$s. %1$s should be positive.", "App Build Number"));
        }

        @NonNull
        public a c(int i2) {
            this.h = Integer.valueOf(i2);
            return this;
        }

        @NonNull
        public a a() {
            this.b.withLogs();
            return this;
        }

        @NonNull
        public a a(@Nullable Location location) {
            this.b.withLocation(location);
            return this;
        }

        @NonNull
        public a a(@NonNull String str, @Nullable String str2) {
            this.i.put(str, str2);
            return this;
        }

        @NonNull
        public a b(@NonNull String str, @Nullable String str2) {
            this.j.put(str, str2);
            return this;
        }

        @NonNull
        public a a(@Nullable List<String> list) {
            this.d = list;
            return this;
        }

        @NonNull
        public j b() {
            return new j(this, null);
        }

        @NonNull
        public a a(@Nullable Map<String, String> map, @Nullable Boolean bool) {
            this.k = bool;
            this.f = map;
            return this;
        }

        @NonNull
        public a a(@Nullable PreloadInfo preloadInfo) {
            this.b.withPreloadInfo(preloadInfo);
            return this;
        }

        @NonNull
        public a a(@NonNull e eVar) {
            this.m = eVar;
            return this;
        }

        @NonNull
        public a a(@Nullable c cVar) {
            this.o = cVar;
            return this;
        }
    }

    public j(@NonNull YandexMetricaConfig yandexMetricaConfig) {
        super(yandexMetricaConfig);
        this.a = null;
        this.b = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.c = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.d = null;
        this.h = null;
        this.m = null;
        this.l = null;
        this.n = null;
    }

    @NonNull
    public static j a(@NonNull YandexMetricaConfig yandexMetricaConfig) {
        if (yandexMetricaConfig instanceof j) {
            return (j) yandexMetricaConfig;
        }
        return new j(yandexMetricaConfig);
    }

    @NonNull
    public static a b(@NonNull YandexMetricaConfig yandexMetricaConfig) {
        a a3 = a(yandexMetricaConfig.apiKey);
        if (dl.a((Object) yandexMetricaConfig.appVersion)) {
            a3.a(yandexMetricaConfig.appVersion);
        }
        if (dl.a(yandexMetricaConfig.sessionTimeout)) {
            a3.a(yandexMetricaConfig.sessionTimeout.intValue());
        }
        if (dl.a(yandexMetricaConfig.crashReporting)) {
            a3.a(yandexMetricaConfig.crashReporting.booleanValue());
        }
        if (dl.a(yandexMetricaConfig.nativeCrashReporting)) {
            a3.b(yandexMetricaConfig.nativeCrashReporting.booleanValue());
        }
        if (dl.a(yandexMetricaConfig.location)) {
            a3.a(yandexMetricaConfig.location);
        }
        if (dl.a(yandexMetricaConfig.locationTracking)) {
            a3.d(yandexMetricaConfig.locationTracking.booleanValue());
        }
        if (dl.a(yandexMetricaConfig.installedAppCollecting)) {
            a3.e(yandexMetricaConfig.installedAppCollecting.booleanValue());
        }
        if (dl.a(yandexMetricaConfig.logs) && yandexMetricaConfig.logs.booleanValue()) {
            a3.a();
        }
        if (dl.a(yandexMetricaConfig.preloadInfo)) {
            a3.a(yandexMetricaConfig.preloadInfo);
        }
        if (dl.a(yandexMetricaConfig.firstActivationAsUpdate)) {
            a3.g(yandexMetricaConfig.firstActivationAsUpdate.booleanValue());
        }
        if (dl.a(yandexMetricaConfig.statisticsSending)) {
            a3.f(yandexMetricaConfig.statisticsSending.booleanValue());
        }
        if (dl.a(yandexMetricaConfig.maxReportsInDatabaseCount)) {
            a3.e(yandexMetricaConfig.maxReportsInDatabaseCount.intValue());
        }
        if (yandexMetricaConfig instanceof j) {
            j jVar = (j) yandexMetricaConfig;
            if (dl.a((Object) jVar.d)) {
                a3.a(jVar.d);
            }
            if (dl.a(jVar.n)) {
                a3.a(jVar.n);
            }
        }
        return a3;
    }

    @NonNull
    public static a a(@NonNull String str) {
        return new a(str);
    }

    @NonNull
    public static a a(@NonNull j jVar) {
        a a3 = b(jVar).a(new ArrayList());
        if (dl.a((Object) jVar.a)) {
            a3.c(jVar.a);
        }
        if (dl.a((Object) jVar.b) && dl.a(jVar.j)) {
            a3.a(jVar.b, jVar.j);
        }
        if (dl.a(jVar.e)) {
            a3.b(jVar.e.intValue());
        }
        if (dl.a(jVar.f)) {
            a3.d(jVar.f.intValue());
        }
        if (dl.a(jVar.g)) {
            a3.c(jVar.g.intValue());
        }
        if (dl.a((Object) jVar.c)) {
            a3.b(jVar.c);
        }
        if (dl.a((Object) jVar.i)) {
            for (Map.Entry<String, String> entry : jVar.i.entrySet()) {
                a3.b(entry.getKey(), entry.getValue());
            }
        }
        if (dl.a(jVar.k)) {
            a3.h(jVar.k.booleanValue());
        }
        if (dl.a((Object) jVar.d)) {
            a3.a(jVar.d);
        }
        if (dl.a((Object) jVar.h)) {
            for (Map.Entry<String, String> entry2 : jVar.h.entrySet()) {
                a3.a(entry2.getKey(), entry2.getValue());
            }
        }
        if (dl.a(jVar.m)) {
            a3.a(jVar.m);
        }
        if (dl.a(jVar.l)) {
            a3.c(jVar.l.booleanValue());
        }
        return a3;
    }

    public j(a aVar, b bVar) {
        super(aVar.b);
        List<String> list;
        Map<String, String> map;
        Map<String, String> map2;
        this.e = aVar.e;
        List<String> list2 = aVar.d;
        Map<String, String> map3 = null;
        if (list2 == null) {
            list = null;
        } else {
            list = Collections.unmodifiableList(list2);
        }
        this.d = list;
        this.a = aVar.c;
        Map<String, String> map4 = aVar.f;
        if (map4 == null) {
            map = null;
        } else {
            map = Collections.unmodifiableMap(map4);
        }
        this.b = map;
        this.g = aVar.h;
        this.f = aVar.g;
        this.c = aVar.a;
        LinkedHashMap<String, String> linkedHashMap = aVar.i;
        if (linkedHashMap == null) {
            map2 = null;
        } else {
            map2 = Collections.unmodifiableMap(linkedHashMap);
        }
        this.h = map2;
        LinkedHashMap<String, String> linkedHashMap2 = aVar.j;
        this.i = linkedHashMap2 != null ? Collections.unmodifiableMap(linkedHashMap2) : map3;
        this.j = aVar.k;
        this.k = aVar.l;
        this.m = aVar.m;
        this.l = aVar.n;
        this.n = aVar.o;
    }
}
