package com.avito.android.di.module;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.OrientationTracker;
import com.avito.android.connection_quality.di.ConnectivityProviderModule;
import com.avito.android.db.sqlbrite.di.BriteDbModule;
import com.avito.android.di.component.ApplicationComponent;
import com.avito.android.di.component.BaseApplicationComponent;
import com.avito.android.search.subscriptions.di.SearchSubscriptionSyncRunnerModule;
import com.avito.android.serp.dfp_mobile_ads.DfpMobileAdsModule;
import com.avito.android.user_adverts.expired_count.di.UserAdvertsInfoUpdateRunnerModule;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/di/module/AvitoApplicationModule;", "", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/analytics/OrientationTracker;", "provideOrientationTracker", "(Lcom/avito/android/Features;Lcom/avito/android/analytics/Analytics;Landroid/app/Application;)Lcom/avito/android/analytics/OrientationTracker;", "<init>", "()V", "Declarations", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {CoreApplicationModule.class, ConnectivityProviderModule.class, BriteDbModule.class, ShortTaskModule.class, AvitoIntentFactoryModule.class, ServiceIntentFactoryModule.class, WorkFactoryModule.class, AvitoTabFragmentFactoryModule.class, ActivityIntentFactoryModule.class, SearchSubscriptionSyncRunnerModule.class, UserAdvertsInfoUpdateRunnerModule.class, DfpMobileAdsModule.class, BuildInfoModule.class, RawPhoneNumberFormatterModule.class, FirebaseInstanceIdModule.class, Declarations.class})
public class AvitoApplicationModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/di/module/AvitoApplicationModule$Declarations;", "", "Lcom/avito/android/di/component/ApplicationComponent;", "factory", "Lcom/avito/android/di/component/BaseApplicationComponent;", "bindBaseApplicationComponent", "(Lcom/avito/android/di/component/ApplicationComponent;)Lcom/avito/android/di/component/BaseApplicationComponent;", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Singleton
        @Binds
        @NotNull
        BaseApplicationComponent bindBaseApplicationComponent(@NotNull ApplicationComponent applicationComponent);
    }

    @Provides
    @Singleton
    @Nullable
    public OrientationTracker provideOrientationTracker(@NotNull Features features, @NotNull Analytics analytics, @NotNull Application application) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        if (!features.getLogScreenOrientation().invoke().booleanValue()) {
            return null;
        }
        Resources resources = application.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "application.resources");
        Configuration configuration = resources.getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "application.resources.configuration");
        return new OrientationTracker(analytics, configuration);
    }
}
