package com.avito.android.analytics.screens.fps;

import android.app.Application;
import android.view.Display;
import android.view.WindowManager;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0006R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/analytics/screens/fps/RefreshRateProvider;", "", "", "getRefreshRate", "()D", "refreshRate", "Impl", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public interface RefreshRateProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/analytics/screens/fps/RefreshRateProvider$Impl;", "Lcom/avito/android/analytics/screens/fps/RefreshRateProvider;", "", "getRefreshRate", "()D", "refreshRate", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "<init>", "(Landroid/app/Application;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements RefreshRateProvider {
        public final Application a;

        @Inject
        public Impl(@NotNull Application application) {
            Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
            this.a = application;
        }

        @Override // com.avito.android.analytics.screens.fps.RefreshRateProvider
        public double getRefreshRate() {
            Object systemService = this.a.getSystemService("window");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "(application.getSystemSe…          .defaultDisplay");
            return (double) defaultDisplay.getRefreshRate();
        }
    }

    double getRefreshRate();
}
