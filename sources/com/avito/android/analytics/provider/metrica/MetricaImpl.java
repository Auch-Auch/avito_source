package com.avito.android.analytics.provider.metrica;

import android.app.Application;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.google.android.exoplayer2.util.MimeTypes;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/analytics/provider/metrica/MetricaImpl;", "Lcom/avito/android/analytics/provider/metrica/Metrica;", "", "isInitialized", "()Z", "Lkotlin/Function0;", "", "onInitialized", "initialize", "(Lkotlin/jvm/functions/Function0;)V", AuthSource.SEND_ABUSE, "()V", "Z", "Landroid/app/Application;", AuthSource.BOOKING_ORDER, "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/util/BuildInfo;", "c", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "<init>", "(Landroid/app/Application;Lcom/avito/android/util/BuildInfo;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class MetricaImpl implements Metrica {
    public volatile boolean a;
    public final Application b;
    public final BuildInfo c;

    public MetricaImpl(@NotNull Application application, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.b = application;
        this.c = buildInfo;
    }

    public final void a() {
        YandexMetricaConfig.Builder newConfigBuilder = YandexMetricaConfig.newConfigBuilder("1ae47837-3870-4f32-a05d-d9b5cf37ce69");
        Intrinsics.checkNotNullExpressionValue(newConfigBuilder, "YandexMetricaConfig.newC…r(YANDEX_METRICA_API_KEY)");
        newConfigBuilder.withCrashReporting(false);
        newConfigBuilder.withNativeCrashReporting(false);
        newConfigBuilder.withSessionTimeout((int) TimeUnit.MINUTES.toMillis(30));
        newConfigBuilder.withLocationTracking(false);
        newConfigBuilder.withInstalledAppCollecting(false);
        if (this.c.isDebug()) {
            newConfigBuilder.withLogs();
        }
        YandexMetrica.activate(this.b, newConfigBuilder.build());
        YandexMetrica.enableActivityAutoTracking(this.b);
        Logs.verbose$default("MetricaWrapper", "Yandex metrica initialized", null, 4, null);
    }

    @Override // com.avito.android.util.Initializable
    public synchronized void initialize(@Nullable Function0<Unit> function0) {
        if (!this.a) {
            a();
            this.a = true;
        }
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.util.Initializable
    public boolean isInitialized() {
        return this.a;
    }
}
