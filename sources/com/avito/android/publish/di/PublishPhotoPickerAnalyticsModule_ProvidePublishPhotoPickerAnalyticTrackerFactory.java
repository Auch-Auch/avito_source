package com.avito.android.publish.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.UnhandledPhotoPickerEvent;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.analytics.PhotoPickerOnPublishEventTracker;
import com.google.gson.Gson;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishPhotoPickerAnalyticsModule_ProvidePublishPhotoPickerAnalyticTrackerFactory implements Factory<PhotoPickerOnPublishEventTracker> {
    public final Provider<PublishAnalyticsDataProvider> a;
    public final Provider<Analytics> b;
    public final Provider<PublishRelay<UnhandledPhotoPickerEvent>> c;
    public final Provider<Gson> d;

    public PublishPhotoPickerAnalyticsModule_ProvidePublishPhotoPickerAnalyticTrackerFactory(Provider<PublishAnalyticsDataProvider> provider, Provider<Analytics> provider2, Provider<PublishRelay<UnhandledPhotoPickerEvent>> provider3, Provider<Gson> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static PublishPhotoPickerAnalyticsModule_ProvidePublishPhotoPickerAnalyticTrackerFactory create(Provider<PublishAnalyticsDataProvider> provider, Provider<Analytics> provider2, Provider<PublishRelay<UnhandledPhotoPickerEvent>> provider3, Provider<Gson> provider4) {
        return new PublishPhotoPickerAnalyticsModule_ProvidePublishPhotoPickerAnalyticTrackerFactory(provider, provider2, provider3, provider4);
    }

    public static PhotoPickerOnPublishEventTracker providePublishPhotoPickerAnalyticTracker(PublishAnalyticsDataProvider publishAnalyticsDataProvider, Analytics analytics, PublishRelay<UnhandledPhotoPickerEvent> publishRelay, Gson gson) {
        return (PhotoPickerOnPublishEventTracker) Preconditions.checkNotNullFromProvides(PublishPhotoPickerAnalyticsModule.INSTANCE.providePublishPhotoPickerAnalyticTracker(publishAnalyticsDataProvider, analytics, publishRelay, gson));
    }

    @Override // javax.inject.Provider
    public PhotoPickerOnPublishEventTracker get() {
        return providePublishPhotoPickerAnalyticTracker(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
