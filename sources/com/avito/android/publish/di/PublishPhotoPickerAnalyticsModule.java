package com.avito.android.publish.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.UnhandledPhotoPickerEvent;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.analytics.PhotoPickerOnPublishEventTracker;
import com.avito.android.publish.analytics.PhotoPickerOnPublishEventTrackerImpl;
import com.avito.android.publish.drafts.di.AnalyticsParametersSerializer;
import com.google.gson.Gson;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import io.reactivex.rxjava3.functions.Consumer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\b\u0010\tJ9\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/publish/di/PublishPhotoPickerAnalyticsModule;", "", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/analytics/UnhandledPhotoPickerEvent;", "providePhotoPickerEventStream", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "stream", "Lio/reactivex/rxjava3/functions/Consumer;", "providePhotoPickerEventObserver", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/publish/analytics/PhotoPickerOnPublishEventTracker;", "providePublishPhotoPickerAnalyticTracker", "(Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/analytics/Analytics;Lcom/jakewharton/rxrelay3/PublishRelay;Lcom/google/gson/Gson;)Lcom/avito/android/publish/analytics/PhotoPickerOnPublishEventTracker;", "<init>", "()V", "PublishPhotoPicker", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {PublishAnalyticModule.class})
public final class PublishPhotoPickerAnalyticsModule {
    @NotNull
    public static final PublishPhotoPickerAnalyticsModule INSTANCE = new PublishPhotoPickerAnalyticsModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/di/PublishPhotoPickerAnalyticsModule$PublishPhotoPicker;", "", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface PublishPhotoPicker {
    }

    @Provides
    @IntoSet
    @NotNull
    @Singleton
    public final Consumer<UnhandledPhotoPickerEvent> providePhotoPickerEventObserver(@PublishPhotoPicker @NotNull PublishRelay<UnhandledPhotoPickerEvent> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "stream");
        return publishRelay;
    }

    @Provides
    @PublishPhotoPicker
    @NotNull
    @Singleton
    public final PublishRelay<UnhandledPhotoPickerEvent> providePhotoPickerEventStream() {
        PublishRelay<UnhandledPhotoPickerEvent> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }

    @Provides
    @NotNull
    @Singleton
    public final PhotoPickerOnPublishEventTracker providePublishPhotoPickerAnalyticTracker(@NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull Analytics analytics, @PublishPhotoPicker @NotNull PublishRelay<UnhandledPhotoPickerEvent> publishRelay, @AnalyticsParametersSerializer @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(publishRelay, "stream");
        Intrinsics.checkNotNullParameter(gson, "gson");
        return new PhotoPickerOnPublishEventTrackerImpl(analytics, publishAnalyticsDataProvider, publishRelay, gson);
    }
}
