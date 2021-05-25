package com.yandex.metrica;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.ReporterConfig;
import com.yandex.metrica.impl.ob.dl;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
public class f extends ReporterConfig {
    @Nullable
    public final Integer a;
    @Nullable
    public final Integer b;
    public final Map<String, String> c;

    public static class a {
        public ReporterConfig.Builder a;
        public Integer b;
        public Integer c;
        public LinkedHashMap<String, String> d = new LinkedHashMap<>();

        public a(String str) {
            this.a = ReporterConfig.newConfigBuilder(str);
        }

        @NonNull
        public a a(int i) {
            this.a.withSessionTimeout(i);
            return this;
        }

        @NonNull
        public a b(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        @NonNull
        public a c(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        @NonNull
        public a d(int i) {
            this.a.withMaxReportsInDatabaseCount(i);
            return this;
        }

        @NonNull
        public a a() {
            this.a.withLogs();
            return this;
        }

        @NonNull
        public f b() {
            return new f(this);
        }

        @NonNull
        public a a(String str, String str2) {
            this.d.put(str, str2);
            return this;
        }

        @NonNull
        public a a(boolean z) {
            this.a.withStatisticsSending(z);
            return this;
        }
    }

    public f(@NonNull a aVar) {
        super(aVar.a);
        this.b = aVar.b;
        this.a = aVar.c;
        LinkedHashMap<String, String> linkedHashMap = aVar.d;
        this.c = linkedHashMap == null ? null : Collections.unmodifiableMap(linkedHashMap);
    }

    public static f a(@NonNull ReporterConfig reporterConfig) {
        return new f(reporterConfig);
    }

    public static a a(@NonNull f fVar) {
        a a3 = a(fVar.apiKey);
        if (dl.a(fVar.sessionTimeout)) {
            a3.a(fVar.sessionTimeout.intValue());
        }
        if (dl.a(fVar.logs) && fVar.logs.booleanValue()) {
            a3.a();
        }
        if (dl.a(fVar.statisticsSending)) {
            a3.a(fVar.statisticsSending.booleanValue());
        }
        if (dl.a(fVar.maxReportsInDatabaseCount)) {
            a3.d(fVar.maxReportsInDatabaseCount.intValue());
        }
        if (dl.a(fVar.a)) {
            a3.c(fVar.a.intValue());
        }
        if (dl.a(fVar.b)) {
            a3.b(fVar.b.intValue());
        }
        if (dl.a((Object) fVar.c)) {
            for (Map.Entry<String, String> entry : fVar.c.entrySet()) {
                a3.a(entry.getKey(), entry.getValue());
            }
        }
        return a3;
    }

    public f(ReporterConfig reporterConfig) {
        super(reporterConfig);
        if (reporterConfig instanceof f) {
            f fVar = (f) reporterConfig;
            this.a = fVar.a;
            this.b = fVar.b;
            this.c = fVar.c;
            return;
        }
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public static a a(@NonNull String str) {
        return new a(str);
    }
}
