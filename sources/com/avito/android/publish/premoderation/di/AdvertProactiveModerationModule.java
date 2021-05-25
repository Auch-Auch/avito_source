package com.avito.android.publish.premoderation.di;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.premoderation.AdvertProactiveModerationInteractor;
import com.avito.android.publish.premoderation.AdvertProactiveModerationInteractorImpl;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/publish/premoderation/di/AdvertProactiveModerationModule;", "", "Lcom/avito/android/remote/PublishApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "converter", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/publish/premoderation/AdvertProactiveModerationInteractor;", "providerAdvertProactiveModerationInteractor", "(Lcom/avito/android/remote/PublishApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)Lcom/avito/android/publish/premoderation/AdvertProactiveModerationInteractor;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class AdvertProactiveModerationModule {
    @Provides
    @Reusable
    @NotNull
    public final AdvertProactiveModerationInteractor providerAdvertProactiveModerationInteractor(@NotNull PublishApi publishApi, @NotNull SchedulersFactory schedulersFactory, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(publishApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "converter");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        return new AdvertProactiveModerationInteractorImpl(publishApi, schedulersFactory, categoryParametersConverter, publishAnalyticsDataProvider);
    }
}
