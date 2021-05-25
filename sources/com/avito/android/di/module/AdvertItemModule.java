package com.avito.android.di.module;

import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.serp.adapter.AdvertGridItemPresenter;
import com.avito.android.serp.adapter.AdvertItemDoubleBlueprint;
import com.avito.android.serp.adapter.AdvertItemGridBlueprint;
import com.avito.android.serp.adapter.AdvertItemListBlueprint;
import com.avito.android.serp.adapter.AdvertListItemPresenter;
import com.avito.android.serp.adapter.RdsAdvertGridItemBlueprint;
import com.avito.android.serp.adapter.RdsAdvertItemPresenter;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.server_time.TimeSource;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J7\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/avito/android/di/module/AdvertItemModule;", "", "Lcom/avito/android/serp/adapter/AdvertGridItemPresenter;", "advertGridItemPresenter", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;", "viewAbConfig", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "Lcom/avito/android/serp/adapter/AdvertItemDoubleBlueprint;", "provideAdvertItemDoubleBlueprint", "(Lcom/avito/android/serp/adapter/AdvertGridItemPresenter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)Lcom/avito/android/serp/adapter/AdvertItemDoubleBlueprint;", "Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;", "provideAdvertItemGridBlueprint", "(Lcom/avito/android/serp/adapter/AdvertGridItemPresenter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;", "Lcom/avito/android/serp/adapter/RdsAdvertItemPresenter;", "advertItemPresenter", "viewConfig", "Lcom/avito/android/serp/adapter/RdsAdvertGridItemBlueprint;", "provideRdsAdvertGridItemBlueprint", "(Lcom/avito/android/serp/adapter/RdsAdvertItemPresenter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)Lcom/avito/android/serp/adapter/RdsAdvertGridItemBlueprint;", "Lcom/avito/android/serp/adapter/AdvertListItemPresenter;", "advertListItemPresenter", "Lcom/avito/android/serp/adapter/AdvertItemListBlueprint;", "provideAdvertItemListBlueprint", "(Lcom/avito/android/serp/adapter/AdvertListItemPresenter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)Lcom/avito/android/serp/adapter/AdvertItemListBlueprint;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdvertItemPresenterModule.class})
public final class AdvertItemModule {
    @NotNull
    public static final AdvertItemModule INSTANCE = new AdvertItemModule();

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final AdvertItemDoubleBlueprint provideAdvertItemDoubleBlueprint(@NotNull AdvertGridItemPresenter advertGridItemPresenter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull SerpItemAbViewConfig serpItemAbViewConfig, @NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(advertGridItemPresenter, "advertGridItemPresenter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(serpItemAbViewConfig, "viewAbConfig");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        return new AdvertItemDoubleBlueprint(advertGridItemPresenter, timeSource, locale, serpItemAbViewConfig, connectivityProvider);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final AdvertItemGridBlueprint provideAdvertItemGridBlueprint(@NotNull AdvertGridItemPresenter advertGridItemPresenter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull SerpItemAbViewConfig serpItemAbViewConfig, @NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(advertGridItemPresenter, "advertGridItemPresenter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(serpItemAbViewConfig, "viewAbConfig");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        return new AdvertItemGridBlueprint(advertGridItemPresenter, timeSource, locale, serpItemAbViewConfig, connectivityProvider);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final RdsAdvertGridItemBlueprint provideRdsAdvertGridItemBlueprint(@NotNull RdsAdvertItemPresenter rdsAdvertItemPresenter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull SerpItemAbViewConfig serpItemAbViewConfig, @NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(rdsAdvertItemPresenter, "advertItemPresenter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(serpItemAbViewConfig, "viewConfig");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        return new RdsAdvertGridItemBlueprint(rdsAdvertItemPresenter, timeSource, locale, serpItemAbViewConfig, connectivityProvider);
    }

    @Provides
    @Reusable
    @NotNull
    public final AdvertItemListBlueprint provideAdvertItemListBlueprint(@NotNull AdvertListItemPresenter advertListItemPresenter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull SerpItemAbViewConfig serpItemAbViewConfig, @NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(advertListItemPresenter, "advertListItemPresenter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(serpItemAbViewConfig, "viewAbConfig");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        return new AdvertItemListBlueprint(advertListItemPresenter, timeSource, locale, serpItemAbViewConfig, connectivityProvider);
    }
}
