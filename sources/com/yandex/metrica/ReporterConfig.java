package com.yandex.metrica;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.ads;
import com.yandex.metrica.impl.ob.adw;
import com.yandex.metrica.impl.ob.adx;
import com.yandex.metrica.impl.ob.dl;
public class ReporterConfig {
    @NonNull
    public final String apiKey;
    @Nullable
    public final Boolean logs;
    @Nullable
    public final Integer maxReportsInDatabaseCount;
    @Nullable
    public final Integer sessionTimeout;
    @Nullable
    public final Boolean statisticsSending;

    public static class Builder {
        public static final adw<String> f = new ads(new adx());
        public final String a;
        @Nullable
        public Integer b;
        @Nullable
        public Boolean c;
        @Nullable
        public Boolean d;
        @Nullable
        public Integer e;

        public Builder(@NonNull String str) {
            f.a(str);
            this.a = str;
        }

        @NonNull
        public ReporterConfig build() {
            return new ReporterConfig(this);
        }

        @NonNull
        public Builder withLogs() {
            this.c = Boolean.TRUE;
            return this;
        }

        @NonNull
        public Builder withMaxReportsInDatabaseCount(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        @NonNull
        public Builder withSessionTimeout(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        @NonNull
        public Builder withStatisticsSending(boolean z) {
            this.d = Boolean.valueOf(z);
            return this;
        }
    }

    public ReporterConfig(@NonNull Builder builder) {
        this.apiKey = builder.a;
        this.sessionTimeout = builder.b;
        this.logs = builder.c;
        this.statisticsSending = builder.d;
        this.maxReportsInDatabaseCount = builder.e;
    }

    public static Builder createBuilderFromConfig(@NonNull ReporterConfig reporterConfig) {
        Builder newConfigBuilder = newConfigBuilder(reporterConfig.apiKey);
        if (dl.a(reporterConfig.sessionTimeout)) {
            newConfigBuilder.withSessionTimeout(reporterConfig.sessionTimeout.intValue());
        }
        if (dl.a(reporterConfig.logs) && reporterConfig.logs.booleanValue()) {
            newConfigBuilder.withLogs();
        }
        if (dl.a(reporterConfig.statisticsSending)) {
            newConfigBuilder.withStatisticsSending(reporterConfig.statisticsSending.booleanValue());
        }
        if (dl.a(reporterConfig.maxReportsInDatabaseCount)) {
            newConfigBuilder.withMaxReportsInDatabaseCount(reporterConfig.maxReportsInDatabaseCount.intValue());
        }
        return newConfigBuilder;
    }

    @NonNull
    public static Builder newConfigBuilder(@NonNull String str) {
        return new Builder(str);
    }

    public ReporterConfig(@NonNull ReporterConfig reporterConfig) {
        this.apiKey = reporterConfig.apiKey;
        this.sessionTimeout = reporterConfig.sessionTimeout;
        this.logs = reporterConfig.logs;
        this.statisticsSending = reporterConfig.statisticsSending;
        this.maxReportsInDatabaseCount = reporterConfig.maxReportsInDatabaseCount;
    }
}
