package com.avito.android.publish.publish_advert_request.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractor;
import com.avito.android.photo_picker.legacy.service.UploadingInteractor;
import com.avito.android.progress_overlay.LoadingProgressOverlayModule;
import com.avito.android.publish.di.PublishParametersModule;
import com.avito.android.publish.publish_advert_request.PublishAdvertRequestViewModelFactory;
import com.avito.android.publish.publish_advert_request.data.PublishAdvertCloudDataSource;
import com.avito.android.publish.publish_advert_request.data.PublishAdvertDataSource;
import com.avito.android.publish.publish_advert_request.data.PublishAdvertRepository;
import com.avito.android.publish.publish_advert_request.data.PublishAdvertRepositoryImpl;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ7\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/di/PublishAdvertRequestModule;", "", "Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertDataSource;", "dataSource", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsData", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "converter", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertRepository;", "providePublishAdvertRepository", "(Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertDataSource;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertRepository;", "repository", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", "uploadingInteractor", "Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;", "uploadingProgressInteractor", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModelFactory;", "providePublishAdvertRequestViewModelFactory", "(Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertRepository;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;)Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModelFactory;", "<init>", "()V", "Declarations", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, PublishParametersModule.class, LoadingProgressOverlayModule.class})
public final class PublishAdvertRequestModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/di/PublishAdvertRequestModule$Declarations;", "", "Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertCloudDataSource;", "dataSource", "Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertDataSource;", "providePublishAdvertCloudDataSource", "(Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertCloudDataSource;)Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertDataSource;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        PublishAdvertDataSource providePublishAdvertCloudDataSource(@NotNull PublishAdvertCloudDataSource publishAdvertCloudDataSource);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PublishAdvertRepository providePublishAdvertRepository(@NotNull PublishAdvertDataSource publishAdvertDataSource, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(publishAdvertDataSource, "dataSource");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsData");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "converter");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        return new PublishAdvertRepositoryImpl(publishAdvertDataSource, publishAnalyticsDataProvider, categoryParametersConverter, typedErrorThrowableConverter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PublishAdvertRequestViewModelFactory providePublishAdvertRequestViewModelFactory(@NotNull PublishAdvertRepository publishAdvertRepository, @NotNull Analytics analytics, @NotNull SchedulersFactory schedulersFactory, @NotNull UploadingInteractor uploadingInteractor, @NotNull UploadingProgressInteractor uploadingProgressInteractor) {
        Intrinsics.checkNotNullParameter(publishAdvertRepository, "repository");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(uploadingInteractor, "uploadingInteractor");
        Intrinsics.checkNotNullParameter(uploadingProgressInteractor, "uploadingProgressInteractor");
        return new PublishAdvertRequestViewModelFactory(publishAdvertRepository, analytics, schedulersFactory, uploadingInteractor, uploadingProgressInteractor);
    }
}
